package com.dev.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author xilihui
 * @description:
 * @date 2022/2/17
 */
@Configuration
@EnableFeignClients(basePackages = {"com.dev.feign"})
public class OpenFeignConfig {
}
