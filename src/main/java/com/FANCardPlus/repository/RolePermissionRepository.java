package com.FANCardPlus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FANCardPlus.model.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    List<RolePermission> findByPermissionPermissionId(Long permissionId);
}
