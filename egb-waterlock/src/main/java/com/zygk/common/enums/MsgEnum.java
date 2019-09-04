package com.zygk.common.enums;

/**
 *
 * @author: TSY
 * @date: 2018-06-30 页面返回提示信息，使用的枚举
 **/
public enum MsgEnum {
	SUCCESS("success",200),     
	AUTHENTICATION("Unauthorized",401), 
	AUTHORIZATION("Unauthorized",401), 
	LOGIN_FILURE("登录失败",400),
	LOGIN_TIMEOUT("登录过期",402),
	HTTP_REQUEST_ERROR("请求方式错误",1003),  
	USER_NOT_EXIST("用户不存在",2001),  
	PASSWORD_ERROR("密码错误",2002),  
	ERROR("系统异常", -1);

	private String desc;// 描述
	private Integer statusCode;// 状态码

	private MsgEnum(String desc, Integer statusCode) {
		this.desc = desc;
		this.statusCode = statusCode;
	}

	private MsgEnum(String desc) {
		this.desc = desc;
	}

	private MsgEnum(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return this.desc;
	}

}
