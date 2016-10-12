<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="/resources/css/material.min.css" /-->
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/material.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.2.1/material.cyan-red.min.css" />
<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
</head>
<body>
	<style>
.demo-layout-waterfall .mdl-layout__header-row .mdl-navigation__link:last-of-type
	{
	padding-right: 0;
}

body {
	background:
		url(http://localhost:8080/revewthedcotors/resources/images/background.jpg)
}
</style>
	<div class="mdl-layout mdl-js-layout">
		<header class="mdl-layout__header mdl-layout__header--scroll">
		<div class="mdl-layout__header-row">
			<!-- Title -->
			<span class="mdl-layout-title">Review The Doctors</span>
			<!-- Add spacer, to align navigation to the right -->
			<div class="mdl-layout-spacer"></div>
			<!-- Navigation -->
			<!--  <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="">Link</a>
        <a class="mdl-navigation__link" href="">Link</a>
        <a class="mdl-navigation__link" href="">Link</a>
        <a class="mdl-navigation__link" href="">Link</a>
      </nav> -->
		</div>
		</header>
	</div>
	<!-- <main class="mdl-layout__content">
    <div class="page-content">
    	<div class="mdl-layout mdl-js-layout mdl-color--grey-100"> -->
	<main class="mdl-layout__content">

	<div class="page-content" />
	
		
		
		<div class="demo-card-wide mdl-card mdl-shadow--2dp"
			style="margin-left:450px;margin-top:200px;">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">Welcome</h2>
  </div>
  <div class="mdl-card__supporting-text">
<form action="#">
					<div class="mdl-textfield mdl-js-textfield">
						<input class="mdl-textfield__input" type="text" id="email" />
						<label class="mdl-textfield__label" for="email">Email</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<input class="mdl-textfield__input" type="password" id="userpass" />
						<label class="mdl-textfield__label" for="userpass">Password</label>
					</div>
				</form>
  </div>

 <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="width:150px;margin-left:85px;">
  Button
</button>
  </div>
  <div class="mdl-card__menu">
    <button
					class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>
</div>

	</main>

	
</body>
</html>