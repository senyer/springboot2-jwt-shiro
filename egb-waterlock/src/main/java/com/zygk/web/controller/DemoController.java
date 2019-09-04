package com.zygk.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("demo")
@Api(tags="swagger测试样例")
public class DemoController {
	
	@GetMapping("hello")
	@ApiOperation("打个招呼")
	public String hello() {
		log.info("=================Hello Water Lock Project=======================");
		return "Hello Water Lock Project";
	}

}
