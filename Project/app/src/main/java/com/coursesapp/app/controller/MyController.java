package com.coursesapp.app.controller;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import com.coursesapp.app.entities.Course;
import com.coursesapp.app.services.CourseService;


@RestController
public class MyController {

    @Autowired 
    private CourseService courseService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/home")
    public String home(){
        return "Welcome to Courses Application";
    }
    // get the courses
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/courses", produces = {"application/xml","application/json"}) 
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    //get single Course
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    // Send data to server
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/courses")
    public Course addOrUpdate(@RequestBody Course course){
        return this.courseService.addOrUpdate(course);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}