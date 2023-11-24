package com.FANCardPlus.repository;

import com.FANCardPlus.model.Facility;
import com.FANCardPlus.model.Permission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Permission> findByPermission(Facility facility);
}