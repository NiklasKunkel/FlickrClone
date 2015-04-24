<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.FriendDao" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <title>Friend List</title></head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

     <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<body>

<% 
FriendDao friendDao = new FriendDao();
int numFriend = 0;
%>

<h2>Friend List</h2>
<table border="1">
        <%
            List<String> friends = friendDao.getFriends(request.getUserPrincipal().getName());
            for (String friend : friends) {
            numFriend++;
        %>
    <tr>
        <td>
		Friend #<%= numFriend %> : <%= friend %>
        </td>
    </tr>
        <%
            }
        %>
</table>
<br>
<p><a class="btn btn-lg btn-info" href="/photoshare/index.jsp" role="button">Return Home</a></p>

</body>
</html>