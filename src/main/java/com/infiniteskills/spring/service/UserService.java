package com.infiniteskills.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.infiniteskills.spring.entites.Address;
import com.infiniteskills.spring.entites.Users;

public class UserService {
	 protected EntityManager em;

	 public UserService(EntityManager em) {
	    this.em = em;
	 }

	 public Users saveUser(Users user){
		 em.persist(user);
		 return user;
	 }
	 
	 public Users createUser(String firstname, String lastname, String emailaddress){
		 Users user = new Users();
		 user.setFirstName(firstname);
		 user.setLastName(lastname);
		 user.setEmailAddress(emailaddress);
		 em.persist(user);
		 return user;
	 }
	 
	 public Address createAddress(String addressline, String city, String state, String country, String zipcode) {
		 Address address = new Address();
		 address.setAddressLine(addressline);
		 address.setCity(city);
		 address.setState(state);
		 address.setCountry(country);
		 address.setZipCode(zipcode);
		 em.persist(address);
		 return address;
		 
	 }	 
	
	 @SuppressWarnings("unchecked")
	 public List<Users> findAllUsers() {
		 List<Users> users = new ArrayList<Users>();   
		 Query query = em.createQuery("SELECT u FROM Users u");
		 users =  query.getResultList();
		 //return (List<Users>) query.getResultList();
		 return users;
	 }
	 
	 public List<Address> findAddressByUser(long id) {
		 List<Address> address = new ArrayList<Address>();   
		 Query query = em.createQuery("FROM Address WHERE state=:stateId");
		 //query.setParemeter("stateId", id);
		 address =  query.getResultList();
		 //return (List<Address>) query.getResultList();
		 return address;
	 }
	 
	 public void updateUserById(long id){
		 Users user = em.find(Users.class, id);
		 
		 //Update some propertity
		 user.setEmailAddress("general.school@yahoo.com");
	 }
	 
	 public void updateAddress(){
		 Query query = em.createQuery("Update Address address SET address.zipCode = '10000' "
				 		+ "WHERE address.addressId= :id");
		 query.setParameter("id", 1);
		 int reslut = query.executeUpdate();
		 if (reslut > 0) {
			 System.out.println("Update successfully");
		 }
	 }
	 
}
