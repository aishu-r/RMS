package com.spartan.user_details.controller;

import com.spartan.user_details.model.UserDetails;
import com.spartan.user_details.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDetails> registerUser(@RequestBody UserDetails userDetails) {
        return ResponseEntity.ok(userService.registerUser(userDetails));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(userService.loginUser(email, password));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetails> updateUser(@PathVariable Long id, @RequestBody UserDetails userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}