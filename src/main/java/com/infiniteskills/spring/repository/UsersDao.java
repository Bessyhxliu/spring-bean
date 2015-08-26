package com.infiniteskills.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.spring.HibernateUtil;
import com.infiniteskills.spring.entites.Users;

public class UsersDao {
	
	//Add a new user
    public Users saveUser(Users user){
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction = null;
    	try{
			 transaction =  session.beginTransaction();
			 session.saveOrUpdate(user);
			 transaction.commit();
			 
		}catch (Exception error) {
			if (transaction != null) {
				transaction.rollback();
            }
            error.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    	
    	return user;
    };
    
    //Update a user based on html page
    public void updateUserById(Users user) {
        Users entity = findUserById(user.getUserId());
        if(entity!=null){
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmailAddress(user.getEmailAddress());
          }
    }
    
    @SuppressWarnings("unchecked")
	public List<Users> findAllUsers(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Users> users = new ArrayList<Users>();
        
        try{
        		String SELECT_QUERY = "SELECT u FROM Users u"; 
        		users = session.createQuery(SELECT_QUERY).list();
        
        } catch (Exception error) {
            error.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
	
    public Users findUserById(long id) {
    	Users user = null;
    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        try{
        	String QUERY = "FROM Users WHERE userId = :userId";
            Query query = session.createQuery(QUERY);
            query.setParameter("userId", id);
            user = (Users)query.uniqueResult();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        
        return user;
    }
    
    public void deleteUser(long userid){
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction = null;
    	try{
			 transaction =  session.beginTransaction();
			 Users user = (Users) session.load(Users.class, new Long(userid));
			 session.delete(user);
			 transaction.commit();
			 
		}catch (Exception error) {
			if (transaction != null) {
				transaction.rollback();
            }
            error.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    	
    };
    
    public void deleteUserByLastName(String name){
    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        try{
        	String DELETE_QUERY = "DELETE FROM Users WHERE lastName = :lastName";
            Query query = session.createQuery(DELETE_QUERY);
            query.setString("lastName", name);
            int a = query.executeUpdate();
            System.out.println("success?" +a);
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
      
    };
}
