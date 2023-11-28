package com.FANCardPlus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FANCardPlus.model.Permission;
import com.FANCardPlus.model.Role;
import com.FANCardPlus.model.RolePermission;
import com.FANCardPlus.repository.PermissionRepository;
import com.FANCardPlus.repository.RolePermissionRepository;
import com.FANCardPlus.repository.RoleRepository;

@RestController
@RequestMapping("/api/role-permission")
public class RolePermissionController {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;

    @Autowired
    public RolePermissionController (RoleRepository roleRepository,
                                    PermissionRepository permissionRepository,
                                    RolePermissionRepository rolePermissionRepository) {
        this.permissionRepository = permissionRepository;
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
        Optional<Permission> checkPermission = permissionRepository.findById(rolePermission.getPermission().getPermissionId());
        
        if (checkRole.isPresent() && checkPermission.isPresent()) {
            rolePermissionRepository.save(rolePermission);
            return ResponseEntity.ok("Role-Permission added");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Role-Permission failed to add");
        }
        
    }
}
