package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("﻿<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\" dir=\"ltr\">\n");
      out.write("<head >\n");
      out.write("\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /><title>\n");
      out.write("\n");
      out.write("    Welcome To Website.\n");
      out.write("\n");
      out.write("</title><link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("  <!--[if IE 6]><link rel=\"stylesheet\" href=\"style.ie6.css\" type=\"text/css\" media=\"screen\" /><![endif]-->\n");
      out.write("  <!--[if IE 7]><link rel=\"stylesheet\" href=\"style.ie7.css\" type=\"text/css\" media=\"screen\" /><![endif]-->\n");
      out.write("\n");
      out.write("  <script type=\"text/javascript\" src=\"jquery.js\"></script>\n");
      out.write("  <script type=\"text/javascript\" src=\"script.js\"></script>\n");
      out.write("  </head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"art-page-background-glare-wrapper\">\n");
      out.write("    <div id=\"art-page-background-glare\"></div>\n");
      out.write("</div>\n");
      out.write("<div id=\"art-main\">\n");
      out.write("    <div class=\"cleared reset-box\"></div>\n");
      out.write("<div class=\"art-header\">\n");
      out.write("<div class=\"art-header-position\">\n");
      out.write("    <div class=\"art-header-wrapper\">\n");
      out.write("        <div class=\"cleared reset-box\"></div>\n");
      out.write("        <div class=\"art-header-inner\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"art-headerobject\"></div>\n");
      out.write("<div class=\"art-logo\">\n");
      out.write("        <h1 class=\"art-logo-name\"><a>Book Store</a></h1>\n");
      out.write("            <h2 class=\"art-logo-text\">Reading, Thinking, Feeling.</h2>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<div class=\"cleared reset-box\"></div>\n");
      out.write("<div class=\"art-box art-sheet\">\n");
      out.write("    <div class=\"art-box-body art-sheet-body\">\n");
      out.write("<div class=\"art-bar art-nav\">\n");
      out.write("<div class=\"art-nav-outer\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<ul class=\"art-hmenu\">\n");
      out.write("    <li><a href=\"#\" class=\" active\"><span class=\"l\"></span><span class=\"r\"></span><span class=\"t\">Home</span></a></li>\n");
      out.write("    <li><a href=\"#\"><span class=\"l\"></span><span class=\"r\"></span><span class=\"t\">Menu Item</span></a>\n");
      out.write("        <ul>\n");
      out.write("\t\t    <li><a href=\"#\">Menu Subitem 1</a></li>\n");
      out.write("\t\t    <li><a href=\"#\">Menu Subitem 2</a></li>\n");
      out.write("\t\t    <li><a href=\"#\">Menu Subitem 3</a></li>\n");
      out.write("\t    </ul>\n");
      out.write("    </li>\n");
      out.write("    <li><a href=\"#\"><span class=\"l\"></span><span class=\"r\"></span><span class=\"t\">About</span></a></li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"cleared reset-box\"></div>\n");
      out.write("<div class=\"art-layout-wrapper\">\n");
      out.write("    <div class=\"art-content-layout\">\n");
      out.write("        <div class=\"art-content-layout-row\">\n");
      out.write("\n");
      out.write("<div class=\"art-layout-cell art-content\">\n");
      out.write("    <table><tr height=\"600\"><td></td></tr></table>\n");
      out.write("</div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"cleared\"></div>\n");
      out.write("\n");
      out.write("<div class=\"art-footer\">\n");
      out.write("    <div class=\"art-footer-body\">\n");
      out.write("                <div class=\"art-footer-text\">\n");
      out.write("<!--p><a href=\"\">Home</a> | <a href=\"\">About</a> | <a href=\"\">Site Map</a></p-->\n");
      out.write("\n");
      out.write("<p>Copyright © 2012. All Rights Reserved.</p>\n");
      out.write("\n");
      out.write("<p>&nbsp;</p>\n");
      out.write("\n");
      out.write("<p>&nbsp;</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("        <div class=\"cleared\"></div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"cleared\"></div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"cleared\"></div>\n");
      out.write("</div>\n");
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
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
