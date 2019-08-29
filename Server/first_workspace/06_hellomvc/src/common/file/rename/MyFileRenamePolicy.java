package common.file.rename;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

  @Override
  public File rename(File oldFile) {
    File newFile = null;
    do {
      //file rename을 위한 준비값
      long currentTime = System.currentTimeMillis();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
      int rndNum = (int)(Math.random()*1000);
      
      //파일의 확장자명 가져오기
      //rename시에 확장자까지 변경하면?? 안됨
      String oldName = oldFile.getName(); //확장자까지 다 가져옴
      String ext = "";
      int dot = oldName.indexOf(".");
      if(dot>-1) {
        ext = oldName.substring(dot);
      }
      String newName = sdf.format(new Date(currentTime)) + "_" + rndNum+ext;
      newFile = new File(oldFile.getParent(), newName); //같은 부모 됨
    } while(!createNewFile(newFile));
    //생성됏을때, while문 빠져나옴 
    //중복되는 파일 있으면 계속 whileloop으로 중복 안된 파일명 generate

    return newFile;
  }
  
  private boolean createNewFile(File newFile) {
    //파일이 있는지 확인하고 있으면 파일을 생성하지 않고,
    //파일을 생성하지 않고, 다른이름을 변경
    //없으면 생성
    try {
      return newFile.createNewFile(); //파일이름이 없으면 true
    } catch(IOException e) {
      e.printStackTrace();
      return false;
    }
  }


}
