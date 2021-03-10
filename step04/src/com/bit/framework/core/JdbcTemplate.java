package com.bit.framework.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bit.model.entity.DeptVo;

public abstract class JdbcTemplate {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List queryForList(String sql) throws SQLException{
		Object[] obj = {};
		return queryForList(sql, obj);
	}
	
	public List queryForList(String sql,Object[] obj) throws SQLException{
		List list = new ArrayList();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rowMapper(rs));
			}
			
		} finally {
			close();
		}
		return list;
	}
	
	public Object queryForOne(String sql, Object[] obj) throws SQLException{
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			for(int i = 0; i<obj.length; i++) {
				pstmt.setObject(i, obj);
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rowMapper(rs);
			}
			
		} finally {
			close();
		}
		return null;
	}
	
	// 와 이건 진짜 이해 못하겠다
	public abstract Object rowMapper(ResultSet rs) throws SQLException; //{
//		DeptVo bean = new DeptVo();
//		bean.setDeptno(rs.getInt("deptno"));
//		bean.setDname(rs.getString("dname"));
//		bean.setLoc(rs.getString("loc"));
		//list.add(bean);
//		return bean;
//	}
	
	public void close() throws SQLException {
		if (rs!= null) {rs.close();}
		if (pstmt!= null) {pstmt.close();}
		if (conn!= null) {conn.close();}
	}
	
}
