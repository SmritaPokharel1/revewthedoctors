<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${not empty successMessage}">
	<div class="success-msg">
		<c:out value="${successMessage}" />
	</div>
</c:if>

<c:if test="${not empty errorMessage}">
	<div class="error-msg">
		<c:out value="${errorMessage}" />
	</div>
</c:if>
