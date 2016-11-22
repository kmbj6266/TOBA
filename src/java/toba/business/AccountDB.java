package toba.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import toba.data.DBUtil;
//import toba.business.Account;
//import toba.business.AccountDB;

public class AccountDB {
    
    public static void insert(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
            }
        catch (Exception e){
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    
 public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
            
        }  
}
 public static Account selectAccount(User user, String acctType) {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
     List<Account> accounts = null;
     Account selected = null;
     try {
        String qString = "Select a from Account a " +
                       "Where a.accountOwner = :user";
        TypedQuery<Account> q = em.createQuery(qString, Account.class); 
        q.setParameter("user", user);
     
        accounts = q.getResultList();
        for(Account a: accounts){
            if (a.getAccountType() == null ? acctType == null : a.getAccountType().equals(acctType))
                selected = a;
        }
       
    } finally {
         em.close();
    }
     
     return selected;
 }
}
 

