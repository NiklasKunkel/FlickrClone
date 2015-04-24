package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.PictureDao;
import java.util.List;

public final class searchMyPicsbyTag_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>New User</title>\n");
      out.write("\t<!-- Latest compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("     <!-- Optional theme -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("    <!-- Latest compiled and minified JavaScript -->\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
 boolean showSearch = true; 
      out.write('\n');
      out.write('\n');
 if(request.getParameter("tag")!=null) {
      out.write("\n");
      out.write("\t<h2>Pictures based on the tag ");
      out.print( request.getParameter("tag") );
      out.write("</h2>\n");
      out.write("\t<table>\n");
      out.write("\t    <tr>\n");
      out.write("\t\t");

		    PictureDao pictureDao = new PictureDao();
		    List<Integer> pictureIds = pictureDao.myPicturesbyTag(request.getUserPrincipal().getName(),request.getParameter("tag"));
		    for (Integer pictureId : pictureIds) {
		
      out.write("\n");
      out.write("\t\t<td><a href=\"/photoshare/picture.jsp?id=");
      out.print( pictureId );
      out.write("\">\n");
      out.write("\t\t    <img src=\"/photoshare/img?t=1&picture_id=");
      out.print( pictureId );
      out.write("\" class=\"img-rounded\"/>\n");
      out.write("\t\t</a>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");

		    }
		
      out.write("\n");
      out.write("\t    </tr>\n");
      out.write("\t</table>\n");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
if (showSearch) {
      out.write("\n");
      out.write("\t<h2>Search My Own Photos by Tag(s)</h2>\n");
      out.write("\t<form action=\"searchMyPicsbyTag.jsp\" method=\"post\">\n");
      out.write("\t  Tag: <input type=\"text\" name=\"tag\"/><br>\n");
      out.write("\t  <input type=\"submit\" value=\"Search\"/><br/>\n");
      out.write("\t</form>\n");
 } 
      out.write("\n");
      out.write("\n");
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
