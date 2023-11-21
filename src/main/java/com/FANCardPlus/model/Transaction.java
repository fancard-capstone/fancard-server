package com.FANCardPlus.model;
import javax.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "transaction_category_id", nullable = false)
    private TransactionCategory transactionCategory; 

    public TransactionCategory getFaqCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId; 

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    ///
    
    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facilityId; 

    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
    }

    ///

    @Column(name = "description", columnDefinition = "text")
    private String transactionDescription;

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    ///

    @Column(name = "transaction_on", columnDefinition = "int")
    private int transactionOn;

    public int getTransactionOn() {
        return transactionOn;
    }

    public void setTransactionOn(int transactionOn) {
        this.transactionOn = transactionOn;
    }

}