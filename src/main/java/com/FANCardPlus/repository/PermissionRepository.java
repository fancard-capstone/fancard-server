package com.FANCardPlus.repository;

import com.FANCardPlus.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    // Additional query methods if needed
}
