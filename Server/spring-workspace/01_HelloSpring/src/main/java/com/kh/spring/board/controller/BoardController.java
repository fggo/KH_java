package com.kh.spring.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.common.PageBarFactory;

@Controller
public class BoardController {

  private Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService service;
  
  /**
   * 
   * @param cPage
   * @return ModelAndView
   */
  @RequestMapping("/board/boardList.do")
  public ModelAndView boardList(@RequestParam(value="cPage", required=false, defaultValue="0") int cPage) {
    logger.debug("");
    ModelAndView mv = new ModelAndView(); //모델과 뷰를 둘다 저장할 수 있음

    int numPerPage = 5;
    List<Map<String, String>> list = service.selectBoardList(cPage, numPerPage);
    int totalCount = service.selectBoardCount();

    
    mv.addObject("pageBar", PageBarFactory.getPageBar(totalCount, cPage, numPerPage, "/spring/board/boardList.do"));
    mv.addObject("count", totalCount);
    mv.addObject("list", list);

    mv.setViewName("board/boardList");

    return mv;
  }
  
  @RequestMapping("/board/boardForm")
  public String boardForm() {
    return "board/boardForm";
  }

  @RequestMapping("/board/boardFormEnd.do")
  public ModelAndView insertBoard(@RequestParam Map<String, String> param,
                                  @RequestParam(value="upFile", required=false) MultipartFile[] upFile,
                                  HttpServletRequest request){
    for(Object o : param.keySet())
      logger.debug("param " + param.get(o));
    logger.debug(" " + upFile[0].getOriginalFilename());
    logger.debug(" " + upFile[0].getSize());
    logger.debug(" " + upFile[1].getOriginalFilename());
    logger.debug(" " + upFile[1].getSize());
    
    /* 파일업로드 처리하기 */
    //1.저장경로 지정하기
    String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/board");
    List<Attachment> attachList = new ArrayList<Attachment>(); //에러파일 보관용

    File dir = new File(saveDir);

    if(!dir.exists()) logger.debug("" + dir.mkdirs());
    
    for(MultipartFile f : upFile) {
      if(!f.isEmpty()) {
        //파일명 생성(rename)
        String oriFileName = f.getOriginalFilename();
        String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
        //규칙설정
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHMMssSSS");
        int rdv = (int)(Math.random()*1000);
        String reName = sdf.format(System.currentTimeMillis())+ "_" + rdv + ext;
        try {
          f.transferTo(new File(saveDir + "/" + reName));
        } catch(Exception e) {
          e.printStackTrace(); //IllegalStateException, IOException
        }
        
//        DB에 저장할 데이터 보관
        Attachment att = new Attachment();
        att.setOriginalFileName(oriFileName);
        att.setRenamedFileName(reName);
        attachList.add(att);
      }
    }
    int result = 0;
    try {
      result=service.insertBoard(param,attachList);
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    String msg ="";
    String loc="/board/boardList.do";
    if( result >0)
      msg= "입력 성공!";
    else
      msg="입력 실패!";

    ModelAndView mv = new ModelAndView();
    mv.addObject("msg", msg);
    mv.addObject("loc", loc);
    mv.setViewName("common/msg");

    return mv;
  }


  @RequestMapping("/board/boardView.do")
  public ModelAndView boardView(int boardNo) {
    ModelAndView mv = new ModelAndView();
    Map<String, String> board = service.selectBoard(boardNo);
    List<Attachment> att = service.selectAttachList(boardNo);
    
    mv.addObject("board", board);
    mv.addObject("att", att);
    mv.setViewName("board/boardView");

    return mv;
  }
  
  @RequestMapping("/board/filedownLoad.do")
  public void boardFileDownLoad(String rName, String oName, HttpServletRequest request,
        HttpServletResponse response) {
     BufferedInputStream bis = null;
     ServletOutputStream sos = null;
     String dir = request.getSession().getServletContext().getRealPath("/resources/upload/board");
     File saveFile = new File(dir + "/" + rName);
     try {
        FileInputStream fis = new FileInputStream(saveFile);
        bis = new BufferedInputStream(fis);
        sos = response.getOutputStream();
        String resFileName = "";
        boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
              || request.getHeader("user-agent").indexOf("Trident") != -1;

        if (isMSIE) {
           resFileName = URLEncoder.encode(oName, "UTF-8");
           resFileName = resFileName.replaceAll("\\", "%20");
        } else {
           resFileName = new String(oName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setContentType("application/octet-stream;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=\"" + resFileName + "\"");
        response.setContentLength((int) saveFile.length());

        int read = 0;
        while ((read = bis.read()) != -1) {
           sos.write(read);
        }
     } catch (IOException e) {
        e.printStackTrace();
     } finally {
        try {
           sos.close();
           bis.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
     }
  }

}
