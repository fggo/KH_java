package com.kh.spring.common.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

//@Component
public class AEScrypto implements MyEncrypt {
  //자바는 기본적으로 암호화객체를 API로 제공하고 있음
  //javax.crypto 패키지에서 암호화 관련 내용을 제공
  //암호화 알고리즘은 java.security 패키지에서 제공
  //대칭 암호화를 위한 대칭키가 필요함
  
  private SecretKey key; //암호화 키
  
  public AEScrypto() throws NoSuchAlgorithmException {
    //key 생성파일이 있는지 확인하고 있으면, 파일에 저장된 key값을 가져오고
    //없으면  getkey를 통해서 key파일을 생성

    String path = this.getClass().getResource("/").getPath();//클래스 위치
    path = path.substring(0, path.lastIndexOf("/target"));
    File f = new File(path + "/src/main/webapp/WEB-INF/mykey.key");
    if(f.exists()) {
      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
        key = (SecretKey)ois.readObject();
      } catch(IOException e) {
        e.printStackTrace();
      } catch(ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    else {
      if(key == null) {
        this.getKey();
      }
    }
    
  }

  private void getKey() throws NoSuchAlgorithmException{
    SecureRandom sRandom = new SecureRandom(); //키값 생성을 위한 sort값
    //난수를 통해서 키값을 만듦
    //Math.random() 랜덤값을 만들었는데.. 이 SecureRandom객체는
    //Math.random의 랜덤값 보다 더 정교한 방식으로 만들어낸 랜덤값
    
    KeyGenerator keygen; //key를 생성하는 객체
    
    //key생성에 필요한 알고리즘을 적용해 키 생성객체를 세팅
    keygen = KeyGenerator.getInstance("AES");
    //객체에 선언된 알고리즘을 초기화
    
    keygen.init(128, sRandom); //256비트 이용, sort는 랜덤으로 적용
    key = keygen.generateKey();
    
    //파일로 저장하기 위해서, 한번 변환한 키는 그 키로만 복호화 암호화를 해야하기 때문에
    //동일한 값으로 보관되어야함.
    //만든키는 파일로 보관을 진행
    //만든 암호화키는 저장장소를 WEB-INF 폴더에 저장
    String path = this.getClass().getResource("/").getPath();//클래스 위치
    //c://01.hellospring/src/WEB-INF/classes/com/
    path.substring(0, path.lastIndexOf("target"));
    File f = new File(path + "/src/main/webapp/WEB-INF/mykey.key");
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
      oos.writeObject(key);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String encrpt(String msg) throws Exception {
    //생성한 Key를 이용하여 암호화 진행하면 됨
    //Cipher객체를 통해서 암호화 및 복화를 할 수  있음
    Cipher cipher = Cipher.getInstance("AES"); //암호화할 알고리즘을 생성
    cipher.init(Cipher.ENCRYPT_MODE, key); //암호화 할건지 복호화 할건지 모드를 지정
    byte [] encryptResult = cipher.doFinal(msg.getBytes());
    return Base64.getEncoder().encodeToString(encryptResult);
  }

  @Override
  public String decrypt(String msg) throws Exception {
    Cipher cipher = Cipher.getInstance("AES"); //암호화할 알고리즘을 생성
    cipher.init(Cipher.DECRYPT_MODE, key); //암호화 할건지 복호화 할건지 모드를 지정
    byte [] encryptResult = Base64.getDecoder().decode(msg.getBytes());
    byte [] decrStr = cipher.doFinal(encryptResult);
    return new String(decrStr, "UTF-8");
//    return Base64.getEncoder().encodeToString(encryptResult);
  }

}
