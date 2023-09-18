package com.example.tms_app.service.user_service;

import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.LogInDto;
import com.example.tms_app.models.dto.user.UserDto;
import com.example.tms_app.models.dto.user.UserPostDto;

import java.util.UUID;

public interface IUserService {
    UserDto getUserById(UUID userId);
    UserDto saveUser(UserPostDto userPostDto);
    UserDto updateUser(UserPostDto userPostDto, UUID userId);
    void deleteUser(UUID userId);
    public UserDto getUserByUsername(String username);
    User logIn(LogInDto userDto);
}
