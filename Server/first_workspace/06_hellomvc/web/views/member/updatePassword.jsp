<%@ page language="java" contentType="text/html; charset=${encoding}"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <title>Insert title here</title>
  <style>
    div#updatePassword-container{
      background-color: red;
    }
    div#updatePassword-container{
      margin: 0 auto;
      border-spacing: 20px;
    }
    div#updatePassword-container table tr:last-of-type td{
      text-align: center;
    }
  </style>
</head>
<body>
  <div id="updatePassword-container">
    <!-- form[name="updatePwdFrm"] action= -->
    <form name="updatePwdFrm" action="<%=request.getContextPath() %>/member/updatePasswordEnd" method="post">
      <table>
        <tr>
          <th>현재 비밀번호</th>
          <td>
            <input type="password" name="password"
            id="password" required="required" />
          </td>
        </tr>
        <tr>
          <th>변경할 비밀번호</th>
          <td>
            <input type="password" name="passwordNew"
            id="passwordNew" required="required" />
          </td>
        </tr>
        <tr>
          <th>비밀번호 확인</th>
          <td>
            <input type="password" id="passwordChk" required="required" />
          </td>
        </tr>
        <tr>
          <td colspan='2'>
            <input type="submit" onclick="return password_validate()" value="변경">
            <input type="button" onclick="self.close()" value="닫기">
          </td>
        </tr>
      </table>

      <input type="hidden" name="userId" value="<%=(String)request.getAttribute("userId") %>">

    </form>
  </div>
  <script>
    function password_validate(){
      var pwd_new=$('#passwordNew').val().trim();
      var pwd_chk = $('#passwordChk').val().trim();
      if(pwd_new != pwd_chk){
        alert("입력한 비밀번호가 일치하지 않습니다.");
        $('#passwordNew').select();
        return false;
      }
      return true;
    }
  </script>
</body>
</html>