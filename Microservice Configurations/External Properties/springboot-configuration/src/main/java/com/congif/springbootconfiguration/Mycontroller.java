package com.congif.springbootconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
    @Value("${my.greeting}")
    private String greetings;

    @Value("${my.message}")
    private String message;

    @GetMapping("/message")
    public String getMessage(){
        return greetings;
    }
    @GetMapping("/internal")
    public String getInternalMessage(){
        return message;
    }
}