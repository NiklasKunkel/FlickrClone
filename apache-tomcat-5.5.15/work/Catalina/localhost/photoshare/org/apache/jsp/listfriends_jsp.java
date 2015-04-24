package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.FriendDao;
import java.util.List;

public final class listfriends_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Friend List</title></head>\n");
      out.write("    <!-- Latest compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("     <!-- Optional theme -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("    <!-- Latest compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("<body>\n");
      out.write("\n");
 
FriendDao friendDao = new FriendDao();
int numFriend = 0;

      out.write("\n");
      out.write("\n");
      out.write("<h2>Friend List</h2>\n");
      out.write("<table border=\"1\">\n");
      out.write("        ");

            List<String> friends = friendDao.getFriends(request.getUserPrincipal().getName());
            for (String friend : friends) {
            numFriend++;
        
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>\n");
      out.write("\t\tFriend #");
      out.print( numFriend );
      out.write(' ');
      out.write(':');
      out.write(' ');
      out.print( friend );
      out.write("\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("</table>\n");
      out.write("<br>\n");
      out.write("<p><a class=\"btn btn-lg btn-info\" href=\"/photoshare/index.jsp\" role=\"button\">Return Home</a></p>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
