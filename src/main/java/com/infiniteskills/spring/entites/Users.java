package com.infiniteskills.spring.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;  

@Entity
@Table(name = "USERS")
public class Users {
	
	private long userId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Set<Address> userAddress = new HashSet<Address>();
	
	public Users() {
		
	}
	
	public Users(String firstname, String lastname, String emailaddress) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.emailAddress = emailaddress;
	}

	public Users(String firstname, String lastname, String emailaddress,Set<Address> address) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.emailAddress = emailaddress;
		this.userAddress = address;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL_ADDRESS")
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "users", cascade = CascadeType.ALL)
	public Set<Address> getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(Set<Address> address) {
		this.userAddress = address;
	}
	
	public void addAddress(Address address) {
        //address.setUsers(this);
        //getUserAddress().add(address);
		
		 if (!getUserAddress().contains(address)) {
			 getUserAddress().add(address);
	         if (address.getUsers() != null) {
	             address.getUsers().getUserAddress().remove(address);
	         }
	         
	         address.setUsers(this);
	     }
    }
	
	public void removeAddress(Address address) {
        //address.setUsers(this);
        getUserAddress().add(address);
    }
	
	public String toString() {
        return firstName + " " + lastName  + "\nEmail: " + emailAddress ;
    }
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Users))
			return false;
		Users other = (Users) obj;
		if (userId != other.userId)
			return false;
		
		return true;
	}
}