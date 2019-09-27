<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

  <div class="container card my-3 mx-3 py-3 px-3 col-md-6">

    <h2>기본숫자 표현하기</h2>
    <c:set var="numtest" value="1234501987" />
    <c:set var="numtest2" value="19873000" />
    <c:set var="numtest3" value="1" />
    <c:set var="numtest4" value="124.546" />
    
    기본 출력 numtest: <c:out value="${numtest}" />
    <p>
      기본숫자 설정 : <fmt:formatNumber value="${numtest}" />
    </p>
    <p>
      자동으로 3자리마다 , 표시. 원래는 속성값으로 설정 default , 표시<br>
      속성: groupingUsed
    </p>

    <pre>
      groupingUsed사용 O: <fmt:formatNumber value="${numtest}" groupingUsed="true" />
      groupingUsed사용 X: <fmt:formatNumber value="${numtest}" groupingUsed="false" />
    </pre>
    <hr>
    <h2>화폐표시하기</h2>
    <p>화폐는 기본적으로 톰켓이 가지고 있는 locale값을 기준으로 설정됨.<br>
      currencySymbol="기호($, \)" 설정을 변경할 수 있음<br>
      지역설정을 변경하는 것도 가능. fmt:setLocale태그 이용<br>
      화폐를 표시할때, type속성 -> currency으로 설정
    </p>
    <p>기본통화설정 : <fmt:formatNumber value="${numtest}" type="currency"/>원</p>
    <p>현재 locale : <%=request.getLocale() %> (톰캣 locale설정은 바뀌지 않음) </p>


    <fmt:setLocale value="en_US" />
    <p>locale변경 후 통화 : <fmt:formatNumber value="${numtest}" type="currency"/> 달러</p>

    <p>직접 통화 정의 <fmt:formatNumber value="${numtest}" type="currency" currencySymbol="**"/></p>

    <p>직접 통화 정의 <fmt:formatNumber value="${numtest}" type="currency" currencySymbol="**" groupingUsed="false"/></p>

    <h3>퍼센트 표시하기</h3>
    <p>
      type="percent" value가 정해져 있음 0~1(100%)
    </p>
    <p>기본 퍼센트 표시: <fmt:formatNumber value="${numtest3}" type="percent"/></p>
    <p>퍼센트 표시: <fmt:formatNumber value="${numtest3/2}" type="percent"/></p>
    <p>퍼센트 표시: <fmt:formatNumber value="${.2}" type="percent"/></p>
    <p>퍼센트 표시: <fmt:formatNumber value="${.02}" type="percent"/></p>
    <p>퍼센트 표시: <fmt:formatNumber value="${.002}" type="percent"/></p>

    <h2>패턴형식을 지정하여 출력</h2>
    <p>
      pattern속성에 지정된 표현식으로 설정을 하면 됨
      표현식 : 0, #
      0: 패턴에서 해당자리에 수가 없으면 0으로 표시 * 무조건 자리표시
      #: 패턴에서 해당자리에 수가 없으면 빈칸으로 표시 * 자리를 표시하지 않음
    </p>
    <p>기본출력: <fmt:formatNumber value="${numtest4}"/></p>
    <p>패턴지정1: <fmt:formatNumber value="${numtest4}" pattern="0,00.0" /></p>
    <p>패턴지정2: <fmt:formatNumber value="${numtest4}" pattern="000,00.00000" /></p>
    <p>패턴지정3: <fmt:formatNumber value="${numtest4}" pattern="###,##.#####" /></p>
    <p>패턴지정4: <fmt:formatNumber value="${123123.123123}" pattern="###,##.#####" /></p>
    <p>패턴지정5: <fmt:formatNumber value="${numtest4}" pattern="#####.00000" /></p>
    <p>패턴지정6: <fmt:formatNumber value="${numtest4}" pattern="$ #####.00000" /></p>

    <h2>소수점자리 표현을 지정</h2>

    <pre>
      minFractionDigit : 최소 소수점 자리수
      maxFractionDigit : 최대 소수점 자리수 반올림
    </pre>
    <p>최소소수점 자리수 : <fmt:formatNumber value="${numtest4}" minFractionDigits="5" pattern="#,###.####" /> </p>
    <p>최대소수점 자리수 : <fmt:formatNumber value="${numtest4}" maxFractionDigits="2" pattern="#,###.####" /> </p>

  </div>

</body>
</html>