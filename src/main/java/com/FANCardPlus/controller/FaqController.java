package com.FANCardPlus.controller;

import com.FANCardPlus.model.Faq;
import com.FANCardPlus.model.FaqCategory;
import com.FANCardPlus.repository.FaqCategoryRepository;
import com.FANCardPlus.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faqs")
public class FaqController {
    private final FaqRepository FaqRepository;
    private final FaqCategoryRepository FaqCategoryRepository;

    @Autowired
    public FaqController(FaqRepository FaqRepository, FaqCategoryRepository FaqCategoryRepository) {
        this.FaqRepository = FaqRepository;
        this.FaqCategoryRepository = FaqCategoryRepository;
    }

    @GetMapping
    public List<Faq> getAllFaqs() {
        return FaqRepository.findAll();
    }

    // @PostMapping
    // public ResponseEntity<Faq> createFaq(@RequestBody Faq Faq) {
    //     // Check if the specified Faq category ID exists
    //     Optional<FaqCategory> optionalCategory = FaqCategoryRepository.findById(Faq.getFaqCategoryId().getFaqCategoryId());
    //     if (optionalCategory.isPresent()) {
    //         // If the category exists, save the Faq
    //         Faq.setFaqCategoryId(optionalCategory.get());
    //         Faq savedFaq = FaqRepository.save(Faq);
    //         return ResponseEntity.ok(savedFaq);
    //     } else {
    //         // If the category does not exist, return an error response
    //         return ResponseEntity.badRequest().build();
    //     }
    // }
    @PostMapping
public ResponseEntity<Faq> createFaq(@RequestBody Faq faq) {
    // Check if the specified Faq category ID exists
    if (faq.getFaqCategory() != null) {
        Optional<FaqCategory> optionalCategory = FaqCategoryRepository.findById(faq.getFaqCategory().getfaqCategory());
        System.out.println("Category ID:" + optionalCategory.get());
        if (optionalCategory.isPresent()) {
            // If the category exists, save the Faq
            faq.setFaqCategory(optionalCategory.get());
            Faq savedFaq = FaqRepository.save(faq);
            return ResponseEntity.ok(savedFaq);
        } else {
            // If the category does not exist, return an error response
            return ResponseEntity.badRequest().build();
        }
    } else {
        // If the faqCategory is null, return an error response
        return ResponseEntity.badRequest().build();
    }
}


    // Other CRUD operations for Faq
}
