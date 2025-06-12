package com.project.loginForm.service;

import com.project.loginForm.model.User;
import com.project.loginForm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User>getRegistrations(){
        return userRepository.findAll();
    }
    public User register(User user){

        String password = user.getPassword();
        String email = user.getEmail();
        if(userRepository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email Already Exist");
        }
        if(password.length()>=8){
            return userRepository.save(user);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"password less than 8 characters");
        }

    }

    public boolean login(String email, String password){
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
