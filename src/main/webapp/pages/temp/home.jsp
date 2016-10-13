<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="/resources/css/material.min.css" />
<script src="/resources/js/jquery.js"></script>-->
<script src="/resources/js/material.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.cyan-red.min.css" /> 
<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
</head>
<body>
<style>
.demo-layout-waterfall .mdl-layout__header-row .mdl-navigation__link:last-of-type  {
  padding-right: 0;
}
</style>

<div class="demo-layout-waterfall mdl-layout mdl-js-layout">
  <header class="mdl-layout__header mdl-layout__header--waterfall">
    <!-- Top row, always visible -->
    <div class="mdl-layout__header-row">
      <!-- Title -->
      <span class="mdl-layout-title">Home</span>
      <div class="mdl-layout-spacer"></div>
      <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
        <label class="mdl-button mdl-js-button mdl-button--icon"
               for="waterfall-exp">
          <i class="material-icons">search</i>
        </label>
        <div class="mdl-textfield__expandable-holder">
          <input class="mdl-textfield__input" type="text" name="sample"
                 id="waterfall-exp">
        </div>
      </div>
    </div>
    <!-- Bottom row, not visible on scroll -->
    <div class="mdl-layout__header-row">
      <div class="mdl-layout-spacer"></div>
      <!-- Navigation -->
      <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="">Create</a>
        <a class="mdl-navigation__link" href="">List</a>
      </nav>
    </div>
  </header>
  <div class="mdl-layout__drawer">
    <span class="mdl-layout-title">Examine Doctors</span>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="/user">User</a>
      <a class="mdl-navigation__link" href="doctor">Doctor</a>
      <a class="mdl-navigation__link" href="hospital.jsp">Hospital</a>
      <a class="mdl-navigation__link" href="location.jsp">Location</a>
         <a class="mdl-navigation__link" href="speciality.jsp">Speciality</a>
      <a class="mdl-navigation__link" href="review.jsp">Review</a>
      <a class="mdl-navigation__link" href="document.jsp">Document</a>
    </nav>
  </div>
  <main class="mdl-layout__content">
    <div class="page-content"></div>
  </main>
</div>
	
</body>
</html>