<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="page_content">
<div class="demo-card-wide mdl-card mdl-shadow--2dp"
		style="margin-left: 50px; margin-top: 50px; width: 400px;">
		<div class="mdl-card__title">
			<h2 class="mdl-card__title-text">Add User</h2>
		</div>
		<div class="mdl-card__supporting-text" style="width: 400px;">
			<form action="${pageContext.request.contextPath}/main/users" method="post" modelAttribute="user">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="firstname"
						name="firstName" modelAttribute="firstName" /> <label
						class="mdl-textfield__label" for="name">First Name</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="middlename"
						name="middleName" modelAttribute="middleName" /> <label
						class="mdl-textfield__label" for="name">Middle Name</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="lastname"
						name="lastName" modelAttribute="lastName" /> <label
						class="mdl-textfield__label" for="name">last Name</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="email"
						name="email" modelAttribute="email" /> <label
						class="mdl-textfield__label" for="name">Email</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="password"
						name="password" modelAttribute="password" /> <label
						class="mdl-textfield__label" for="name">Password</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<label class="mdl-textfield"><b>City</b></label>
					<select class="mdl-textfield__input" id="city-select"
						name="cityName" modelAttribute="cityName">
					</select>
				</div>
				<input type="submit"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					style="width: 150px; margin-bottom: 60px" value="Signup" />
			</form>
		</div>

	</div>

</div>


<script>
$(document).ready(function() {
	
	$("#section-2-anchor").click(function() {
		getCityList("${pageContext.request.contextPath}");
	});
	
});
</script>