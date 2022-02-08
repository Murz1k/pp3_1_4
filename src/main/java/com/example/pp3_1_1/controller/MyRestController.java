package com.example.pp3_1_1.controller;


import com.example.pp3_1_1.dto.UserDto;
import com.example.pp3_1_1.model.User;
import com.example.pp3_1_1.service.RoleService;
import com.example.pp3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/admin")
public class MyRestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public MyRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();

        return (list != null && !list.isEmpty())
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);

        return (user != null)
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = userService.convertUserDtoToUser(userDto);
        userService.addUser(user);

        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto, @PathVariable long id) {
        User user = userService.convertUserDtoToUser(userDto);
        user.setId(userDto.getId());
        userService.updateUser(id, user);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        userService.removeUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
