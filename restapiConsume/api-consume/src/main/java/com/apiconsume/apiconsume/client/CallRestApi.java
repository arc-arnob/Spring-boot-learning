package com.apiconsume.apiconsume.client;

import com.apiconsume.apiconsume.model.Person;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallRestApi{
    public void getEmployees(){
    String url = "http://localhost:8080/employees";
     
    RestTemplate restTemplate = new RestTemplate();
    Person result = restTemplate.getForObject(url, Person.class);
     
    System.out.println(result.getName()); 
    }
}