<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${ param.pageTitle }</title>
  
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
    integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  
  <!-- Custom CSS -->
  <!-- Scrollbar Custom CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

  <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
  <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
  <style>
    .carousel-item {
      height: 65vh;
      min-height: 350px;
      background: no-repeat center center scroll;
      -webkit-background-size: cover;
      -moz-background-size: cover;
      -o-background-size: cover;
      background-size: cover;
    }

    .site-header { /* custom transparent header */
      /* background-color: rgba(19, 37, 53, .80); */
      background-color: rgb(42, 42, 42);
    }
    .site-header a {
      transition: ease-in-out color .15s;
    }
  </style>
</head>
<body>
  <header>
    <a id="back-to-top" href="#" class="btn btn-info border-light back-to-top py-1 px-2" role="button">
      <i class="fa fa-chevron-up">&nbsp;&nbsp;Top</i>
    </a>

    <!-- Navigation bar -->
    <nav class="site-header navbar navbar-expand-md navbar-dark fixed-top py-0 justify-content-center">
      <!-- d-flex container -->
      <div class="container d-flex justify-content-center row">
        <!-- Logo -->
        <div class='py-0 mr-auto inline px-0' id="navbar-logo">
          <a class="navbar-brand" href="<%=request.getContextPath() %>" >
            <img src="<%=request.getContextPath() %>/images/logo_white.png">
          </a>
        </div>
        <!-- Nav search bar -->
        <div id="nav-searchbar" class="col-lg-6 py-0 inline-block px-0 ml-0 mr-1">
          <form action="<%=request.getContextPath()%>/map/mapListView" method="POST" class='w-100'>
            <input type="hidden" name="userCode" value="${ userCode }">
            <div class="input-group">
              <input type="search" placeholder="   Where do you need parking?" aria-describedby="button-addon5" class="form-control" name="search" id="nav-search">
              <div class="input-group-append">
                <button id="button-addon5" type="submit" class="btn btn-light" id="nav-searchbar-btn"><i class="fa fa-search"></i></button>
              </div>
            </div>
          </form>
        </div>
        <!-- toggle button -->
        <button class="navbar-toggler ml-auto inline my-1" type="button" data-toggle="collapse" data-target="#navbarCollapsible" aria-controls="navbarCollapsible" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <!-- collapsible elements -->
        <div class="collapse navbar-collapse" id="navbarCollapsible">
          <ul class="navbar-nav ml-auto" id='collapseItems'>

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle menu-item mt-1 mr-0 text-white" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-globe"></i></a>

              <div class="dropdown-menu mt-1" aria-labelledby="dropdown01">
                <div id="google_translate_element" class="dropdown-item fa fa-globe"></div>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle menu-item mt-1 mr-0 text-white" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Help</a>

              <div class="dropdown-menu mt-1" aria-labelledby="dropdown01">
                <a class="dropdown-item" href="<%=request.getContextPath() %>/board/helpBoardList" ><i class="fa fa-info-circle">&nbsp;&nbsp;</i>Help</a>
                <a class="dropdown-item" href="<%=request.getContextPath() %>/board/qnaBoardList" ><i class="fa fa-question-circle-o">&nbsp;&nbsp;</i>Q&amp;A Board</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle menu-item mt-1 mr-2 text-white" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>

              <div class="dropdown-menu mt-1" aria-labelledby="dropdown01">

              <a class="dropdown-item" href=""><i class="fa fa-cog">&nbsp;&nbsp;</i>Account Settings</a>
              <a class="dropdown-item" href=""><i class="fa fa-bookmark">&nbsp;&nbsp;</i>Bookmark</a>
              <a class="dropdown-item" href=""><i class="fa fa-edit">&nbsp;&nbsp;</i>My Reviews</a>
              <a class="dropdown-item" href=""><i class="fa fa-credit-card">&nbsp;&nbsp;</i>Payment Methods</a>
              <a class="dropdown-item" href=""><i class="fa fa-won">&nbsp;&nbsp;</i>Credit Balance</a>
              <a class="dropdown-item" href=""><i class="fa fa-car">&nbsp;&nbsp;</i>My Vehicle</a>

              <a class="dropdown-item" href="${path }/views/member/memberView.jsp"><i class="fa fa-cog">&nbsp;&nbsp;</i>Settings</a>
              <a class="dropdown-item" href="${path }/bookmark/bookmarkView"><i class="fa fa-bookmark">&nbsp;&nbsp;</i>Bookmark</a>
              <a class="dropdown-item" href="${path }/board/reviewList"><i class="fa fa-edit">&nbsp;&nbsp;</i>My Reviews</a>

              <a class="dropdown-item" href="${path }"><i class="fa fa-list">&nbsp;&nbsp;</i>Member List</a>

              <script>

                /**
                * sends a request to the specified url from a form. this will change the window location.
                * @param {string} urlMapping the path to send the post request to
                * @param {object} params the paramiters to add to the url
                * @param {string} [method=post] the method to use on the form
                */
                function mypageLoad(urlMapping, params){ var form = $("<form>");
                  form.attr({"method": "POST",
                             "action" : urlMapping,
                  });
                  $.each(params, function(key, value){
                    var input = $("<input>");
                    input.attr({"type": "hidden",
                                "name": key,
                                "value": value,
                    });
                    form.append(input);
                  });

                  form.submit();
                }
              </script>

              </div>
            </li>

            <li class="nav-item">
              <form action="<%=request.getContextPath() %>/logout" method="post">
                <button type="submit" class="btn btn-sm btn-outline-light mt-2 mr-1" onclick="return logoutSnsAccount();" style="width: 72px;">Log Out</button>
              </form>
            </li>

            <script>
              function logoutSnsAccount(){
                googleLogout();
                return true;
              }
            </script>

            <li class="nav-item">
              <form action="${path }/views/member/loginView.jsp" method="post">
                <button type="submit" class="btn btn-sm btn-outline-light mt-2 mr-1" style="width:67px;">Log In</button>
              </form>
            </li>
            <li class="nav-item">
              <button class="btn btn-sm btn-outline-light mt-2" onclick='location.href="<%=request.getContextPath() %>/memberEnroll"' style="width:70px;">Sign Up</button>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>


  <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active" style="background-image: url('https://source.unsplash.com/FGXqbqbGt5o/1920x1080')">
          <div class="carousel-caption d-none d-md-block">
            <h3 class="display-4">
              <a class="nav-link" href="${pageContext.request.contextPath}/homeView">Join Us 1</a>
            </h3>
            <p class="lead">This is a description for the first slide.</p>
          </div>
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('https://source.unsplash.com/pjAH2Ax4uWk/1920x1080')">
          <div class="carousel-caption d-none d-md-block">
            <h3 class="display-4">
              <a class="nav-link" href="${pageContext.request.contextPath}/homeView">Join Us 2</a>
            </h3>
            <p class="lead">This is a description for the second slide.</p>
          </div>
        </div>
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('https://source.unsplash.com/cOkpTiJMGzA/1920x1080')">
          <div class="carousel-caption d-none d-md-block">
            <h3 class="display-4">
              <a class="nav-link" href="${pageContext.request.contextPath}/homeView">Join Us 3</a>
            </h3>
            <p class="lead">This is a description for the third slide.</p>
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
    </div>
  </header>

  <!-- Page Content -->
  <section class="py-5">
    <div class="container">
      <h1 class="font-weight-light">
        <a class="nav-link" href="${pageContext.request.contextPath}/homeView">Join Us Now</a>
      </h1>
      <p class="lead">The background images for the slider are set directly in the HTML using inline CSS. The images in this snippet are from <a href="https://unsplash.com">Unsplash</a>!</p>
    </div>
  </section>

  <!-- JQUERY -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
