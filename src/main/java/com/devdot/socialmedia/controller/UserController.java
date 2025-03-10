/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devdot.socialmedia.controller;

import com.devdot.socialmedia.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devdot.socialmedia.entity.User;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Sachira Madhushan
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUser() {

        List<User> users = userRepo.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody User user) {
        if (userRepo.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("User Already Exists!", HttpStatus.BAD_GATEWAY);
        }
        User newUser = userRepo.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        Optional<User> u = userRepo.findByEmail(user.getEmail());

        if (u.isPresent()) {
            if (u.get().getPassword().equals(user.getPassword())) {
                return new ResponseEntity<>(u, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Username or Password Incorrect!", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("Username or Password Incorrect!", HttpStatus.UNAUTHORIZED);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        Optional<User> u = userRepo.findById(id);

        if (u.isPresent()) {
            userRepo.delete(u.get());
            return new ResponseEntity<>("User Deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        Optional<User> u= userRepo.findByEmail(user.getEmail());
        if(u.isPresent()){
            u.get().setName(user.getName());
            User us=userRepo.save(u.get());
            return new ResponseEntity<>(us,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        }
        
        
    }
}
