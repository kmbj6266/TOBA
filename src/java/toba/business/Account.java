package toba.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import toba.business.User;

    
@Entity
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String accountType;
    private double startingBalance; 
    @ManyToOne
    private User user;     

    //@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    //private List<transaction> transactions;
 
    public Account (){
        accountType = "";
        startingBalance = 0.00;
        user = new User();
    }
    
    public Account (String accountType, Double startingBalance, User user){
        this.accountType = accountType;
        this.startingBalance = startingBalance;
        this.user = user;
     }
     
    //is this doing anything?
    private boolean isProcessed;
    

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }

    public Double getStartingBalance() {
        return startingBalance;
    }
    public void setStartingBalance(Double startingBalance){
        this.startingBalance = startingBalance;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    
    
    public void credit(double startingBalance){
        this.startingBalance += startingBalance;
    }
    
    public void debit(double startingBalance){
        
        this.startingBalance -= startingBalance;
    }
    
}
