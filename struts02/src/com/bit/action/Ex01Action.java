package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {

	@Override
	public String execute() throws Exception { // 리퀘스트가 없는데 어떻게 값을 받고 출력할까?
		System.out.println("run Ex01Action");
		return "success";
	}

}
