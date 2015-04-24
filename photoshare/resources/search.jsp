<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.NewUserDao" %>

<html>
<head>
	<title>Add Friends</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
<% boolean showSearch = true; %>

<% 
String email  = request.getParameter("email");
String output = "";
if (email!=null && !email.equals("")) {
	NewUserDao userDao = new NewUserDao();		
	output = userDao.search(email);
	if(output != null)
		showSearch =false;
}
%>

<%if (showSearch) {%>
	<h2>Search for a friend via email</h2>

	<form action="search.jsp" method="post">
	  Email Address: <input type="text" name="email"/><br>
	  <input type="submit" value="Search"/><br/>
	</form>


<% }
else { %>
	<h2>Friend Search Results</h2>
	<%= output %>

	<form action="addfriend.jsp" method="post">
		<input type="hidden" name="frienda" value= <%= request.getUserPrincipal().getName()%> ><br>
		<input type="hidden" name="friendb" value= <%= email%> ><br>
		<input type="submit" value="Add Friend">
	</form>

<% } %>

<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>

</body>
</html>