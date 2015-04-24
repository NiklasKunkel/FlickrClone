<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.FriendDao" %>
<jsp:useBean id="friend"
             class="photoshare.Friend" />
<jsp:setProperty name="friend" property="*"/>

<html>
<head>
	<title>New User</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet"> -->
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>

<% 
Boolean success = false;
FriendDao friendDao = new FriendDao();
success = friendDao.createFriendship(friend.getFrienda(),friend.getFriendb());
%>



<%if (success) {%>
	<h2>Successfully created a friendship </h2>
<% }
else { %>
	<h2>ERROR couldn't create friendship</h2>
<% } %>

<a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Home</a>
<a class="btn btn-lg btn-warning" href="/photoshare/search.jsp" role="button">Add Another Friend</a>

</body>
</html>
