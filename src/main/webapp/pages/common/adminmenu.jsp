<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<header class="demo-header mdl-layout__header ">
	<!-- Top row, always visible -->
	<div class="mdl-layout__header-row">
		<!-- Title -->
		<span class="mdl-layout-title">${pageTitle}</span>
		<div class="mdl-layout-spacer"></div>
		<!-- <div
			class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
			<label class="mdl-button mdl-js-button mdl-button--icon"
				for="waterfall-exp"> <i class="material-icons">search</i>
			</label>
			<div class="mdl-textfield__expandable-holder">
				<input class="mdl-textfield__input" type="text" name="sample"
					id="waterfall-exp">
			</div>
		</div> -->
	</div>

	<div class="mdl-layout__tab-bar mdl-js-ripple-effect">
		<a id="section-1-anchor" href="#scroll-tab-1" class="mdl-layout__tab is-active">Create</a> 
		<a id="section-2-anchor" href="#scroll-tab-2" class="mdl-layout__tab">List</a>
	</div>
</header>
<div class="mdl-layout__drawer">
	<span class="mdl-layout-title">Examine Doctor</span>
	<nav class="mdl-navigation">
	<nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/country">Country</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/zone">Zone</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/district">District</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/city">City</a>	
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/user">User</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/hospital">Hospital</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/speciality">Speciality</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/doctor">Doctor</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/admin/review">Review</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/main/logout">Logout</a>
    </nav>
	</nav>
</div>