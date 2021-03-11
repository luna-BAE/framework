package com.bit.action;

import com.bit.dept.model.DeptDao;
import com.opensymphony.xwork2.Action;

public class EditDeptAction implements Action {

	int deptno;
	String dname, loc;
	
	public int getDeptno() {
		return deptno;
	} // 이게 있어야 리다이렉트할 때 액션에서 값을 받아서 넘어갈 수 있음
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public void setLoc(String loc) {
		this.loc = loc;
	}



	@Override
	public String execute() throws Exception {

		DeptDao dao = new DeptDao();
		dao.updateOne(deptno, dname, loc);
		return Action.SUCCESS;
	}

}
