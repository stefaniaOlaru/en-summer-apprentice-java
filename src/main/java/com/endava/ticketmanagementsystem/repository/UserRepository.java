package com.endava.ticketmanagementsystem.repository;

import com.endava.ticketmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findUserById(Integer userId);
}
