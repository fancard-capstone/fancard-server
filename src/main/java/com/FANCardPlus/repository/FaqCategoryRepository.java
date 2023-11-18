package com.FANCardPlus.repository;

import com.FANCardPlus.model.FaqCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqCategoryRepository extends JpaRepository<FaqCategory, Long> {
    // Additional query methods if needed
}
