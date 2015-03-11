package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class default_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/tlds/AssignmentTagLib.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_co_if_test_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_NewTagHandler;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_co_if_test_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_NewTagHandler = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_co_if_test_nobody.release();
    _jspx_tagPool_c_NewTagHandler.release();
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");
      if (_jspx_meth_co_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_NewTagHandler_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_co_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  co:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_co_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_co_if_test_nobody.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_co_if_0.setPageContext(_jspx_page_context);
    _jspx_th_co_if_0.setParent(null);
    _jspx_th_co_if_0.setTest(false);
    int _jspx_eval_co_if_0 = _jspx_th_co_if_0.doStartTag();
    if (_jspx_th_co_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_co_if_test_nobody.reuse(_jspx_th_co_if_0);
      return true;
    }
    _jspx_tagPool_co_if_test_nobody.reuse(_jspx_th_co_if_0);
    return false;
  }

  private boolean _jspx_meth_c_NewTagHandler_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:NewTagHandler
    apk.NewTagHandler _jspx_th_c_NewTagHandler_0 = (apk.NewTagHandler) _jspx_tagPool_c_NewTagHandler.get(apk.NewTagHandler.class);
    _jspx_th_c_NewTagHandler_0.setPageContext(_jspx_page_context);
    _jspx_th_c_NewTagHandler_0.setParent(null);
    int _jspx_eval_c_NewTagHandler_0 = _jspx_th_c_NewTagHandler_0.doStartTag();
    if (_jspx_eval_c_NewTagHandler_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_NewTagHandler_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_NewTagHandler_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_NewTagHandler_0.doInitBody();
      }
      do {
        out.write("hjgjjhjj");
        int evalDoAfterBody = _jspx_th_c_NewTagHandler_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_NewTagHandler_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_NewTagHandler_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_NewTagHandler.reuse(_jspx_th_c_NewTagHandler_0);
      return true;
    }
    _jspx_tagPool_c_NewTagHandler.reuse(_jspx_th_c_NewTagHandler_0);
    return false;
  }
}
