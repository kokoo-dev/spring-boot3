package com.kokoo.springboot3.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@Configuration
@ConditionalOnProperty(prefix = "spring.cloud.zookeeper", name = "enabled", havingValue = "true")
public class ZookeeperConfig {
}
