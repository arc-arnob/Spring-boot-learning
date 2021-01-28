package com.multiplejpa.multiplejpa.UserService.Repository;

import com.multiplejpa.multiplejpa.UserService.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
