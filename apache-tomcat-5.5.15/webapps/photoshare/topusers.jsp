<%@ page import="photoshare.CommentDao" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.NewUserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
	<title>Photo Sharing test </title>
	  <!-- Latest compiled and minified CSS -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 	 <!-- Optional theme -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  	<!-- Latest compiled and minified JavaScript -->
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
<h1>Power User Rankings</h1>
<br>
<b>No life your way to the top!</b>
<br>
<br>
<table border="1">
		<tr>
		<td><b>Emails</b></td>
		<td><b>Points</b></td>
		</tr>
<%
	NewUserDao userDao = new NewUserDao();
	List<Integer> points = new ArrayList();
	List<String> emails = new ArrayList();
	userDao.topUsers(points,emails);
	for(int i =0;i<points.size();i++){ %>
		<tr>
		<td> <%= emails.get(i)%> </td>
		<td> <%= Integer.toString(points.get(i))%> </td>
		</tr>
<%	} %>
</table> 
<br>
<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>





</body>
</html>