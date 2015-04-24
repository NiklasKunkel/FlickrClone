package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.Picture;
import photoshare.PictureDao;
import photoshare.AlbumDao;
import org.apache.commons.fileupload.FileUploadException;
import java.util.List;

public final class showpictures_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      photoshare.ImageUploadBean imageUploadBean = null;
      synchronized (_jspx_page_context) {
        imageUploadBean = (photoshare.ImageUploadBean) _jspx_page_context.getAttribute("imageUploadBean", PageContext.PAGE_SCOPE);
        if (imageUploadBean == null){
          imageUploadBean = new photoshare.ImageUploadBean();
          _jspx_page_context.setAttribute("imageUploadBean", imageUploadBean, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("    ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("imageUploadBean"), request);
          out.write('\n');
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>All Photos</title>\n");
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
      out.write("<h1>Browse Pictures</h1>\n");
      out.write("\n");
      out.write("<p>\n");
      out.write("\t<a class=\"btn btn-md btn-success\" href=\"/photoshare/searchMyPicsbyTag.jsp\" role=\"button\">Search My Photos by Tag</a>\n");
      out.write("\t<a class=\"btn btn-md btn-success\" href=\"/photoshare/searchAllPicsbyTag.jsp\" role=\"button\">Search All Photos by Tag</a>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("<form action=\"showpictures.jsp\"  method=\"post\" >\n");
      out.write("\t\t<select name=\"albumname\">\n");
      out.write("\t\t\t\t\t<option value=all> All Albums </option>\n");
      out.write("\t\t  ");
    
			AlbumDao albumDao = new AlbumDao();
			List<String> albumList = albumDao.getAllalbums();
			if(!albumList.isEmpty()){
				for(String albumName: albumList){ 
      out.write("\n");
      out.write("\t\t\t\t\t<option value=");
      out.print( albumName);
      out.write('>');
      out.print( albumName);
      out.write(" </option>\n");
      out.write("\t\t  ");
 		}
			}
      out.write("\n");
      out.write("\t\t</select>\n");
      out.write("\t<input type=\"submit\" value=\"Select Album\"/><br/>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
 if(request.getParameter("albumname")!=null && request.getParameter("albumname").equals("all")) {
      out.write("\n");
      out.write("\t<h2>All Pictures</h2>\n");
      out.write("\t<table>\n");
      out.write("\t    <tr>\n");
      out.write("\t\t");

		    PictureDao pictureDao = new PictureDao();
		    List<Integer> pictureIds = pictureDao.allPicturesIds();
		    for (Integer pictureId : pictureIds) {
		
      out.write("\n");
      out.write("\t\t<td><a href=\"/photoshare/picture.jsp?id=");
      out.print( pictureId );
      out.write("\">\n");
      out.write("\t\t    <img src=\"/photoshare/img?t=1&picture_id=");
      out.print( pictureId );
      out.write("\" width=\"150\" height=auto class=\"img-rounded\"/>\n");
      out.write("\t\t</a>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");

		    }
		
      out.write("\n");
      out.write("\t    </tr>\n");
      out.write("\t</table>\n");
 } 
else if(request.getParameter("albumname")!=null) {
      out.write("\n");
      out.write("\t<h2>All Pictures</h2>\n");
      out.write("\t<table>\n");
      out.write("\t    <tr>\n");
      out.write("\t\t");

		    PictureDao pictureDao = new PictureDao();
		    int aid = albumDao.getAlbumID(request.getParameter("albumname"));
		    List<Integer> pictureIds = pictureDao.allPicturesforAlbum(aid);
		    int counter = 0;
		    for (Integer pictureId : pictureIds) {
		
      out.write("\n");
      out.write("\t\t<td><a href=\"/photoshare/picture.jsp?id=");
      out.print( pictureId );
      out.write("\">\n");
      out.write("\t\t    <img src=\"/photoshare/img?t=1&picture_id=");
      out.print( pictureId );
      out.write("\" width=\"150\" height=auto/>\n");
      out.write("\t\t</a>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t");

		    }
		
      out.write("\n");
      out.write("\t    </tr>\n");
      out.write("\t</table>\n");
 } 
      out.write("\n");
      out.write("<br>\n");
      out.write("<p><a class=\"btn btn-lg btn-info\" href=\"/photoshare/index.jsp\" role=\"button\">Return Home</a></p>\n");
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
