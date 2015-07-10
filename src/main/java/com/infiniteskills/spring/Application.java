package com.infiniteskills.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BeanAA beanA = context.getBean("beanAA",BeanAA.class); 
		
		System.out.println("end call");
//		Singleton singleton = context.getBean("singleton", Singleton.class);
//		Prototype prototype1 = singleton.createPrototype();
//		Prototype prototype2 = singleton.createPrototype();
//		System.out.println((prototype1 == prototype2) ? "Same Instance":"Separate Instances");
		
//		CollectionBean bean = context.getBean("bean", CollectionBean.class);
//		
//		System.out.println("\nPrinting List:");
//		for(ObjectA token: bean.getList()) {
//			System.out.println(token);
//		}
//
//		System.out.println("\nPrinting Set:");
//		for(String token: bean.getSet()) {
//			System.out.println(token);
//		}
//		
//		System.out.println("\nPrinting Map:");
//		for(String token: bean.getMap().values()) {
//			System.out.println(token);
//		}
//
//		System.out.println("\nPrinting Properties:");
//		for(Object key: bean.getProperties().keySet()){
//			System.out.println(bean.getProperties().getProperty((String) key));
//		}
	}
}
