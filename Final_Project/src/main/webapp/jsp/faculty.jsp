<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${faculty.name}</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/faculty.css">
</head>
<body style="background-color: #eee;">
<jsp:include page="header.jsp"></jsp:include>


<header>
  <span class="siteTitle">${faculty.name}</span>
</header>

  <div  class="card">
      <div class="inner">
        <h2 class="title">${faculty.description}</h2>
        <h2 class="subtitle">${faculty.universityName}</h2>
      </div>
      <a href="${contextPath}/faculty/${faculty.id}/apply/${pageContext.request.userPrincipal.name}" class="btn btn-primary btn-lg apply-button">Apply</a>
  </div>
  <h3>Applicants</h3>
  
  <table class="table">	
  				<thead>
						<tr>
							<th>Applicant name</th>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty applicants}">
						<c:forEach items="${applicants}" var="applicant">
						
						
							<tr>
							<td>${applicant.firstName} ${applicant.lastName}</td>		
							<td>TO DO</td>
					<tr>
				</c:forEach>
						</c:if> 
					</tbody>
				</table>
  



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>