package com.min.myapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.myapp.dao.IBlogDao;

@SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
class BlogDaoTest {
  
  @Autowired
  private IBlogDao blogDao;

  @Test
  void 목록테스트() {
    assertEquals(2, blogDao.selectBlogList().size());
  }
  
  @Test
  void 상세테스트() {
    int blog_id =1;
    assertEquals("라면 끓이기", blogDao.selectBlogById(blog_id).getTitle());
  }
  
  @Test
  void 전체행개수테스트() {
    assertEquals(2, blogDao.selectBlogCont());
  }

}
