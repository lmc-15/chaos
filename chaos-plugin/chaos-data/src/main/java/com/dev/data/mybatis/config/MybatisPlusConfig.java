package com.dev.data.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlusConfig
 *
 * 1、默认填充策略
 * 2、分页插件
 *
 *
 * @author dengrijin
 * @version v0.1 2020/07/16
 */
@Configuration
@EnableTransactionManagement
@AutoConfigureBefore(MyMetaObjectHandler.class)
public class MybatisPlusConfig {

    @ConditionalOnMissingBean(FieldFillConfig.class)
    @Bean
    FieldFillConfig fieldFillConfig() {

        return new FieldFillConfig();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
}
