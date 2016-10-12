<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>

<div
	class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer ">

	<%@include file="../../common/adminmenu.jsp"%>

	<main class="mdl-layout__content"> 
		<section class="mdl-layout__tab-panel is-active" id="scroll-tab-1"> 
			<%@include file="../../common/message.jsp"%>
			<%@include file="admin_zone_create.jsp"%> </section> 
		<section class="mdl-layout__tab-panel" id="scroll-tab-2"> 
			<%@ include file="admin_zone_list.jsp"%> </section>
	</main>
</div>

</body>

<script src="${pageContext.request.contextPath}/resources/js/module/zone/admin_zone_create.js"></script>
<script>
	$(document).ready(function(){
		$(".success-msg").delay(5000).fadeOut("100000");
		$(".error-msg").delay(5000).fadeOut("100000");
			getCountryList('${pageContext.request.contextPath}');
			$("#section-1-anchor").click(function() {
				getCountryList('${pageContext.request.contextPath}');
			});
			$("#section-2-anchor").click(function(){
				getZoneList('${pageContext.request.contextPath}');
			});
		});
	
</script>
</html>