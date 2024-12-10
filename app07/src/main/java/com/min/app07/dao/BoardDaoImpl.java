package com.min.app07.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.app07.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // 생성자생성 : public BoardDaoImpl(@NonNull SqlSessionTemplate template) 대신 사용가능 app02-pkg03-Person 
@Repository  // DAO 에서 사용하는 @Component 입니다. Spring Container에 IBoardDao 타입의 bean이 생성됩니다. 1개만 만들어진다.(스코프 싱글톤)
public class BoardDaoImpl implements IBoardDao {

  private final SqlSessionTemplate template;
  
  /*
   ** ************************************ **
   ** @RequiredArgsConstructor // 대신사용 **
   ** ************************************ **
  // @Autowired  //생략가능
  public BoardDaoImpl(@NonNull SqlSessionTemplate template) {  // final처리하여 상수처리 생성자주입 / 생성자는 @Autowired 생략가능 / 반드시 입력되어야 해서 @NonNull을 넣어주는게 안전하다. 
                                                      // Edit -> Generate Constructor using FieIds.
                                                      // bean을 가져올때는 id아닌 type으로 가져온다
    super();
    this.template = template;
  }
  */
  
  /*
   * 매퍼의 SQL 구문 호출하는 방식
   * 
   * selectList(SQL's id[, Parameter (파라미터는 선택)])
   *  selectOne(SQL's id[, Parameter (파라미터는 선택)])
   *     insert(SQL's id[, Parameter (파라미터는 선택)])
   *     update(SQL's id[, Parameter (파라미터는 선택)])
   *     delete(SQL's id[, Parameter (파라미터는 선택)])
   */
  
  
  // boardMapper.xml 쿼리문에 ID는 메소드 이름으로 통일필수
  // boardMapper.xml에 namespace를 mybatis.mappers.boardMapper 로 기제해놓음
  // template.selectOne("네임스페이스.쿼리문아이디", 파라미터)
  
  @Override
  public List<BoardDto> selectBoardList(String sort) {
    List<BoardDto> boardList = template.selectList("mybatis.mappers.boardMapper.selectBoardList", sort);  // 쿼리문 아이디 : selectList("SelectBoardList") ->  SelectBoardList
    return boardList;
  }

  @Override
  public int selectBoardCount() {
    int boardcount = template.selectOne("mybatis.mappers.boardMapper.selectBoardCount");
    return boardcount;
  }

  @Override
  public BoardDto selectBoardById(int boardId) {
    BoardDto boardDto = template.selectOne("mybatis.mappers.boardMapper.selectBoardById", boardId);   // template.selectOne("네임스페이스.쿼리문아이디", 파라미터)
                                                                          // int boardId 받아온걸 그대로 넘겨준다.
    return boardDto;
  }

  @Override
  public List<BoardDto> selectBoardSearchList(Map<String, Object> map) {
    List<BoardDto> searchList = template.selectList("mybatis.mappers.boardMapper.selectBoardSearchList", map);
    return searchList;
  }
  
  @Override
  public List<BoardDto> selectBoardPeriodList(Map<String, Object> map) {
    List<BoardDto> peridoList = template.selectList("mybatis.mappers.boardMapper.selectBoardPeriodList", map);
    return peridoList;
  }
  
  @Override
  public List<BoardDto> selectBoardIntegratedSearch(Map<String, Object> map) {
    List<BoardDto> list = template.selectList("mybatis.mappers.boardMapper.selectBoardIntegratedSearch", map);
    return list;
  }
  
  @Override
  public int insertBoard(BoardDto boardDto) {
    int result = template.insert("mybatis.mappers.boardMapper.insertBoard", boardDto);
    return result;
  }

  @Override
  public int updateBoard(BoardDto boardDto) {
    int result = template.update("mybatis.mappers.boardMapper.updateBoard", boardDto);
    return result;
  }

  @Override
  public int deletBoard(int boardId) {
    int result = template.delete("mybatis.mappers.boardMapper.deletBoard", boardId);
    return result;
  }
  
  @Override
  public int deleteSelectedBoard(int[] numbers) {
    int result = template.delete("mybatis.mappers.boardMapper.deleteSelectedBoard", numbers);
    return result;
  }

}
