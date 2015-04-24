<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Logout</title>
	<title>Picture Tagger</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Logged out</h2>

<% session.invalidate(); %>
<a class="btn btn-md btn-info" href="/photoshare/index.jsp" role="button">Login Again</a>
</body>
</html>