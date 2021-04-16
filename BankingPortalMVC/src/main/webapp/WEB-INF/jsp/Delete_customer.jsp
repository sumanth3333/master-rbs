<html>
<head>
<title>Remove Account</title>
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

		<h2 style="text-align: center; margin-top: 2%; margin-bottom: 2%">Remove
			Customer</h2>
		<br> <br>

		<form action="/deleteCustomer" method="post">
			<input type="number" name="customerId"
				placeholder="Enter the Customer Id" autocomplete="off" /><br>
			<br> <input type="submit" name="View" value="Delete Customer"
				class="btn btn-primary" />
		</form>
		<br>
	</div>
</body>
</html>