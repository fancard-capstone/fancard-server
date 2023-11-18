/*
package com.FANCardPlus.controller;

import com.FANCardPlus.model.FaqCategory;
import com.FANCardPlus.repository.FaqCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Faq-categories")
public class FaqCategoryController {
    private final FaqCategoryRepository FaqCategoryRepository;

    @Autowired
    public FaqCategoryController(FaqCategoryRepository FaqCategoryRepository) {
        this.FaqCategoryRepository = FaqCategoryRepository;
    }

    @GetMapping
    public List<FaqCategory> getAllFAQCategories() {
        return FaqCategoryRepository.findAll();
    }


    @PostMapping
    public FaqCategory createFAQCategory(@RequestBody FaqCategory faqCategory) {
        return FaqCategoryRepository.save(faqCategory);
    }


    // Other CRUD operations for FaqCategory
}
*/

package com.FANCardPlus.controller;

import com.FANCardPlus.model.FaqCategory;
import com.FANCardPlus.repository.FaqCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faq-categories")
public class FaqCategoryController {
    private final FaqCategoryRepository faqCategoryRepository;

    @Autowired
    public FaqCategoryController(FaqCategoryRepository faqCategoryRepository) {
        this.faqCategoryRepository = faqCategoryRepository;
    }

    @GetMapping
    public List<FaqCategory> getAllFAQCategories() {
        return faqCategoryRepository.findAll();
    }

    @PostMapping
    public FaqCategory createFAQCategory(@RequestBody FaqCategory faqCategory) {
        return faqCategoryRepository.save(faqCategory);
    }

    // Other CRUD operations for FAQ_Category
}

