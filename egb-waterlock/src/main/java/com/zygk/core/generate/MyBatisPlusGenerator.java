package com.zygk.core.generate;
 
import java.sql.SQLException;
 
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
 
public class MyBatisPlusGenerator {
	/**
	 * 具体参考官方源码：https://gitee.com/baomidou/mybatis-plus/tree/3.0/mybatis-plus-generator/src/main/java/com/baomidou/mybatisplus/generator/config
	 */
	public static void main(String[] args) throws SQLException {
		//1. 全局配置
				GlobalConfig config = new GlobalConfig();
				config.setActiveRecord(true) // 是否支持AR模式
					  .setAuthor("Senyer") // 作者
					  .setOutputDir("D:\\workspace\\workspace-simrel\\egb-waterlock\\src\\main\\java") // 生成路径 --项目右键Properties--Resource---可以看到项目的路径
					  .setFileOverride(true)  // 文件覆盖
					  .setIdType(IdType.AUTO) // 主键策略
					  .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I，%s 为占位符“I%sService”
					  .setSwagger2(false)//是否开启 swagger2 模式
		 			  .setBaseResultMap(true)//生成基本的resultMap
		 			  .setBaseColumnList(true);//生成基本的SQL片段 
					  
				
		//2. 数据源配置
				DataSourceConfig  dsConfig  = new DataSourceConfig();
				dsConfig.setDbType(DbType.SQL_SERVER)  // 设置数据库类型
						.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
						.setUrl("jdbc:sqlserver://192.168.100.170;DatabaseName=water_lock")
						.setUsername("sa")
						.setPassword("123456");
				 
		//3. 策略配置globalConfiguration中
				StrategyConfig stConfig = new StrategyConfig();
				stConfig.setCapitalMode(true) //全局大写命名
						.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
						//.setTablePrefix("sys_")//表前缀,如果不给定，则会默认给实体类加上此前缀：即User可能就变成了：SysUser。
						.setTablePrefix(new String[]{"sys_","wl"})// 此处提供多个表的前缀去除
						.setEntityLombokModel(true)//【实体】是否为lombok模型（默认 false）
						.setRestControllerStyle(true)//restControllerStyle 生成@RestController 控制器
						.entityTableFieldAnnotationEnable(true)//是否生成实体时，生成字段注解
						//.setInclude(new String[] {"community","district","oaBmManager","pumproom","RealTimeValue","ResBuild","unitName","tagDesc"}) // 需要生成的表
                        // .setExclude(new String[]{"table_B","table_C"}) // 排除生成的表
						;  // 需要包含的表名，允许正则表达式（与exclude二选一配置）
				
		//4. 包名策略配置 
				PackageConfig pkConfig = new PackageConfig();
				pkConfig.setParent("")//父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名,建议写空，这样，可以让xml文件写入到templates下面，更为规范。
						.setMapper("com.zygk.web.domain.local.persistence")//dao
						.setService("com.zygk.web.service")//servcie
						.setServiceImpl("com.zygk.web.service.impl")
						.setController("com.zygk.web.controller")//controller
						.setEntity("com.zygk.web.domain.local.entity")
						.setXml("mappers.local");//mapper.xml   //即："/templates/mapper.xml"
				
		//5. 整合配置
				AutoGenerator  ag = new AutoGenerator();
				ag.setGlobalConfig(config)
				  .setDataSource(dsConfig)
				  .setStrategy(stConfig)
				  .setPackageInfo(pkConfig);
				
		//6. 执行
				ag.execute();
	}
 
}
