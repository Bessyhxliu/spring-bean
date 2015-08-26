package com.infiniteskills.spring;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.spring.entites.Address;
import com.infiniteskills.spring.entites.Users;
import com.infiniteskills.spring.repository.UsersDao;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UsersDao usersDao = new UsersDao();
		
		try {
				Users user1[] = new Users[1];
		        user1[0] = new Users("Andrew", "Jones", "aj@gmail.com");
		        user1[0].addAddress(new Address("111 London Street","Earlwood", "NSW", "AU", "2122"));
		        user1[0].addAddress(new Address("222 Hello Avenue", "Eastwood","VIC", "AU", "2345"));
		        user1[0].addAddress(new Address("333 Gordon Street","Burwood", "TAS", "AU", "2117"));	
		        
		        user1[1] = new Users("Joan", "Jachoson", "jj@hotmail.com");
		        user1[1].addAddress(new Address("555, Sussex Street", "Sydney", "NSW","AU", "2006"));
		        user1[1].addAddress(new Address("666,  Libery Avenue", "Rockdale", "TAS","AU", "2057"));
		 
		        for (int i = 0; i < 2; i++) {
		            usersDao.saveUser(user1[i]);
		        }
		        System.out.println("Add records done");
			 	
				//Get all users
				List<Users> users = usersDao.findAllUsers();
				System.out.println("Here are a list of Users:");
				 if (users.isEmpty()) {
				        System.out.println("No Users found ");
				 } else {
				        System.out.println("Here are a list of Users:");
				        for(Users auser: users){
				            //System.out.println("\t" + auser + " with " + auser.getUserAddress().size() + " address");//				        	System.out.println("---------------------------------------------------");
				        	System.out.println(auser.toString());            
				        	Set<Address> addresses = auser.getUserAddress();            
				        	int i=1;
				        	for (Address addr : addresses) {
				        		System.out.printf("Address %d: %s", i, addr.toString());
				        		System.out.println();                
				        		i++;
				        	}
				        }
				 }
	
			//Get user by id
			System.out.println("Find User by ID");
	        System.out.println(usersDao.findUserById(5));
	        System.out.println("Delete users by id");
	       // usersDao.deleteUser(9);
	       
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}	
	}

}
