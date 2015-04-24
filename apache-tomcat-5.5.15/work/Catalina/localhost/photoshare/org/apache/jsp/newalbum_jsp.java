package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.AlbumDao;

public final class newalbum_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      photoshare.Album album = null;
      synchronized (_jspx_page_context) {
        album = (photoshare.Album) _jspx_page_context.getAttribute("album", PageContext.PAGE_SCOPE);
        if (album == null){
          album = new photoshare.Album();
          _jspx_page_context.setAttribute("album", album, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("album"), request);
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <title>Create New Album</title></head>\n");
      out.write("    <!-- Latest compiled and minified CSS -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("  <!-- Optional theme -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("  <!-- Latest compiled and minified JavaScript -->\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("<body>\n");
      out.write("\n");
 boolean showForm = true;
   String err = null; 
      out.write('\n');
      out.write('\n');
 if (!album.getAname().equals("")) {
	AlbumDao albumDao = new AlbumDao();
   	boolean success=albumDao.create(request.getUserPrincipal().getName(),album.getAname());
	if(success){
		showForm = false;
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
      out.write("<h2>Create New Album</h2>\n");
      out.write("\n");
      out.write("<form action=\"newalbum.jsp\" method=\"post\">\n");
      out.write("  Album Name: <input type=\"text\" name=\"aname\"/><br>\n");
      out.write("  <input type=\"submit\" value=\"Create\"/><br/>\n");
      out.write("</form>\n");
      out.write("\n");
 }
   else { 
      out.write("\n");
      out.write("\n");
      out.write("<h2>Album created!</h2>\n");
      out.write("\n");
      out.write("<p>New album with name ");
      out.print( album.getAname() );
      out.write(" has been created!</p>\n");
      out.write("<p><a class=\"btn btn-lg btn-info\" href=\"/photoshare/index.jsp\" role=\"button\">Return Home</a></p>\n");
      out.write("\n");
 } 
      out.write("\n");
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
