package com.in28minutes.springboot.myfirstwebapplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    //authenticate the user and return true if valid and false if invalid
    public boolean authenticate(String username, String password){
        boolean isValidUsername = username.equalsIgnoreCase("aravind");
        boolean isValidPassword = password.equalsIgnoreCase("password");
        return isValidUsername && isValidPassword;
    }
}
