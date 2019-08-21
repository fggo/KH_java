<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.prac.model.vo.Member" %>

<%
  Member m = (Member)session.getAttribute("loginMember");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <title>HelloMVC practice</title>

  <!-- favicon -->
  <link rel="icon" href="https://img.icons8.com/ios/50/000000/parking.png?v=1.1">

  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <style>
    body {
      padding-top: 56px;
    }
  </style>

</head>

<body class="bg-light d-flex flex-column" cz-shortcut-listen="true">

  <header>
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark ">
      <a class="navbar-brand mr-auto mr-lg-0" href="#">HelloMVC</a>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
      </button>
      
      <div class="navbar-collapse offcanvas-collapse" id="">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="#">Profile</a>
          </li>
        </ul>

        <% if(m == null){ %>
          <form class="form-inline my-2 my-lg-0" action ="<%=request.getContextPath()%>/login">
            
            <label for="id" class="text-white">ID&nbsp;
              <input class="form-control mr-sm-2" type="text" placeholder="type your id" aria-label="id" id="id" name="id">
            </label>
            <label for="pw" class="text-white">PW&nbsp;
              <input class="form-control mr-sm-2" type="password" placeholder="type your pw" aria-label="pw" id="pw" name="pw">
            </label>
            <button class="btn btn-primary my-2 my-sm-0" type="submit" >Log In</button>
            <label for="rememberId" class="text-white">&nbsp;&nbsp;
              <input type="checkbox" name="rememberId" id="rememberId"> &nbsp;Remember Me&nbsp;
            </label>
          </form>
        <%} else { %>
          <table>
            <tr>
              <td>
                <p class="text-white">Hello! <%=m.getUserName() %></p>
              </td>
              <td>
                <input type="button" onclick="logout()" value="Log Out">
              </td>
            </tr>
          </table>
        <%} %>
      </div>
    </nav>
  </header>