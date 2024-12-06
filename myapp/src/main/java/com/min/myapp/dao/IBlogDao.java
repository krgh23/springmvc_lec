package com.min.myapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.min.myapp.dto.BlogDto;



public interface IBlogDao {
  void connect() throws ClassNotFoundException, SQLException; // 데이터베이스 연결을 설정하는 메서드. JDBC 드라이버를 로드하고 데이터베이스와의 연결을 수립.
  void colse() throws SQLException;      // 데이터베이스 연결을 닫는 메서드. 리소스를 해제하여 메모리 누수를 방지.
  List<BlogDto> selectBlogList();        // 모든행
  int selectBlogCont();                  // 블로그 데이터의 특정 콘텐츠나 요약 데이터를 반환하는 메서드.
  BlogDto selectBlogById(int blog_id);   // pk 행반환
  int insertBlog(BlogDto blogDto);       // 등록
  int updateBlog(BlogDto blogDto);       // 수정
  int updateHit(int blog_id);            // 특정 블로그 ID의 조회수(hit)를 증가시키고, 업데이트된 행의 개수를 반환하는 메서드.
  int deletBlog(int blog_id);            // 삭제
}
