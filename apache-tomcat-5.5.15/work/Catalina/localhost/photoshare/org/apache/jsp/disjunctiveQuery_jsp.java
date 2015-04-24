package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.TagDao;
import java.util.List;
import java.util.ArrayList;

public final class disjunctiveQuery_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>You may also like</title>\n");
      out.write("\t<!-- Latest compiled and minified CSS -->\n");
      out.write("  \t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write(" \t <!-- Optional theme -->\n");
      out.write("  \t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("  \t<!-- Latest compiled and minified JavaScript -->\n");
      out.write("  \t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<h3>You may also like</h3>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("\t<td> Image\t</td>\n");
      out.write("\t<td> Points </td>\n");
      out.write("    </tr>\n");
      out.write("\t");

	    TagDao tagDao = new TagDao();
	    List<Integer> points = new ArrayList();
	    String email = request.getUserPrincipal().getName();
	    List<String> tags = tagDao.myTopTags(email);
	    List<Integer> pictureIds = tagDao.disjunctiveQuery(tags,points);
	    int i = 0;
	    for (Integer pictureId : pictureIds) {
	
      out.write("\n");
      out.write("    <tr>\n");
      out.write("\t<td><a href=\"/photoshare/picture.jsp?id=");
      out.print( pictureId );
      out.write("\">\n");
      out.write("\t    <img src=\"/photoshare/img?t=1&picture_id=");
      out.print( pictureId );
      out.write("\"/>\n");
      out.write("\t</a>\n");
      out.write("\t</td>\n");
      out.write("\t<td> ");
      out.print( points.get(i) );
      out.write(" </td>\n");
      out.write("    </tr>\n");
      out.write("\t");

	   i++; }
	
      out.write("\n");
      out.write("</table>\n");
      out.write("<br>\n");
      out.write("<p><a class=\"btn btn-lg btn-info\" href=\"/photoshare/index.jsp\" role=\"button\">Return Home</a></p>\n");
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
