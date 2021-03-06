<%@ page import="photoshare.TagDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Recommend Tags</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet"> -->
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
<h1>Tag Recommendation Engine</h1>
<h3>Enter in some existing tags, and we'll suggest new ones!</h3>

<% boolean showForm = true; 
List<String> results = null;%>

<%
   if(request.getParameter("listtags")!=null){
	TagDao tagDao = new TagDao();	
	List<String> taglist = Arrays.asList(request.getParameter("listtags").split("\\s+"));	
	results = tagDao.recommendTags(taglist);
	showForm = false;
 } %>

<% if(showForm){ %>
<form action="tagrecommend.jsp?id=<%= request.getParameter("id")%>"  method="post" >
	<input type="text" name="listtags"> <br>
	<button type="submit" value="Recommend Some Tags" class="btn btn-lg
	btn-primary">Recommend Some Tags</button>
	<input type="hidden" value=<%= request.getParameter("id")%> name="pid">
</form>
<% } 
else{ %>
	<% if(results!=null){for(String result: results){ %>
		<h2> <%= result %> </h2>
	<%} }%>
<%} %>
</body>
</html>
