package com.springauth.springauthorizationauthentication;

import java.util.Optional;

import com.springauth.springauthorizationauthentication.models.MyUserDetail;
import com.springauth.springauthorizationauthentication.models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username); // <-- Working fine
        Optional<Users> user = userRepo.findByUserName(username); // Empty return
        System.out.println(user); //optional.empty <--
        System.out.println("Here before"); //debug <-- running
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found"+ username));
        System.out.println("Here"); //debug
        return user.map(MyUserDetail::new).get();
    }

    
    
}