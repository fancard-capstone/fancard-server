package com.FANCardPlus.repository;

import com.FANCardPlus.model.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {
    // Additional query methods if needed
}
