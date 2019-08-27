<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, java.util.ArrayList, com.kh.notice.model.vo.Notice"%>

<%
  List<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
  String pageBar = (String)request.getAttribute("pageBar");
%>

<%@ include file="/views/common/header.jsp" %>
  <style>
    section#notice-container{
      width:600px;
      margin:0 auto;
      text-align: center;
    }
    section#notice-container h2{
      margin: 10px 0;
    }
    table#tbl-notice{
      width:100%; margin: 0 auto;
      border: 1px solid black;
      border-collapse: collapse;
    }

    table#tbl-notice th, table#tbl-notice td{
      border: 1px solid black;
      padding: 5px 0;
      text-align: center;
    }
    input#btn-add{float:right; margin: 0 0 15px;}

  </style>
  <section id="notice-container">
    <h2>공지사항</h2>

    <% if(loginMember != null && loginMember.getUserId().equals("admin")){ %>
      <input type="button" value="글쓰기" id="btn-add" onclick="writeNotice();">
    <%} %>

    <table id="tbl-notice">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>첨부파일</th>
        <th>작성일</th>
      </tr>
      <% for(Notice n : list){ %>
        <tr>
          <td><%=n.getNoticeNo() %></td>
          <td>
            <a href="<%=request.getContextPath()%>/notice/noticeView?no=<%=n.getNoticeNo()%>">
              <%=n.getNoticeTitle() %>
            </a>
          </td>
          <td><%=n.getNoticeWriter()%></td>
          <td>
            <%if(n.getFilePath() !=null){ %>
              <img src="<%=request.getContextPath() %>/images/file.png" width="16px">
            <% } %>
            <!-- <%=n.getFilePath()%> -->
          </td>
          <td><%=n.getNoticeDate()%></td>
        </tr>
      <%} %>
    </table>
    <div id="pageBar">
      <%=pageBar %>
    </div>
  </section>
  <script>
    function writeNotice(){
      location.href = "<%=request.getContextPath() %>/notice/noticeForm";
    }
  </script>
<%@ include file="/views/common/footer.jsp" %>