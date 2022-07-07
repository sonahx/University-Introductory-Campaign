<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code='facultyForm.header'/></title>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bitter:400,700">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


 <link rel="stylesheet" href="css/facultyForm.css">
</head>



<body style="background-color: #eee;">
<jsp:include page="header.jsp"></jsp:include>

<form:form method="POST" action="${contextPath}/addFaculty" modelAttribute="faculty">  
    
  <form:input name="name" path="name" type="text" class="feedback-input" placeholder="Faculty name" />   
  <form:input name="universityName" path="universityName" type="text" class="feedback-input" placeholder="University name" />
  <form:input name="studentsToAccept" path="studentsToAccept" type="number" class="feedback-input" placeholder="Amount of students to accept" />
  <form:textarea name="text" path="description" class="feedback-input" placeholder="Description"></form:textarea>
   <form:input name="studentQuantity" path="studentQuantity" type="number" class="feedback-input" placeholder="Student quantity" />
  <input class="btn-primary" type="submit" value="Submit"/>
  
  <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
  
</form:form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>