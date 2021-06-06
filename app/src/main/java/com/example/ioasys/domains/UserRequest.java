package com.example.ioasys.domains;


public class UserRequest {
    private final String email;
    private final String password;

    public UserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}