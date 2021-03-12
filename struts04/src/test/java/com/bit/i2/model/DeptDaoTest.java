package com.bit.i2.model;

import static org.junit.Assert.*;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bit.i2.model.entity.DeptVo;

public class DeptDaoTest {

	 static DeptVo target = new DeptVo(99,"test","test2");
	 static DeptDao dao;
	 
	 //public DeptDaoTest() throws SQLException {}
	 
	 @BeforeClass
	 public static void setUpBeforClass() throws SQLException { // 테스트케이스 수행 전 단 한번만 수행됨
		 dao = new DeptDao();
	 }
	 
	 
	 
   @Test
   public void test01DataSource() throws SQLException {
      assertNotNull(dao.dataSource);   // 클래스의 필드를 직접 접근함
   }
   
   @Test
   public void test02SelectAll() throws SQLException {
      assertNotNull(dao.selectAll());
      assertTrue(dao.selectAll().size()>0);
      System.out.println("test");
   }
   
   @Test
   public void test03InsertOne() throws SQLException {
	   DeptVo target = new DeptVo(99,"test","test2");
	   assertSame(1,dao.insertOne(target));
	   System.out.println("test2");
   }
   
   @Test
   public void test04SelectOne() throws SQLException {
	   assertNotNull(dao.selectOne(10));
	   assertEquals(target, dao.selectOne(target.getDeptno()));
   }

   
   @Test
   public void test05UpdateOne() throws SQLException {
	   DeptVo target = new DeptVo(this.target.getDeptno(),"edit","edit");
	   assertSame(1, dao.updateOne(target));
	   assertEquals(target, dao.selectOne(target.getDeptno()));
   }
   
   @Test
   public void test06DeleteOne() throws SQLException {
	   assertSame(1,dao.deleteOne(99));
   }
   
   
}