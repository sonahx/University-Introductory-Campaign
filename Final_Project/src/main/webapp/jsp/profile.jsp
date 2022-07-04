<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${user.firstName} ${user.lastName}`s profile</title>

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
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal3" data-whatever="@mdo">Change photo</button>
<div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel2">New photo</h5>
      </div>
      <div class="modal-body">
     
        <form:form method="POST" action="${contextPath}/profile/${pageContext.request.userPrincipal.name}/addPhoto" enctype="multipart/form-data">
          <div class="form-group">
            <label for="encodedImage" class="col-form-label">Upload photo:</label>
      <input type="file" name="encodedImage" class="form-control"/>
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary">
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
                <p class="mb-0">Full Name</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.firstName} ${user.lastName}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Email</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.email}</p>
              </div>
            </div>
            <hr>
            <div class="row certificateScore">
                    
                    <div class="col-sm-3">
                <p class="mb-0">Certificate score</p>
              </div>
              <div class="col-sm-9 CertificateScoreText">
                <p class="text-muted mb-0 ">${user.avgSchoolScore}</p>
              </div>              
            </div>
            
                        <!--START CERTIFICATE MODAL  --> 
   <security:authorize access="hasRole('ROLE_USER')">	         
<button type="button" class="btn btn-primary certificateScoreButton" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Add certificate score</button>
</security:authorize>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New certificate score</h5>
      </div>
      <div class="modal-body">
     
        <form:form method="POST" action="${contextPath}/profile/${pageContext.request.userPrincipal.name}/addCertificateScore">
          <div class="form-group">
            <label for="score" class="col-form-label">Score:</label>
            <input name="score" type="number" step=".01" min="50" max="200" class="form-control">
            
             <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary">
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
                <p class="mb-0">Average score</p>
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
                <p class="mb-4"><span class="text-primary font-italic me-1"></span> Exam Scores </p>
                <div>
                       <table class="table">	
  				<thead>
						<tr>
							<th>Subject</th>
							<th>Score</th>
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
  Add exam scores
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
        You have to add your school certificate first!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

      </div>
    </div>
  </div>
</div> 
         
    </c:when>
    <c:otherwise>
    <security:authorize access="hasRole('ROLE_USER')">		
    	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2" data-whatever="@mdo">Add exam score</button>
    	</security:authorize>
<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel2">New exam score</h5>
      </div>
      <div class="modal-body">
     
        <form:form method="POST" action="${contextPath}/profile/${pageContext.request.userPrincipal.name}/addSubject">
          <div class="form-group">
            <label for="name" class="col-form-label">Subject:</label>
      <input list="subjects" name="name" class="form-control"/>
<datalist id="subjects">
  <option value="Math">
  <option value="Native language">
  <option value="Foreign language">
  <option value="History">
  <option value="Physics">
  <option value="Biology">
  <option value="Chemistry">
  <option value="Geographics">
</datalist>
          </div>
          <div class="form-group">
            <label for="value" class="col-form-label">Score:</label>
            <input name="value" type="number" step=".01" min="100" max="200" class="form-control">
            
             <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
          </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary">
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
                <p class="mb-4"><span class="text-primary font-italic me-1"></span> My Applications</p>
                
                  <table class="table">	
  				<thead>
						<tr>
							<th>Faculty</th>
							<th>University</th>
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