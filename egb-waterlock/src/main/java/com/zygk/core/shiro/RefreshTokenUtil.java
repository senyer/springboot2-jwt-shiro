package com.zygk.core.shiro;

import java.util.Date;

import org.apache.shiro.authc.AuthenticationToken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

/*
 * 用户可以凭此refresh_token读取新的token
 */
@Slf4j
public class RefreshTokenUtil {

	/*
	 * 此处可以配置到配置文件
	 */
	private static long EXPIRE_TIME = (long)43200*60*1000;

	private static final String USERNAME = "tickets";

	/**
	 * 校验token是否正确
	 *
	 * @param token    密钥
	 * @param username 用户名
	 * @param secret   用户的密码
	 * @return 是否正确
	 */
	public static boolean verify(String token, String username, String secret) {
		try {
			// 根据密码生成JWT效验器
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).withClaim(USERNAME, username).build();
			// 效验TOKEN
			verifier.verify(token);
			return true;
		} catch (Exception exception) {
			log.error("JWT verify failure:{}", exception);
			return false;
		}
	}

	/**
	 * 获得token中的信息无需secret解密也能获得
	 *
	 * @return token中包含的用户名
	 */
	public static String getUsername(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(USERNAME).asString();
		} catch (JWTDecodeException e) {
			log.error("JWT getUsername failure:{}", e);
			return null;
		}
	}

	/**
	 * 生成签名，具有时效性
	 *
	 * @param username 用户名
	 * @param secret   用户的密码
	 * @return 加密的token
	 */
	public static String sign(String username, String secret) {
		long currentTimeMillis = System.currentTimeMillis();
		long time= currentTimeMillis+ EXPIRE_TIME;
		Date date = new Date(time);
		Algorithm algorithm = Algorithm.HMAC256(secret);
		// 附带username信息
		return JWT.create().withClaim(USERNAME, username).withExpiresAt(date).sign(algorithm);

	}
	
	public static void main(String[] args) {
		String username="senyer";
		String password="b72e2ec261c75e3a4487e82bbf2096e6";
		String sign = sign(username,password);
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Njc1MDU0MjQsInVzZXJuYW1lIjoic2VueWVyIn0.CzvTmgybua8SqFv1BYLbnunh-orrm-ZKJvwcw8CaZQg";
		boolean verify = verify(token,username,password);
		System.out.println(sign);
		System.out.println(verify);
	}
	
	
}