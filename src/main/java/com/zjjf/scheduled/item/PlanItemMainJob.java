package com.zjjf.scheduled.item;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjjf.analysis.services.items.PlanItemServiceJobImpl;

@SuppressWarnings("resource")
public class PlanItemMainJob {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PlanItemServiceJobImpl planItemServiceJobImpl = (PlanItemServiceJobImpl) context.getBean("planItemServiceJobImpl");
		planItemServiceJobImpl.excuse();
	}

}
