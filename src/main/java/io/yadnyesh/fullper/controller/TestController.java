package io.yadnyesh.fullper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String sendhello() {
        return "Hello!";
    }

    @GetMapping("/v2")
    public String sendhelloV2() {
        return "Hello from v2!";
    }

}
