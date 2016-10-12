<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
	<div class="page-content">

		<div class="demo-card-wide mdl-card mdl-shadow--2dp"
			style="margin-left: 50px; margin-top: 50px; width: 400px;">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">Register Doctor</h2>
			</div>
			<div class="mdl-card__supporting-text" style="width: 400px;">
				<form action="${pageContext.request.contextPath}/admin/doctors" method="post" modelAttribute="doctor">
					<div class="mdl-textfield mdl-js-textfield">
						<input class="mdl-textfield__input" type="text" id="firstName" name="firstName" modelAttribute="firstName" /> <label
							class="mdl-textfield__label" for="firstName">First Name</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<input class="mdl-textfield__input" type="text" id="middleName" name="middleName" modelAttribute="middleName" /> <label
							class="mdl-textfield__label" for="middleName">Middle Name</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<input class="mdl-textfield__input" type="text" id="lastName" name="lastName" modelAttribute="lastName"/> <label
							class="mdl-textfield__label" for="lastName">Last Name</label>
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<label
							class="mdl-textfield"><b>Speciality</b></label>
						<select multiple="multiple" class="mdl-textfield__input" id="speciality-select" name="specialityNameArray" modelAttribute="specialityNameArray"><option>Select Speciality</option></select>
						

					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<label
							class="mdl-textfield"><b>Hospital</b></label>
						<select multiple="multiple" class="mdl-textfield__input" id="hospital-select" name="hospitalNameArray" modelAttribute="hospitalNameArray"><option>Select Hospital</option></select>
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<select class="mdl-textfield__input" id="city-select" name="cityName" modelAttribute="cityName"><option>Select City</option></select>

					</div>
					
					<input type="submit"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					style="width: 150px; margin-bottom: 60px" value="Add" />
				</form>
			</div>

		</div>
	</div>