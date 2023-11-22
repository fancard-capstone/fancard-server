package com.FANCardPlus.repository;

import com.FANCardPlus.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
    // Additional query methods if needed
}