package com.min.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {
  public Connection getConnection() {
    Connection conn = null;
    try {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/db_myapp?serverTimzone=Asia/seoul";
      String username = "greenit";
      String password = "greenit";
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
  
  /**
   * 접속 해제 메소드
   * @param java.sql.Connection DataBase 접속 정보를 처리하는 인터페이스
   * @param java.sql.PreparedStatement 쿼리문을 실행하고 그 결과를 반환하는 인터페이스
   * @param java.sql.ResultSet 테이블의 행(Row) 정보를 가리키는 Cursor를 제공하는 인터페이스
   */
  public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
    try {
      if(conn != null) conn.close();
      if(ps != null) ps.close();
      if(rs != null) rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
