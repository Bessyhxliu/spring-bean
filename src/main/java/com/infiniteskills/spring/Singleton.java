package com.infiniteskills.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singleton implements ApplicationContextAware{

	private Prototype prototype;
	private ApplicationContext context;

	public  Prototype createPrototype() {
		//return prototype;
		return context.getBean("prototype", Prototype.class);
	}

	public void setPrototype(Prototype prototype) {
		this.prototype = prototype;
	}
	
	public void setApplicationContext(ApplicationContext context) throws BeansException{
		this.context = context;
		
	}

}
