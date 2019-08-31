<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.kh.board.model.vo.Board" %>
<%@ page import="com.kh.board.model.vo.BoardComment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
  Board b = (Board)request.getAttribute("board");
  List<BoardComment> list = (ArrayList<BoardComment>)request.getAttribute("list");
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
        /*댓글테이블*/
    table#tbl-comment{width:580px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-reply{display:none;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-reply{display:inline;}
    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
    table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
    table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
    table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}
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
          <input type="button" value="수정하기" onclick="fn_updateBoard()" />
					<input type="button" value="삭제하기" onclick="fn_deleteBoard()" />
				</th>
      </tr>
      <% } %>
      <script>
        function fn_updateBoard(){
          location.href="<%=request.getContextPath() %>/board/boardUpdate?no=<%=b.getBoardNo() %>";
        }
        function fn_deleteBoard(){
          location.href="<%=request.getContextPath() %>/board/boardDelete?no=<%=b.getBoardNo() %>";
        }
      </script>
			
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

          <textarea name="boardCommentContent" cols="60" rows="3" placeholder="댓글을 입력하세요..." style="resize:none;"></textarea>
          <button type="submit" id="btn-insert">등록</button>
        </form>
      </div>
    </div>
   
    <table id="tbl-comment">
		
			<%if(list!=null && !list.isEmpty()){
      for(BoardComment bc : list){ 
          if(bc.getBoardCommentLevel() == 1){ %>
          <tr class="level1">
            <td>
              <sub class="comment-writer">
                <%=bc.getBoardCommentWriter() %>
              </sub>
              <sub class="comment-date">
                <%=bc.getBoardCommentDate() %>
              </sub>
              <br/>
              <%=bc.getBoardCommentContent() %>
            </td>
            <td>
              <button class="btn-reply" value="<%=bc.getBoardCommentNo() %>" >
                답글
              </button>
              <% if(loginMember != null
                && ("admin".equals(loginMember.getUserId())
                    || bc.getBoardCommentWriter().equals(loginMember.getUserId()))){ %>
                <button class="btn-delete" value="<%=bc.getBoardCommentNo() %>">
                  삭제
                </button>
              <% } %>
            </td>
          </tr>
        <% }else{ %>
          <tr class="level2">
            <td>
              <sub>
                <%=bc.getBoardCommentWriter() %>
              </sub>
              <sub>
                <%=bc.getBoardCommentDate() %>
              </sub>
              <br/>
              <%=bc.getBoardCommentContent() %>
            </td>
            <td>
            </td>
          </tr>
        <% }
        } 
			} %>
		</table>
  </section>

  <script>
    $(function(){
      $("textarea[name=boardCommentContent]").focus(function(){
        if(<%=loginMember == null %>){
          alert('로그인 후 등록할 수 있습니다!');
          $("#userId").focus();
        }
      });
      $('#btn-insert').click(function(){
        //prevent null value submit
      });

      $('.btn-delete').click(function(){
				if(<%=loginMember==null %>){
          alert("로그인 후 사용이 가능합니다.");
          return;
        }
        if(confirm("정말로 삭제 하시겠습니까?")){
          location.href="<%=request.getContextPath() %>/board/boardCommentDelete?no=<%=b.getBoardNo() %>&commentNo=" + $(this).val();
        }

      });

      $('.btn-reply').click(function(){
				if(<%=loginMember!=null%>){
					var tr=$('<tr>');
					var td=$("<td>").css({"display":"none","text-align":"left"}).attr("colspan",2);
					var form=$("<form>").attr({
								"action":"<%=request.getContextPath()%>/board/boardCommentInsert",
								"method":"post"
							});
					var boardRef=$("<input>").attr({
							"type":"hidden","name":"board_ref",
							"value":"<%=b.getBoardNo()%>"
						});
					var writer=$("<input>").attr({
							"type":"hidden","name":"writer",
							"value": '<%=loginMember!=null? loginMember.getUserId(): "" %>'
						});
					var level=$("<input>").attr({
						"type":"hidden","name":"level",
						"value":"2"
						});
					var commentRef=$("<input>").attr({
							"type":"hidden","name":"commentRef",
							"value": $(this).val(),
						});
					var content=$("<textarea>").attr({
							"name":"content","cols":"60","rows":"2"
						});
					var btn=$("<button>").attr({
							"type":"submit","class":"btn-insert2"
            }).html("등록");

          form.append(boardRef).append(writer).append(level).append(content).append(commentRef).append(btn);
          td.append(form);

          tr.html(td);
          tr.insertAfter($(this).parent().parent()).children("td").slideDown(800);

          $(this).off("click");

          //자료저장 이벤트
          tr.find("form").submit(function(e){
            if(<%= loginMember == null %>){
              alert('로그인 후에 이용해 주세요!');
              e.preventDefault();
            }
            var len= $(this).children("textarea").val().trim();
            if(len == 0){
              alert("내용을 입력하세요");
              e.preventDefault();
            }
          });
				}else{
					alert("로그인후 이용할 수 있습니다.");
					$("#userId").focus();
				}
      });
    });

  </script>

<%@ include file="/views/common/footer.jsp" %>