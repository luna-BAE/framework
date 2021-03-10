package com.bit.framework.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.EditController;
import com.bit.controller.IndexController;
import com.bit.controller.ListController;
import com.bit.controller.OneController;
import com.bit.framework.Controller;

public class DispatchServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req, resp);
	}
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		uri=uri.substring(req.getContextPath().length());
		
		Controller controller=null;
		if(uri.equals("/index.bit")) {
			controller=new IndexController();
		}
		else if(uri.equals("/dept/list.bit")) {
			controller=new ListController();
		}
		else if(uri.equals("/dept/detail.bit")) {
			controller=new OneController();
		} else if(uri.equals("/dept/deit.bit")) {
			controller=new EditController();
		}

		String path="";
		try {
			path = controller.execute(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String prefix="/WEB-INF/views/";
		String suffix=".jsp";
		
		if(path.startsWith("redirect:"))
			resp.sendRedirect(
					path.substring("redirect:".length()));
		else 
			req
				.getRequestDispatcher(prefix+path+suffix)
				.forward(req, resp);
	}
}
