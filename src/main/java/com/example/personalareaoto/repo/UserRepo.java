package com.example.personalareaoto.repo;

import com.example.personalareaoto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
