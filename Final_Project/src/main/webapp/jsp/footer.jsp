<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bitter:400,700">

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/footer.css">
    
</head>


<footer class="wrapper">

	<div class="text-center" style="background-color: #eee;">
		<div class="localesWrapper">
		<fieldset class="fieldset">
			<label><spring:message code='header.langChoose' /></label> <select
				id="locales">
				<option value="en" selected><spring:message
						code='header.english' /></option>
				<option value="ua"><spring:message code='header.ukrainian' /></option>

			</select>
		</fieldset>
	</div>
  <p class="copyright"><spring:message code='footer.companyName'/></p>	  
  </div>

</footer>
    
    
    
    <script src="/js/locales.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


</html>
