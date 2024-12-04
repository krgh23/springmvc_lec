package com.min.app06.dao;

import java.util.List;

import com.min.app06.dto.ContactDto;

//인터페이스 생성의경우 이름앞에 대문자 I를 넣는게 좋음 c#같은대서 I가 없으면 안만들어짐
public interface IContactDao {                // 행(Row)은 ContactDto 객체에 저장합니다.
  List<ContactDto> getContactList();          // 모든 행(Row)을 반환합니다.
  ContactDto getContactById(int contact_id);  // PK인 contact_id를 쿼리에 전달해서 해당 행(Row)을 반환합니다.
  int getContactCount();                      // 모든 행(Row)의 갯수를 반환합니다.
  int register(ContactDto contactDto);        // 등록할 정보를 ContactDto 객체로 만들어서 쿼리에 전달하고 등록된 행(Row)의 개수를 반환합니다.
  int modify(ContactDto contactDto);          // 수정할 정보를 ContactDto 객체로 만들어서 쿼리에 전달하고 수정된 행(Row)의 개수를 반환합니다.
  int remove(int contact_id);                 // 삭제할 행의 식별자(PK)인 contact_id를 쿼리에 전달하고 삭제된 행(Row)의 개수를 반환합니다.
}
