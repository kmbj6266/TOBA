package toba.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Account sourceAccnt;
    private Account destinationAccnt;
    
    private double amount;
    
    /**
     *
     * @param sourceAccnt
     * @param destinationAccnt
     * @param amount
     */
    public Transaction(Account sourceAccnt, Account destinationAccnt, double amount) {
        this.sourceAccnt = sourceAccnt;
        this.destinationAccnt = destinationAccnt;
        this.amount = amount;
    }
    
    public Account getSourceAccnt() {
        return sourceAccnt;
    }

    public void setSourceAccnt(Account sourceAccnt) {
        this.sourceAccnt = sourceAccnt;
    }

    public Account getDestinationAccnt() {
        return destinationAccnt;
    }
    public void setDestinationAccnt(Account destinationAccnt) {
        this.destinationAccnt = destinationAccnt;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Long id) {
        this.transactionId = id;
    }

}
