package com.FANCardPlus.model;

import javax.persistence.*;

@Entity
@Table(name = "FAQ_Category", schema="dbo")
public class FaqCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAQ_Category_id")
    private Long faqCategory;

    public Long getfaqCategory() {
        return faqCategory;
    }

    public void setfaqCategory(Long faqCategory) {
        this.faqCategory = faqCategory;
    }

    ///

    @Column(name = "name", unique = true)
    private String faqCategoryName;

    public String getfaqCategoryName() {
        return faqCategoryName;
    }

    public void setfaqCategoryName(String faqCategoryName) {
        this.faqCategoryName = faqCategoryName;
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
