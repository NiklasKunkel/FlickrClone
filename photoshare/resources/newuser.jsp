<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.NewUserDao" %>
<jsp:useBean id="newUserBean"
             class="photoshare.NewUserBean" />
<jsp:setProperty name="newUserBean" property="*"/>

<html>
<head>
	<title>New User</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
<!-- We want to show the form unless we successfully create a new user -->
<% boolean showForm = true;
   String err = null; %>

<% if (!newUserBean.getEmail().equals("")) {
     if (!newUserBean.getPassword1().equals(newUserBean.getPassword2())) {
       err = "Both password strings must match";


     }
     else if (newUserBean.getPassword1().length() < 4) {
       err = "Your password must be at least four characters long";
     }
     else {
       // We have valid inputs, try to create the user
       NewUserDao newUserDao = new NewUserDao();
       boolean success = newUserDao.create(newUserBean.getEmail(),
             newUserBean.getPassword1(),
             newUserBean.getFirstName(),
             newUserBean.getLastName(),
             newUserBean.getBirth(),
             newUserBean.getGender(),
             newUserBean.getCurrentCity(),
             newUserBean.getCurrentState(),
             newUserBean.getCurrentCountry(),
             newUserBean.getHomeCity(),
             newUserBean.getHomeState(),
             newUserBean.getHomeCountry(),
             newUserBean.getSchoolName(),
             newUserBean.getSchoolMajor(),
             newUserBean.getSchoolYear()
             );
       if (success) {
         showForm = false;
       } else {
         err = "Couldn't create user (that email may already be in use)";
       }
     }
   }
%>

<% if (err != null) { %>
<font color=red><b>Error: <%= err %></b></font>
<% } %>

<% if (showForm) { %>

<div class="container">
     <h2 class="form-signin-heading">Enter your Information</h2>

     <form class="form-horizontal" action="newuser.jsp" method="post">
	  <div class="form-group">
	       <label for="email" class="col-sm-2 control-label">Email</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control input-lg" name="email" title="Enter your email" placeholder="nkunkel@bu.edu">
	       </div>
	  </div>

 	  <div class="form-group">
	       <label for="password1" class="col-sm-2 control-label">Password</label>
	       <div class="col-sm-10">
	       	    <input type="password" class="center-block form-control
	  input-lg" name="password1" title="Enter your password" placeholder="password">
	       </div>
	  </div>

  	  <div class="form-group">
	       <label for="password2" class="col-sm-2 control-label">Re-Enter Password</label>
	       <div class="col-sm-10">
	       	    <input type="password" class="center-block form-control
	  input-lg" name="password2" title="Re-enter your password" placeholder="password">
	       </div>
	  </div>

    	  <div class="form-group">
	       <label for="firstName" class="col-sm-2 control-label">First Name</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	  input-lg" name="firstName" title="First Name" placeholder="Nik">
	       </div>
	  </div>

  	  <div class="form-group">
	       <label for="lastName" class="col-sm-2 control-label">Last Name</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	  input-lg" name="lastName" title="Last Name" placeholder="Kunkel">
	       </div>
	  </div>

 	  <div class="form-group">
	       <label for="dateOfBirth" class="col-sm-2 control-label">DoB</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	  input-lg" name="dateOfBirth" title="Enter your birthday" placeholder="06/25/1991">
	       </div>
	  </div>

	  <div class="form-group">
	       <label for="userGender" class="col-sm-2 control-label">Gender</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="userGender" title="Enter your gender" placeholder="M">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="currentCity" class="col-sm-2 control-label">Current City</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="currentCity" title="Enter your current city" placeholder="Boston">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="currentState" class="col-sm-2 control-label">Current State</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="currentState" title="Enter your current state" placeholder="MA">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="currentCountry" class="col-sm-2 control-label">Current Country</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="currentCountry" title="Enter your current country" placeholder="USA">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="homeCity" class="col-sm-2 control-label">Origin City</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="homeCity" title="Enter your origin city" placeholder="Aachen">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="homeState" class="col-sm-2 control-label">Origin
	       State</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="homeState" title="Enter your origin state"
	       placeholder="Nordrhein-Westphalen">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="homeCountry" class="col-sm-2 control-label">Origin
	       Country</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="homeCountry" title="Enter your origin country"
	       placeholder="Germany">
	       </div>
	  </div>
          <div class="form-group">
	       <label for="schoolName" class="col-sm-2 control-label">University</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="schoolName" title="Enter your University"
	       placeholder="Boston University">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="schoolMajor" class="col-sm-2 control-label">Major</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="schoolMajor" title="Enter your Major"
	       placeholder="Computer Engineering">
	       </div>
	  </div>

          <div class="form-group">
	       <label for="schoolYear" class="col-sm-2 control-label">Class
	       Year</label>
	       <div class="col-sm-10">
	       	    <input type="text" class="center-block form-control
	       input-lg" name="schoolYear" title="Enter your Year"
	       placeholder="2015">
	       </div>
	  </div>

	  <button class="btn btn-lg btn-primary" type="submit" value="Create"/>Create User</button>    
  	 </form>
  	 <a class="btn btn-lg btn-info" href="index.jsp" role="button">Home</a>
     </form>
</div>
<!-- 
<form action="newuser.jsp" method="post">
  Email: <input type="text" name="email"/><br>
  Password: <input type="password" name="password1"/><br>
  Re-enter password: <input type="password" name="password2"/><br>
  First Name: <input type="text" name="firstName"/><br>
  Last Name: <input type="text" name="lastName"/><br>
  Date Of Birth: <input type="text" name="dateOfBirth"/><br>
  Gender: <input type="text" name="userGender"/><br>
  Current City: <input type="text" name="currentCity"/><br>
  Current State: <input type="text" name="currentState"/><br>
  Current Country: <input type="text" name="currentCountry"/><br>
  Home City: <input type="text" name="homeCity"/><br>
  Home State: <input type="text" name="homeState"/><br>
  Home Country: <input type="text" name="homeCountry"/><br>
  University: <input type="text" name="schoolName"/><br>
  Major: <input type="text" name="schoolMajor"/><br>
  Class Year: <input type="text" name="schoolYear"/><br>
  <input type="submit" value="Create"/><br/>
</form>
-->

<% }
   else { %>

<h2>Success!</h2>

<p>A new user has been created with email <%= newUserBean.getEmail() %>.
You can now return to the <a href="login.jsp">login page</a>.

<% } %>

</body>
</html>
