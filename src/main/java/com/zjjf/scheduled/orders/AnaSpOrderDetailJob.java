package com.zjjf.scheduled.orders;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjjf.analysis.services.SpOrderDetailServiceJobImpl;

@SuppressWarnings("resource")
public class AnaSpOrderDetailJob {

	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpOrderDetailServiceJobImpl spOrderInfoServcie = (SpOrderDetailServiceJobImpl) context.getBean("spOrderDetailServiceJobImpl");
		spOrderInfoServcie.excuse_orderDetail();
	}
}
