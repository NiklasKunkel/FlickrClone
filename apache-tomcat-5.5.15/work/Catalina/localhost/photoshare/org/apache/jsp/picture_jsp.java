package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.CommentDao;
import photoshare.LikeDao;
import photoshare.PictureDao;
import org.apache.commons.fileupload.FileUploadException;
import java.util.List;

public final class picture_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\t<title>View Photo</title>\n");
      out.write("\n");
      out.write("\t<!-- Latest compiled and minified CSS -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("\t<!-- Optional theme -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("\t<!-- Latest compiled and minified JavaScript -->\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("\t<script>\n");
      out.write("\t\t.row {\n");
      out.write("   \t      \t     display: table;\n");
      out.write("\t \t }\n");
      out.write("\n");
      out.write("\t\t .row [class*=\"col-\"] {\n");
      out.write("    \t\t float: none;\n");
      out.write("    \t\t display: table-cell;\n");
      out.write("    \t\t vertical-align: top;\n");
      out.write("\t\t }\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"container-full\">\n");
      out.write("\n");
      out.write("      <div class=\"row\">\n");
      out.write("       \n");
      out.write("        <div class=\"col-lg-12 text-center v-center\">\n");
      out.write("          \n");
      out.write("          <h1>Photo</h1>\n");
      out.write("\n");
      out.write("          ");
  
			PictureDao pictureDao = new PictureDao(); 
			int pictureId = Integer.valueOf(request.getParameter("id"));
			LikeDao likeDao = new LikeDao();
			String caption = pictureDao.getCaption(pictureId);
	  
      out.write("\n");
      out.write("\t  <p class=\"lead\">Picture ID = ");
      out.print( pictureId );
      out.write("</p>\n");
      out.write("           <img src=\"/photoshare/img?picture_id=");
      out.print( pictureId );
      out.write("\" width=auto height=\"400\" class=\"img-rounded\"/>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("      </div> <!-- /row -->\n");
      out.write("  \n");
      out.write("  \t  <div class=\"row\">\n");
      out.write("       \n");
      out.write("        <div class=\"col-lg-12 text-center v-center\">\n");
      out.write("\t\t\n");
      out.write("\t\t<p class=\"lead\">Caption: ");
      out.print( caption );
      out.write("</p>\n");
      out.write("\n");
      out.write("\t\t<form action=\"removepic.jsp?id=");
      out.print( request.getParameter("id"));
      out.write("\" method =\"post\">\n");
      out.write("\t\t      <input type=\"submit\" value=\"Remove Photo\">\n");
      out.write("\t\t</form>\n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("</div> <!-- /container full -->\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("  \n");
      out.write("  \t<hr>\n");
      out.write("  \n");
      out.write("  \t<div class=\"row\">\n");
      out.write("        <div class=\"col-md-4\">\n");
      out.write("          <div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\"><h3>Stats</h3></div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("\t    \t    \t<h2>Number of Likes</h2>\n");
      out.write("\t\t\t");
      out.print( likeDao.numLiked(pictureId));
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<h2>Like this picture</h2>\n");
      out.write("\t\t\t<form action=\"picture.jsp?id=");
      out.print( request.getParameter("id"));
      out.write("&doLike=true\" method =\"post\">\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"LIKE PHOTO\">\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t");
 if(request.getParameter("doLike")!=null){
				boolean createdLike = false;	
				createdLike = likeDao.createLike(request.getUserPrincipal().getName(),pictureId);
					if(createdLike){ 
      out.write("\t\n");
      out.write("\t\t\t\t\tLIKED PHOTO\n");
      out.write("\t\t\t");
}} 
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<h2>Who liked this picture</h2>\n");
      out.write("\t\t\t");
 for(String wholike: likeDao.whoLiked(pictureId)){ 
      out.write("\n");
      out.write("\t\t\t");
      out.print(wholike);
      out.write("<br>\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t<br>\n");
      out.write("\n");
      out.write("\t  \t</div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      \t<div class=\"col-md-4\">\n");
      out.write("        \t<div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\"><h3>Social</h3></div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("\t    \t<h2>Add Comments</h2>\n");
      out.write("\t\t<form action=\"picture.jsp?id=");
      out.print( request.getParameter("id") );
      out.write("\" method=\"post\">\n");
      out.write("\t\t\tComment: <input type=\"text\" name=\"comment\"/><br>\n");
      out.write("\t\t\t<input type=\"submit\" value=\"Submit\">\t\n");
      out.write("\t\t</form>\n");
      out.write("\n");
      out.write("\t\t");
 
			CommentDao commentDao = new CommentDao();
			Boolean success = false;
			if(request.getParameter("comment")!=null){
				int pid = Integer.parseInt(request.getParameter("id"));
				if(request.getUserPrincipal()!=null)
					success = commentDao.create(request.getUserPrincipal().getName(),request.getParameter("comment"),pid);	
			else
				success = commentDao.create("ANONYMOUS",request.getParameter("comment"),pid);
			}
			if(success){
      out.write("\n");
      out.write("\t\t<h3>Successfully added comment</h3>\n");
      out.write("\t\t");
}
      out.write("\n");
      out.write("\n");
      out.write("\t\t<h2>Comments</h2>\n");
      out.write("\t\t");

			if(request.getParameter("id")!=null){
				int pid2 = Integer.parseInt(request.getParameter("id"));
				List<String> comments = commentDao.getAllComments(pid2);	
				for(String comment: comments){ 
      out.write("\n");
      out.write("\t\t\t\t\t");
      out.print( comment);
      out.write(" <br><br>\n");
      out.write("\t\t\t\t");
 	}
		}
      out.write("\n");
      out.write("\n");
      out.write("\t    </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      \t<div class=\"col-md-4\">\n");
      out.write("        \t<div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\"><h3>Tags</h3></div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\t    \t<h2>Add Tags</h2>\n");
      out.write("\t\t<a href=\"/photoshare/addtags.jsp?id=");
      out.print( pictureId );
      out.write("\"\n");
      out.write("          class=\"btn btn-md btn-primary\" role=\"button\">Add</a>\n");
      out.write("\n");
      out.write("\t\t<h2>Recommend Me Tags</h2>\n");
      out.write("\t\t<a href=\"/photoshare/tagrecommend.jsp?id=");
      out.print( pictureId
		);
      out.write("\" class=\"btn btn-md btn-info\" role=\"button\">Recommend</a>\n");
      out.write("\t\t\n");
      out.write("\t\t<h2>Navigation</h2>\n");
      out.write("\t\t<p><a class=\"btn btn-md btn-warning\"\n");
      out.write("\t\thref=\"/photoshare/showpictures.jsp\" role=\"button\">View All Pics</a>\n");
      out.write("\t\t<a class=\"btn btn-md btn-info\" href=\"/photoshare/index.jsp\" role=\"button\">Home</a></p>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("  \n");
      out.write("\t<div class=\"row\">\n");
      out.write("        <div class=\"col-lg-12\">\n");
      out.write("        <br><br>\n");
      out.write("          <p class=\"pull-right\">Flickr Clone - Niklas Kunkel</p>\n");
      out.write("        <br><br>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
