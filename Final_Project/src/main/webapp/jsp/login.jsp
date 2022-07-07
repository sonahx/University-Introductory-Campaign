<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code='login.logIn'/></title>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="/css/register-login.css">
</head>
<body style="background-color: #eee;">

<div class="container reg-log">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading"><spring:message code='login.logIn'/></h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="email" type="text" class="form-control login-input" placeholder=<spring:message code='login.email'/>
                   autofocus="true"/>
            <input name="password" type="password" class="form-control login-input" placeholder=<spring:message code='login.password'/>>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code='login.logIn'/></button>
            <a class="accountText" href="${contextPath}/registration"><spring:message code='login.register'/></a>
        </div>

    </form>

<jsp:include page="footer.jsp"></jsp:include>

</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>