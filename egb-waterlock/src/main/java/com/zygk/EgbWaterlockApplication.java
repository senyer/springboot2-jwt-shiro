package com.zygk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zygk.web.domain.*.persistence")//最好在这里做统一扫描，不然在每个mapper接口文件加上@Mapper很麻烦
public class EgbWaterlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgbWaterlockApplication.class, args);
	}

}
