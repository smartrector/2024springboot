package com.sample.spring.util;

//사용자 정의 제외
public class CustomJWTException extends RuntimeException {
  public CustomJWTException(String msg) {
      super(msg);
  }
}
