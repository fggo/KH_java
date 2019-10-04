

//bean 등록(import stereotype) 
@Controller
public class DemoController{
  
  //+ method와 mapping
  @RequestMapping("/demo/demo.do")
  public String mytestfunc(){
      //method parameter?
    System.out.println("/demo/demo.do 컨트롤러 호출");
    return "demo/demo"; //Resolver에 return 되면서 prefix suffix 붙은 url의 jsp페이지를 보여줌!
    //return: dispatcher servlet 역할 forward(request,response)와 같은 기능
    
  }
  //views 밑에 demo/demo.jsp 생성