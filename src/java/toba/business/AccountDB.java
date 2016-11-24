package toba.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import toba.data.DBUtil;

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
 public static Account selectAccount(User user, String account) {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
     
        String qString = "SELECT a FROM Account a " +
                "WHERE a.user = :user AND a.accountType = :ACCOUNT";
        TypedQuery<Account> q = em.createQuery(qString, Account.class); 
        q.setParameter("user", user);
        q.setParameter("ACCOUNT", account);
      try {
          Account a = q.getSingleResult();
          return a;
      } catch (NoResultException e){
          return null;
      } finally {
         em.close();
        }

     }
 }


 //      
//     
//        accounts = q.getResultList();
//        for(Account a: accounts){
//            if (a.getAccountType() == null ? account == null : a.getAccountType().equals(account))
//                selected = a;
//        }

