package com.min.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.myapp.dto.BlogDto;

@Repository
public class BlogDaoImpl implements IBlogDao {

  @Autowired
  private JdbcConnection jdbcConnection;
  
  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;
  
  @Override
  public void connect() throws ClassNotFoundException, SQLException {
    // TODO Auto-generated method stub

  }

  @Override
  public void colse() throws SQLException {
    // TODO Auto-generated method stub

  }

  @Override
  public List<BlogDto> selectBlogList() {
    List<BlogDto> blogDtos = new ArrayList<BlogDto>();
    conn = jdbcConnection.getConnection();
    try {
      String sql = "SELECT blog_id, title, contents, user_email, hit, modify_dt, criate_dt FROM tbl_blog";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        int blog_id = rs.getInt("blog_id");
        String title = rs.getString("title");
        String contents = rs.getString("contents");
        String user_email = rs.getString("user_email");
        int hit = rs.getInt("hit");
        Timestamp modify_dt = rs.getTimestamp("modify_dt");
        Timestamp criate_dt = rs.getTimestamp("criate_dt");
        BlogDto blogDto = BlogDto.builder()
                            .blog_id(blog_id)
                            .title(title)
                            .contents(contents)
                            .user_email(user_email)
                            .hit(hit)
                            .modify_dt(modify_dt)
                            .criate_dt(criate_dt)
                            .build();
        blogDtos.add(blogDto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    jdbcConnection.close(conn, ps, rs);
    return blogDtos;
  }
  
  
  @Override
  public int selectBlogCont() {
    int amount = 0;
    conn = jdbcConnection.getConnection();
    try {
      String sql = "SELECT COUNT(*) AS amount FROM tbl_blog";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      if(rs.next()) {
        amount = rs.getInt("amount");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    jdbcConnection.close(conn, ps, rs);
    return amount;
  }

  @Override
  public BlogDto selectBlogById(int blog_id) {
    BlogDto blogDto = null;
    conn = jdbcConnection.getConnection();
    try {
      String sql = "SELECT blog_id, title, contents, user_email, hit, modify_dt, criate_dt FROM tbl_blog WHERE blog_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, blog_id);
      rs = ps.executeQuery();
      if(rs.next()) {
        blogDto = BlogDto.builder()
                      .blog_id(rs.getInt("blog_id"))
                      .title(rs.getString("title"))
                      .contents(rs.getString("contents"))
                      .user_email(rs.getString("user_email"))
                      .hit(rs.getInt("hit"))
                      .modify_dt(rs.getTimestamp("modify_dt"))
                      .criate_dt(rs.getTimestamp("criate_dt"))
                      .build();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    jdbcConnection.close(conn, ps, rs);
    return blogDto;
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
