package com.example.pp3_1_1.controller;

import com.example.pp3_1_1.model.Role;
import com.example.pp3_1_1.model.User;
import com.example.pp3_1_1.service.RoleService;
import com.example.pp3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminsController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminsController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String index(Model model, Principal principal) {
        model.addAttribute("loggedUser", userService.getUserByEmail(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());

        return "index";
    }

    @GetMapping("/user")
    public String showUser(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByEmail(principal.getName()));

        return "show_admin";
    }

    @GetMapping("/new")
    public String addUser(Model model, Principal principal) {
        model.addAttribute("loggedUser", userService.getUserByEmail(principal.getName()));
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());

        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam("listRoles[]") String[] listRoles) {
        Set<Role> set = new HashSet<>();

        for (String s : listRoles) {
            set.add(roleService.getRoleByName(s));
        }

        user.setRoles(set);
        userService.addUser(user);

        return "redirect:/admin/";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id,
                         @RequestParam("listRoles[]") String[] listRoles) {
        Set<Role> set = new HashSet<>();

        for (String s : listRoles) {
            set.add(roleService.getRoleByName(s));
        }

        user.setRoles(set);
        userService.updateUser(id, user);

        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);

        return "redirect:/admin/";

    }
}
