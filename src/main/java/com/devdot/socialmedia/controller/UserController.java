/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devdot.socialmedia.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sachira Madhushan
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    
    @GetMapping("/{id}")
    public String getUser(@PathVariable int id){
        return "Get User"+id;
    }
    
    @PostMapping()
    public String createUser(){
        return "User Created";
    }
    
    @DeleteMapping
    public String deleteUser(){
        return "User Deleted";
    }
    
    @PutMapping
    public String updateUser(){
        return "User Updated";
    }
}
