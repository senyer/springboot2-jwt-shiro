package com.zygk.common.exception;

import org.apache.shiro.ShiroException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zygk.common.enums.MsgEnum;
import com.zygk.common.response.R;
import lombok.extern.slf4j.Slf4j;

/**
 * @author TSY
 *
 * @Date: 2018-09-11
 *
 *        统一的异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


	
	/**
	 * 	处理http请求方式不正确   
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public R handHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		log.error("[统一异常处理]--[请求方式] {}  ", ex.toString());
		return new R(MsgEnum.HTTP_REQUEST_ERROR,ex.getMessage());
	}
	

	
	/**
	 *	 处理未知异常信息 
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public R handUnkonwException(Exception ex) {
		log.error("[统一异常处理]--[未知异常]  {} ", ex);
		return new R(MsgEnum.ERROR,ex.getMessage());
	}
	
	/**
	 * 	处理用户授权异常
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ShiroException.class)
	public R handShiroException(ShiroException ex) {
		log.error("[统一异常处理]--[ShiroException异常]  {}", ex);
		return new R(MsgEnum.AUTHORIZATION,ex.getMessage());
	}
	
}
