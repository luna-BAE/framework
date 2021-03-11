package com.bit.was;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Launcher {

	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		tomcat.addWebapp("/", "C:\\Users\\AII2_07\\Downloads\\eGovFrameDev-3.9.0-64bit\\workspace\\was\\webapp");
		try {
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}

}
