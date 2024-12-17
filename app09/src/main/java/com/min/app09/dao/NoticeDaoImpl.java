package com.min.app09.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.app09.dto.AttachDto;
import com.min.app09.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@Repository  // 서비스가 다오를 가져다 쓸때 빈으로 만들어야 쓸수 있어서 넣어둠 //하다가 머가안되면 그냥 new를 하면됨
@RequiredArgsConstructor
public class NoticeDaoImpl implements INoticeDao {

  private final SqlSessionTemplate template;  // SqlSessionTemplate 마이바티스 측에서 스프링용으로 만듬
  
  @Override
  public List<NoticeDto> selectNoticeList() {
    return template.selectList("mybatis.mappers.noticeMapper.selectNoticeList");
  }

  @Override
  public NoticeDto selectNoticeById(int noticeId) {
    return template.selectOne("mybatis.mappers.noticeMapper.selectNoticesById", noticeId);
  }

  @Override
  public List<AttachDto> selectAttachListByNoticeId(int noticeId) {
    return template.selectList("mybatis.mappers.noticeMapper.selectAttachListByNoticeId", noticeId);
  }
  
  @Override
  public AttachDto selectAttachById(int attachId) {
    return template.selectOne("mybatis.mappers.noticeMapper.selectAttachById", attachId);
  }  

  @Override
  public int insertNotice(NoticeDto noticeDto) {
    return template.insert("mybatis.mappers.noticeMapper.insertNotice", noticeDto);
  }
  
  @Override
  public int insertAttach(AttachDto attachDto) {
    return template.insert("mybatis.mappers.noticeMapper.insertAttach", attachDto);
  }

  @Override
  public int deleteNotice(int noticeId) {
    return template.delete("mybatis.mappers.noticeMapper.deleteNotice", noticeId);
  }

  @Override
  public int updateAttachDownloadCount(int attachId) {
    return template.update("mybatis.mappers.noticeMapper.updateAttachDownloadCount", attachId);
  }
  
  
}
