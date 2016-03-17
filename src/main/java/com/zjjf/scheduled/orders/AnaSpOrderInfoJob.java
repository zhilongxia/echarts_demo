package com.zjjf.scheduled.orders;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjjf.analysis.services.SpOrderInfoServiceJobImpl;

@SuppressWarnings("resource")
public class AnaSpOrderInfoJob {

	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpOrderInfoServiceJobImpl spOrderInfoServcie = (SpOrderInfoServiceJobImpl) context.getBean("spOrderInfoServiceJobImpl");
		spOrderInfoServcie.excuse_orderInfo();
	}

}
