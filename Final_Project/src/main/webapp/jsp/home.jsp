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

<%-- 				<c:if test="${not empty faculties}">
					<c:forEach items="${faculties}" var="currentFaculty">

						<div class="w3-card-4" style="width: 20%; margin:2%" >
							<div class="w3-container w3-center">
								<h3>${currentFaculty.name}</h3>
								<p>Minumum score to apply: ${currentFaculty.minimumScore}</p>
								<p>${currentFaculty.description}</p>
							</div>
							<button class="w3-button w3-block w3-dark-grey">Apply</button>
						</div>

					</c:forEach>
				</c:if> --%>


<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Minimum score</th>
							<th>Student quantity</th>
							<th>Description</th>

						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty faculties}">
						<c:forEach items="${faculties}" var="currentFaculty">
							<tr>
							<td>${currentFaculty.name}</td>	
							<td>${currentFaculty.minimumScore}</td>
							<td>${currentFaculty.studentQuantity}</td>
							<td>${currentFaculty.description}</td>
					<td><a href="#">Read More</a></td>
					<td><a href="#">Apply</a></td> 
					<tr>
				</c:forEach>
						</c:if>
					</tbody>
				</table>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<%--   <script src="${contextPath}/resources/js/bootstrap.min.js"></script>   --%>


</body>
</html>