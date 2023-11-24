package com.FANCardPlus.model;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Transaction", schema="dbo")
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

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    ///

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    ///
    
    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility; 

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
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

    @Column(name = "transaction_on", columnDefinition = "timestamp")
    private Timestamp transactionOn;

    public Timestamp getTransactionOn() {
        return transactionOn;
    }

    public void setTransactionOn(Timestamp transactionOn) {
        this.transactionOn = transactionOn;
}


}