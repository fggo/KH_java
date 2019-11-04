package com.kh.spring.common.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.springframework.stereotype.Component;

@Component
public class RSAEncrypto implements MyEncrypt {

  private PublicKey publickey; //암호화키 (네트워크에 public으로 올려놓음)
  private PrivateKey privatekey; //복호화 키 (public 과 matching 되어 있음 paired)
//  A->B 전송 시 (A가 B의 public key를 이용해서  암호화 -> B가 A로부터 받은 것을 private key로 복호화!)
  //정기적으로 key를 바꿔줌

  public RSAEncrypto() {
    String path = this.getClass().getResource("/").getPath();
    path = path.substring(0, path.lastIndexOf("/target/"));
    File f= new File(path + "/src/main/webapp/WEB-INF/keys.jh");
    if(f.exists()) {
      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
        try {
          Map<String, Object> keys = (Map<String, Object>)ois.readObject();
          publickey = (PublicKey)keys.get("public");
          privatekey = (PrivateKey)keys.get("private");
        } catch(Exception e) {
          e.printStackTrace();
        }
        
      } catch(IOException e) {
        e.printStackTrace();
      }
    } else {
      if(publickey==null || privatekey==null) {
        try {
           this.getKey();
        } catch(NoSuchAlgorithmException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  private void getKey() throws NoSuchAlgorithmException{
    SecureRandom ser = new SecureRandom();
    //RSA 방식으로 통신을 하기위해서는 비대칭이기 떄문에 두개의 key값이 필요함
    //1.public key 2.private key
    KeyPairGenerator keygen;
    keygen = KeyPairGenerator.getInstance("RSA");
    keygen.initialize(2048, ser);
    
    //공개키, 개인키를 생성
    KeyPair keypair = keygen.generateKeyPair();
    publickey = keypair.getPublic();
    privatekey = keypair.getPrivate();
    
    Map<String, Object> keys =  new HashMap<String, Object>();
    keys.put("public", publickey);
    keys.put("private", privatekey);

    String path = this.getClass().getResource("/").getPath();
    path = path.substring(0, path.lastIndexOf("/target/"));
    File f= new File(path + "/src/main/java/webapp/WEB-INF/keys.jh");


    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
      oos.writeObject(keys);
      
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }

  @Override
  public String encrpt(String msg) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE, publickey);
    byte[] encStr = cipher.doFinal(msg.getBytes());
    return Base64.getEncoder().encodeToString(encStr);
  }

  @Override
  public String decrypt(String msg) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privatekey);
    byte[] encStr = Base64.getDecoder().decode(msg.getBytes());
    byte[] result = cipher.doFinal(encStr);
        
    return new String(result, "UTF-8");
  }

}
