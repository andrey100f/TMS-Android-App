package com.example.tms_app.controller;

import com.example.tms_app.models.dto.user.UserDto;
import com.example.tms_app.models.dto.user.UserPostDto;
import com.example.tms_app.service.user_service.IUserService;
import com.example.tms_app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/details/{userId}")
    public UserDto getUserById(@PathVariable UUID userId) {
        return this.userService.getUserById(userId);
    }

    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return this.userService.getUserByUsername(username);
    }

    @PostMapping("")
    public UserDto saveUser(@RequestBody UserPostDto userPostDto) {
        return this.userService.saveUser(userPostDto);
    }

    @PatchMapping("/{userId}")
    public UserDto updateUser(@RequestBody UserPostDto userPostDto, @PathVariable UUID userId) {
        return this.userService.updateUser(userPostDto, userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        this.userService.deleteUser(userId);
    }
}
