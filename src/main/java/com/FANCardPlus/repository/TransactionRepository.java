package com.FANCardPlus.repository;

import com.FANCardPlus.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Additional query methods if needed
}
