<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code='profile.header'/></title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="/css/profile.css">
  
</head>
<body style="background-color: #eee;">

<jsp:include page="header.jsp" />


 <section style="background-color: #eee;">
  <div class="container py-5">
    <div class="row">
      <div class="col">

      </div>
    </div>

    <div class="row">
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
 
                  <c:if test="${user.encodedImage != null}">
                         <img  src="data:image/jpeg;base64, ${user.encodedImage}" alt="avatar" 
     class="rounded-circle img-fluid" style="width: 150px;">      
                      </c:if>
                      <c:if test="${user.encodedImage == null}">
                        <img  src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar" 
     class="rounded-circle img-fluid" style="width: 150px;">
                      </c:if>
      
            <h5 class="my-3">${user.firstName} ${user.lastName}</h5>
            <div class="d-flex justify-content-center mb-2">
            
 <!--START PHOTO MODAL  --> 
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal3" data-whatever="@mdo"><spring:message code='profile.changePhoto'/></button>
<div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel2"><spring:message code='profile.changePhoto'/></h5>
      </div>
      <div class="modal-body">
     
        <form:form method="POST" action="${contextPath}/profile/${pageContext.request.userPrincipal.name}/addPhoto" enctype="multipart/form-data">
          <div class="form-group">
            <label for="encodedImage" class="col-form-label"><spring:message code='profile.modal.uploadPhoto'/></label>
      <input type="file" name="encodedImage" class="form-control"/>
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code='profile.modal.close'/></button>
        <input type="submit" class="btn btn-primary" value=<spring:message code='profile.modal.submit'/>>
        </div>
        </form:form >
      </div>
      
    </div>
  </div>
</div>            
     <!--END PHOTO MODAL  --> 


            </div>
          </div>
        </div>
        <div class="card mb-4 mb-lg-0">

        </div>
      </div>
      <div class="col-lg-8">
        <div class="card mb-4">
          <div class="card-body">
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0"><spring:message code='profile.fullName'/></p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.firstName} ${user.lastName}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0"><spring:message code='profile.email'/></p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.email}</p>
              </div>
            </div>
            <hr>
            <div class="row certificateScore">
                    
                    <div class="col-sm-3">
                <p class="mb-0"><spring:message code='profile.certificateScore'/></p>
              </div>
              <div class="col-sm-9 CertificateScoreText">
                <p class="text-muted mb-0 ">${user.avgSchoolScore}</p>
              </div>              
            </div>
            
                        <!--START CERTIFICATE MODAL  --> 
   <security:authorize access="hasRole('ROLE_USER')">	         
<button type="button" class="btn btn-primary certificateScoreButton" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><spring:message code='profile.addCertificateScore'/></button>
</security:authorize>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><spring:message code='profile.modal.newCertificateScore'/></h5>
      </div>
      <div class="modal-body">
     
        <form:form method="POST" action="${contextPath}/profile/${pageContext.request.userPrincipal.name}/addCertificateScore">
          <div class="form-group">
            <label for="score" class="col-form-label"><spring:message code='profile.modal.score'/></label>
            <input name="score" type="number" step=".01" min="50" max="200" class="form-control">
            
             <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code='profile.modal.close'/></button>
        <input type="submit" class="btn btn-primary" value=<spring:message code='profile.modal.submit'/>>
        </div>
        </form:form >
      </div>
      
    </div>
  </div>
</div>           
     <!--END CERTIFICATE MODAL  -->    
    <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0"><spring:message code='profile.averageScore'/></p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.averageScore}</p>
              </div>
            </div>
            <hr> 
     
           
          </div>
 
        </div>
        <div class="row">
          <div class="col-md-6">
            <div class="card mb-4 mb-md-0">
              <div class="card-body">
                <p class="mb-4"><span class="text-primary font-italic me-1"></span><spring:message code='profile.examScores'/></p>
                <div>
                       <table class="table">	
  				<thead>
						<tr>
							<th><spring:message code='profile.subject'/></th>
							<th><spring:message code='profile.score'/></th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty subjects}">
						<c:forEach items="${subjects}" var="subject">				
							<tr>
							<td>${subject.name}</td>		
							<td>${subject.value}</td>
					<tr>
				</c:forEach>
						</c:if> 
					</tbody>
				</table>       
                </div>
                
                 <!--START EXAM SCORE MODAL  --> 
       
       
     <c:choose>
    <c:when test="${user.avgSchoolScore == null}"> 
         <security:authorize access="hasRole('ROLE_USER')">	 
         <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal4">
  <spring:message code='profile.addExamScore'/>
</button>
</security:authorize>
<!-- Modal -->
<div class="modal fade" id="exampleModal4" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"></h5>
      </div>
      <div class="modal-body">
       <spring:message code='profile.modal.warning'/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code='profile.modal.close'/></button>

      </div>
    </div>
  </div>
</div> 
         
    </c:when>
    <c:otherwise>
    <security:authorize access="hasRole('ROLE_USER')">		
    	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2" data-whatever="@mdo"><spring:message code='profile.addExamScore'/></button>
    	</security:authorize>
<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel2"><spring:message code='profile.modal.newExamScore'/></h5>
      </div>
      <div class="modal-body">
     
        <form:form method="POST" action="${contextPath}/profile/${pageContext.request.userPrincipal.name}/addSubject">
          <div class="form-group">
            <label for="name" class="col-form-label"><spring:message code='profile.modal.subject'/></label>
      <input list="subjects" name="name" class="form-control"/>
<datalist id="subjects">
  <option value=<spring:message code='profile.subject.math'/>>
  <option value=<spring:message code='profile.subject.native'/>>
  <option value=<spring:message code='profile.subject.foreign'/>>
  <option value=<spring:message code='profile.subject.history'/>>
  <option value=<spring:message code='profile.subject.biology'/>>
  <option value=<spring:message code='profile.subject.chemistry'/>>
  <option value=<spring:message code='profile.subject.geographics'/>>
  <option value=<spring:message code='profile.subject.physics'/>>
</datalist>
          </div>
          <div class="form-group">
            <label for="value" class="col-form-label"><spring:message code='profile.modal.score'/></label>
            <input name="value" type="number" step=".01" min="100" max="200" class="form-control">
            
             <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code='profile.modal.close'/></button>
        <input type="submit" class="btn btn-primary" value=<spring:message code='profile.modal.submit'/>>
        </div>
        </form:form >
      </div>
      
    </div>
  </div>
</div>            
     <!--END EXAM SCORE MODAL  --> 
      </c:otherwise> 
</c:choose>	  
            
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="card mb-4 mb-md-0">
              <div class="card-body">
                <p class="mb-4"><span class="text-primary font-italic me-1"></span><spring:message code='profile.myApplications'/></p>
                
                  <table class="table">	
  				<thead>
						<tr>
							<th><spring:message code='profile.faculty'/></th>
							<th><spring:message code='profile.university'/></th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${not empty applications}">
						<c:forEach items="${applications}" var="application">
			
							<tr>
							<td>${application.faculty.name}</td>		
							<td>${application.faculty.universityName}</td>
					<tr>
				</c:forEach>
						</c:if> 
					</tbody>
				</table>           
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>