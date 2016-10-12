<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>

<div
	class="demo-layout-waterfall mdl-layout mdl-js-layout ">

	<%@include file="../../common/reviewermenu.jsp"%>

	<main class="mdl-layout__content"> 
	
		<section class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
			<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="page_content">
	<div class="demo-card-wide mdl-card mdl-shadow--2dp"
			style="margin-left: 50px; margin-top: 50px; width: 400px;">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">Create Review</h2>
			</div>
			<div class="mdl-card__supporting-text" style="width: 400px;">
				<form action="${pageContext.request.contextPath}/reviewer/reviews" method="post" modelAttribute="review">
					
					
						<c:if test="${userRole=='ROLE_ADMIN'}">
							<div class="mdl-textfield mdl-js-textfield">
								<select class="mdl-textfield__input" id="user-select" name="userId" modelAttribute="userId"></select>
							</div>
						</c:if>
					
					<div class="mdl-textfield mdl-js-textfield">
						<select class="mdl-textfield__input" id="doctor-select" name="doctorId" modelAttribute="doctorId"></select>

					</div>
					
					<div class="mdl-textfield mdl-js-textfield">
						<!--  <textarea class="mdl-textfield__input" id="review" name="review" modelAttribute="review" placeholder="Review"></textarea-->
						<textarea class="mdl-textfield__input" rows="3" cols="10" id="review" name="review" modelAttribute="review" placeholder="review"></textarea>

					</div>
					
					<div class="mdl-textfield mdl-js-textfield">
						<label
							class="mdl-textfield__label" for="lastName">Rating</label>
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

			
		</section>
			 
	 </main>
</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/module/reviewer/myreviews.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
	getDoctorList('${pageContext.request.contextPath}');
	getUserList('${pageContext.request.contextPath}');
	
	$("#section-1-anchor").click(function() {
		getDoctorList('${pageContext.request.contextPath}');
		getUserList('${pageContext.request.contextPath}');
	});
	$("#section-2-anchor").click(function(){
		getReviewList('${pageContext.request.contextPath}');
	});
});
</script>
</html>