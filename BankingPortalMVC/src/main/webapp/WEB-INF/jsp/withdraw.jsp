<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar bg-dark navbar-dark navbar-expand justify-content-between">
	<a class="navbar-brand" href="#">
		<h2>Bankname</h2>
	</a>

	<ul class="navbar-nav  ">
		<li class="nav-item"><a class="nav-link" href="/customerDetails">My
				Details</a></li>

		<li class="nav-item"><a class="nav-link" href="/transaction">Transactions</a>
		</li>

		<li class="nav-item"><a class="nav-link" href="/withdraw">Withdraw</a>
		</li>

		<li class="nav-item"><a class="nav-link" href="/transfer">Transfer</a>
		</li>

		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
		</li>

	</ul>
	</nav>


	<div align="center">




		<h2>
			<center
				style="font-family: Whitney, -apple-system, BlinkMacSystemFont, Segoe UI, Roboto, Helvetica, Arial, sans-serif; margin-top: 2%; margin-bottom: 2%">Withdraw
				Amount</center>
		</h2>
		<div class="container">
			<form:form action="/checkwithdraw" method="post"
				modelAttribute="account">
				<select
					style="font-family: serif; font-size: 25; font-weight: bold;"
					name="accountId">
					<c:forEach var="acc" items="${accounts}">
						<option value="${acc.accountId }">Account No:
							${acc.accountId }</option>
					</c:forEach>
				</select>
				<div class="form-group">
					<form:label path="amount" name="withdraw">Withdraw Amount</form:label>
					<form:input path="amount" name="withdrawamount"
						class="form-control" id="amount" required="true" />

				</div>

				<div class="form-group">
					<input type="submit" class="btn btn-success" name="submit"
						value="Withdraw" /> <input type="reset" class="btn btn-warning"
						value="Cancel" />

				</div>


			</form:form>

		</div>

	</div>
</body>
</html>