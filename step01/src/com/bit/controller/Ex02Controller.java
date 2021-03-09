package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Ex02Controller extends HttpServlet {

	
	@Override
		public void init() throws ServletException { //최초에 호출을 받을 때 
			System.out.println("Ex02 init run");
		}
	
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("ex02 run...");
      HttpSession session = req.getSession();
      session.invalidate();
   }
}