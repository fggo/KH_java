<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
  <jsp:param name="pageTitle" value="Homepage" />
</jsp:include>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <!-- <button type="button" id="sidebarCollapse" class="btn btn-sm btn-outline-primary">
          <i class="fa fa-align-left"></i>
          <span>Toggle Sidebar</span>
        </button> -->
        <button class="btn btn-sm btn-outline-primary d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fa fa-align-justify"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="nav navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Page</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Page</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Page</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Page</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container card my-5 w-100 jumbotron">
      <a id="toggleInsertBtn" href="javascript:void(0);">insert Employee</a>
      <div id="insertArea" class="container"></div>
    </div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
