package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.TagDao;
import java.util.List;

public final class addtags_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Picture Tagger</title>\n");
      out.write("\t<!-- Latest compiled and minified CSS -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("\t<!-- Optional theme -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("\t<!-- Latest compiled and minified JavaScript -->\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("<h1>Picture Tagger</h1>\n");
      out.write("<p><a class=\"btn btn-lg btn-info\" href=\"/photoshare/index.jsp\" role=\"button\">Return Home</a></p>\n");
      out.write("<br>\n");
      out.write("<br>\n");
 boolean showForm = true; 
      out.write('\n');
 boolean showSucess = false; 
      out.write("\n");
      out.write("<p>Please enter the # of Tags you would like to create:</p>\n");
      out.write("<br>\n");

   if(request.getParameter("tag0")!=null){
	TagDao tagDao = new TagDao();	
	int pid = Integer.parseInt(request.getParameter("pid"));
	int numTags = Integer.parseInt(request.getParameter("numTagscreate"));
	for(int i = 0;i<numTags;i++){
		showForm = showForm && (tagDao.createTag(request.getParameter("tag"+i),pid));
	}
	showSucess = showForm;
	showForm = !showForm;
  } else if(request.getParameter("numTags")!=null && Integer.parseInt(request.getParameter("numTags"))>0){
      out.write("\n");
      out.write("\t<form action=\"addtags.jsp\"  method=\"post\" >\n");
      out.write("\t\t");
 showForm = false;
		for(int i = 0;i<Integer.parseInt(request.getParameter("numTags"));i++){
			String inputName = "tag" + i; 
      out.write("\n");
      out.write("\t\t\t");
      out.print( inputName );
      out.write(" : <input type=\"text\" name=");
      out.print( inputName );
      out.write("><br>\n");
      out.write("\t\t");
 } 
      out.write("\n");
      out.write("\t\t<input type=\"hidden\" value=");
      out.print( request.getParameter("id"));
      out.write(" name=\"pid\">\n");
      out.write("\t\t<input type=\"hidden\" value=");
      out.print( request.getParameter("numTags"));
      out.write(" name=\"numTagscreate\">\n");
      out.write("\t\t<input type=\"submit\" value=\"Create Tags\" name=\"numTagscreate\">\n");
      out.write("\t</form>\n");
 } 
      out.write('\n');
      out.write('\n');
 if(showForm){ 
      out.write("\n");
      out.write("<form action=\"addtags.jsp?id=");
      out.print( request.getParameter("id"));
      out.write("\"  method=\"post\" >\n");
      out.write("\t<input type=\"text\" name=\"numTags\">\n");
      out.write("\t<input type=\"submit\" value=\"Create Tags\">\n");
      out.write("\t<input type=\"hidden\" value=");
      out.print( request.getParameter("id"));
      out.write(" name=\"pid\">\n");
      out.write("</form>\n");
      out.write("\n");
 } 
if(showSucess){ 
      out.write("\n");
      out.write("\t<h3>Tag(s) Added!</h3>\n");
} 
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
