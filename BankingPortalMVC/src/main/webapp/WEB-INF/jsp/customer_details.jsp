<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Details</title>
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
</head>
<body>
	
	<nav
		class="navbar bg-dark navbar-dark navbar-expand justify-content-between">
		<a class="navbar-brand" href="#">
			<h2>Bankname</h2>
		</a>

		<ul class="navbar-nav  ">
			<li class="nav-item"><a class="nav-link" href="/customerDetails">My
					Details</a></li>

			<li class="nav-item"><a class="nav-link" href="/transactions">Transactions</a>
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

		<h2 style="text-align: center; margin-top: 2%; margin-bottom: 2%">Customer
			Details</h2>

		<div class="tablelayout">
			<div class="container">
				<table class="table table-striped">
					<tr>
						<th>CUSTOMER ID</th>
						<th>CUSTOMER NAME</th>
						<th>DOB</th>
						<th>PAN</th>
						<th>AADHAR</th>
						<th>PHONE</th>
						<th>EMAIL</th>
						<th>ADDRESS</th>
						<th>ACCOUNTS</th>
					</tr>
					<tr>
						<td><c:out value="${customer.customerId}" /></td>
						<td><c:out value="${customer.username}" /></td>
						<td><c:out value="${customer.dob}" /></td>
						<td><c:out value="${customer.panNo}" /></td>
						<td><c:out value="${customer.aadharNo}" /></td>
						<td><c:out value="${customer.phoneNumber}" /></td>
						<td><c:out value="${customer.emailId}" /></td>
						<td><c:out value="${customer.address}" /></td>
						<td><table class="table table-striped">

								<tr>
									<th>ACCOUNT ID</th>
									<th>CURRENT BALANCE</th>
									<th>ACCOUNT TYPE</th>
								</tr>
								<c:forEach var="acc" items="${accounts}">
									<tr>

										<td><c:out value="${acc.accountId}" /></td>
										<td><c:out value="${acc.currentBalance}" /></td>
										<td><c:out value="${acc.accountType}" /></td>
									</tr>
								</c:forEach>
							</table></td>

					</tr>
				</table>

			</div>
		</div>

	</div>
</body>
</html>