package com.FANCardPlus.model;

import javax.persistence.*;

@Entity
@Table(name = "FAQ", schema="dbo")
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAQ_ID")
    private Long faqId;

    public Long getFaqId() {
        return faqId;
    }

    public void setFaqId(Long faqId) {
        this.faqId = faqId;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "FAQ_Category_id", nullable = false)
    private FaqCategory faqCategory; 

    public FaqCategory getFaqCategory() {
        return faqCategory;
    }

    public void setFaqCategory(FaqCategory faqCategory) {
        this.faqCategory = faqCategory;
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
