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
    private final FaqRepository faqRepository;
    private final FaqCategoryRepository faqCategoryRepository;

    @Autowired
    public FaqController(FaqRepository faqRepository, FaqCategoryRepository faqCategoryRepository) {
        this.faqRepository = faqRepository;
        this.faqCategoryRepository = faqCategoryRepository;
    }

    @GetMapping
    public List<Faq> getAllFaqs() {
        return faqRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Faq> createFaq(@RequestBody Faq faq) {
        // Check if the specified Faq category ID exists
        Optional<FaqCategory> optionalCategory = faqCategoryRepository.findById(faq.getFaqCategory().getFaqCategory());
        if (optionalCategory.isPresent()) {
            // If the category exists, save the Faq
            faq.setFaqCategory(optionalCategory.get());
            Faq savedFaq = faqRepository.save(faq);
            return ResponseEntity.ok(savedFaq);
        } else {
            // If the category does not exist, return an error response
            return ResponseEntity.badRequest().build();
        }
    }
    /*
        {
            "faqCategory": {
                "faqCategory": 2
            },
            "question": "What is your product?",
            "answer": "Our product is..."
        }
     */




    // Other CRUD operations for Faq
}
