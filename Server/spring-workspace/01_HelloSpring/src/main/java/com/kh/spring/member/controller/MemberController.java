package com.kh.spring.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.common.encrypt.MyEncrypt;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

//bean 등록(import stereotype) + method와 mapping @RequestMapping("");
//sessionAttribute에 model에서 loginMember찾아서 session에 자동으로 올림
//여러개 value 등록 가능(session에 add)
@SessionAttributes(value= {"loginMember"})
@Controller
public class MemberController{
  
  private Logger logger = LoggerFactory.getLogger(MemberController.class);
  
  //의존성 주입으로 자동으로 연결 (= new MemberServiceImpl())
  @Autowired
  private MemberService service;
  @Autowired
  private BoardService bService;

  @Autowired
  private BCryptPasswordEncoder pwEncoder;
  
  @Autowired
  private MyEncrypt enc;
//  bean 등록방법
//  1.annotation / 2.xml
//  AEScrypto 클래스를 bean으로 등록 @Component
 
//  @RequestMapping("/member/memberLogin.do")
//  public String login(Member m, HttpSession session) {
//    Member loginMember = service.selectMemberOne(m);
//
//    if(loginMember !=null) {
//      session.setAttribute("loginMember", loginMember);
//      System.out.println(loginMember);
//    }
//
//    return "redirect:/";
//  }


//  //1. Ajax 통신 - stream 이용하는 방법 
//  @RequestMapping("/member/checkId.do")
//  public void ajaxStream(String userId, HttpServletResponse res) throws IOException {
//    Member m = new Member();
//    m.setUserId(userId);
//    
//    m = service.selectMemberOne(m);
//    boolean isUsable = (m!= null && m.getUserId() !=null )? false : true;
//    res.getWriter().print(isUsable);
//  }
  
  //2. Ajax통신 - viewResolver(jsonView를 이용)로 처리하는 방법
  //pom.xml에 의존성 등록
//  @RequestMapping("/member/checkId.do")
//  public ModelAndView ajaxViewResolver(String userId, ModelAndView mv) {
//    Member m = new Member();
//    m.setUserId(userId);
//    m = service.selectMemberOne(m);
//
////    Member member = service.selectMemberOne(m); //객체넘기기
//
//    boolean isUsable =  (m!=null && m.getUserId()!=null)? false:true;
//
//    mv.addObject("userId", "dsads");
//    mv.addObject("isUsable", isUsable);
//    mv.setViewName("jsonView"); //명칭을 반드시 jsonView로 해야됨!
//
//    return mv;
//  }
  
  //3. jackson형식 jackson mapper 필요
  @RequestMapping("/member/checkId.do")
  @ResponseBody
  public String responseBody (String userId, Model model) throws JsonProcessingException{
    Member m = new Member();
    m.setUserId(userId);
    m = service.selectMemberOne(m);
    //jackson은 gson과 비슷한 역할, better functionality
    ObjectMapper mapper = new ObjectMapper();
//    mapper.readValue(json값, vo클래스);

    List<Map<String, String>> list = bService.selectBoardList(1, 5);
//    return mapper.writeValueAsString(m);
    return mapper.writeValueAsString(list);
  }

  /**
   * 
   * @param m
   * @param model
   * @param session SessionStatus
   * @return String(jsp)
   */
  @RequestMapping("/member/memberLogin.do")
  public String login(Member m, Model model, HttpSession session) {

    Member loginMember = service.selectMemberOne(m);
//    Model: request 대신에 씀

    String msg="";
    String loc = "/";

//    if(loginMember.getPassword().equals(m.getPassword())
    logger.debug(m.getUserId()); //debug 위단계들만 출력 xml에서 info로 세팅하면 debug등 안뜸
    logger.debug(m.getPassword());
    logger.debug(pwEncoder.encode(m.getPassword()));
    logger.debug(loginMember.getPassword());

    if(loginMember != null &&
        pwEncoder.matches(m.getPassword(), loginMember.getPassword())) {
      msg ="login success";
      model.addAttribute("loginMember", loginMember); //model은 request같아서 세션 유지 X
      //@SessionAttributes등록하면 loginMember를 session에 올림
    }
    else
      msg = "login fail";
    
    model.addAttribute("msg", msg);
    model.addAttribute("loc", loc);

    return "common/msg";
  }
  
  @RequestMapping("/member/memberEnroll.do")
  public String enroll() {
    //only changes view
    return "member/memberEnroll";
  }

  @RequestMapping("/member/memberEnrollEnd.do")
  public String enrollEnd(Member m, Model model) {
    m.setPassword(pwEncoder.encode(m.getPassword()));
    try {
      m.setEmail(enc.encrpt(m.getEmail())); //이메일 암호화
      m.setAddress(enc.encrpt(m.getAddress())); //이메일 암호화
      m.setPhone(enc.encrpt(m.getPhone())); //이메일 암호화
    } catch(Exception e) {
      e.printStackTrace();
    }

    int result = service.insertMember(m);

    String msg ="";
    String loc= "/";
    System.out.println(m);

    if(result > 0) msg= "Member Enroll Succcess";
    else msg="Member Enroll Failed...";

    model.addAttribute("msg", msg);
    model.addAttribute("loc", loc);

    System.out.println(m);
    System.out.println(result);

    return "common/msg";
  }
  
  @RequestMapping("/member/memberLogout.do")
//  public String logout(Member m, Model model, HttpSession session) {
  public String logout(Member m, Model model, SessionStatus status) {
//    model.addAttribute("loginMember", m);
//    session.invalidate();

    if(!status.isComplete()) //check if session is closed
      status.setComplete(); //httpsessison.invalidate()와 같은기능

    return "redirect:/";
  }

//  @RequestMapping("/member/memberDelete.do")
//  public String delete(Member m, Model model) {
//    String msg = "";
//    String loc="/";
//    int result = service.deleteMember(m);
//    return "common/msg";
//  }
  
  @RequestMapping("/viewChatting.do")
  public String viewChatting() {
    return "chatting/viewChatting";
  }
  
	@RequestMapping("/member/memberView.do")
	public String memberView(Member m, Model model) {
	  Member result = service.selectMemberOne(m);
	  try {
	    result.setEmail(enc.decrypt(result.getEmail()));
	    result.setPhone(enc.decrypt(result.getPhone()));
	    result.setAddress(enc.decrypt(result.getAddress()));
	  } catch(Exception e){
	    e.printStackTrace();
	  }
	  model.addAttribute("member", result);
	  
	  return "member/memberView";
	}
  
  
}
