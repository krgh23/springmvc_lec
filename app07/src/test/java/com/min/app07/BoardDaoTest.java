package com.min.app07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.app07.dao.IBoardDao;

@SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"
                            , "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})


// @RequiredArgsConstructor 디폴트로 만들어서 test에서 사용불가
class BoardDaoTest {

  // Spring Container 에 저장된 IBoardDao 타입의 Bean 가져오기
  @Autowired
  private /* final 생성자주입 아님으로 사용불가*/ IBoardDao boardDao;
  
  @Test
  void 목록테스트() {
    // 두 번째 항목의 conatents="대방어, 광어, 우럭 매운탕" 인지 테스트
    assertEquals(true, boardDao.selectBoardList().get(1).getContents().startsWith("대방어"));
  }

}
