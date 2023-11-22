package com.FANCardPlus.repository;

import com.FANCardPlus.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    // Additional query methods if needed
}
