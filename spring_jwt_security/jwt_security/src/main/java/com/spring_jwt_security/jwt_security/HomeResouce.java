package com.spring_jwt_security.jwt_security;

import com.spring_jwt_security.jwt_security.models.AuthenticationRequest;
import com.spring_jwt_security.jwt_security.models.AuthenticationResponse;
import com.spring_jwt_security.jwt_security.services.MyUserDetailsService;
import com.spring_jwt_security.jwt_security.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResouce {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService userDetailService;

    @Autowired
    JwtUtil jwtTokenUtil;

    @GetMapping("/home")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
            try{
            authenticationManager.authenticate(
                
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
                
            }catch(BadCredentialsException e){
                System.out.println(authenticationRequest.getUsername()); //debug
                System.out.println(authenticationRequest.getPassword()); //debug
                throw new Exception("Username or password wrong");
            }
            
            UserDetails userDetails = userDetailService
            .loadUserByUsername(authenticationRequest.getUsername());

            String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }   

    
}