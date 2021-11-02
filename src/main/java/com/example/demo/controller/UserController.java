package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user-by-id/{id}")
    public UserResponse getUserById(@PathVariable Integer id)
    {
        User user = userService.findById(id);

        return new UserResponse().userResponseResponse(user);
    }

    @PutMapping(value = "/user-update/{id}")
    public User updateUser(@PathVariable(value = "id") int id, @RequestBody UserRequest updateUserRequest)
    {
        return userService.updateUser(id,updateUserRequest.getName(),updateUserRequest.getAge());
    }
}
