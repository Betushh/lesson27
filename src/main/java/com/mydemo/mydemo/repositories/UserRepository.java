package com.mydemo.mydemo.repositories;

import com.mydemo.mydemo.Models.security.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @EntityGraph(attributePaths = {"authorities"})
    Optional<User> findByUsername(String username);
}
