package com.zjjf.scheduled.item;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjjf.analysis.services.items.ItemServiceJobImpl;

@SuppressWarnings("resource")
public class ItemMainJob {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItemServiceJobImpl itemServiceJobImpl = (ItemServiceJobImpl) context.getBean("itemServiceJobImpl");
		itemServiceJobImpl.excuse_item();
	}

}
