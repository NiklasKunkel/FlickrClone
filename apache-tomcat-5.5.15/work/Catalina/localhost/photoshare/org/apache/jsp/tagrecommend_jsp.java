package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.TagDao;
import java.util.List;
import java.util.Arrays;

public final class tagrecommend_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Recommend Tags</title>\n");
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
      out.write("<h1>Tag Recommendation Engine</h1>\n");
      out.write("<h3>Enter in some existing tags, and we'll suggest new ones!</h3>\n");
      out.write("\n");
 boolean showForm = true; 
List<String> results = null;
      out.write('\n');
      out.write('\n');

   if(request.getParameter("listtags")!=null){
	TagDao tagDao = new TagDao();	
	List<String> taglist = Arrays.asList(request.getParameter("listtags").split("\\s+"));	
	results = tagDao.recommendTags(taglist);
	showForm = false;
 } 
      out.write('\n');
      out.write('\n');
 if(showForm){ 
      out.write("\n");
      out.write("<form action=\"tagrecommend.jsp?id=");
      out.print( request.getParameter("id"));
      out.write("\"  method=\"post\" >\n");
      out.write("\t<input type=\"text\" name=\"listtags\"> <br>\n");
      out.write("\t<button type=\"submit\" value=\"Recommend Some Tags\" class=\"btn btn-lg\n");
      out.write("\tbtn-primary\">Recommend Some Tags</button>\n");
      out.write("\t<input type=\"hidden\" value=");
      out.print( request.getParameter("id"));
      out.write(" name=\"pid\">\n");
      out.write("</form>\n");
 } 
else{ 
      out.write('\n');
      out.write('	');
 if(results!=null){for(String result: results){ 
      out.write("\n");
      out.write("\t\t<h2> ");
      out.print( result );
      out.write(" </h2>\n");
      out.write("\t");
} }
      out.write('\n');
} 
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
