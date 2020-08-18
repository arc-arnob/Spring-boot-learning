package com.coursesapp.app.services;


import java.util.List;


import com.coursesapp.app.dao.CourseDao;
import com.coursesapp.app.entities.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServicesImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    public Course getCourse(long courseId) {
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Course addOrUpdate(Course course) {

        courseDao.save(course);
        return course;

    }

    @Override
    public void deleteCourse(long courseId) {

        Course en = courseDao.getOne(courseId);
        courseDao.delete(en);
    
    }

}
