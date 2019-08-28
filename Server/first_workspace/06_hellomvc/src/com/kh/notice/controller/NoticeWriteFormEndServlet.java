package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class NoticeWriteFormEndServlet
 */
@WebServlet("/notice/noticeFormEnd")
public class NoticeWriteFormEndServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //file upload 구현하기
    //1.enctype="multipart/form-data" <-- 로 보내야 파일 관련 처리가능
    //client가 데이터를 multipart/form-data로  보냈는지 확인
    if(!ServletFileUpload.isMultipartContent(request)) {
      request.setAttribute("msg", "공지사항 에러!![form: enctype 관리자에게 문의하세요...");
      request.setAttribute("loc", "/");
      request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
      return;
    }

    //파일 업로드 처리 및 DB 저장
    //1. 파일 업로드 경로를 가져옴
    //   서버의 디렉토리 절대 경로를 가져와야 함.
    String root = getServletContext().getRealPath("/");
    System.out.println(root);
    //파일을 저장할 위치를 선정
    //서버내부에 폴더 위치를 만들어 줘야 함
    //경로없으면 폴더 생성 안함. 직접 만들기
    String saveDir = root + "/upload/notice";
    
    //2. 업로드 파일의 최대용량을 정함.
    int maxSize = 1024 * 1024*10; //10MB
    
    //3. cos.jar 에서 지원하는 객체를 생성하기
    //MultiPartRequest (파일처리 객체)
    //매개변수가 있는 생성자를 이용해서 생성함
    /* MultipartRequest mr 
      = new MultipartRequest(HttpServletRequest,
                             저장경로,
                             최대파일 크기,
                             문자열 인코딩값,
                             파일 rename 설정 되어있는 객체));   //  같은 이름 파일 올리는걸 방지-> 파일 rename
    */
    //생성구문을 해석하는 순간 파일업로드 완료!
    MultipartRequest mr = new MultipartRequest(request,
                                               saveDir,
                                               maxSize,
                                               "UTF-8",
                                               new DefaultFileRenamePolicy());
    
    //파일명을 DB에 저장
    //client가 보낸 값을 받아오기
    //값을 가져올 때는 MultipartRequest객체에서 가져옴
    String title = mr.getParameter("title");
    String writer = mr.getParameter("writer");
    String content = mr.getParameter("content");
    //file명 가져오기!
    String fileName = mr.getFilesystemName("up_file");
    System.out.println();
    fileName = mr.getOriginalFileName("up_file");
    //sequence로 어차피 notice_no 들어가므로 아무 값이나 넣음(=0)
    Notice n = new Notice(0, title, writer, content, null, fileName);
    System.out.println(n);

    int result = new NoticeService().insertNotice(n);

    String msg = "";
    String loc = "";

    if(result > 0) {
      msg = "공지사항 등록완료";
//      loc="/notice/noticeList";
      loc="/notice/noticeView?no="+result;
    }
    else{
      msg = "공지사항 등록실패";
      loc="/notice/noticeForm";
    }
    request.setAttribute("msg", msg);
    request.setAttribute("loc", loc);
    request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
