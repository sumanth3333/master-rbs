<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.border-class {
	border: thin black solid;
	margin: 20px;
	padding: 20px;
}

form {
	width: 400px;
	height: 350px;
	margin: auto;
	position: relative;
	display: inline-block;
	background-color: white;
	color: black;
}
</style>
</head>
<body style="text-align: center">

	<nav
		class="navbar bg-dark navbar-dark navbar-expand justify-content-between">
		<a class="navbar-brand" href="#">
			<h2>BankName</h2>
		</a>
	</nav>
	<div>
		<h1 style="text-align: center">Customer Login</h1>
		<form:form action="customerLogin" class="border-class"
			modelAttribute="user" method="post">
			<!-- Email input -->
			<div class="form-outline mb-4">
				<form:label path="username" class="form-label" for="form2Example1">Username</form:label>
				<form:input path="username" type="text" id="form2Example1"
					class="form-control" required="true" />
			</div>

			<!-- Password input -->
			<div class="form-outline mb-4">
				<form:label path="password" class="form-label" for="form2Example2">Password</form:label>
				<form:input path="password" type="password" id="form2Example2"
					class="form-control" required="true" />

			</div>

			<!-- 2 column grid layout for inline styling -->
			<div class="row mb-4 justify-content-center">
				<div class="col">
					<input type="submit" name="customerLogin"
						class="btn btn-primary btn-block mb-4 mt-4"
						value="Login as Customer" />
				</div>

				<div class="row ">
					<div class="text-danger">${errorMsg}</div>
				</div>
			</div>
		</form:form>
	</div>
	<div>
		Login as Employee <a href="/employeeLogin">Click Here</a>
	</div>
</body>
</html>