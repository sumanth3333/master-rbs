<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Transactions</title>
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

		<h2 style="text-align: center; margin-top: 2%; margin-bottom: 2%">Transaction
			Details</h2>

		<form action="/getTransactions" method="post">
			<select style="font-family: serif; font-size: 25; font-weight: bold;" name="accountId">
				<c:forEach var="acc" items="${accounts}">
					<option value="${acc.accountId }">Account No:
						${acc.accountId }</option>
				</c:forEach>
			</select> <br> <br> <input class="btn btn-primary" type="submit"
				value="Submit" />

		</form>
		<br>
		<c:if test="${!empty transactions}">
			<div class="tablelayout">
				<div class="container">

					<table class="table table-striped">

						<thead>
							<tr>
								<th>sourceAccountId</th>
								<th>sourceOwnerName</th>
								<th>targetAccountId</th>
								<th>targetOwnerName</th>
								<th>amount</th>
								<th>initiationDate</th>
								<th>reference</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="trans" items="${transactions}">
								<tr>

									<td><c:out value="${trans.sourceAccountId}" /></td>
									<td><c:out value="${trans.sourceOwnerName}" /></td>
									<td><c:out value="${trans.targetAccountId}" /></td>
									<td><c:out value="${trans.targetOwnerName}" /></td>
									<td><c:out value="${trans.amount}" /></td>
									<td><c:out value="${trans.initiationDate}" /></td>
									<td><c:out value="${trans.reference}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>

	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
