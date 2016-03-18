package com.zjjf.scheduled.item;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjjf.analysis.services.items.ScmsItemServiceJobImpl;

@SuppressWarnings("resource")
public class ScmsItemMainJob {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ScmsItemServiceJobImpl scmsItemServiceJobImpl = (ScmsItemServiceJobImpl) context.getBean("scmsItemServiceJobImpl");
		scmsItemServiceJobImpl.excuse();
	}

}
