package com.bootjpa.demoapp.controller;

import com.bootjpa.demoapp.dao.AlienRepo;
import com.bootjpa.demoapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView; 
import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;
    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }
    @PostMapping("/alien")
    public Alien addAlien(Alien alien){
        repo.save(alien);
        return alien;
    }
    @GetMapping(path="/alien") //more like restapi format.
    public List<Alien> getAliens(){
        //ModelAndView mv = new ModelAndView("showalien.jsp");
        
        //Alien alien = repo.findById(aid).orElse(new Alien());
        
        // System.out.println(repo.findByAtech("java"));
        // System.out.println(repo.findByAidGreaterThan(101));
        // System.out.println(repo.findByAtechSorted("java"));

        //mv.addObject(alien);
        return repo.findAll();
    }
    @RequestMapping("/alien/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }
}