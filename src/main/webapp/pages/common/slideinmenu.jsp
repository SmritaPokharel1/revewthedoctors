<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<header class="demo-header mdl-layout__header "> <!-- Top row, always visible -->
		<div class="mdl-layout__header-row">
			<!-- Title -->
			<span class="mdl-layout-title">Doctor</span>
			<div class="mdl-layout-spacer"></div>
			<div
				class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
				<label class="mdl-button mdl-js-button mdl-button--icon"
					for="waterfall-exp"> <i class="material-icons">search</i>
				</label>
				<div class="mdl-textfield__expandable-holder">
					<input class="mdl-textfield__input" type="text" name="sample"
						id="waterfall-exp">
				</div>
			</div>
		</div>

		<div class="mdl-layout__tab-bar mdl-js-ripple-effect">
			<a href="#scroll-tab-1" class="mdl-layout__tab is-active">Create</a>
			<a href="#scroll-tab-2" class="mdl-layout__tab">List</a>
		</div>
		</header>

<div class="mdl-layout__drawer">
    <span class="mdl-layout-title">Examine Doctors</span>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="/user">Country</a>
      <a class="mdl-navigation__link" href="/zone">Zone</a>
      <a class="mdl-navigation__link" href="/district">District</a>
      <a class="mdl-navigation__link" href="/city">City</a>	
      <a class="mdl-navigation__link" href="/user">User</a>
      <a class="mdl-navigation__link" href="/doctor">Doctor</a>
      <a class="mdl-navigation__link" href="/hospital">Hospital</a>
      <a class="mdl-navigation__link" href="/location">Location</a>
      <a class="mdl-navigation__link" href="/speciality">Speciality</a>
      <a class="mdl-navigation__link" href="/review">Review</a>
      <a class="mdl-navigation__link" href="document">Document</a>
    </nav>
  </div>