<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix= "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="head">
			<h1>Welcome</h1>
		</div>
		
		<div class="content">
			<div class="reg">
				<h3>Register</h3>
				<form:form action="/register" method="POST" modelAttribute="user">
					<div class='name'>
						<form:label path='name'>Name</form:label>
						<form:errors path='name' class='text-danger'></form:errors>
						<form:input path='name' class="form-control" type='text'></form:input>					
					</div>
					
					<div class='email'>
						<form:label path='email'>Email</form:label>
						<form:errors path='email' class='text-danger'/>
						<form:input path='email' class="form-control" type='text'></form:input>						
					</div>
					
					<div class='pw'>
					<form:label path='pw'>Password</form:label>
					<form:errors path='pw' class='text-danger'></form:errors>
					<form:input path='pw' class="form-control" type='password'></form:input>
					
					</div>
					
					<div class='confirm'>
						<form:label path='confirm'>Confirm password</form:label>
						<form:errors path='confirm' class='text-danger'></form:errors>
						<form:input path='confirm' class="form-control" type='password'></form:input>					
					</div>
					
					<button type='submit' class="btn btn-primary">Sign Up</button>
				</form:form>
			</div>
		
			<div class="log">
				<h3>Log In</h3>
				<form:form action="/login" method="POST" modelAttribute="loginUser">
					<div class='email'>
						<form:label path='email'>Email</form:label>
						<form:errors path='email' class='text-danger'></form:errors>
						<form:input path='email' class="form-control" type='text'></form:input>		
					</div>					
					
					<div class='pw'>
						<form:label path='pw'>Password</form:label>
						<form:errors path='pw' class='text-danger'></form:errors>
						<form:input path='pw' class="form-control" type='password'></form:input>						
					</div>
					<button type='submit' class="btn btn-outline-primary">Log In</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>