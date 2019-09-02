<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>Javascript를 이용한 Ajax</title>
</head>
<body>
  <h1>자바스크립트를 이용한 ajax 통신</h1>
  <button onclick="fn_getAjax()">get방식으로 요청</button>
  <button onclick="fn_postAjax()">post방식으로 요청</button>
  <div id="result">
    <!-- ajax로 변결해줄 container -->
  </div>

  <script>
    function fn_postAjax(){
      //1.XMLHttpRequest객체 생성!
      var xhr = new XMLHttpRequest();
      var result = document.getElementById("result");

      //이벤트객체 등록
      xhr.onreadystatechange = function(){
        // switch(xhr.readyState){}
        if(xhr.readyState == 1){
          result.innerHTML += "전송중...";
        }
        if(xhr.readyState == 2){
          result.innerHTML += "전송중...";
        }
        if(xhr.readyState == 3){
          result.innerHTML += "전송중...";
        }
        if(xhr.readyState == 4){
          if(xhr.status==200){ // $.ajax(){} 속성 success
            //전송 완료
            result.innerHTML += xhr.responseText;
          }
        }
      }
      xhr.open("post", "<%=request.getContextPath() %>/js/test2");
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xhr.send("name=유병승&age=19");
    }

    function fn_getAjax(){
      //1.XMLHttpRequest객체 생성!
      var xhr = new XMLHttpRequest();
      //객체로 send하면 httprequest날라 가는것 처럼 작동함. 요청함
      //->비동기식으로 요청 보내고 server가 처리함
      //클릭시 요청 생성 -> 요청 + 응답이 url변경 없이 처리됨!
      //2. 전송 후 응답이 오면 처리할 함수지정
      xhr.onreadystatechange=function(){
        //readyState가 0~4 바뀔때 마다 호출
        //readyState == 4 전송이 완료된것을 의미
        //브라우저가 전송상태에 따라 알아서 값을 대입해줌!
        if(xhr.readyState == 4){
          if(xhr.status == 200){
            //status : 응답결과(코드)
            console.log("정상적인 처리!");
            //responseText : 응답한 데이터를 보관하는 변수
            console.log(xhr.responseText);
            //웹상통신 값 문자열로 전달

            document.getElementById("result").innerHTML=xhr.responseText;
            //서버에서 보내주는 값을 화면에도 출력해서 확인!!!
          }
          else if(xhr.status == 404){
            console.log("페이지가 없습니다~~~"); //서블릿을 못찾을때
            console.log(xhr.responseText);
            document.getElementById("result").innerHTML = xhr.responseText;
            //새로운 페이지로 넘어가는것이 아니라, 기존 index.jsp 페이지에서 element만 변경됨
          }
        }
      } /* onreadystatechange function 끝! */
      xhr.open("get", "<%=request.getContextPath()%>/js/test?name=yoo&age=19");
      xhr.send();//전송!
    }
  </script>

  <h2>csv방식으로 불러오기</h2>

</body>
</html>