package com.securitydemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home")
public class LoginController {

    @GetMapping(path = "/login")
    public ResponseEntity<String> loginForAllUsers(){
        return ResponseEntity.ok("This is for all the users");
    }
}
