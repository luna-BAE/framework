package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

import com.bit.framework.core.JdbcTemplate;
import com.bit.model.entity.DeptVo;

public class DeptDao {
	DataSource dataSource;
	
	public DeptDao() throws SQLException {
		MariaDbDataSource source=null;
		source=new MariaDbDataSource();
		source.setUrl("jdbc:mysql://localhost:3306/xe");
		source.setUser("scott");
		source.setPassword("tiger");
		dataSource=source;
	}
	
	public List selectAll() throws SQLException {
		String sql="select * from dept order by deptno";
		JdbcTemplate template=new JdbcTemplate() {

			@Override
			public Object rowMapper(ResultSet rs) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
			}

			
		};
		template.setDataSource(dataSource);
		Object[] obj = {};
		return template.queryForList(sql);
	}

	public Object selectOne(int param) throws SQLException {
		String sql="select * from dept where deptno=?";
		JdbcTemplate template = new JdbcTemplate() {
			
			@Override
			public Object rowMapper(ResultSet rs) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
			}
		};
		template.setDataSource(dataSource);
		Object[] obj = {param};
		return template.queryForOne(sql,obj);
	}

	public int updateOne(DeptVo bean) throws SQLException {
		String sql = "update dept set dname=?, loc=? where deptno=?";
		
		Object[] obj = {bean.getDname(), bean.getLoc(), bean.getDeptno()};
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i<obj.length; i++) {
				pstmt.setObject(i+1, obj[i]);
			}
			return pstmt.executeUpdate();
		} finally {conn.close();}
		
	}
}



