package com.infiniteskills.spring;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.spring.dao.UsersDao;
import com.infiniteskills.spring.entites.Address;
import com.infiniteskills.spring.entites.Users;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UsersDao usersDao = new UsersDao();
		Users user = new Users();
		
		try {
				//Create users: function saveUsers
//				Transaction transaction = session.beginTransaction();
//			 	Users c[] = new Users[1];
//		        c[0] = new Users("Andrew", "Jones", "aj@gmail.com");
//		        c[0].addAddress(new Address("111 ABC Street","Earlwood", "LA", "US", "112233"));
//		        c[0].addAddress(new Address("222 ERT Street", "Earlwood","CA", "US", "445566"));
//		        c[0].addAddress(new Address("333 PPP Street","Earlwood", "LA", "US", "667788"));	
//			    session.saveOrUpdate(c[0]);
//		        transaction.commit();
//		        System.out.println("Done");
			 	
				//Get all users
//				List<Users> users = usersDao.findAllUsers();
//				System.out.println("Here are a list of Users:");
//				 if (users.isEmpty()) {
//				        System.out.println("No Users found ");
//				 } else {
//				        System.out.println("Here are a list of Users:");
//				        for(Users auser: users){
//				            //System.out.println("\t" + auser + " with " + auser.getUserAddress().size() + " address");//				        	System.out.println("---------------------------------------------------");
//				        	System.out.println(auser.toString());            
//				        	Set<Address> addresses = auser.getUserAddress();            
//				        	int i=1;
//				        	for (Address addr : addresses) {
//				        		System.out.printf("Address %d: %s", i, addr.toString());
//				        		System.out.println();                
//				        		i++;
//				        	}
//				        }
//				 }
//	
			//Get user by id
			System.out.println("Find User by ID");
	        System.out.println(usersDao.findUserById(3));
	        
	      //Update user 
			System.out.println("Update A User");
			user.setUserId(9);
			user.setFirstName("Anna");
            //user.setLastName("Dish");
            //user.setEmailAddress("peter.goodyear@gmail.com");
	       // usersDao.modifyUser(user);
			usersDao.updateUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}	
	}

}
