package com.FANCardPlus.controller;

import com.FANCardPlus.model.User;
import com.FANCardPlus.model.Role;
import com.FANCardPlus.model.UserRole;

import com.FANCardPlus.repository.UserRepository;
import com.FANCardPlus.repository.RoleRepository;
import com.FANCardPlus.repository.UserRoleRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleController (
        UserRepository userRepository,
        RoleRepository roleRepository,
        UserRoleRepository userRoleRepository
        ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping
    public List<UserRole> getAllUserRoles () {
        return userRoleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<UserRole> createUserRole (@RequestBody UserRole userRole) {
        Optional<User> checkUser = userRepository.findById(userRole.getUser().getUserId());
        Optional<Role> checkRole = roleRepository.findById(userRole.getRole().getRoleId());

        if (checkUser.isPresent() && checkRole.isPresent()) {
            userRole.setUser(checkUser.get());
            userRole.setRole(checkRole.get());
            userRoleRepository.save(userRole);
            return ResponseEntity.ok(userRole);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
