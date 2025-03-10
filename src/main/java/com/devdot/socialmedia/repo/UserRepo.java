/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.devdot.socialmedia.repo;
import com.devdot.socialmedia.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Sachira Madhushan
 */
public interface UserRepo extends JpaRepository<User, Integer>{
    boolean existsByEmail(String email);
    
    Optional<User> findByEmail(String email);
}
