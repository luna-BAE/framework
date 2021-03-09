package com.bit.dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.dept.model.entity.DeptVo;

import oracle.jdbc.pool.OracleDataSource;

public class DeptDao {
	
	
	
	DataSource dataSource;
	
	public List getList(){
		
		String sql = "select * from dept";
		
		List list = new ArrayList<>();
		
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new DeptVo(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public DeptDao() {
		
		try {
			OracleDataSource source = new OracleDataSource();
			
			source.setDriverType("oracle.jdbc.OracleDriver");
			source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			source.setUser("scott");
			source.setPassword("tiger");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
