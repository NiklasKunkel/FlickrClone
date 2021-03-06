<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.TagDao" %>
<%@ page import="java.util.List" %>

<html>
<head>
	<title>Search all photos by tags</title>
	<!-- Latest compiled and minified CSS -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

  	<!-- Optional theme -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  	<!-- Latest compiled and minified JavaScript -->
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>

<h2>TOP TAGS</h2>
<table>
	    <tr>
		<td>Tag</td>
		<td>Rank</td>
	    </tr>
	<%
	    TagDao tagDao = new TagDao();
	    List<String> tags = tagDao.topTags();
		int i = 0;
	    for (String tag : tags) {i++;
	%>
	    <tr>
		<td><a href="/photoshare/searchAllPicsbyTag.jsp?tag=<%= tag %>"><%= tag %> </a><br></td>
		<td><%= i %></td>
	    </tr>
	<%
	    }
	%>
</table>
<br>
<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>
</body>
</html>
