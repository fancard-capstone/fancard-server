package com.FANCardPlus.controller;

import com.FANCardPlus.model.RolePermission;
import com.FANCardPlus.model.TransactionCategory;
import com.FANCardPlus.model.User;
import com.FANCardPlus.model.Role;
import com.FANCardPlus.model.Facility;
import com.FANCardPlus.model.Permission;

import com.FANCardPlus.repository.RolePermissionRepository;
import com.FANCardPlus.repository.RoleRepository;
import com.FANCardPlus.repository.PermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/role-permission")
public class RolePermissionController {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionrepository;
    private final RolePermissionRepository rolePermissionRepository;

    @Autowired
    public RolePermissionController (RoleRepository roleRepository,
                                    PermissionRepository permissionRepository,
                                    RolePermissionRepository rolePermissionRepository) {
        this.permissionrepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @GetMapping
    public List<RolePermission> getAllRolePermissions() {
        return rolePermissionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createRolePermission (@RequestBody RolePermission rolePermission) {
        Optional<Role> checkRole = roleRepository.findById(rolePermission.getRole().getRoleId());
        Optional<Permission> checkPermission = permissionrepository.findById(rolePermission.getPermission().getPermissionId());
        
        if (checkRole.isPresent() && checkPermission.isPresent()) {
            rolePermissionRepository.save(rolePermission);
            return ResponseEntity.ok("Role-Permission added");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Role-Permission failed to add");
        }
        
    }
}
