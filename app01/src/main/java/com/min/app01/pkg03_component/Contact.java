package com.min.app01.pkg03_component;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Component  // 이 Contact 클래스는 이름이 contact 인 bean 으로 만들어집니다.(클레스 이름의 첫글자가 소문자로 변경되어 bean으로 만들어짐)
            // (디폴트 형식의 생성자를 사용합니다. @NoArgsConstructor 사용)

@NoArgsConstructor
@AllArgsConstructor  // Contact(String, String) 해당 생성자를 사용하면 디폴트생성자가 없어져서 @NoArgsConstructor 을 추가해 주어야 한다.
@Getter
public class Contact {
  public String mobile = "010-1111-1111";
  public String email = "user@min.com";
  
}
