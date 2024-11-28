package com.min.app01.pkg03_component;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component(value = "p")  // 이 Person 클래스는 이름이 p 인 bean 으로 만들어집니다.(클레스 이름의 첫글자가 소문자로 변경되어 bean으로 만들어짐)

@Getter
public class Person {
  public String name = "유저";
  public Contact contact = new Contact("010-2222-2222", "user2@min.com");
  
}
