<%@ page import="photoshare.TagDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Picture Tagger</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>

<body>
<div class="container">
<h1>Picture Tagger</h1>
<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>
<br>
<br>
<% boolean showForm = true; %>
<% boolean showSucess = false; %>
<p>Please enter the # of Tags you would like to create:</p>
<br>
<%
   if(request.getParameter("tag0")!=null){
	TagDao tagDao = new TagDao();	
	int pid = Integer.parseInt(request.getParameter("pid"));
	int numTags = Integer.parseInt(request.getParameter("numTagscreate"));
	for(int i = 0;i<numTags;i++){
		showForm = showForm && (tagDao.createTag(request.getParameter("tag"+i),pid));
	}
	showSucess = showForm;
	showForm = !showForm;
  } else if(request.getParameter("numTags")!=null && Integer.parseInt(request.getParameter("numTags"))>0){%>
	<form action="addtags.jsp"  method="post" >
		<% showForm = false;
		for(int i = 0;i<Integer.parseInt(request.getParameter("numTags"));i++){
			String inputName = "tag" + i; %>
			<%= inputName %> : <input type="text" name=<%= inputName %>><br>
		<% } %>
		<input type="hidden" value=<%= request.getParameter("id")%> name="pid">
		<input type="hidden" value=<%= request.getParameter("numTags")%> name="numTagscreate">
		<input type="submit" value="Create Tags" name="numTagscreate">
	</form>
<% } %>

<% if(showForm){ %>
<form action="addtags.jsp?id=<%= request.getParameter("id")%>"  method="post" >
	<input type="text" name="numTags">
	<input type="submit" value="Create Tags">
	<input type="hidden" value=<%= request.getParameter("id")%> name="pid">
</form>

<% } 
if(showSucess){ %>
	<h3>Tag(s) Added!</h3>
<%} %>
</body>
</html>