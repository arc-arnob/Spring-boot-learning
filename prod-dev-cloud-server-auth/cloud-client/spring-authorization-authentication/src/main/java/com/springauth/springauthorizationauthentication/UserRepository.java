package com.springauth.springauthorizationauthentication;

import java.util.Optional;

import com.springauth.springauthorizationauthentication.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>{


        Optional<Users> findByUserName(String userName);

    
}