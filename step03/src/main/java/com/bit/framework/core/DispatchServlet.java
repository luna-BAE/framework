package com.bit.framework.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dept.controller.IndexController;
import com.bit.dept.controller.ListController;
import com.bit.framework.Controller;

public class DispatchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req,resp);
		// 겟 방식은 엔코딩을 톰캣 서버가 함
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req,resp);
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // 패스 정보를 얻어냄
		String path = uri.substring(req.getContextPath().length());
		System.out.println(path);
		
		// handle mapping
		Controller controller = null;
		
		if (path.equals("/index.bit")) {
			controller = new IndexController();
		} else if (path.equals("/list.bit")) {
			controller = new ListController();
		}
		
		String viewName = controller.execute(req);
		
		// view resolver
		if (viewName.startsWith("redirect:")) {
			resp.sendRedirect(viewName.substring("redirect:".length()));
		} else {
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);;
		}
	}
	
}
