package com.infiniteskills.spring;

import org.springframework.beans.factory.BeanNameAware;

public class BeanD implements BeanNameAware {

	private String name;

	public BeanD() {
		super();
		System.out.println("Constructor Called: public BeanD()in BeanD");
	}

	public void setBeanName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}