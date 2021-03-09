package com.bit.dept.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.dept.model.entity.DeptVo;

import oracle.jdbc.pool.OracleDataSource;

public class DeptDaoTest {

	public static void main(String[] args) throws Exception {

		DeptDao dao = new DeptDao();
		OracleDataSource source;
		try {
			source = new OracleDataSource();
			
			source.setDriverType("oracle.jdbc.OracleDriver");
			source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			source.setUser("scott");
			source.setPassword("tiger");
			
			dao.dataSource = source;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<DeptVo> list = dao.getList();
		notNull(list);
		checkTrue(list.size()>0);
	}
	
	public static void notNull(Object obj) throws Exception {
		if (obj == null) throw new Exception();
	}
	
	public static void same(int a, int b) throws Exception {
		if ( a != b ) throw new Exception();
	}
	
	public static void checkTrue(boolean boo) throws Exception {
		if (!boo) throw new Exception();
	}

}
