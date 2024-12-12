package com.min.app07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.app07.dao.IBoardDao;
import com.min.app07.dto.BoardDto;
import com.min.app07.dto.UserDto;

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
    String sort="DESC";
    assertEquals(true, boardDao.selectBoardList(sort).get(1).getContents().startsWith("대방어"));
  }

  @Test
  void 목록테스트2() {
    String sort="ASC";
    assertEquals("james", boardDao.selectBoardList(sort).get(1).getUserDto().getUsrName());
  }
  
  @Test
  void 상세테스트() {
    int boardId =3;
    assertEquals("helena", boardDao.selectBoardById(boardId).getUserDto().getUsrName());
  }
  
  @Test
  void 검색테스트() {
    // Map 이전 String 일때
    // title에 10이 포함되는 항목이 조회되는지 테스트
    //String query = "10";
    //assertEquals("20241210_식단", boardDao.SelectBoardSearchList(query).get(0).getTitle());
    
    Map<String, Object> map = java.util.Map.of("column", "title", "query", "10");
    assertEquals("20241210_식단", boardDao.selectBoardSearchList(map).get(0).getTitle());
  }
  
  @Test
  void 기간검색테스트() {
    String beginDt = "2024-12-05";
    String endDt = "2024-12-06";    
    Map<String, Object> map = java.util.Map.of("beginDt", beginDt, "endDt", endDt);
    assertEquals(2, boardDao.selectBoardPeriodList(map).size());
  }
  
  @Test
  void 통합검색테스트() {
    String title = "";
    String usrEmail = "@";
    String usrName = "";
    String beginDt = "";
    String endDt = "";    
    Map<String, Object> map = Map.of("title", title, "usrEmail", usrEmail, "usrName", usrName, "beginDt", beginDt, "endDt", endDt);
    assertEquals(3, boardDao.selectBoardIntegratedSearch(map).size());
  }
  
  @Test
  void 수정테스트() {
    
    BoardDto boardDto = new BoardDto();
    // boardDto.setTitle("20241210_식단(2)");
    boardDto.setContents("짜장면, 탕수육, 난자완스");
    boardDto.setBoardId(2);
    
    assertEquals(1, boardDao.updateBoard(boardDto));
    
  }
  
  @Test
  void 선택항목삭제테스트() {
    String[] numbers = {"1","2","3"};
    assertEquals(numbers.length, boardDao.deleteSelectedBoard(numbers));  // numbers.length 대신 3을 기제가능 삭제된 행의 갯수
  }
  
  @Test
  void 삽입테스트() {
    // 삽입 이전 BoardDto 객체는 title, contents, usrId 값을 가집니다.
    BoardDto boardDto = new BoardDto();
    boardDto.setTitle("20241212_식단");
    boardDto.setContents("스시, 냉모밀, 텐동");
    boardDto.setUserDto(new UserDto(3, null, null));
    System.out.println("삽입 이전 : " + boardDto);
    
    // 삽입
    assertEquals(1, boardDao.insertBoard(boardDto));
    
    // 삽입 이후 BoardDto 객체는 title, contents, usrId, boardId 값을 가집니다.
    // boardId 값은 매퍼의 <selectKey> 태그가 넣어 준 값입니다.
    System.out.println("삽입 이후 : " + boardDto);
  }
  
}