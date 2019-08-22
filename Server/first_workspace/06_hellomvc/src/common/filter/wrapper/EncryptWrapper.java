package common.filter.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {
  
  public EncryptWrapper(HttpServletRequest request) {
    super(request);
  }

  @Override
  public String getParameter(String name) {
    String value="";
    if(name!=null && name.equals("password")) {
//      shar512 암호화 코드
      value = getSha512(super.getParameter(name)); //client가 보낸 실제 값을 암호화
      System.out.println("암호화된 비번 : " + value);
      return value;
    }
    else {
      return super.getParameter(name);
    }
  }
  
  private String getSha512(String val) {
    String encPwd = "";
//    messagedigest(sha512 방식)
//    단방향 암호화, 양방향암호화
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("SHA-512");
    } catch(NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    byte[] bytes = val.getBytes(Charset.forName("UTF-8"));
//    md.digest(bytes);
    md.update(bytes);
    encPwd = Base64.getEncoder().encodeToString(md.digest()); //encode: byte->string

    return encPwd;
  }
}
