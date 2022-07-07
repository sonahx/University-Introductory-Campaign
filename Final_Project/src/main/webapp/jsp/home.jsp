<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code='home.header'/></title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/home.css"> 
<body style="background-color: #eee;">

<jsp:include page="header.jsp" />

<div class="tableStyles">
<table class="table table-striped">
					<thead>
						<tr>
							<th><spring:message code='home.facultyName'/></th>
							<th><spring:message code='home.university'/></th>
							<th><spring:message code='home.students'/></th>
							<th><spring:message code='home.studentSpots'/></th>
							<th></th>
							<th></th>

						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty faculties}">
						<c:forEach items="${faculties}" var="currentFaculty">
							<tr>
							<td>${currentFaculty.name}</td>	
							<td>${currentFaculty.universityName}</td>
							<td>${currentFaculty.studentQuantity}</td>
							<td>${currentFaculty.studentsToAccept}</td>
							
					<td><a class="btn btn-primary apply-button" href="${contextPath}/faculty/${currentFaculty.id}"><spring:message code='home.more'/></a></td>
					
					
  <c:set var="averageScore" value="${user.averageScore}" />
<c:choose>
    <c:when test="${averageScore ne null}"> 
        <td>
        <security:authorize access="hasRole('ROLE_USER')">
        <a class="btn btn-primary apply-button" href="${contextPath}/faculty/${currentFaculty.id}/apply/${pageContext.request.userPrincipal.name}"><spring:message code='home.apply'/></a>
        </security:authorize>
        </td>
    </c:when>
    <c:otherwise>
           
<!-- Button trigger modal -->

<td>
 <security:authorize access="hasRole('ROLE_USER')">
<button type="button" class="btn btn-primary apply-button" data-toggle="modal" data-target="#exampleModal">
  <spring:message code='home.apply'/> </button> 
</security:authorize>  
</td>  
  
    </c:otherwise> 
</c:choose>	
					<tr>
				</c:forEach>
						</c:if>
					</tbody>
				</table>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"></h5>
      </div>
      <div class="modal-body">
        <spring:message code='home.modal.text'/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code='home.modal.close'/></button>
        <a type="button" href="${contextPath}/profile/${pageContext.request.userPrincipal.name}" class="btn btn-primary"><spring:message code='home.modal.navigate'/></a>
      </div>
    </div>
  </div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>