<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var="path" value="${pageContext.request.contextPath}" />

  <footer>
    <p>&lt;Copyright 2019. <strong>KH정보교육원</strong>. All rights reserved.&gt;</p>
  </footer>
  </div>


  <script>
    function demo1(){
      $('#devFrm').attr({"action" : "${path }/demo/demo1.do" } );
      $('#devFrm').submit();
    }
    function demo2(){
      $('#devFrm').attr({"action" : "${path }/demo/demo2.do" } );
      $('#devFrm').submit();
    }
    function demo3(){
      $('#devFrm').attr({"action" : "${path }/demo/demo3.do" } );
      $('#devFrm').submit();
    }
    function demo4(){
      $('#devFrm').attr({"action" : "${path }/demo/demo4.do" } );
      $('#devFrm').submit();
    }

    function insertDev(){
      $('#devFrm').attr({"action" : "${path }/demo/insertDev.do" } );
      $('#devFrm').submit();
    }
  </script>

</body>
</html>