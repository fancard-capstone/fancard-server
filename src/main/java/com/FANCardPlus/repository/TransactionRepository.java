package com.FANCardPlus.repository;
import java.util.List;


import com.FANCardPlus.model.Transaction;
import com.FANCardPlus.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(User user);
}
