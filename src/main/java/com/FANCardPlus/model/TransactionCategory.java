package com.FANCardPlus.model;
import javax.persistence.*;

@Entity
@Table(name = "Transaction_category")
public class TransactionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_category_id")
    private Long transactionCategoryId;

    public Long getTansactionCategoryId() {
        return transactionCategoryId;
    }

    public void setTransactionCategory(Long transactionCategoryId) {
        this.transactionCategoryId = transactionCategoryId;
    }

    ///

    @Column(name = "name", length = 150)
    private String transactionCategoryName;

    public String getTransactionCategoryName() {
        return transactionCategoryName;
    }

    public void setTransactionCategoryName(String transactionCategoryName) {
        this.transactionCategoryName = transactionCategoryName;
    }
    
    ///

    @Column(name = "description", columnDefinition = "text")
    private String transactionCategoryDescription;

    public String getTransactionCategoryDescription() {
        return transactionCategoryDescription;
    }

    public void setTransactionCategoryDescription(String transactionCategoryDescription) {
        this.transactionCategoryDescription = transactionCategoryDescription;
    }

}
