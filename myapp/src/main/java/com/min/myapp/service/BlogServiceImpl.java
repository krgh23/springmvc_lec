package com.min.myapp.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.myapp.dao.IBlogDao;
import com.min.myapp.dto.BlogDto;

@Service
public class BlogServiceImpl implements IBlogService {
  
  private IBlogDao blogDao;

  @Autowired
  private void prepare(IBlogDao blogDao) {
    this.blogDao = blogDao;
  }
  
  @Override
  public Map<String, Object> getBlogList() {
    List<BlogDto> blogDtos = blogDao.selectBlogList();
    int count = blogDao.selectBlogCont();
    return Map.of("blogDtos", blogDtos, "count", count);
  }

  @Override
  public int increseBlogHit(int blog_id) {
    return blogDao.updateHit(blog_id);
  }

  @Override
  public BlogDto getBlogId(int blog_id) {
    return blogDao.selectBlogById(blog_id);
  }

  @Override
  public String registerBlog(HttpServletRequest request) {
    return null;
  }

  @Override
  public String modifyBlog(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String removeBlog(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
