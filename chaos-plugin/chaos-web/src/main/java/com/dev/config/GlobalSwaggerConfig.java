/*
 * @(#) GlobalSwaggerConfig.java 2018/09/19
 *
 * Copyright 2018 CEC(Fujian) Healthcare Big Data Operation Service Co., Ltd. All rights reserved.
 */
package com.dev.config;


import com.dev.core.util.StringUtils;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * GlobalSwaggerConfig
 *
 * @author dengrijin
 * @version v0.1 2018/09/19
 * @since JDK1.8
 */
@Configuration
@EnableSwagger2
@Profile({"!prod"})
public class GlobalSwaggerConfig {

    @Value("${chaos.swagger.title:app接口文档}")
    String title;

    @Value("${chaos.swagger.scan:com.dev}")
    String apiBasePackage;

    @Value("${chaos.swagger.version:1.0}")
    String version;

    @Bean
    public Docket customDocket() {
        //
        if(StringUtils.isBlank(apiBasePackage)){
            return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                    .paths(Predicates.not(PathSelectors.regex("/error.*")))
                    .build()
                    .apiInfo(apiInfo());
        }else {
            return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(apiBasePackage))
                    .paths(Predicates.not(PathSelectors.regex("/error.*")))

                    .build()
                    .apiInfo(apiInfo());
        }
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                //版本号
                .version(version)
                .build();
    }
}
