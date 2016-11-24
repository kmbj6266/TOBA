package toba.business;
/**

 * @author kathyborne
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import toba.data.DBUtil;


public class TransactionDB {
    public static void insert(Transaction transaction){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(transaction);
            trans.commit();
        }
        catch(Exception e){
            System.out.println(e);
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public static List<Transaction> getTransactions(User aThis) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
