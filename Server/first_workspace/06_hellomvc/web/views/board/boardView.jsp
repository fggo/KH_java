<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.kh.board.model.vo.Board" %>

<%
  Board b = (Board)request.getAttribute("board");
%>

<%@ include file="/views/common/header.jsp" %>
  <style>
    section#board-container{width:600px; margin:0 auto; text-align:center;}
    section#board-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
  </style>
  <section id="board-container">
  <h2>게시판</h2>
    <% if(loginMember != null && loginMember.getUserId().equals("admin")){ %>
      <input type="button" value="글쓰기" id="btn-add" onclick="writeBoard();">
    <%} %>
		<table id="tbl-board">
			<tr>
				<th>글번호</th>
				<td><%=b.getBoardNo()%></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><%=b.getBoardTitle()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=b.getBoardWriter()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=b.getBoardReadcount() %></td>
			</tr>
			<tr>
				<th>첨부파일</th>
        </td>
          <% if(b.getFilePath() != null){ %>
            <!-- click to Download! -->
            <!-- <a href="<%=request.getContextPath()%>/notice/noticeFileDown?fileName=<%=n.getFilePath()%>" > -->

            <!-- encoding 처리해서 보낼수 있음 -->
            <!-- a태그에 옵션이 걸리면 실행 -->
              <a href="javascript:fn_filedown('<%=b.getFilePath()%>')"></a>
              <img src="<%=request.getContextPath()%>/images/file.png" alt="" width='16px'>
            <!-- </a> -->
            <script>
              function fn_filedown(filename){
                //미리 한글로 바꿀 수 있음
                var file=encodeURIComponent(filename);
                location.href="<%=request.getContextPath()%>/board/boardFileDown?fileName="+ file;
              }
            </script>
          <% } %>
        </td>
			</tr>
			<tr>
				<th>내 용</th>
        <td><%=b.getBoardContent() %></td>
			</tr>
			<%--글작성자/관리자인경우 수정삭제 가능 --%>
			
			<tr>
				<th colspan="2">
					<input type="button" value="수정하기" onclick="fn_updateBoard()">
					<input type="button" value="삭제하기" onclick="fn_deleteBoard()">
				</th>
			</tr>
			
		</table>
    <%--글작성자/관리자인경우 수정삭제 가능  --%>
   
    <form >
      <input  />
      <input  />
    </form>
    <script>
      function writeBoard(){

      }

      function fn_updateBoard(){
        
      }
      function fn_deleteBoard(){
          
      }
    </script>

  </section>

<%@ include file="/views/common/footer.jsp" %>