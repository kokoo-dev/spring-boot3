package com.kokoo.springboot3.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello-world")
public class HelloWorldController {

    @GetMapping(value = "")
    public boolean getHelloWorld() {
        return true;
    }
}
