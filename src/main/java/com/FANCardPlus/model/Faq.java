package com.FANCardPlus.model;

import javax.persistence.*;

@Entity
@Table(name = "faq")
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faq_id")
    private Long faqId;

    public Long getFaqId() {
        return faqId;
    }

    public void setFaqId(Long faqId) {
        this.faqId = faqId;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "faq_category_id", nullable = false)
    private FaqCategory faqCategoryId;

    public FaqCategory getFaqCategoryId() {
        return faqCategoryId;
    }

    public void setFaqCategoryId(FaqCategory faqCategoryId) {
        this.faqCategoryId = faqCategoryId;
    }

    ///

    @Column(name = "question", columnDefinition = "TEXT")
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    /// 

    @Column(name = "answer", columnDefinition = "TEXT")
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
