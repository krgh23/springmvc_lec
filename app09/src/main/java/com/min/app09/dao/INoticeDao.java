package com.min.app09.dao;

import java.util.List;

import com.min.app09.dto.AttachDto;
import com.min.app09.dto.NoticeDto;

public interface INoticeDao {
  List<NoticeDto> selectNoticeList();
  NoticeDto selectNoticeById(int noticeId);  // 상세보기1  1과 2는 하나의 서비스에서 호출하여 사용
  List<AttachDto> selectAttachListByNoticeId(int noticeId); // 상세보기2
  AttachDto selectAttachById(int attachId);
  int insertNotice(NoticeDto noticeDto);  // 공지1  공지확인할때 1과 2가 같이 사용됨
  int insertAttach(AttachDto attachDto);  // 공지2
  int deleteNotice(int noticeId);  // sql의 "ON DELETE CASCADE"에 의하여 deletAttach는 만들지 않는다.
  int updateAttachDownloadCount(int attachId);
}
