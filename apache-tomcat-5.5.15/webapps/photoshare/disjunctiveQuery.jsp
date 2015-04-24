<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.TagDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
	<title>You may also like</title>
	<!-- Latest compiled and minified CSS -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 	 <!-- Optional theme -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  	<!-- Latest compiled and minified JavaScript -->
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>

<body>
<h3>You may also like</h3>
<table>
    <tr>
	<td> Image	</td>
	<td> Points </td>
    </tr>
	<%
	    TagDao tagDao = new TagDao();
	    List<Integer> points = new ArrayList();
	    String email = request.getUserPrincipal().getName();
	    List<String> tags = tagDao.myTopTags(email);
	    List<Integer> pictureIds = tagDao.disjunctiveQuery(tags,points);
	    int i = 0;
	    for (Integer pictureId : pictureIds) {
	%>
    <tr>
	<td><a href="/photoshare/picture.jsp?id=<%= pictureId %>">
	    <img src="/photoshare/img?t=1&picture_id=<%= pictureId %>"/>
	</a>
	</td>
	<td> <%= points.get(i) %> </td>
    </tr>
	<%
	   i++; }
	%>
</table>
<br>
<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>
</body>
</html>