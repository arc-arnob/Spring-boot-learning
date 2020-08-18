package com.coursesapp.app.services;

import java.util.List;


import com.coursesapp.app.entities.Course;



public interface CourseService {

    public List<Course> getCourses();
    
    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public Course addOrUpdate(Course course);

    public void deleteCourse(long course);

}