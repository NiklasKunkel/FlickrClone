package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Photoshare Login</title>\n");
      out.write("\n");
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
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<h2 class=\"form-signin-heading\">Please login</h2>\n");
      out.write("\n");
      out.write("\t\t<form method=\"POST\" action=\"j_security_check\" class=\"form-signin\">\n");
      out.write("\t\t\t<label class=\"sr-only\" for=\"inputEmail\">Email</label>\n");
      out.write("\t\t\t<input type=\"email\" name=\"j_username\" id=\"inputEmail\" class=\"form-control\" placeholder=\"Email Address\" required autofocus>\n");
      out.write("\n");
      out.write("\t\t\t<label class=\"sr-only\" for=\"inputPassword\">Password</label>\n");
      out.write("\t\t\t<input type=\"password\" name=\"j_password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\n");
      out.write("\n");
      out.write("\t\t\t<button class=\"btn btn-md btn-info\" type=\"submit\"\n");
      out.write("\t\t\tvalue=\"Login\"/>Log In</button>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<form class=\"form-signin\" method=\"GET\" action=\"j_security_check\">\n");
      out.write("\t\t\t<a class=\"btn btn-md btn-success\" href=\"newuser.jsp\" role=\"button\">Register</a>\n");
      out.write("     \t\t\t<a class=\"btn btn-md btn-warning\" href=\"showpictures.jsp\" role=\"button\">Go Incognito</a>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
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
