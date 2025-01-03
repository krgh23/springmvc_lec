package com.min.app06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.app06.dao.IContactDao;
import com.min.app06.dto.ContactDto;

/*
 * ContactDaoImpl bean을 만드는 방법에 따른 @SpringJUnitConfig 설정 방법
 * 1. <bean>
 *    : @SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
 * 2. @Bean
 *    : @SpringJUnitConfig(classes=AppConfig.class)
 * 3. @Component
 *    : @SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
 */

/*
 * Spring Container에 저장된 ContactDaoImpl bean을 가져오기 위해서
 * 환경 설정 파일로 servlet-context.xml 파일을 등록합니다.
 * ContactDaoImpl bean은 @Component(사실은 @Repository)로 만든 bean이므로
 * Component Scan이 필요합니다. servlet-context.xml 파일에는
 * <context:component-scan base-package="com.min.app06" /> 태그가 
 * Component Scan으로 등록되어 있습니다.
 */

 /*
  * 실행방법
  * 1.한개만 실항할경우 메소드 이름만 드레그해서 마우스 오른쪽 클릭 run as -> JUnit Test 실행
  * 2.전체를 테스트 할경우 test 파일을 선택하고 마우스 오른쪽 클릭 run as -> JUnit Test 실행
  */

@SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

class ContactTest {


  @Autowired                      // 테스트 코드에서는 필드 주입이 적절합니다.
  private IContactDao contactDao; // 인터페이스 구현 클래스는 타입으로 인터페이스를 사용합니다.
  
  /*
   * 테스트를 수행하는 메소드를 만드는 방법
   * 1. @Test    : 테스트를 수행하는 메소드입니다.
   * 2. 반환타입 : void를 사용합니다.
   * 3. 메소드명 : 자유롭게 사용합니다. (한글 사용도 무방합니다.)
   * 4. 매개변수 : 없습니다.
   */
  
  @Test
  void 목록테스트() {
    
    // 목록의 첫 번째 요소의 last_name이 james이면 통과입니다.
    // assertEquals("james", contactDao.getContactList().get(0).getLast_name());
    
    // 목록의 개수가 3개이면 통과입니다.
    assertEquals(3, contactDao.getContactList().size());
    
  }

  @Test
  void 상세테스트() {
    
    // contact_id = 3인 행의 first_name이 lee인지 확인하기
    int contact_id = 3;
    assertEquals("lee", contactDao.getContactById(contact_id).getFirst_name());
    
  }
  
  @Test
  void 전체행개수테스트() {
    
    // 전체 행 개수가 3개이면 통과
    assertEquals(3, contactDao.getContactCount());
    
  }
  
  @Test
  void 등록테스트() {
    // 등록할 ContactDto 객체 생성하기
    ContactDto contactDto = ContactDto.builder()
                              .last_name("button")
                              .first_name("tim")
                              .email("asdf@gmail")
                              .mobile("010-4444-4444")
                              .build();
    // 등록 결과가 1 이면 통과
    assertEquals(1, contactDao.register(contactDto));

  }
  
  @Test
  void 수정테스트() {
    // 수정할 정보를 저장한 ContactDto 객체 생성하기
    ContactDto contactDto = ContactDto.builder()
                              .contact_id(1)
                              .last_name("min")
                              .first_name("jin")
                              .email("rrrr@gmail.com")
                              .mobile("010-9999-9999")
                              .build();
    // 수정할 결과가 1이면 통과
    assertEquals(1, contactDao.modify(contactDto));
  }
  
  @Test
  void 삭제테스트() {
    // 삭제할 contact_id
    int contact_id = 2;
    
    // 삭제 결과가 1이면 통과
    assertEquals(1, contactDao.remove(contact_id));
  }
}