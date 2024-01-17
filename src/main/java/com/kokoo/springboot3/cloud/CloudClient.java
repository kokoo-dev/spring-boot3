package com.kokoo.springboot3.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "cloudClient", url = "http://localhost:8082", path = "/cloud/sleuth")
public interface CloudClient {

    @GetMapping("")
    void testSleuth();
}
