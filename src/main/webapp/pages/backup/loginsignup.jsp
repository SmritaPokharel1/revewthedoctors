<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../../common/header.jsp"%>

<div
	class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer ">

	<%@include file="common/loginmenu.jsp"%>

	<main class="mdl-layout__content"> 
	
		<section class="mdl-layout__tab-panel" id="scroll-tab-2"> <%@ include
			file="module/user/admin_user_list.jsp"%> </section>
			
	 </main>
</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/loginsignup/loginsignup.js" type="text/javascript"></script>
</html>