package com.example.pp3_1_1.service;

import com.example.pp3_1_1.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleByName(String roleName);
}
