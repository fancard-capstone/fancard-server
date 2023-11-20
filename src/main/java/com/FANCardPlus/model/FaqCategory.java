package com.FANCardPlus.model;

import javax.persistence.*;

@Entity
@Table(name = "FAQ_Category", schema="dbo")
public class FaqCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAQ_Category_id")
    private Long faqCategoryId;

    public Long getFaqCategoryId() {
        return faqCategoryId;
    }

    public void setFaqCategoryId(Long faqCategoryId) {
        this.faqCategoryId = faqCategoryId;
    }

    ///

    @Column(name = "name", unique = true)
    private String faqCategory;

    public String getFaqCategory() {
        return faqCategory;
    }

    public void setFaqCategory(String faqCategory) {
        this.faqCategory = faqCategory;
    }

    ///

    @Column(name = "description")
    private String faqDescription;

    public String getFaqDescription() {
        return faqDescription;
    }

    public void setFaqDescription(String faqDescription) {
        this.faqDescription = faqDescription;
    }
}
