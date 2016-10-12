<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>

<div class="demo-layout-waterfall mdl-layout mdl-js-layout">

	<%@include file="../../common/adminmenu1.jsp"%>

	<main class="mdl-layout__content"> <section
		class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
	<div class="page-content">
		<div style="margin: 30px;">


			<div class="mdl-grid">
				<div class="mdl-cell mdl-cell--3-col" />
				<div class="mdl-cell mdl-cell--9-col">
					<div class="demo-card-wide mdl-card mdl-shadow--2dp"
						style="min-width: 1000px; min-height: 450px;">
						<div class="mdl-card__title mdl-card--border review-title">
							<h2 class="mdl-card__title-text" id="review-title">Doctor</h2>
						</div>
						<div class="mdl-card__actions">
							<div class="demo-card-wide mdl-card mdl-shadow--2dp"
								style="margin: 10px; min-width: 900px;">
								
								<div>
									<div style="float:left;padding:10px;margin:10px;"><img src="${pageContext.request.contextPath}/resources/images/doc1.jpg"/></div>
									<div style="float:left;padding:10px;margin:10px;">
										<table>
											<tr>
												<td>Name</td>
												<td id="doctor-name">${doctor.firstName}
													${doctor.middleName} ${doctor.lastName}</td>
											</tr>
											<tr>
												<td>Title</td>
												<td id="doctor-title">${doctor.speciality.specialityName }</td>
											</tr>
											<tr>
												<td>Category</td>
												<td id="doctor-category">${doctor.speciality.category}</td>
											</tr>
											<tr>
												<td>Hospital</td>
												<td id="doctor-hospital">${doctor.hospital.name}</td>
											</tr>

										</table>
									</div>
								</div>
							</div>
						</div>
						<div style="clear: both">
							<div class="mdl-card__title mdl-card--border review-title">
								<h2 class="mdl-card__title-text">Reviews</h2>
							</div>
						</div>
						<div class="mdl-card__supporting-text  mdl-card--border"
							id="doctor-review">
							<c:forEach items="${doctor.reviewList}" var="review">
								<div class="demo-card-wide mdl-card mdl-shadow--2dp"
									style="margin: 10px; min-width: 900px; min-height: 100px;">

									<div class="mdl-card__supporting-text">${review.review}</div>
									<div class="mdl-card__actions mdl-card--border">
										<a
											class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
											href="${pageContext.request.contextPath}/admin/individualreview?reviewId=${review.reviewId}">
											View </a>
									</div>
								</div>

							</c:forEach>

						</div>

						<%-- <div class="mdl-card__actions mdl-card--border" >
								<table>
									<tr>
										<td>Reviewed By</td>
										<td id="reviewed-by">${review.user.firstName} ${review.user.middleName} ${review.user.lastName}</td>
									</tr>
								</table>
						</div>
						 --%>



					</div>
				</div>
			</div>

		</div>


	</div>
	</section> </main>
</div>

</body>
<script
	src="${pageContext.request.contextPath}/resources/js/module/reviewer/profile.js"
	type="text/javascript"></script>
</html>