<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="page_content">

<div class="demo-card-wide mdl-card mdl-shadow--2dp"
		style="margin-left: 50px; margin-top: 50px; width: 400px;">
		<div class="mdl-card__title">
			<h2 class="mdl-card__title-text">Add Zone</h2>
		</div>
		<div class="mdl-card__supporting-text" style="width: 400px;">
			<form action="${pageContext.request.contextPath}/admin/zones" method="post" modelAttribute="zone">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="name"
						name="name" modelAttribute="name" /> <label
						class="mdl-textfield__label" for="name">Zone Name</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					 <label
						class="mdl-textfield"><b>Country</b></label>
					<select class="mdl-textfield__input"  id="country-select"
						name="country" modelAttribute="country" >
					</select>
				</div>
				<input type="submit"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					style="width: 150px; margin-bottom: 100px" value="Add" />
			</form>
		</div>

	</div>

</div>