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

    div#comment-container button#btn-insert{
      width:60px; height:50px; color:white; background:#3300ff; position:relative; top:-20px;
    }
  </style>
  <section id="board-container">
  <h2>게시판</h2>
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
        <td>
          <%-- <% if(b.getBoardRenamedFilename() != null){ %> OK AS WELL! --%>
          <% if(b.getBoardOriginalFilename() != null){ %>
            
            <!-- click to Download! -->
            <!-- <a href="<%=request.getContextPath()%>/board/boardFileDown?fileName=<%=b.getBoardOriginalFilename() %>" > -->

            <!-- encoding 처리해서 보낼수 있음 -->
            <!-- a태그에 옵션이 걸리면 실행 -->
              <a href="javascript:fn_filedown('<%=b.getBoardOriginalFilename() %>','<%=b.getBoardRenamedFilename() %>')">
                <img src="<%=request.getContextPath()%>/images/file.png" alt="" width='16px' />
                <%=b.getBoardOriginalFilename() %>
              </a>
            <!-- </a> -->
          <% } %>
          <script>
            function fn_filedown(ori,re){
              var file=encodeURIComponent(ori);
              location.href="<%=request.getContextPath()%>/board/boardFileDown?orifileName="+file+"&refileName="+ re;
            }
          </script>
        </td>
			</tr>
			<tr>
				<th>내 용</th>
        <td><%=b.getBoardContent() %></td>
			</tr>
			<%-- 글작성자/관리자인 경우만 수정삭제 가능 --%>
      
      <% if(loginMember != null 
           && (loginMember.getUserId().equals(b.getBoardWriter())
           || loginMember.getUserId().equals("admin"))){ %>
			<tr>
				<th colspan="2">
					<input type="button" value="수정하기" onclick="fn_updateBoard()">
					<input type="button" value="삭제하기" onclick="fn_deleteBoard()">
				</th>
      </tr>
      <% } %>
			
    </table>

    <!-- 댓글화면 구현하기 -->
    <div id="comment-container">
      <div class="comment-editor">
        <form action="<%=request.getContextPath() %>/boardcomment/commentInsert" method="post">
          <!-- DB나 businiess logic에 필요한 데이터를 hidden input으로 보냄 -->
          <input type="hidden" name="boardRef" value="<%=b.getBoardNo() %>">
          <input type="hidden" name="boardCommentWriter" value="<%=loginMember!=null? loginMember.getUserId(): "" %>">
          <input type="hidden" name="boardCommentLevel" value="1">
          <input type="hidden" name="boardCommentRef" value="0">

          <textarea name="boardCommentContent" cols="60" rows="3" placeholder="댓글을 입력하세요..."></textarea>
          <button type="submit" id="btn-insert">등록</button>
        </form>
      </div>
    </div>
   
    <script>
      function fn_updateBoard(){
        location.href="<%=request.getContextPath() %>/board/boardUpdate?no=<%=b.getBoardNo() %>";
      }
      function fn_deleteBoard(){
        location.href="<%=request.getContextPath() %>/board/boardDelete?no=<%=b.getBoardNo() %>";
      }

      $(function(){
        $("textarea[name=boardCommentContent]").focus(function(){
          if(<%=loginMember== null %>){
            alert('로그인 후 등록할 수 있습니다!');
            $("#userId").focus();
          }
        });
      });
    </script>
  </section>

<%@ include file="/views/common/footer.jsp" %>