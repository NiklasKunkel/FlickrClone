package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.Picture;
import photoshare.PictureDao;
import photoshare.AlbumDao;
import photoshare.FriendDao;
import org.apache.commons.fileupload.FileUploadException;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      photoshare.Album album = null;
      synchronized (_jspx_page_context) {
        album = (photoshare.Album) _jspx_page_context.getAttribute("album", PageContext.PAGE_SCOPE);
        if (album == null){
          album = new photoshare.Album();
          _jspx_page_context.setAttribute("album", album, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("album"), request);
      out.write('\n');
      out.write('\n');
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
      out.write("  <title>Photo Sharing</title>\n");
      out.write("\n");
      out.write("  <!-- Latest compiled and minified CSS -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("  <!-- Optional theme -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("  <!-- Latest compiled and minified JavaScript -->\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div class=\"container-full\">\n");
      out.write("      \t     <div class=\"row\">\n");
      out.write("             \t  <div class=\"col-lg-12 text-center v-center\">\n");
      out.write("          \n");
      out.write("\t\t\t<h1>Slightly Less Cool Imgur</h1>\n");
      out.write("          \t\t<p class=\"lead\">Imgur > Flickr</p>\n");
      out.write("          \n");
      out.write("\t\t\t<br>\n");
      out.write("          \t\t<img src=\"http://i.imgur.com/bXvvN3t.png\" class=\"img-rounded\">\n");
      out.write("             \t<div class=\"header\">\n");
      out.write("    \t\t     Hi there <b><code>");
      out.print( request.getUserPrincipal().getName()  );
      out.write("</code></b>!\n");
      out.write("    \t\t     <p>Wrong User?</p>\n");
      out.write("    \t\t     <p><a href=\"/photoshare/logout.jsp\" class=\"btn btn-info\" role=\"button\">Log Out</a></p>\n");
      out.write("  \t\t</div>  \t  \n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("             </div> <!-- /row -->\n");
      out.write("\n");
      out.write("\t </div> <!-- /container full -->\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("  \n");
      out.write("  \t<hr>\n");
      out.write("  \n");
      out.write("  \t<div class=\"row\">\n");
      out.write("        <div class=\"col-md-4\">\n");
      out.write("          <div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\"><h3>Tags</h3></div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\t    \t <h2>Power Users</h2>\n");
      out.write("      \t\t <a href=\"topusers.jsp\" class=\"btn btn-info\" role=\"button\">View</a>\n");
      out.write("\n");
      out.write("      \t\t <h2>Trending Tags</h2>\n");
      out.write("      \t\t <a href=\"toptags.jsp\" class=\"btn btn-info\" role=\"button\">View</a>\n");
      out.write("\n");
      out.write("      \t\t <h2>Disjunctive Tag Search</h2>\n");
      out.write("      \t\t <a href=\"disjunctiveQuery.jsp\" class=\"btn btn-info\" role=\"button\">Search</a>\n");
      out.write("\n");
      out.write("      \t\t <h2>Conjective Tag Search</h2>\n");
      out.write("      \t\t <a href=\"conjunctiveQuery.jsp\" class=\"btn btn-info\" role=\"button\">Search</a>\t    \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      \t<div class=\"col-md-4\">\n");
      out.write("        \t<div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\"><h3>Create</h3></div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\t    \t <h2>Upload a new picture</h2>\n");
      out.write("\n");
      out.write("      \t\t <form action=\"index.jsp\" enctype=\"multipart/form-data\" method=\"post\" id=\"uploadImage\">\n");
      out.write("        \t       Filename: <input type=\"file\" name=\"filename\"/>\n");
      out.write("\t\t       Caption: <input type=\"text\" name=\"caption\" placeholder=\"caption\"/>\n");
      out.write("      \t\t       <button type=\"submit\" value=\"Upload\" class=\"btn btn-info\"/>Upload</button><br/>\n");
      out.write("      \t\t</form>\n");
      out.write("\n");
      out.write("      \t\t");

      		PictureDao pictureDao = new PictureDao();
      		AlbumDao albumDao = new AlbumDao();
      		try {
       		    Picture picture = imageUploadBean.upload(request);
        	    if (picture != null) {
          	       int aid = albumDao.getAlbumID(picture.getAlbumname());
          	       pictureDao.save(picture,aid);
        	       }
      		 } catch (FileUploadException e) {
        	   	 e.printStackTrace();
      		 }
      		 
      out.write("\n");
      out.write("\n");
      out.write("      \t\t <select name=\"albumname\" form=\"uploadImage\">\n");
      out.write("      \t\t ");
    
        	 List<String> albumList = albumDao.getAlbums(request.getUserPrincipal().getName());
        	 if(!albumList.isEmpty()){
			for(String albumName: albumList){ 
      out.write("\n");
      out.write("            \t\t\t   <option value=");
      out.print( albumName);
      out.write('>');
      out.print( albumName);
      out.write(" </option>\n");
      out.write("          \t\t\t   ");
 }
        		}
      		
      out.write("\n");
      out.write("      \t\t</select>\n");
      out.write("\n");
      out.write("      \t\t");
 boolean showForm = true;
      		String err = null; 
      out.write("\n");
      out.write("\n");
      out.write("      \t\t");
 if (!album.getAname().equals("")) {
        	      AlbumDao albumDaoX = new AlbumDao();
        	      boolean success=albumDaoX.create(request.getUserPrincipal().getName(),album.getAname());
        	      if(success){
				showForm = false;
        		}
		}
      		
      out.write("\n");
      out.write("\n");
      out.write("      \t\t");
 if (err != null) { 
      out.write("\n");
      out.write("        \t<font color=red><b>Error: ");
      out.print( err );
      out.write("</b></font>\n");
      out.write("      \t\t");
 } 
      out.write("\n");
      out.write("\n");
      out.write("      \t\t");
 if (showForm) { 
      out.write("\n");
      out.write("\n");
      out.write("        \t<h2>Create New Album</h2>\n");
      out.write("\n");
      out.write("        \t<form action=\"newalbum.jsp\" method=\"post\">\n");
      out.write("          \t      Album Name: <input type=\"text\" name=\"aname\"/><br>\n");
      out.write("          \t      <button type=\"submit\" value=\"Create\" class=\"btn btn-info\"/>Create</button><br/>\n");
      out.write("        \t</form>\n");
      out.write("\n");
      out.write("      \t\t");
 }
      		else { 
      out.write("\n");
      out.write("\n");
      out.write("        \t<h2>Album created!</h2>\n");
      out.write("\n");
      out.write("        \t<p>New album with name ");
      out.print( album.getAname() );
      out.write(" has been created!</p>\n");
      out.write("        \t<p><a href=\"index.jsp\">Return to Home Page</a></p>\n");
      out.write("\n");
      out.write("      \t\t");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("      \t\t<h2>Delete Album</h2>\n");
      out.write("      \t\t<form action=\"index.jsp\" method=\"post\">\n");
      out.write("      \t\t<input type=\"text\" name=\"albumDelete\">\n");
      out.write("      \t\t<button type=\"submit\" value=\"Delete\" class=\"btn btn-info\">Delete</button>\n");
      out.write("      \t\t</form>\n");
      out.write("\n");
      out.write("      \t\t");
 if(request.getParameter("albumDelete")!=null){
        	boolean doneDelete = albumDao.delete(request.getParameter("albumDelete"));  
        	if(doneDelete){
      out.write("\n");
      out.write("          \t<h2>Delete Successful </h2>\n");
      out.write("      \t\t");
}}
      out.write("\n");
      out.write("\t    \n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      \t<div class=\"col-md-4\">\n");
      out.write("        \t<div class=\"panel panel-default\">\n");
      out.write("            <div class=\"panel-heading\"><h3>Social</h3></div>\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("\t         <h2>View Photos</h2>\n");
      out.write("      \t\t <a href=\"showpictures.jsp\" class=\"btn btn-info\" role=\"button\">Browse Pictures</a>\n");
      out.write("\n");
      out.write("      \t\t <h2>Friends</h2>\n");
      out.write("      \t\t <a href=\"/photoshare/listfriends.jsp\" class=\"btn btn-info\" role=\"button\">List All</a>\n");
      out.write("\n");
      out.write("     \t\t  <h2>Search and Add Friends</h2>\n");
      out.write("      \t\t  <a href=\"/photoshare/search.jsp\" class=\"btn btn-info\" role=\"button\">Search</a>\n");
      out.write("\n");
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
