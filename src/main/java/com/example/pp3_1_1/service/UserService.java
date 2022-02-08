package com.example.pp3_1_1.service;

import com.example.pp3_1_1.dto.UserDto;
import com.example.pp3_1_1.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(long id, User user);

    void removeUser(long id);

    User getUserById(long id);

    User convertUserDtoToUser(UserDto userDto);

    List<User> getAllUsers();

    User getUserByEmail(String email);


}
