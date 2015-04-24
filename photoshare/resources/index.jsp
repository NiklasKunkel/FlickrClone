<%@ page import="photoshare.Picture" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.AlbumDao" %>
<%@ page import="photoshare.FriendDao" %>
<%@ page import="org.apache.commons.fileupload.FileUploadException" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="album"
             class="photoshare.Album" />

<jsp:setProperty name="album" property="*"/>

<jsp:useBean id="imageUploadBean"
             class="photoshare.ImageUploadBean">
    <jsp:setProperty name="imageUploadBean" property="*"/>
</jsp:useBean>

<html>
<head>
  <title>Photo Sharing</title>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container-full">
      	     <div class="row">
             	  <div class="col-lg-12 text-center v-center">
          
			<h1>Slightly Less Cool Imgur</h1>
          		<p class="lead">Imgur > Flickr</p>
          
			<br>
          		<img src="http://i.imgur.com/bXvvN3t.png" class="img-rounded">
             	<div class="header">
    		     Hi there <b><code><%= request.getUserPrincipal().getName()  %></code></b>!
    		     <p>Wrong User?</p>
    		     <p><a href="/photoshare/logout.jsp" class="btn btn-info" role="button">Log Out</a></p>
  		</div>  	  
		</div>

             </div> <!-- /row -->

	 </div> <!-- /container full -->

<div class="container">
  
  	<hr>
  
  	<div class="row">
        <div class="col-md-4">
          <div class="panel panel-default">
            <div class="panel-heading"><h3>Tags</h3></div>
            <div class="panel-body">
	    	 <h2>Power Users</h2>
      		 <a href="topusers.jsp" class="btn btn-info" role="button">View</a>

      		 <h2>Trending Tags</h2>
      		 <a href="toptags.jsp" class="btn btn-info" role="button">View</a>

      		 <h2>Disjunctive Tag Search</h2>
      		 <a href="disjunctiveQuery.jsp" class="btn btn-info" role="button">Search</a>

      		 <h2>Conjective Tag Search</h2>
      		 <a href="conjunctiveQuery.jsp" class="btn btn-info" role="button">Search</a>	    

            </div>
          </div>
        </div>
      	<div class="col-md-4">
        	<div class="panel panel-default">
            <div class="panel-heading"><h3>Create</h3></div>
            <div class="panel-body">
	    	 <h2>Upload a new picture</h2>

      		 <form action="index.jsp" enctype="multipart/form-data" method="post" id="uploadImage">
        	       Filename: <input type="file" name="filename"/>
		       Caption: <input type="text" name="caption" placeholder="caption"/>
      		       <button type="submit" value="Upload" class="btn btn-info"/>Upload</button><br/>
      		</form>

      		<%
      		PictureDao pictureDao = new PictureDao();
      		AlbumDao albumDao = new AlbumDao();
      		try {
       		    Picture picture = imageUploadBean.upload(request);
        	    if (picture != null) {
          	       int aid = albumDao.getAlbumID(picture.getAlbumname());
          	       pictureDao.save(picture,aid);
        	       }
      		 } catch (FileUploadException e) {
        	   	 e.printStackTrace();
      		 }
      		 %>

      		 <select name="albumname" form="uploadImage">
      		 <%    
        	 List<String> albumList = albumDao.getAlbums(request.getUserPrincipal().getName());
        	 if(!albumList.isEmpty()){
			for(String albumName: albumList){ %>
            			   <option value=<%= albumName%>><%= albumName%> </option>
          			   <% }
        		}
      		%>
      		</select>

      		<% boolean showForm = true;
      		String err = null; %>

      		<% if (!album.getAname().equals("")) {
        	      AlbumDao albumDaoX = new AlbumDao();
        	      boolean success=albumDaoX.create(request.getUserPrincipal().getName(),album.getAname());
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
          	      <button type="submit" value="Create" class="btn btn-info"/>Create</button><br/>
        	</form>

      		<% }
      		else { %>

        	<h2>Album created!</h2>

        	<p>New album with name <%= album.getAname() %> has been created!</p>
        	<p><a href="index.jsp">Return to Home Page</a></p>

      		<% } %>


      		<h2>Delete Album</h2>
      		<form action="index.jsp" method="post">
      		<input type="text" name="albumDelete">
      		<button type="submit" value="Delete" class="btn btn-info">Delete</button>
      		</form>

      		<% if(request.getParameter("albumDelete")!=null){
        	boolean doneDelete = albumDao.delete(request.getParameter("albumDelete"));  
        	if(doneDelete){%>
          	<h2>Delete Successful </h2>
      		<%}}%>
	    
            </div>
          </div>
        </div>
      	<div class="col-md-4">
        	<div class="panel panel-default">
            <div class="panel-heading"><h3>Social</h3></div>
            <div class="panel-body">
	         <h2>View Photos</h2>
      		 <a href="showpictures.jsp" class="btn btn-info" role="button">Browse Pictures</a>

      		 <h2>Friends</h2>
      		 <a href="/photoshare/listfriends.jsp" class="btn btn-info" role="button">List All</a>

     		  <h2>Search and Add Friends</h2>
      		  <a href="/photoshare/search.jsp" class="btn btn-info" role="button">Search</a>

            </div>
          </div>
        </div>
    </div>
  
	<div class="row">
        <div class="col-lg-12">
        <br><br>
          <p class="pull-right">Flickr Clone - Niklas Kunkel</p>
        <br><br>
        </div>
    </div>
</div>

</body>
</html>
