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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
         <nav class="navbar bg-dark navbar-dark navbar-expand justify-content-between" >
            <a class="navbar-brand" href="#">
            <h2>Bankname</h2>
          </a>
            
          <ul class="navbar-nav  ">
            <li class="nav-item">
              <a class="nav-link" href="/createCustomer">Create Customer</a>
            </li>
			
			<li class="nav-item">
              <a class="nav-link" href="/createAccount">Create Account</a>
            </li>
			
            <li class="nav-item">
              <a class="nav-link" href="/deposit">Deposit</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="/delete">Remove Customer</a>
            </li>
             
			  <li class="nav-item">
              <a class="nav-link" href="/serviceCharge">Deductions</a>
            </li>
			
             <li class="nav-item">
              <a class="nav-link" href="/logout">Logout</a>
            </li>
            
          </ul>
            </nav>
			
		<h2>
		<center style ="font-family: Whitney,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica,Arial,sans-serif; margin-top:2%; margin-bottom:2%">Deposit Amount</center>
	</h2>
<div class = "container">
	<form:form action="/checkdeposit" method="post"  modelAttribute="account">
		
			<div class = "form-group">
						<form:label path="accountId" name="accountId">Account Number:</form:label>
			            <form:input path="accountId"  name="accountId"   class = "form-control" id="accountId" required="true"/>
						
			</div>
			
			<div class = "form-group">
						<form:label path="amount" name="withdraw">Deposit Amount:</form:label>
			            <form:input path="amount"  name="withdrawamount"   class = "form-control" id="amount" required="true"/>
						
			</div>
			
			<div class = "form-group">	
						<input type="submit" class="btn btn-success" name="submit" value="Deposit" />
				        <input type="reset"  class="btn btn-warning"  value="Cancel" />
				        	   
		    </div>
		    

	</form:form>
		<span style="color:red">${deposit}</span>
</div>
	
	</body>
</html>