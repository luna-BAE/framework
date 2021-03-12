package com.bit.i2.action;

import com.bit.i2.model.DeptDao;
import com.bit.i2.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InsertAction extends ActionSupport implements ModelDriven<DeptVo>, Preparable {

	DeptVo bean;
	
	@Override
	public void prepare() throws Exception {
		
		bean = new DeptVo();
	}

	@Override
	public DeptVo getModel() {
		
		return bean;
	}
	
	@Override
	public void validate() { //add form이 스트러츠이기 때문에 이름을 맞춰줘야 함
		if (bean.getDeptno()==0) {
			addFieldError("deptno", "비었음");
		} 
		if (bean.getDname().isEmpty()) {
			addFieldError("dname", "비었음");
		}
		if (bean.getLoc().isEmpty()) {
			addFieldError("loc", "비었음");
		}
	}

	@Override
	public String execute() throws Exception {
		DeptDao dao = new DeptDao();
		dao.insertOne(bean);
		return Action.SUCCESS;
	}
	
}
