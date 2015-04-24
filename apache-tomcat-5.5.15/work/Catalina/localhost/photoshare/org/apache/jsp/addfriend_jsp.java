package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.FriendDao;

public final class addfriend_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      photoshare.Friend friend = null;
      synchronized (_jspx_page_context) {
        friend = (photoshare.Friend) _jspx_page_context.getAttribute("friend", PageContext.PAGE_SCOPE);
        if (friend == null){
          friend = new photoshare.Friend();
          _jspx_page_context.setAttribute("friend", friend, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("friend"), request);
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>New User</title>\n");
      out.write("\t<!-- Latest compiled and minified CSS -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\t<!-- <link href=\"http://getbootstrap.com/examples/signin/signin.css\" rel=\"stylesheet\"> -->\n");
      out.write("\t<!-- jQuery library -->\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("\t<!-- Latest compiled JavaScript -->\n");
      out.write("\t<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
 
Boolean success = false;
FriendDao friendDao = new FriendDao();
success = friendDao.createFriendship(friend.getFrienda(),friend.getFriendb());

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
if (success) {
      out.write("\n");
      out.write("\t<h2>Successfully created a friendship </h2>\n");
 }
else { 
      out.write("\n");
      out.write("\t<h2>ERROR couldn't create friendship</h2>\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("<a class=\"btn btn-lg btn-info\" href=\"/photoshare/index.jsp\" role=\"button\">Home</a>\n");
      out.write("<a class=\"btn btn-lg btn-warning\" href=\"/photoshare/search.jsp\" role=\"button\">Add Another Friend</a>\n");
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
