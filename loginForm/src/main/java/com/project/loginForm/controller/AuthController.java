package com.project.loginForm.controller;

import com.project.loginForm.model.User;
import com.project.loginForm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("registrations")
    public List<User>getRegistrations(){
        return userService.getRegistrations();
    }

    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.register(user));
        } catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody Map<String,String>loginData){

        boolean valid = userService.login(loginData.get("email"),loginData.get("password"));

        if(valid){
            return ResponseEntity.ok("Login successful!");
        }
        else{
            return new ResponseEntity<>("Password or email wrong", HttpStatus.BAD_REQUEST);
        }
    }
}
