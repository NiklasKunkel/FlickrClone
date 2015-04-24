<%@ page import="photoshare.PictureDao" %>
<%@ page import="java.util.List" %>
<html>
<head><title>Deleting Photo </title></head>
<body>
<% 
	PictureDao pictureDao = new PictureDao();
	boolean success = pictureDao.delete(Integer.parseInt(request.getParameter("id")));
%>
<h2>Success Picture Removal</h2>
</body>
</html>