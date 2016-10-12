
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>

<div class="demo-layout-waterfall mdl-layout mdl-js-layout">

	<%@include file="../../common/reviewermenu.jsp"%>

	<main class="mdl-layout__content"> <section
		class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
	<div class="page-content mdl-layout-spacer">
		<div style="text-align: center;">
			<h5 style="font-family: 'Bree Serif', serif;">My Reviews</h5>
			<c:if test="${not empty message}">
				<div class="warning-msg" >
					<c:out value="${message}" />
				</div>
			</c:if>

		</div>
		<div class="mdl-grid">
			<c:forEach items="${reviewList}" var="review">
				<div class="mdl-cell mdl-cell--4-col">
					<div class="demo-card-wide mdl-card mdl-shadow--2dp"
						style="min-height: 80px !important; min-width: 350px !important;">

						<div class="mdl-card__supporting-text">
							<table>

								<tr>
									<td>Review</td>
									<td><a
										href="${pageContext.request.contextPath}/reviewer/individualreview?reviewId=${review.reviewId}">${review.review}</td>
								</tr>

								<tr>
									<td>Doctor</td>
									<td><a
										href="${pageContext.request.contextPath}/reviewer/individualdoctor?doctorId=${review.doctor.doctorId}">${review.doctor.firstName}
											${review.doctor.middleName} ${review.doctor.lastName}</a></td>
								</tr>
							</table>
						</div>

					</div>


				</div>
			</c:forEach>
		</div>
	</div>
	</section> </main>
</div>

</body>

<!-- <script>
	$(document).ready(function(){
		$(".warning-msg").delay(5000).fadeOut("100000");
	});
</script> -->
<script
	src="${pageContext.request.contextPath}/resources/js/module/reviewer/profile.js"
	type="text/javascript"></script>
</html>