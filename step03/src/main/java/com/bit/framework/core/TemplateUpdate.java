package com.bit.framework.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TemplateUpdate {
   String driver="org.mariadb.jdbc.Driver";
   String url="jdbc:mysql://localhost:3306/xe";
   String user="scott";
   String password="tiger";
   Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   public Connection getConnection() throws SQLException {
      if(conn==null || conn.isClosed()) {
         try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
      }
      return conn;
   }
   private PreparedStatement setPstmt(PreparedStatement pstmt, Object key, int idx) throws SQLException {
      pstmt.setObject(idx, key);
      return pstmt;
   }
   
   public int executeUpdate(String sql, Object[] obj) throws SQLException {
      try {
         conn=getConnection();
         pstmt=conn.prepareStatement(sql);
         for(int i=0; i<obj.length; i++)
            pstmt=setPstmt(pstmt, obj[i], i+1);   // index는 0부터 시작하지만 parameter는 1부터 시작하므로 +1
         return pstmt.executeUpdate();
      } finally {
         close();
      }
   }
   
   private void close() throws SQLException {
      if(rs!=null)rs.close();
      if(pstmt!=null)pstmt.close();
      if(conn!=null)conn.close();
   }
}