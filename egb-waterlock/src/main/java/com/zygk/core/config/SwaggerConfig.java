package com.zygk.core.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Component
public class SwaggerConfig {
    public static final String WEB_VERSION = "1.0.0";
    public static final String APP_VERSION = "1.0.0";
    public static final String SWAGGER_SCAN_WEB_PACKAGE = "com.zygk.web.controller";
    
	@Bean
    public Docket appRestApi() {
		
		
		//添加head参数
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	tokenPar.name("Authorization").description("token令牌(除登入/出&刷新token方法，其他方法必须带上此请求头参数)").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("").build();
    	pars.add(tokenPar.build());
		
        return new Docket(DocumentationType.SWAGGER_2)
        		.globalOperationParameters(pars)
        		.groupName("APP分组")
        		.apiInfo(apiAPPInfo())
        		.useDefaultResponseMessages(false)
        		.enableUrlTemplating(false)
        		.forCodeGeneration(false)
        		.select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_WEB_PACKAGE))//多个controller就用通配符
	            // 扫描所有有注解的api
	            /*.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))*/
	            //.paths(PathSelectors.any())
                .paths(PathSelectors.regex(".*/api/.*"))
	            .build();
    }
	
    private ApiInfo apiAPPInfo() {
        return new ApiInfoBuilder()
        		.title("二供部智能水箱锁项目APP端接口文档")
        		.description("app后端接口文档")
                .version(APP_VERSION)
                .build();
    }

//==============================================================================================================================================
    
	@Bean
    public Docket webRestApi() {
		//添加head参数
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	tokenPar.name("Authorization").description("token令牌(除登入/出&刷新token方法，其他方法必须带上此请求头参数)").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
    	pars.add(tokenPar.build());
		
    	
        return new Docket(DocumentationType.SWAGGER_2)
        		.globalOperationParameters(pars)
        		.groupName("Web端分组")
        		.apiInfo(apiWebInfo())
        		.useDefaultResponseMessages(false)
        		.enableUrlTemplating(false)
        		.forCodeGeneration(false)
        		.select()
        		.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_WEB_PACKAGE))//多个controller就用通配符
        		// 扫描所有有注解的api
	            //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        		.paths(PathSelectors.regex(".*/web/.*"))
	            .build();
    }

    private ApiInfo apiWebInfo() {
        return new ApiInfoBuilder()
        		.title("二供部智能水箱锁项目Web端接口文档")
        		.description("web后端接口文档")
                .version(WEB_VERSION)
                .build();
    }
}
