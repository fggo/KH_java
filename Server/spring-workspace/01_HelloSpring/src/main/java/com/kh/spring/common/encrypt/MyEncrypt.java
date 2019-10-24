package com.kh.spring.common.encrypt;

public interface MyEncrypt {
  String encrpt(String msg) throws Exception;
  String decrypt(String msg) throws Exception;
}
