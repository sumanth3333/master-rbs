<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Customer</title>
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
	width: 350px;
	height: 400px;
	margin: auto;
	position: relative;
	display: inline-block;
	background-color: white;
	color: black;
}
</style>
</head>
<body>
	
	<nav
		class="navbar bg-dark navbar-dark navbar-expand justify-content-between">
		<a class="navbar-brand" href="#">
			<h2>Bankname</h2>
		</a>

		<ul class="navbar-nav  ">
			<li class="nav-item"><a class="nav-link" href="/createCustomer">Create
					Customer</a></li>

			<li class="nav-item"><a class="nav-link" href="/createAccount">Create
					Account</a></li>

			<li class="nav-item"><a class="nav-link" href="/deposit">Deposit</a>
			</li>

			<li class="nav-item"><a class="nav-link" href="/delete">Remove
					Customer</a></li>

			<li class="nav-item"><a class="nav-link" href="/serviceCharge">Deductions</a>
			</li>

			<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
			</li>

		</ul>
	</nav>

	<div align="center">

		<h2 style="text-align: center; margin-top: 2%; margin-bottom: 2%">Create
			Customer</h2>

		<div class="border-class">
			<form:form action="/customerCreation" method="post"
				modelAttribute="customer">

				<table>
					<tr>
						<td><form:label path="username" for="username">Enter username:</form:label></td>
						<td><form:input type="text" path="username" name="username"
								placeholder="username" autocomplete="off" required="true" /></td>
					</tr>
					<tr>
						<td><form:label path="password" for="password">Enter Password:</form:label></td>
						<td><form:input type="password" path="password"
								placeholder="password" name="password" required="true" /></td>
					</tr>
					<tr>
						<td><form:label path="address" for="address">Enter Address:</form:label></td>
						<td><form:input type="text" path="address" name="address"
								placeholder="address" autocomplete="off" required="true" /></td>
					</tr>
					<tr>
						<td><form:label path="dob" for="dateOfBirth"> Date of Birth:</form:label></td>
						<td><form:input type="date" id="date" path="dob" name="dob"
								required="true" /></td>
					</tr>
					<tr>
						<td><form:label path="panNo" for="pan">Enter Pan details:</form:label></td>
						<td><form:input type="text" path="panNo" name="pan"
								placeholder="Pan Number" minlength="10" maxlength="10"
								pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}" autocomplete="off"
								required="true" /></td>
					</tr>
					<tr>
						<td><form:label path="aadharNo" for="adhar">Enter Aadhar number:</form:label></td>
						<td><form:input type="text" minlength="12" maxlength="12"
								path="aadharNo" name="aadharNo" placeholder="Aadhar Number"
								pattern="[0-9]{12}" autocomplete="off" required="true" /></td>
					</tr>
					<tr>
						<td><form:label path="phoneNumber" for="phone">Enter Phone:</form:label></td>
						<td><form:input type="text" minlength="10" maxlength="10"
								path="phoneNumber" placeholder="Phone Number" name="phoneNumber"
								pattern="[6-9]{1}[0-9]{9}" autocomplete="off" required="true" /></td>
					</tr>
					<tr>
						<td><form:label path="emailId" for="emailId">Enter Email:</form:label></td>
						<td><form:input type="email" path="emailId" name="emailId"
								placeholder="Email ID" autocomplete="off" required="true" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Create" class="btn btn-primary" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>

</body>
</html>
