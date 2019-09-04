package com.zygk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zygk.common.base.BaseController;
import com.zygk.common.enums.MsgEnum;
import com.zygk.common.response.R;
import com.zygk.web.service.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("api")
@Api(tags = "手机终端App接口")
public class AppController extends BaseController {

	@Autowired
	private ApiService apiService;
	
	

	@ApiOperation(value = "系统登陆")
	@PostMapping("/login")
	@ApiImplicitParams({ @ApiImplicitParam(name = "loginName", required = true, example = "senyer", value = "登录名"),
			@ApiImplicitParam(name = "password", required = true, example = "123456", value = "密码") })
	public R login(String loginName, String password) {
		return success(apiService.login(loginName, password));
	}


	@GetMapping("/refresh_token")
	@ApiOperation(value = "获取新的token")
	public R refreshToken(String refresh_token) {
		return success(apiService.refreshToken(refresh_token));
	}
	
	@GetMapping("/binding")
	@ApiOperation(value = "绑定水箱锁和NFC卡信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "nfc", required = true, example = "", value = "nfc唯一标识（手机感应获取）"),
		@ApiImplicitParam(name = "devID", required = true, example = "", value = "设备串号（扫码获取）") })
	public R binding(String nfc, String devID) {
		
		//TODO (senyer)
		return error();
	}
	

	
	
	@ApiOperation(value = "系统未登录提示信息:401 /未授权")
	@ApiIgnore
	@GetMapping("/unLogin")
	public R unLogin() {
		return error(MsgEnum.AUTHENTICATION);
	}
}
