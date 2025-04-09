package com.spartan.user_details.service;

import com.spartan.user_details.model.UserDetails;
import com.spartan.user_details.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails registerUser(UserDetails userDetails) {
        return userRepository.save(userDetails);
    }

    public String loginUser(String email, String password) {
        Optional<UserDetails> user = userRepository.findByEmail(email);
        if (user.isPresent() && password.equals(user.get().getPhoneNumber())) { // Replace with actual password logic
            return "Login successful";
        }
        return "Invalid credentials";
    }

    public UserDetails getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDetails updateUser(Long id, UserDetails userDetails) {
        UserDetails existingUser = getUserById(id);
        existingUser.setFirstName(userDetails.getFirstName());
        existingUser.setLastName(userDetails.getLastName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPhoneNumber(userDetails.getPhoneNumber());
        existingUser.setAddress(userDetails.getAddress());
        existingUser.setDob(userDetails.getDob());
        existingUser.setRole(userDetails.getRole());
        return userRepository.save(existingUser);
    }

    public List<UserDetails> getAllUsers() {
        return userRepository.findAll();
    }
}