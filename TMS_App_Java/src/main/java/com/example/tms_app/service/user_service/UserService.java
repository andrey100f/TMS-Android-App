package com.example.tms_app.service.user_service;

import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.LogInDto;
import com.example.tms_app.models.dto.user.UserDto;
import com.example.tms_app.models.dto.user.UserPostDto;
import com.example.tms_app.models.exceptions.models.EntityNotFoundException;
import com.example.tms_app.models.mapper.UserMapper;
import com.example.tms_app.repository.UserRepository;
import com.example.tms_app.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto getUserById(UUID userId) {
        User user = this.userRepository.getUserByUserId(userId);
        if(user == null) {
            throw new EntityNotFoundException("User Not Found");
        }
        return this.userMapper.convertModelTodDto(user);
    }

    @Override
    public UserDto saveUser(UserPostDto userPostDto) {
        User user = this.userMapper.convertPostDtoToModel(userPostDto);
        user.setUserRole(this.userRoleRepository.getUserRoleByRoleId(UUID.fromString("D657939B-5E07-4288-B903-455069627F61")));
        User userSaved = this.userRepository.save(user);
        return this.userMapper.convertModelTodDto(userSaved);
    }

    @Override
    public UserDto updateUser(UserPostDto userPostDto, UUID userId) {
        User user = this.userRepository.getUserByUserId(userId);
        user.setUserRole(this.userRoleRepository.getUserRoleByRoleId(UUID.fromString("D657939B-5E07-4288-B903-455069627F61")));
        user.setUsername(userPostDto.getUsername());
        user.setEmail(userPostDto.getEmail());
        user.setPassword(userPostDto.getPassword());
        user.setCustomerName(userPostDto.getCustomerName());
        user.setImageUrl(userPostDto.getImageUrl());
        User userUpdated = this.userRepository.save(user);
        return this.userMapper.convertModelTodDto(userUpdated);
    }

    @Override
    public void deleteUser(UUID userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = this.userRepository.getUserByUsername(username);
        if(user == null) {
            throw new EntityNotFoundException("User Not Found");
        }
        return this.userMapper.convertModelTodDto(user);
    }

    @Override
    public User logIn(LogInDto userDto) {
        User user = userRepository.getUserByUsername(userDto.getUsername());
        if(user == null) {
            throw new EntityNotFoundException("User Not Found!!");
        }
        if(!user.getPassword().equals(userDto.getPassword())) {
            throw new EntityNotFoundException("User Not Found!!");
        }
        return user;
    }
}
