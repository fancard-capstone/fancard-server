package com.FANCardPlus.controller;

import com.FANCardPlus.model.TransactionCategory;
import com.FANCardPlus.repository.TransactionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-categories")
public class TransactionCategoryController {
    private final TransactionCategoryRepository transactionCategoryRepository;

    @Autowired
    public TransactionCategoryController(TransactionCategoryRepository transactionCategoryRepository) {
        this.transactionCategoryRepository = transactionCategoryRepository;
    }

    @GetMapping
    public List<TransactionCategory> getAllTransactionCategories() {
        return transactionCategoryRepository.findAll();
    }

    @PostMapping
    public TransactionCategory createTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
        return transactionCategoryRepository.save(transactionCategory);
    }

}

