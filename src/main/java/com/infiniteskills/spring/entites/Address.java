package com.infiniteskills.spring.entites;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	private long addressId;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private Users users; 
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")  
	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public Address() {
	}
	
	public Address(String addressline, String city, String state, String country, String zipcode) {
		this.addressLine = addressline;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipcode;
	}
	
//	public Address(String addressline, String city, String state, String country, String zipcode, Users user) {
//		this.addressLine = addressline;
//		this.city = city;
//		this.state = state;
//		this.country = country;
//		this.zipCode = zipcode;
//		this.users = user;
//		
//	}
	
	@Column(name="ADDRESS_LINE")
	public String getAddressLine() {
		return this.addressLine;
	}

	public void setAddressLine(String addressline) {
		this.addressLine = addressline;
	}

	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="STATE")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="COUNTRY")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name="ZIPCODE")
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "USER_ID", nullable = false)  
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users user) {
		this.users = user;
	}
	
	public String toString() {
		return  addressLine + ", city=" + city + ", state=" + state +", country=" + country + ", zipcode=" + zipCode;
	}
}