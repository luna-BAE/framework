package com.bit.i2.action;

import com.bit.i2.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class Ex02Action implements Action,ModelDriven,Preparable {

	DeptVo bean;
	
//	public void setBean(DeptVo bean) {
//		this.bean = bean;
//	}
	
	@Override
	public String execute() throws Exception {

		System.out.println(bean);
		return Action.SUCCESS;
	}

	@Override
	public Object getModel() {
		// 게터와 세터의 요청이 있을 때 bean을 던져주는 것
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new DeptVo();
	}

}
