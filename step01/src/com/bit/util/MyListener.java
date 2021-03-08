package com.bit.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Listener destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Listener initialized");
	}

}
