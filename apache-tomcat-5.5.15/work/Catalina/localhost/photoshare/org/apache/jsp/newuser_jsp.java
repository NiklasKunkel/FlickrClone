package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.NewUserDao;

public final class newuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      photoshare.NewUserBean newUserBean = null;
      synchronized (_jspx_page_context) {
        newUserBean = (photoshare.NewUserBean) _jspx_page_context.getAttribute("newUserBean", PageContext.PAGE_SCOPE);
        if (newUserBean == null){
          newUserBean = new photoshare.NewUserBean();
          _jspx_page_context.setAttribute("newUserBean", newUserBean, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("newUserBean"), request);
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>New User</title>\n");
      out.write("\t<!-- Latest compiled and minified CSS -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("\t<!-- Optional theme -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("\t<!-- Latest compiled and minified JavaScript -->\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<!-- We want to show the form unless we successfully create a new user -->\n");
 boolean showForm = true;
   String err = null; 
      out.write('\n');
      out.write('\n');
 if (!newUserBean.getEmail().equals("")) {
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

      out.write('\n');
      out.write('\n');
 if (err != null) { 
      out.write("\n");
      out.write("<font color=red><b>Error: ");
      out.print( err );
      out.write("</b></font>\n");
 } 
      out.write('\n');
      out.write('\n');
 if (showForm) { 
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("     <h2 class=\"form-signin-heading\">Enter your Information</h2>\n");
      out.write("\n");
      out.write("     <form class=\"form-horizontal\" action=\"newuser.jsp\" method=\"post\">\n");
      out.write("\t  <div class=\"form-group\">\n");
      out.write("\t       <label for=\"email\" class=\"col-sm-2 control-label\">Email</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control input-lg\" name=\"email\" title=\"Enter your email\" placeholder=\"nkunkel@bu.edu\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write(" \t  <div class=\"form-group\">\n");
      out.write("\t       <label for=\"password1\" class=\"col-sm-2 control-label\">Password</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"password\" class=\"center-block form-control\n");
      out.write("\t  input-lg\" name=\"password1\" title=\"Enter your password\" placeholder=\"password\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("  \t  <div class=\"form-group\">\n");
      out.write("\t       <label for=\"password2\" class=\"col-sm-2 control-label\">Re-Enter Password</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"password\" class=\"center-block form-control\n");
      out.write("\t  input-lg\" name=\"password2\" title=\"Re-enter your password\" placeholder=\"password\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("    \t  <div class=\"form-group\">\n");
      out.write("\t       <label for=\"firstName\" class=\"col-sm-2 control-label\">First Name</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t  input-lg\" name=\"firstName\" title=\"First Name\" placeholder=\"Nik\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("  \t  <div class=\"form-group\">\n");
      out.write("\t       <label for=\"lastName\" class=\"col-sm-2 control-label\">Last Name</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t  input-lg\" name=\"lastName\" title=\"Last Name\" placeholder=\"Kunkel\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write(" \t  <div class=\"form-group\">\n");
      out.write("\t       <label for=\"dateOfBirth\" class=\"col-sm-2 control-label\">DoB</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t  input-lg\" name=\"dateOfBirth\" title=\"Enter your birthday\" placeholder=\"06/25/1991\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("\t  <div class=\"form-group\">\n");
      out.write("\t       <label for=\"userGender\" class=\"col-sm-2 control-label\">Gender</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"userGender\" title=\"Enter your gender\" placeholder=\"M\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"currentCity\" class=\"col-sm-2 control-label\">Current City</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"currentCity\" title=\"Enter your current city\" placeholder=\"Boston\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"currentState\" class=\"col-sm-2 control-label\">Current State</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"currentState\" title=\"Enter your current state\" placeholder=\"MA\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"currentCountry\" class=\"col-sm-2 control-label\">Current Country</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"currentCountry\" title=\"Enter your current country\" placeholder=\"USA\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"homeCity\" class=\"col-sm-2 control-label\">Origin City</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"homeCity\" title=\"Enter your origin city\" placeholder=\"Aachen\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"homeState\" class=\"col-sm-2 control-label\">Origin\n");
      out.write("\t       State</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"homeState\" title=\"Enter your origin state\"\n");
      out.write("\t       placeholder=\"Nordrhein-Westphalen\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"homeCountry\" class=\"col-sm-2 control-label\">Origin\n");
      out.write("\t       Country</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"homeCountry\" title=\"Enter your origin country\"\n");
      out.write("\t       placeholder=\"Germany\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"schoolName\" class=\"col-sm-2 control-label\">University</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"schoolName\" title=\"Enter your University\"\n");
      out.write("\t       placeholder=\"Boston University\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"schoolMajor\" class=\"col-sm-2 control-label\">Major</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"schoolMajor\" title=\"Enter your Major\"\n");
      out.write("\t       placeholder=\"Computer Engineering\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("\t       <label for=\"schoolYear\" class=\"col-sm-2 control-label\">Class\n");
      out.write("\t       Year</label>\n");
      out.write("\t       <div class=\"col-sm-10\">\n");
      out.write("\t       \t    <input type=\"text\" class=\"center-block form-control\n");
      out.write("\t       input-lg\" name=\"schoolYear\" title=\"Enter your Year\"\n");
      out.write("\t       placeholder=\"2015\">\n");
      out.write("\t       </div>\n");
      out.write("\t  </div>\n");
      out.write("\n");
      out.write("\t  <button class=\"btn btn-lg btn-primary\" type=\"submit\" value=\"Create\"/>Create User</button>    \n");
      out.write("  \t </form>\n");
      out.write("  \t <a class=\"btn btn-lg btn-info\" href=\"index.jsp\" role=\"button\">Home</a>\n");
      out.write("     </form>\n");
      out.write("</div>\n");
      out.write("<!-- \n");
      out.write("<form action=\"newuser.jsp\" method=\"post\">\n");
      out.write("  Email: <input type=\"text\" name=\"email\"/><br>\n");
      out.write("  Password: <input type=\"password\" name=\"password1\"/><br>\n");
      out.write("  Re-enter password: <input type=\"password\" name=\"password2\"/><br>\n");
      out.write("  First Name: <input type=\"text\" name=\"firstName\"/><br>\n");
      out.write("  Last Name: <input type=\"text\" name=\"lastName\"/><br>\n");
      out.write("  Date Of Birth: <input type=\"text\" name=\"dateOfBirth\"/><br>\n");
      out.write("  Gender: <input type=\"text\" name=\"userGender\"/><br>\n");
      out.write("  Current City: <input type=\"text\" name=\"currentCity\"/><br>\n");
      out.write("  Current State: <input type=\"text\" name=\"currentState\"/><br>\n");
      out.write("  Current Country: <input type=\"text\" name=\"currentCountry\"/><br>\n");
      out.write("  Home City: <input type=\"text\" name=\"homeCity\"/><br>\n");
      out.write("  Home State: <input type=\"text\" name=\"homeState\"/><br>\n");
      out.write("  Home Country: <input type=\"text\" name=\"homeCountry\"/><br>\n");
      out.write("  University: <input type=\"text\" name=\"schoolName\"/><br>\n");
      out.write("  Major: <input type=\"text\" name=\"schoolMajor\"/><br>\n");
      out.write("  Class Year: <input type=\"text\" name=\"schoolYear\"/><br>\n");
      out.write("  <input type=\"submit\" value=\"Create\"/><br/>\n");
      out.write("</form>\n");
      out.write("-->\n");
      out.write("\n");
 }
   else { 
      out.write("\n");
      out.write("\n");
      out.write("<h2>Success!</h2>\n");
      out.write("\n");
      out.write("<p>A new user has been created with email ");
      out.print( newUserBean.getEmail() );
      out.write(".\n");
      out.write("You can now return to the <a href=\"login.jsp\">login page</a>.\n");
      out.write("\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
