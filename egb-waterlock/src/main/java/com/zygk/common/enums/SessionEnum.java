package com.zygk.common.enums;

/**
 *
 * @author: TSY
 * @date: 2018-06-30
 * 
 *        Session会话保存信息的key
 **/
public enum SessionEnum {
	LOGIN_USER_INFO("login_user_info"),// 用户key
	DYNAMIC_SECRET_KEY("dynamic_secret_key"),// 动态秘钥
	DYNAMIC_TOKEN("dynamic_token");// 动态秘钥
	private String desc;// 描述

	private SessionEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.desc;
	}
}
