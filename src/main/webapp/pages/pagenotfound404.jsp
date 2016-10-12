<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="common/header.jsp"%>
<header class="mdl-layout__header mdl-layout__header--waterfall">
	<!-- Top row, always visible -->
	<div class="mdl-layout__header-row">
		<!-- Title -->
		<span class="mdl-layout-title">${pageTitle}</span>
		<div class="mdl-layout-spacer"></div>
		
	</div>
</header>	

<div
	class="demo-layout-waterfall mdl-layout mdl-js-layout" style="background-color:#EBA917;">

	

	<main class="mdl-layout__content"> 
		
		<section class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
			<div class="page-content">
			<div style="margin:30px;" style="align:center;">
				<img src="${pageContext.request.contextPath}/resources/images/404.jpg"/>
				<a href="${pageContext.request.contextPath}/home">Home</a>	
			</div>
			</div>	
		</section>
			 
	 </main>
</div>

</body>
</html>