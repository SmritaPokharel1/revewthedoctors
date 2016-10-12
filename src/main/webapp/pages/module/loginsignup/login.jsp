<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="page_content">
	<div class="demo-card-wide mdl-card mdl-shadow--2dp"
		style="margin-left: 50px; margin-top: 50px; width: 400px;">
		<div class="mdl-card__title">
			<h2 class="mdl-card__title-text">Login</h2>
		</div>
		<div class="mdl-card__supporting-text" style="width: 400px;">
			<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" modelAttribute="user">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="email"
						name="j_username" modelAttribute="email" /> <label
						class="mdl-textfield__label" for="name">Email</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="password" id="password"
						name="j_password" modelAttribute="password" /> <label
						class="mdl-textfield__label" for="name">Password</label>
				</div>
				<input type="submit"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					style="width: 150px; margin-bottom: 100px" value="Login" />
			</form>
		</div>

	</div>

</div>