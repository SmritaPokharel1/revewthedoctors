<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="page_content">
	<div class="demo-card-wide mdl-card mdl-shadow--2dp"
		style="margin-left: 50px; margin-top: 50px; width: 400px;">
		<div class="mdl-card__title">
			<h2 class="mdl-card__title-text">Add hospital</h2>
		</div>
		<div class="mdl-card__supporting-text" style="width: 400px;">
			<form action="${pageContext.request.contextPath}/admin/hospitals" method="post" modelAttribute="hospital">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="name"
						name="name" modelAttribute="name" /> <label
						class="mdl-textfield__label" for="name">Hospital Name</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<label
						class="mdl-textfield"><b>Type</b></label>
					<select class="mdl-textfield__input"  id="hospital-type"
						name="hospitalType" modelAttribute="hospitalType" >
						<option value="NEURO_HOSPITAL">Neuro Hospital</option>
						<option value="CARDIO_HOSPITAL">Cardio Hospital</option>
						<option value="ALL">ALL</option>
					</select> 
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<label
						class="mdl-textfield"><b>City</b></label>
					<select class="mdl-textfield__input" id="city-select"
						name="cityName" modelAttribute="cityName">
					</select>
				</div>
				<input type="submit"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					style="width: 150px; margin-bottom: 80px" value="Add" />
			</form>
		</div>

	</div>
</div>