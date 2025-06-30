package com.project.loginForm.service;

import com.project.loginForm.model.User;
import com.project.loginForm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
            user.setPassword(passwordEncoder.encode(password));
            return userRepository.save(user);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"password less than 8 characters");
        }

    }

    public boolean login(String email, String password){
        User user = userRepository.findByEmail(email);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    public boolean deleteUser(Long id){
        Optional<User>optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
