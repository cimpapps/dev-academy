package com.orange.devacademy.mediaservice.controller;

import com.orange.devacademy.mediaservice.model.User;
import com.orange.devacademy.mediaservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody User user) {
        userService.registerUser(user);
    }

}
