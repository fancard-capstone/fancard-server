package com.FANCardPlus.repository;

import com.FANCardPlus.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Additional query methods if needed
}
