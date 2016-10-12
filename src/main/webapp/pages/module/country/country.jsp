<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>
<!-- script src="${pageContext.request.contextPath}/resources/js/module/country/admin_country_list.js"/-->

<div
	class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer ">

	<%@include file="../../common/adminmenu.jsp"%>

	<main class="mdl-layout__content"> 
	
		<section class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
			 <%@include file="../../common/message.jsp"%>
			 <%@include file="admin_country_create.jsp"%>
	    </section>
			 
	    <section class="mdl-layout__tab-panel" id="scroll-tab-2"> <%@ include
			file="admin_country_list.jsp"%> </section>
			
	 </main>
</div>
<script>
$(document).ready(function(){
	$(".success-msg").delay(5000).fadeOut("100000");
	$(".error-msg").delay(5000).fadeOut("100000");
	
	$("#section-2-anchor").click(function(){
		getAllCountries('${pageContext.request.contextPath}');
	});
	
	$(".delete-country").live("click",function(){
		var tr = $(this).closest("tr");
		var countryId = tr.attr("countryId");
		deleteCountry(countryId);
		
	});
});


</script>
<script src="${pageContext.request.contextPath}/resources/js/module/country/admin_country.js" type="text/javascript"></script>
</body>
</html>