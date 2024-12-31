package com.min.app13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.app13.dao.IBbsDao;
import com.min.app13.dto.BbsDto;

@SpringJUnitConfig(locations={
                      "file:src/main/webapp/WEB-INF/spring/root-context.xml"
                    , "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BbsDaoTests {

  @Autowired
  private IBbsDao bbsDao;
  
  @Test
  void 원글_삽입_테스트() {
    int result = bbsDao.insertBbs(BbsDto.builder()
                                    .contents("테스트내용입니다.")
                                    .build());
    Assertions.assertEquals(1, result);
    
  }
  
}
