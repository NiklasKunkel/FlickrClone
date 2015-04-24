<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Photoshare Login</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<h2 class="form-signin-heading">Please login</h2>

		<form method="POST" action="j_security_check" class="form-signin">
			<label class="sr-only" for="inputEmail">Email</label>
			<input type="email" name="j_username" id="inputEmail" class="form-control" placeholder="Email Address" required autofocus>

			<label class="sr-only" for="inputPassword">Password</label>
			<input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required>

			<button class="btn btn-md btn-info" type="submit"
			value="Login"/>Log In</button>
		</form>
		<form class="form-signin" method="GET" action="j_security_check">
			<a class="btn btn-md btn-success" href="newuser.jsp" role="button">Register</a>
     			<a class="btn btn-md btn-warning" href="showpictures.jsp" role="button">Go Incognito</a>
		</form>
	</div>

</body>
</html>
