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
<% boolean showSearch = true; %>

<% if(request.getParameter("tag1")!=null && request.getParameter("tag2")!=null) {%>
	<h2>Pictures based on the two tags</h2>
	<table>
	    <tr>
		<%
		    TagDao tagDao = new TagDao();
		    List<Integer> pictureIds = tagDao.conjunctiveQuery(request.getParameter("tag1"),request.getParameter("tag2"));
		    for (Integer pictureId : pictureIds) {
		%>
		<td><a href="/photoshare/picture.jsp?id=<%= pictureId %>">
		    <img src="/photoshare/img?t=1&picture_id=<%= pictureId %>"/>
		</a>
		</td>
		<%
		    }
		%>
	    </tr>
	</table>
<% } %>

<%if (showSearch) {%>
	<h2>Conjective Tag Query</h2>
	<form action="conjunctiveQuery.jsp" method="post">
	  Tag 1: <input type="text" name="tag1"/><br>
	  Tag 2: <input type="text" name="tag2"/><br>
	  <input type="submit" value="Search"/><br/>
	</form>
<% } %>

<br>
<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>

</body>
</html>
