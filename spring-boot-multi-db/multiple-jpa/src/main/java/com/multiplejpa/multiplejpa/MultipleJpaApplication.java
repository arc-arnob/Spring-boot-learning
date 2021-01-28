package com.multiplejpa.multiplejpa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.multiplejpa.multiplejpa.TaskService.Repository.TaskRepository;
import com.multiplejpa.multiplejpa.TaskService.model.Task;
import com.multiplejpa.multiplejpa.UserService.Repository.UserRepository;
import com.multiplejpa.multiplejpa.UserService.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.multiplejpa.multiplejpa.UserService.Repository",
				"com.multiplejpa.multiplejpa.UserService.databaseConfiguration",
				"com.multiplejpa.multiplejpa.UserService.model",
				"com.multiplejpa.multiplejpa.TaskService.Repository",
				"com.multiplejpa.multiplejpa.TaskService.dataBaseConfiguration",
				"com.multiplejpa.multiplejpa.TaskService.model"})
@RestController
public class MultipleJpaApplication {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	@PostConstruct
	public void addData2DB() {
		userRepository.saveAll(Stream.of(new User("John"), new User("Pitter")).collect(Collectors.toList()));
		taskRepository.saveAll(Stream.of(new Task("Core Java"), new Task("Spring Boot")).collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getTasks")
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(MultipleJpaApplication.class, args);
	}

}
