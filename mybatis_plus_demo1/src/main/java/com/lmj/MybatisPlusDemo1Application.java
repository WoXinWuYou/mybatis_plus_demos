package com.lmj;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@MapperScan("com.lmj.mapper")
public class MybatisPlusDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemo1Application.class, args);
    }
    
    /*@Bean
    public PaginationInnerInterceptor PaginationInnerInterceptor() {
        PaginationInnerInterceptor PaginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // PaginationInnerInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // PaginationInnerInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        //PaginationInnerInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return PaginationInnerInterceptor;
    }*/
    
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer(){
		return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING); // 代码解读：Jackson2ObjectMapperBuilderCustomizer接口的匿名函数实现；lambda表达式返回的是一个接口实现类实例；
	}

	/*@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer(){
	    return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
	}*/
}
