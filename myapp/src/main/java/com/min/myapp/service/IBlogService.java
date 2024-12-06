package com.min.myapp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.min.myapp.dto.BlogDto;

public interface IBlogService {
  
  Map<String, Object> getBlogList();
  int increseBlogHit(int blog_id);
  BlogDto getBlogId(int blog_id);
  String registerBlog(HttpServletRequest request);
  String modifyBlog(HttpServletRequest request);
  String removeBlog(HttpServletRequest request);
  
}
