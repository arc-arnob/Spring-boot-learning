package com.multiplejpa.multiplejpa.TaskService.Repository;

import com.multiplejpa.multiplejpa.TaskService.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
