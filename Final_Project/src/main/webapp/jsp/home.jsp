<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<body style="background-color: #eee;">

<jsp:include page="header.jsp" />

<table class="table table-striped">
					<thead>
						<tr>
							<th>Faculty name</th>
							<th>University</th>
							<th>Students</th>


						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty faculties}">
						<c:forEach items="${faculties}" var="currentFaculty">
							<tr>
							<td>${currentFaculty.name}</td>	
							<td>${currentFaculty.universityName}</td>
							<td>${currentFaculty.studentQuantity}</td>
							
					<td><a href="${contextPath}/faculty/${currentFaculty.id}">Read More</a></td>
					<td><a href="${contextPath}/faculty/${currentFaculty.id}/apply/${pageContext.request.userPrincipal.name}">Apply</a></td> 
					<tr>
				</c:forEach>
						</c:if>
					</tbody>
				</table>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>