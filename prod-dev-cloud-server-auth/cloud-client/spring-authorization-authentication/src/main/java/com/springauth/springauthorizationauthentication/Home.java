package com.springauth.springauthorizationauthentication;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Home {
    
    @GetMapping("/")
    public String home(){
        return "Welcome to home!";
        
    }
    @GetMapping("/user")
    public String user(){
        return "Welcome to user!";
        
    }
    @GetMapping("/admin")
    public String admin(){
        return "Welcome to admin!";
        
    }


}