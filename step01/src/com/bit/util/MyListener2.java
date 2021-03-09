package com.bit.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class MyListener2 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Listener2 destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Listener2 initialized");
	}

}
