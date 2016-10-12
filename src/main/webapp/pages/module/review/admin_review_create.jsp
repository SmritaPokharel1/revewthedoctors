<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="page_content">
	<div class="demo-card-wide mdl-card mdl-shadow--2dp"
			style="margin-left: 50px; margin-top: 50px; width: 400px;">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">Create Review</h2>
			</div>
			<div class="mdl-card__supporting-text" style="width: 400px;">
				<form action="${pageContext.request.contextPath}/admin/reviews" method="post" modelAttribute="review">
					
					
						<c:if test="${userRole=='ROLE_ADMIN'}">
							<div class="mdl-textfield mdl-js-textfield">
								<label class="mdl-textfield"><b>User</b></label>
								<select class="mdl-textfield__input" id="user-select" name="userId" modelAttribute="userId"></select>
							</div>
						</c:if>
					
					<div class="mdl-textfield mdl-js-textfield">
						<label class="mdl-textfield"><b>Doctor</b></label>
						<select class="mdl-textfield__input" id="doctor-select" name="doctorId" modelAttribute="doctorId"></select>

					</div>
					
					<div class="mdl-textfield mdl-js-textfield">
						<!--  <textarea class="mdl-textfield__input" id="review" name="review" modelAttribute="review" placeholder="Review"></textarea-->
						<textarea class="mdl-textfield__input" rows="3" cols="10" id="review" name="review" modelAttribute="review" placeholder="review"></textarea>

					</div>
					
					<div class="mdl-textfield mdl-js-textfield">
						<label
							class="mdl-textfield"><b>Rating</b></label>
						<select  class="mdl-textfield__input" id="rating-select" name="rating" modelAttribute="rating">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
										
					<input type="submit"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					style="width: 150px; margin-bottom: 60px" value="Add" />
				</form>
			</div>

		</div>
</div>
