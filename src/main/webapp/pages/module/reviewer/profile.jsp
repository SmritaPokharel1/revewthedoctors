<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>

<div class="demo-layout-waterfall mdl-layout mdl-js-layout">

	<%@include file="../../common/reviewermenu.jsp"%>

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
							<h2 class="mdl-card__title-text" id="review-title">User</h2>
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
											<td>${user.firstName} ${user.middleName} ${user.lastName}</td>
										</tr>
										<tr>
											<td>Email</td>
											<td>${user.email}</td>
										</tr>
										<tr>
											<td>City</td>
											<td>${user.city.name}</td>
										</tr>
										
										<tr>
											<td>District</td>
											<td>${user.city.district}</td>
										</tr>
										<tr>
											<td>Zone</td>
											<td>${user.city.zone}</td>
										</tr>
										
										<tr>
											<td>Country</td>
											<td>${user.city.country}</td>
										</tr>
										
									</table>	
									</div>
									</div>		
							</div>
						</div>
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