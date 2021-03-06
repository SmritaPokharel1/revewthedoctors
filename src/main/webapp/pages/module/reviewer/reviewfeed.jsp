<%@include file="../../common/header.jsp"%>

<div class="demo-layout-waterfall mdl-layout mdl-js-layout">

	<%@include file="../../common/reviewermenu.jsp"%>

	<main class="mdl-layout__content"> 
	
	<section class="mdl-layout__tab-panel is-active" id="scroll-tab-2">

	<div class="page-content mdl-layout-spacer" >
			<div style="text-align:center;">
				<h5 style="font-family: 'Bree Serif', serif;">Review Feed</h5>
				<c:if test="${not empty message}">
				<div class="warning-msg">
					<c:out value="${message}" />
				</div>
			</c:if>
				
			</div>
		<div class="mdl-grid">
		<c:forEach items="${reviewList}" var="search">
			<div class="mdl-cell mdl-cell--4-col">
				<div class="demo-card-wide mdl-card mdl-shadow--2dp" style="min-height:80px !important;min-width:350px !important;">
				
				<div class="mdl-card__supporting-text">
					<table>
						
						<tr>
							<td>Review</td>
							<td><a href="${pageContext.request.contextPath}/reviewer/individualreview?reviewId=${search.reviewId}">${search.review}</td>
						</tr>
						
						<tr>
							<td>Doctor</td>
							<td><a href="${pageContext.request.contextPath}/reviewer/individualdoctor?doctorId=${search.doctor.doctorId}">${search.doctor.firstName} ${search.doctor.middleName} ${search.doctor.lastName}</a></td>
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

