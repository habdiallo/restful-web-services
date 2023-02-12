package com.habdiallo.react.webservices.restfulwebservices.security.user;

import com.habdiallo.react.webservices.restfulwebservices.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String email);
}
