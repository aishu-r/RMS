package com.spartan.user_details.repository;

import com.spartan.user_details.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByEmail(String email);
}