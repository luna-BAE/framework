package com.bit.i2.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Validateable;

public class Ex03Action implements Action,Validateable {

	int deptno;
	String dname, loc;
	
	
	
	public int getDeptno() {
		return deptno;
	}



	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public String getLoc() {
		return loc;
	}



	public void setLoc(String loc) {
		this.loc = loc;
	}



	@Override
	public String execute() throws Exception {
		return Action.SUCCESS;
	}



	@Override
	public void validate() {
		if(dname.equals("")) {
			
		}
	}

}
