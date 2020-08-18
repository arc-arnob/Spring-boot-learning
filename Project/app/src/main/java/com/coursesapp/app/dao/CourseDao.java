package com.coursesapp.app.dao;

import com.coursesapp.app.entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long>{

}

