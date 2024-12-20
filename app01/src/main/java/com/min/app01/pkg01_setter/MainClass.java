package com.min.app01.pkg01_setter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

  public static void main(String[] args) {

    // GenericXmlapplicationContext(제너릭 엑스엠엘 어플리케이션 컨텍스트) 클래스
    // XML로 생성된 bean을 관리하는 클래스
    // AbstractApplicationContext(앱스트랙트 애플리케이션 컨텍스트)
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("pkg01_setter/app-context.xml");
    
    Contact c = ctx.getBean("contactBean", Contact.class); // Contact c = (Contact) ctx.getBean("contactBean");
    System.out.println(c.getMobile());
    System.out.println(c.getEmail());
    
    Person p = ctx.getBean("personBean", Person.class);
    System.out.println(p.getName());
    System.out.println(p.getContact().getEmail());
    System.out.println(p.getContact().getMobile());
    
    // scope 동작 확인
    Person p2 = ctx.getBean("personBean", Person.class);
    System.out.println(p == p2);
    
    ctx.close();
    
    
    // Singleton pattern 확인
    /*
    Contact c1 = Contact.getInstance();
    Contact c2 = Contact.getInstance();
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c1 == c2);
    */
    
  }

}
