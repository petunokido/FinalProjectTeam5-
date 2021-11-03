package com.example.demo.service;

import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(UserNotFound::new);
    }

    public User updateUser (int id, String name, int age)
    {
        User updateUser = this.findById(id);
        updateUser.setUserName(name);
        updateUser.setAge(age);
        userRepository.save(updateUser);
        return updateUser;
    }
 }
