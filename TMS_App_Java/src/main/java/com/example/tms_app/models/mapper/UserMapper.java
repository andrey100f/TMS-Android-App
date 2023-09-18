package com.example.tms_app.models.mapper;

import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.user.UserDto;
import com.example.tms_app.models.dto.user.UserPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserMapper() {
    }

    public UserDto convertModelTodDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setCustomerName(user.getCustomerName());
        userDto.setImageUrl(user.imageUrl());
        return userDto;
    }

    public User convertPostDtoToModel(UserPostDto userPostDto) {
        User user = new User();
        user.setUsername(userPostDto.getUsername());
        user.setEmail(userPostDto.getEmail());
        user.setPassword(userPostDto.getPassword());
        user.setCustomerName(userPostDto.getCustomerName());
        user.setImageUrl(userPostDto.getImageUrl());
        return user;
    }

    public List<UserDto> convertModelListToDtoList(List<User> users) {
        List<UserDto> result = new ArrayList<>();
        for(User user: users) {
            result.add(convertModelTodDto(user));
        }
        return result;
    }
}
