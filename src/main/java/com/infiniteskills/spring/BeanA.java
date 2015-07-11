package com.infiniteskills.spring;

import java.util.Calendar;

public class BeanA {

	public BeanA() {
		
	}
	
	private int prop1;
	private BeanB beanb;
	private Calendar calendar;
	
	public BeanA(Calendar calendar){
		this.calendar = calendar;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public int getProp1() {
		return prop1;
	}

	public void setProp1(int prop1) {
		this.prop1 = prop1;
		System.out.println("Setting the age using Setter method");
	}

	public BeanB getBeanb() {
		return beanb;
	}

	public void setBeanb(BeanB beanb) {
		this.beanb = beanb;
	}

	public int getYear() {
		return this.calendar.get(Calendar.YEAR);
	}
	
	
}
