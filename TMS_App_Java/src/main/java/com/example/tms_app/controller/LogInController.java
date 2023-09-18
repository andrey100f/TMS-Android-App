package com.example.tms_app.controller;

import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.LogInDto;
import com.example.tms_app.models.dto.user.UserDto;
import com.example.tms_app.service.user_service.IUserService;
import com.example.tms_app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/login")
public class LogInController {
    private final IUserService userService;

    @Autowired
    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User login(@RequestBody LogInDto userDto) {
        return this.userService.logIn(userDto);
    }
}