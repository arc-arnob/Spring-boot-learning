package com.apiconsume.apiconsume.controller;

import java.util.Arrays;
import java.util.List;

import com.apiconsume.apiconsume.client.CallRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get-all")
    public List<Object> getEmployees(){
        String url = "http://localhost:8080/employees";
        Object result = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(result);
    }
    

}