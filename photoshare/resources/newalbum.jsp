<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.AlbumDao" %>
<jsp:useBean id="album"
             class="photoshare.Album" />
<jsp:setProperty name="album" property="*"/>

<html>
<head>
  <title>Create New Album</title></head>
    <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<body>

<% boolean showForm = true;
   String err = null; %>

<% if (!album.getAname().equals("")) {
	AlbumDao albumDao = new AlbumDao();
   	boolean success=albumDao.create(request.getUserPrincipal().getName(),album.getAname());
	if(success){
		showForm = false;
	}
   }
%>

<% if (err != null) { %>
<font color=red><b>Error: <%= err %></b></font>
<% } %>

<% if (showForm) { %>

<h2>Create New Album</h2>

<form action="newalbum.jsp" method="post">
  Album Name: <input type="text" name="aname"/><br>
  <input type="submit" value="Create"/><br/>
</form>

<% }
   else { %>

<h2>Album created!</h2>

<p>New album with name <%= album.getAname() %> has been created!</p>
<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>

<% } %>

</body>
</html>