package com.min.app11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.min.app11.aop.BeforeAdvice;

@EnableAspectJAutoProxy  // AOP 동작을 위해서 필요합니다.
@Configuration // Spring Container에 bean을 만들어 두는 클래스 입니다.
public class AppConfig {
  
  @Bean // bean을 만드는 메소드입니다. bean의 타입은 BeforeAdvice.class이고, 
        // bean의 이름은 before 입니다. 
  BeforeAdvice before() {
    return new BeforeAdvice();
  }
}
