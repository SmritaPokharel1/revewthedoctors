<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>

<div class="demo-layout-waterfall mdl-layout mdl-js-layout">

	<%@include file="../../common/reviewermenu.jsp"%>

	<main class="mdl-layout__content"> <section
		class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
	<div class="page-content">

		<div style="margin: 30px 100px 30px 100px;">
			
			<div style="text-align: center;">
				<c:if test="${not empty message}">
				<div class="error-msg" style="margin-left:330px;">
					<c:out value="${message}" />
				</div>
			</c:if>
				<h3 style="font-family: 'Bree Serif', serif;">Health is wealth</h3>
				<h4 style="font-family: 'Bree Serif', serif;">Know your doctors
					around you.</h4>
			</div>
			<div id="search-area">
				<form action="${pageContext.request.contextPath}/reviewer/searches" method="post" modelAttribute="search">

					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">

						<!-- <label class="mdl-button mdl-js-button mdl-button--icon"
						for="waterfall-exp"> <i class="material-icons">search</i>
					</label> -->
						<div class="mdl-textfield" style="width: 1000px;">
							<input class="mdl-textfield__input" type="text" name="searchQuery" modelAttribute="searchQuery"
								id="waterfall-exp">
							<button
								class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
								style="width: 60px;" value="Search">
								<i class="material-icons">search</i>
							</button>

						</div>
					</div>
					<center>
						<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
							for="option-1"> <input type="radio" id="option-1"
							class="mdl-radio__button" name="searchMainCriteria" modelAttribute="searchMainCriteria" value="Doctor" checked>
							<span class="mdl-radio__label">Doctor</span>
						</label> <label
							class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
							for="option-2"> <input type="radio" id="option-2"
							class="mdl-radio__button" name="searchMainCriteria" modelAttribute="searchMainCriteria" value="Review"> <span
							class="mdl-radio__label">Review</span>
						</label>
					</center>	
					</div>
				</form>

				<div id="search-categories">
					<div id="rating"
						class="mdl-grid mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
						 <div class="mdl-cell mdl-cell--3-col mdl-cell--1-col-phone"></div>
						
						<div class="mdl-cell mdl-cell--1-col">
							<span class="mdl-chip mdl-chip--contact"> <span
								class="mdl-chip__contact mdl-color--teal mdl-color-text--white">R</span>
								<span class="mdl-chip__text">Rating</span>
							</span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">1 star</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">2 star</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">3 star</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">4 star</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">5 star</span></span>
						</div>
					</div>

					<div id="category" class="mdl-grid">
						<div class="mdl-cell mdl-cell--2-col mdl-cell--1-col-phone"></div>
						<div class="mdl-cell mdl-cell--1-col">
							<span class="mdl-chip mdl-chip--contact"> <span
								class="mdl-chip__contact mdl-color--teal mdl-color-text--white">C</span>
								<span class="mdl-chip__text">Category</span>
							</span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">Pediatrics</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">Pulmonologist</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">Cardiologist</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">Ortheopedics</span></span>
						</div>
						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">ENT</span></span>
						</div>

						<div class="mdl-cell mdl-cell--1-col mdl-cell--1-col-phone">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">Dermatologist</span></span>
						</div>

						<div class="mdl-cell mdl-cell--1-col">
							<span class="mdl-chip"
								style="min-width: 65px; text-align: center;"> <span
								class="mdl-chip__text">Gynaecologist</span></span>
						</div>

					</div>

					
				</div>
			</div>


		</div>
	</div>
	</section> </main>
</div>

</body>
<script>

$(".error-msg").delay(5000).fadeOut("100000");
</script>
<script
	src="${pageContext.request.contextPath}/resources/js/module/reviewer/search.js"
	type="text/javascript"></script>
</html>