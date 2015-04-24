<%@ page import="photoshare.CommentDao" %>
<%@ page import="photoshare.LikeDao" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="org.apache.commons.fileupload.FileUploadException" %>
<%@ page import="java.util.List" %>
<html>
<head>
	<title>View Photo</title>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script>
		.row {
   	      	     display: table;
	 	 }

		 .row [class*="col-"] {
    		 float: none;
    		 display: table-cell;
    		 vertical-align: top;
		 }
	</script>
</head>

<body>

<div class="container-full">

      <div class="row">
       
        <div class="col-lg-12 text-center v-center">
          
          <h1>Photo</h1>

          <%  
			PictureDao pictureDao = new PictureDao(); 
			int pictureId = Integer.valueOf(request.getParameter("id"));
			LikeDao likeDao = new LikeDao();
			String caption = pictureDao.getCaption(pictureId);
	  %>
	  <p class="lead">Picture ID = <%= pictureId %></p>
           <img src="/photoshare/img?picture_id=<%= pictureId %>" width=auto height="400" class="img-rounded"/>
        </div>
        
      </div> <!-- /row -->
  
  	  <div class="row">
       
        <div class="col-lg-12 text-center v-center">
		
		<p class="lead">Caption: <%= caption %></p>

		<form action="removepic.jsp?id=<%= request.getParameter("id")%>" method ="post">
		      <input type="submit" value="Remove Photo">
		</form>
        </div>
      
      </div>

</div> <!-- /container full -->

<div class="container">
  
  	<hr>
  
  	<div class="row">
        <div class="col-md-4">
          <div class="panel panel-default">
            <div class="panel-heading"><h3>Stats</h3></div>
            <div class="panel-body">

	    	    	<h2>Number of Likes</h2>
			<%= likeDao.numLiked(pictureId)%>

			<h2>Like this picture</h2>
			<form action="picture.jsp?id=<%= request.getParameter("id")%>&doLike=true" method ="post">
				<input type="submit" value="LIKE PHOTO">
			</form>
			<% if(request.getParameter("doLike")!=null){
				boolean createdLike = false;	
				createdLike = likeDao.createLike(request.getUserPrincipal().getName(),pictureId);
					if(createdLike){ %>	
					LIKED PHOTO
			<%}} %>

			<h2>Who liked this picture</h2>
			<% for(String wholike: likeDao.whoLiked(pictureId)){ %>
			<%=wholike%><br>
			<%} %>
			<br>

	  	</div>
          </div>
        </div>
      	<div class="col-md-4">
        	<div class="panel panel-default">
            <div class="panel-heading"><h3>Social</h3></div>
            <div class="panel-body">

	    	<h2>Add Comments</h2>
		<form action="picture.jsp?id=<%= request.getParameter("id") %>" method="post">
			Comment: <input type="text" name="comment"/><br>
			<input type="submit" value="Submit">	
		</form>

		<% 
			CommentDao commentDao = new CommentDao();
			Boolean success = false;
			if(request.getParameter("comment")!=null){
				int pid = Integer.parseInt(request.getParameter("id"));
				if(request.getUserPrincipal()!=null)
					success = commentDao.create(request.getUserPrincipal().getName(),request.getParameter("comment"),pid);	
			else
				success = commentDao.create("ANONYMOUS",request.getParameter("comment"),pid);
			}
			if(success){%>
		<h3>Successfully added comment</h3>
		<%}%>

		<h2>Comments</h2>
		<%
			if(request.getParameter("id")!=null){
				int pid2 = Integer.parseInt(request.getParameter("id"));
				List<String> comments = commentDao.getAllComments(pid2);	
				for(String comment: comments){ %>
					<%= comment%> <br><br>
				<% 	}
		}%>

	    </div>
          </div>
        </div>
      	<div class="col-md-4">
        	<div class="panel panel-default">
            <div class="panel-heading"><h3>Tags</h3></div>
            <div class="panel-body">
	    	<h2>Add Tags</h2>
		<a href="/photoshare/addtags.jsp?id=<%= pictureId %>"
          class="btn btn-md btn-primary" role="button">Add</a>

		<h2>Recommend Me Tags</h2>
		<a href="/photoshare/tagrecommend.jsp?id=<%= pictureId
		%>" class="btn btn-md btn-info" role="button">Recommend</a>
		
		<h2>Navigation</h2>
		<p><a class="btn btn-md btn-warning"
		href="/photoshare/showpictures.jsp" role="button">View All Pics</a>
		<a class="btn btn-md btn-info" href="/photoshare/index.jsp" role="button">Home</a></p>
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
