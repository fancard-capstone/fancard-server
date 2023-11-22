package com.FANCardPlus.repository;

import com.FANCardPlus.model.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {
    // Additional query methods if needed
}
