package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newbook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tl_forEach_var_items;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_tl_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_tl_forEach_var_items.release();
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
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\" dir=\"ltr\">\n");
      out.write("<head >\n");
      out.write("\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /><title>\n");
      out.write("\n");
      out.write("    Welcome To Website.\n");
      out.write("\n");
      out.write("</title><link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("  <!--[if IE 6]><link rel=\"stylesheet\" href=\"css/style.ie6.css\" type=\"text/css\" media=\"screen\" /><![endif]-->\n");
      out.write("  <!--[if IE 7]><link rel=\"stylesheet\" href=\"css/style.ie7.css\" type=\"text/css\" media=\"screen\" /><![endif]-->\n");
      out.write("\n");
      out.write("  <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("  <script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
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
      out.write("        <h1 class=\"art-logo-name\"><a>Book Library</a></h1>\n");
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
      out.write(" <form id=\"form1\" name=\"form1\" method=\"post\" action=\"AddBook\">\n");
      out.write("    <table width=\"800\" border=\"1\">\n");
      out.write("  <tr>\n");
      out.write("    <td colspan=\"3\">Add new book</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td width=\"167\">Name book</td>\n");
      out.write("    <td width=\"357\">\n");
      out.write("      <input type=\"text\" name=\"txtName\" id=\"txtName\" width=\"357\"/>\n");
      out.write("    </td>\n");
      out.write("    <td width=\"254\">&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>Author</td>\n");
      out.write("    <td>\n");
      out.write("      <input type=\"text\" name=\"txtAuthor\" id=\"txtAuthor\" width=\"357\"/>\n");
      out.write("   </td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>Publisher</td>\n");
      out.write("    <td>\n");
      out.write("      <input type=\"text\" name=\"txtPublisher\" id=\"txtPublisher\" />\n");
      out.write("    </td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>Year</td>\n");
      out.write("    <td>\n");
      out.write("      <input type=\"text\" name=\"txtYear\" id=\"txtYear\" />\n");
      out.write("    </td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>Description</td>\n");
      out.write("    <td>\n");
      out.write("      <input type=\"text\" name=\"txtDesc\" id=\"txtDesc\" />\n");
      out.write("   </td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>Category</td>\n");
      out.write("    <td>\n");
      out.write("      <select name=\"txtCateID\" id=\"txtCateID\">\n");
      out.write("         ");
      if (_jspx_meth_tl_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("      </select>\n");
      out.write("    </td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("    <td>\n");
      out.write("      <input type=\"submit\" name=\"txtSubmit\" id=\"txtSubmit\" value=\"Submit\" />\n");
      out.write("      <input type=\"reset\" name=\"txtClear\" id=\"txtClear\" value=\"Reset\" />\n");
      out.write("   </td>\n");
      out.write("    <td>&nbsp;</td>\n");
      out.write("  </tr>\n");
      out.write("</table> </form>\n");
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

  private boolean _jspx_meth_tl_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tl:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_tl_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_tl_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_tl_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_tl_forEach_0.setParent(null);
    _jspx_th_tl_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ sessionScope.list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_tl_forEach_0.setVar("s");
    int[] _jspx_push_body_count_tl_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_tl_forEach_0 = _jspx_th_tl_forEach_0.doStartTag();
      if (_jspx_eval_tl_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("          <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.cateID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${s.cateName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("         ");
          int evalDoAfterBody = _jspx_th_tl_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_tl_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_tl_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_tl_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_tl_forEach_0.doFinally();
      _jspx_tagPool_tl_forEach_var_items.reuse(_jspx_th_tl_forEach_0);
    }
    return false;
  }
}
