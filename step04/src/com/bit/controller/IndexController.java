package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class IndexController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		return "index";
	}

}
