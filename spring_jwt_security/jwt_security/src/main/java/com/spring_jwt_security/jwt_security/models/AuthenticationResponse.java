package com.spring_jwt_security.jwt_security.models;

public class AuthenticationResponse {
    private final String jwt;

    
    public String getJwt() {
        return jwt;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    
    
}