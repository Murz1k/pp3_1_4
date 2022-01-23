package com.example.pp3_1_1.controller;

import com.example.pp3_1_1.model.User;
import com.example.pp3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {

    private UserRepository userRepository;

    @Autowired
    public void setUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String login(Principal principal, Model model) {
        User user = userRepository.findUserByUsername(principal.getName());
        model.addAttribute("user", user);

        return "/show";
    }
}
