package com.zygk.web.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.util.StringUtil;
import com.zygk.common.utils.StringUtils;
import com.zygk.web.domain.local.entity.Userinfo;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserinfoServiceTest {

	@Autowired
	private UserinfoService userinfoService;
	
	/**
	 * 测试添加用户（相当于注册用户）
	 */
	@Test
	public void testSave() {
		String randomSalt = StringUtils.getRandomSalt();
		Userinfo user=new Userinfo();
		user.setAvatar(null);//TODO (senyer) improved the code
		user.setDelFlag("0");//TODO (senyer) improved the code
		user.setEgbUserKey("jbf");//TODO (senyer) improved the code
		user.setLoginName("senyer");//登录名
		user.setPassword(new Md5Hash("123456", randomSalt, 8).toString());//设置密码，加盐，MD5迭代次数
		user.setSalt(randomSalt);
		user.setStatus("0");
		user.setTele("17521361640");
		user.setUsername("测试用户");//用户昵称
		user.setIotUserKey("admin");//TODO (senyer) improved the code
		userinfoService.save(user);
	}

	@Test
	public void testListByIds() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOneWrapperOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testListWrapperOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		List<Userinfo> list = userinfoService.list();
		log.info(list.toString());
	}

}
