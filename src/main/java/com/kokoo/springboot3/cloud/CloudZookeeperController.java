package com.kokoo.springboot3.cloud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.zookeeper.serviceregistry.ServiceInstanceRegistration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperServiceRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cloud/zookeeper")
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "spring.cloud.zookeeper", name = "enabled", havingValue = "true")
public class CloudZookeeperController {

    private final DiscoveryClient discoveryClient;
    private final ZookeeperServiceRegistry zookeeperServiceRegistry;
    private final LoadBalancerClient loadBalancerClient;

    @GetMapping("/service")
    public List<String> getZookeeperServices() {
        return discoveryClient.getServices();
    }

    @GetMapping("")
    public List<ServiceInstance> getZookeeperInstances() {
        return discoveryClient.getInstances("/sample/anotherService");
    }

    @PostMapping("")
    public void postZookeeperInstance() {
        ServiceInstanceRegistration serviceInstanceRegistration = ServiceInstanceRegistration.builder()
                .defaultUriSpec()
                .address("/sample-url")
                .port(9000)
                .name("/sample/anotherService")
                .build();

        zookeeperServiceRegistry.register(serviceInstanceRegistration);
    }

    @GetMapping("/load-balancer")
    public ServiceInstance getInstanceByLoadBalancer() {
        return loadBalancerClient.choose("/sample/anotherService");
    }
}
