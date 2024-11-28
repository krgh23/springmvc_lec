package com.min.app02.pkg02_setter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

  public static void main(String[] args) {

    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.min.app02.pkg02_setter", "com.min.app02.domain");
                                                                        // ("com.min.app02"); 상위 패키지로 지정하여 둘다 되게 할수도 있음
    Person person = ctx.getBean("person", Person.class);
    System.out.println(person);
    
    ctx.close();
    
  }

}
