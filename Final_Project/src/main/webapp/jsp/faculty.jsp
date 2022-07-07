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
<title>${faculty.name}</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/faculty.css">

</head>
<body style="background-color: #eee;" onload="changeColor()">
<jsp:include page="header.jsp"></jsp:include>


<header>
  <span class="siteTitle">${faculty.name}</span>
</header>

  <div  class="card">
      <div class="inner">
        <h2 class="title">${faculty.description}</h2>
        <h2 class="subtitle">${faculty.universityName}</h2>
      </div>
      
  
  <c:set var="averageScore" value="${user.averageScore}" />
  <c:set var="schoolScore" value="${user.avgSchoolScore}" />
<c:choose>
    <c:when test="${averageScore ne null}"> 
         <a href="${contextPath}/faculty/${faculty.id}/apply/${pageContext.request.userPrincipal.name}" class="btn btn-primary btn-lg apply-button"><spring:message code='faculty.apply'/></a>             
    </c:when>
    <c:otherwise>
           
<!-- Button trigger modal -->
<security:authorize access="hasRole('ROLE_USER')">
<button type="button" class="btn btn-primary btn-lg apply-button" data-toggle="modal" data-target="#exampleModal">
  <spring:message code='faculty.apply'/>
</button>
</security:authorize>


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
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code='Close home.modal.close'/></button>
        <a type="button" href="${contextPath}/profile/${pageContext.request.userPrincipal.name}" class="btn btn-primary"><spring:message code='home.modal.navigate'/></a>
      </div>
    </div>
  </div>
</div> 
          
    </c:otherwise> 
</c:choose>
    </div>
    
    <h3 class="textReminder"><spring:message code='faculty.message-p1'/> ${faculty.studentsToAccept} <spring:message code='faculty.message-p2'/></h3>
    
    
  <h3 class="textReminder"><spring:message code='faculty.applicants'/></h3>
  
  <div class="tableStyles">
  <table class="table">	
  				<thead>
						<tr>
							<th><spring:message code='faculty.applicantName'/></th>
							<th><spring:message code='faculty.score'/></th>
							<th><spring:message code='faculty.status'/></th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty applicants}">
						<c:forEach items="${applicants}" var="applicant">										
	                          <tr>
							<td>${applicant.user.firstName} ${applicant.user.lastName}</td>		
							<td>${applicant.user.averageScore}</td>
										
 <c:choose>
    <c:when test="${applicant.status == 'Accepted'}"> 
         <td class="row-green">${applicant.status}</td>
    </c:when>
    <c:otherwise>		
    	<td class="row-red">${applicant.status}</td>
      </c:otherwise> 
</c:choose>		
					<tr>
				</c:forEach>
						</c:if> 
					</tbody>
				</table>
  </div>


<script src="/js/faculty.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>