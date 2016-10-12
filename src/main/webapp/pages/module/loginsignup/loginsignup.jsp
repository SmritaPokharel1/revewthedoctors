<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/landingheader.jsp"%>

<div
	class="demo-layout-waterfall mdl-layout mdl-js-layout">

	<%@include file="../../common/loginmenu.jsp"%>

	<main class="mdl-layout__content"> 
	
		<section class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
			 <%@include file="login.jsp"%> </section>
			 
	    <section class="mdl-layout__tab-panel" id="scroll-tab-2"> <%@ include
			file="signup.jsp"%> </section>
			
	 </main>
</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/module/loginsignup/loginsignup.js" type="text/javascript"></script>
<script>
getCityList("${pageContext.request.contextPath}");
$("#section-1-anchor").click(function() {
	getCityList("${pageContext.request.contextPath}");
});
</script>


</html>