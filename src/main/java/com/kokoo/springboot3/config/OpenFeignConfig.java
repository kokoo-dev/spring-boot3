package com.kokoo.springboot3.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.kokoo.springboot3")
@Configuration
public class OpenFeignConfig {

}
