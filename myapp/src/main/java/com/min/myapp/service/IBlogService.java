package com.min.myapp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.min.myapp.dto.BlogDto;

public interface IBlogService {
  
  Map<String, Object> getBlogList();                // 목록, 개수
  int increseBlogHit(int blog_id);                  // 방문자 증가
  BlogDto getBlogId(int blog_id);                   // 블로그 정보
  String registerBlog(HttpServletRequest request);  // 등록
  String modifyBlog(HttpServletRequest request);    // 수정
  String removeBlog(HttpServletRequest request);    // 삭제
  
}
