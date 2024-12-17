package com.min.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.myapp.dto.BlogDto;

@Repository
public class BlogDaoImpl implements IBlogDao {
  
  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;
  
  @Override
  public void connect() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_myapp?serverTimezone=Asia/Seoul", "greenit", "greenit");
  }

  @Override
  public void close() throws SQLException {
    if(conn != null) conn.close();
    if(ps != null) ps.close();
    if(rs != null) rs.close();
  }

  @Override
  public List<BlogDto> selectBlogList() {
    List<BlogDto> blogList = new ArrayList<BlogDto>();
    try {
      connect();
      String sql = "SELECT blog_id, title, contents, user_email, hit, modify_dt, create_dt FROM tbl_blog ORDER BY blog_id DESC";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        BlogDto blogDto = BlogDto.builder()
            .blog_id(rs.getInt(1))
            .title(rs.getString(2))
            .contents(rs.getString(3))
            .user_email(rs.getString(4))
            .hit(rs.getInt(5))
            .modify_dt(rs.getTimestamp(6))
            .create_dt(rs.getTimestamp(7))
            .build();
        blogList.add(blogDto);
      }
      close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return blogList;
  }
  
  @Override
  public int selectBlogCont() {
    int count = 0;
    try {
      connect();
      String sql = "SELECT COUNT(*) FROM tbl_blog";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      if(rs.next()) {
        count = rs.getInt(1);
      }
      close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  @Override
  public BlogDto selectBlogById(int blog_id) {
  
    return null;
  }


  @Override
  public int insertBlog(BlogDto blogDto) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updateBlog(BlogDto blogDto) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updateHit(int blog_id) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deletBlog(int blog_id) {
    // TODO Auto-generated method stub
    return 0;
  }

}
