package com.zygk.web.service.impl;

import java.util.List;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zygk.common.exception.NotImplementException;
import com.zygk.core.shiro.JwtUtil;
import com.zygk.core.shiro.RefreshTokenUtil;
import com.zygk.web.domain.local.entity.Userinfo;
import com.zygk.web.service.ApiService;
import com.zygk.web.service.UserinfoService;
import com.zygk.web.vo.FreshTokenVO;
import com.zygk.web.vo.LoginVO;
import com.zygk.web.vo.WaterLockVO;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	private UserinfoService userinfoService;

	@Override
	public LoginVO login(String username, String password) {
		if (StrUtil.isNullOrUndefined(username)) {
			throw new AuthenticationException("username Invalid");
		}
		Userinfo user = userinfoService.getOne(new QueryWrapper<Userinfo>().eq("login_name", username));
		if (BeanUtil.isEmpty(user)) {
			throw new AuthenticationException("User not found");
		}
		String pwd = new Md5Hash(password, user.getSalt(), 8).toString();
		if (!pwd.equals(user.getPassword())) {
			throw new AuthenticationException("username or password error");
		}
		LoginVO result = new LoginVO();
		BeanUtil.copyProperties(user, result);
		result.setToken(JwtUtil.sign(username, pwd));
		result.setRefreshToken(RefreshTokenUtil.sign(username, pwd));

		// TODO (senyer) 关联用戶角色,实现用户权限
		result.setRoleName("曲阳站");
		result.setRoleKey("root:root");

		// TODO (senyer) 实现与服务端的通信，登录（汪）的服务端，进行身份认证,拿到动态秘钥key
		result.setKey("123");

		return result;
	}

	@Override
	public List<WaterLockVO> queryAllWaterLock(boolean isAdmin, int status, String name, String devID, int userId) {
		throw new NotImplementException();
	}

	@Override
	public boolean openLock(String devID) {
		throw new NotImplementException();
	}

	@Override
	public FreshTokenVO refreshToken(String refresh_token) {
		String username = RefreshTokenUtil.getUsername(refresh_token);
		if (StrUtil.isNullOrUndefined(username)){
            throw new AuthenticationException("token Invalid");
        }
        Userinfo user = userinfoService.getOne(new QueryWrapper<Userinfo>().eq("login_name", username));
        if (BeanUtil.isEmpty(user)) {
            throw new AuthenticationException("token Invalid");
        }
        boolean verify = RefreshTokenUtil.verify(refresh_token, username, user.getPassword());
        if (!verify) {
            throw new AuthenticationException("token Invalid");
        }
        FreshTokenVO ft=new FreshTokenVO();
        ft.setRefreshToken(refresh_token);
        ft.setToken(JwtUtil.sign(username, user.getPassword()));
		return ft;
	}

}
