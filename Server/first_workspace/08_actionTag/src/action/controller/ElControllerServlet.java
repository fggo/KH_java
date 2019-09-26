package action.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.model.vo.Person;

/**
 * Servlet implementation class ElControllerServlet
 */
@WebServlet("/elscope")
public class ElControllerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /* <h2>공유객체에 있는 데이터 </h2> */
    request.setAttribute("name", "유병승");
    request.setAttribute("age", 19);
    request.getSession().setAttribute("userId", "user01");
    getServletContext().setAttribute("admin", "여러분힘내요!");
    
    /* <h3>중복값</h3> */
    request.setAttribute("item", "신발");
    request.getSession().setAttribute("item", "모자");

    /* <h3>객체</h3> */
    Person p=new Person("김태엽",28,"남");
    request.setAttribute("person", p);

    /* <h2>공유객체에 있는 데이터</h2> */
    List<String> list=new ArrayList<String>();
    list.add("축구");
    list.add("농구");
    list.add("배구");
    list.add("야구");
    list.add("탁구");

    request.setAttribute("sports", list);

    /* <h3>컬렉션 </h3> */
    List<Person>list2=new ArrayList<Person>();
    list2.add(new Person("김기호",26,"남"));
    list2.add(new Person("최장원지각",27,"남"));
    list2.add(new Person("서선덕",21,"여"));
    list2.add(new Person("김준영",25,"남"));

    request.setAttribute("persons", list2);
    

    request.getRequestDispatcher("/views/el/scopeResult.jsp")
      .forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
