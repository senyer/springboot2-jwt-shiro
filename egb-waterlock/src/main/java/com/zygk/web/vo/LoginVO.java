package com.zygk.web.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 	用户登录后返回的信息
 * 
 */
@Data
@ApiModel(value="用户登录返回信息")
public class LoginVO {
	@ApiModelProperty(value="昵称",name="username")
	private String username;
	@ApiModelProperty(value="登录名",name="loginName")
	private String loginName;
	@ApiModelProperty(value="用户头像",name="avator")
	private String avator;
	@ApiModelProperty(value="手机号",name="tele")
	private String tele;
	@ApiModelProperty(value="访问令牌",name="token")
	private String token;
	@ApiModelProperty(value="刷新令牌",name="refreshToken")
	private String refreshToken;
	@ApiModelProperty(value="角色名",name="roleName")
	private String roleName;
	@ApiModelProperty(value="服务端通信key",name="key")
	private String key;
	@ApiModelProperty(value="角色关键字",name="roleKey")
	private String roleKey;
}
