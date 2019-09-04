package com.zygk.core.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zygk.web.domain.local.entity.Userinfo;
import com.zygk.web.service.UserinfoService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
 
@Component
@Slf4j
public class MyRealm extends AuthorizingRealm {
 
	@Autowired
	private UserinfoService userinfoService;
    /**
     * 	必须重写此方法
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
 
    /**
     *	 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	//TODO (senyer)
        return null;
    }
 
    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)  throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (StrUtil.isNullOrUndefined(username)){
            throw new AuthenticationException("token Invalid");
        }
        Userinfo user = userinfoService.getOne(new QueryWrapper<Userinfo>().eq("login_name", username));
        if (BeanUtil.isEmpty(user)) {
            throw new AuthenticationException("User not found");
        }
 
        if (!JwtUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("Incorrect username or password");
        }
        return new SimpleAuthenticationInfo(token, token, "senyer_realm");
    }
}
