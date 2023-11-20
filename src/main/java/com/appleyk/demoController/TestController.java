package com.appleyk.demoController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {


    @GetMapping("/jenkins")
    public String getHello(){
        return "HELLO-JENKINS SUCCESS";
    }
}
