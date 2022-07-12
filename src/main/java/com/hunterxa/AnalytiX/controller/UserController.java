package com.hunterxa.AnalytiX.controller;

import com.hunterxa.AnalytiX.entity.User;
import com.hunterxa.AnalytiX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping
    public void addNewUser(User user) {
        userService.addNewUser(user);
    }
}
