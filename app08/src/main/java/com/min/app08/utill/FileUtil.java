package com.min.app08.utill;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class FileUtil {
  
  // field : 현재 날짜
  private LocalDate today = LocalDate.now();
  
  /**
   * 파일 업로드 경로를 반환하는 메소드
   * @return 현재 날짜를 경로로 사용. 예를 들어 2024-12-12일에 실행하는 경우 반환되는 경로는 /upload/2024/12/12 입니다.
   *         경로 구분자는 슬래시(/)를 사용합니다. (linux, mac, windows 도 모두 사용가능)
   */
  public String getFilePath() {
    return "/upload" + DateTimeFormatter.ofPattern("/yyyy/MM/dd").format(today);
  }
  /**
   * 파일 저장 이름을 반환하는 메소드
   * @param originalFilename 파일의 원래 이름
   * @return 파일의 저장이름. 중복 방지를 위해서 난수 처리된 이름을 사용(UUID : 유니버셜 유니크 아이디). 파일의 원래 확장자를 그대로 사용.
   */
  public String getFilesystemName(String originalFilename) {
    String extensionName = "";                // 확장자
    if(originalFilename.endsWith(".tar.gz"))  // 파일이름.확장자.확장자 형태의 파일
      extensionName = ".tar.gz";
    else
      extensionName = originalFilename.substring(originalFilename.lastIndexOf("."));
    return UUID.randomUUID().toString() + extensionName;
  }
  
  
  
}
