package com.zygk.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="刷新token接口返回信息")
public class FreshTokenVO {
	@ApiModelProperty(value="新的访问令牌",name="token")
	private String token;
	@ApiModelProperty(value="回显刷新令牌",name="refreshToken")
	private String refreshToken;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	
}
