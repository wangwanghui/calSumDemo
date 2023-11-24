package com.appleyk.demoController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class TestController {


    @GetMapping("/jenkins")
    @ResponseBody
    public String getHello(){
        return "HELLO-JENKINS-docker SUCCESS";
    }
}
