package toba.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import toba.business.User;

public class UserDB {

    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static User selectUser(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.username = :username AND u.password = :password";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    
    
    
    
    //not sure if this is correct???? 12/3/2016
    
    public static User selectUsers(String userName)
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                        "WHERE u.userName = :userName";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("userName", userName);
        
        try
        {
            User user = q.getSingleResult();
            return user;
        }
        catch(NoResultException e)
        {
            return null;
        }
        finally
        {
            em.close();
        }
    }
    //not sure if this is correct???? 12/3/2016
    public static List<User> selectAllUsers()
    {
        //Create connection using the connection pool
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u ";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        
        List<User> allUsers;
        
        try
        {
            allUsers = q.getResultList();
            if(allUsers == null || allUsers.isEmpty())
                allUsers = null;
        }
        finally
        {
            em.close();
        }
        return allUsers;
    }
    
    //end of new code on 12/3/2016
    
    
    
    
    
    
    
    
    

//    public static boolean emailExists(String email) {
//        User u = selectUser(email);   
//        return u != null;
//    }

//     public static boolean emailExists(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public static boolean userExists(String username, String password) {
        User u = selectUser(username, password);
        return u != null;
    }
}