/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-05-24 08:22:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class member_005finsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1\">	\r\n");
      out.write("  	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" \r\n");
      out.write("		integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\"\r\n");
      out.write("		crossorigin=\"anonymous\">  \r\n");
      out.write("  	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("	<title>회원등록</title>\r\n");
      out.write("  	<style>\r\n");
      out.write("  		.login-btn {\r\n");
      out.write("  			clear: black;\r\n");
      out.write("  			background-color: #FFC312; \r\n");
      out.write("  			width: 100px;\r\n");
      out.write("  		}\r\n");
      out.write("  		.login-btn:hover {\r\n");
      out.write("  			clear: white;\r\n");
      out.write("  			background-color: black;  		\r\n");
      out.write("  		}\r\n");
      out.write("  		.input-group-prepend span {\r\n");
      out.write("  			color: black;\r\n");
      out.write("  			border-left-color: #FFC312;\r\n");
      out.write("  			width: 40px;\r\n");
      out.write("  			border: 0 !important;\r\n");
      out.write("  		}\r\n");
      out.write("  	</style>	\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\" align=\"center\">\r\n");
      out.write("		<div class=\"jumbotron\">\r\n");
      out.write("			<h3>회원등록하기</h3>\r\n");
      out.write("			<p>회원등록 페이지 입니다. 회원정보를 작성해 주세요</p>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<form action=\"memberInsert.co\" method=\"post\" class=\"form-group\" name=\"memberform\" \r\n");
      out.write("				enctype=\"multipart/form-data\">\r\n");
      out.write("			<div class=\"form-group input-group\">\r\n");
      out.write("				<div class=\"input-group-prepend\"><span class=\"input-group-text\"><i class=\"fas fa-user\"></i></span></div>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" name=\"id\" id=\"id\" value=\"\" required placeholder=\"member ...\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group input-group\">\r\n");
      out.write("				<div class=\"input-group-prepend\"><span class=\"input-group-text\"><i class=\"fas fa-key\"></i></span></div>\r\n");
      out.write("				<input type=\"password\" class=\"form-control\" name=\"pw\" id=\"pw\" value=\"1\" required placeholder=\"password ...\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group input-group\">\r\n");
      out.write("				<div class=\"input-group-prepend\"><span class=\"input-group-text\"><i class=\"fas fa-clipboard\"></i></span></div>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" name=\"name\" id=\"name\" value=\"홍길동\" required placeholder=\"name ...\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group input-group\">\r\n");
      out.write("				<div class=\"input-group-prepend\"><span class=\"input-group-text\"><i class=\"fas fa-comment-dots\"></i></span></div>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" name=\"age\" id=\"age\" required placeholder=\"age ...\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group input-group\">\r\n");
      out.write("				<div class=\"input-group-prepend\"><span class=\"input-group-text\"><i class=\"fas fa-comment-dots\"></i></span></div>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" name=\"gender\" id=\"gender\" value=\"남자\" required placeholder=\"age ...\">\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"form-group input-group\">\r\n");
      out.write("				<div class=\"form-group input-group\">\r\n");
      out.write("					<div class=\"input-group-prepend\"><span class=\"input-group-text\"><i class=\"fas fa-comment-dots\"></i></span></div>\r\n");
      out.write("					<input type=\"text\" class=\"form-control\" name=\"email\" id=\"email\" required placeholder=\"email ...\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"form-group mt-md-5\">\r\n");
      out.write("					<input type=\"reset\" class=\"btn btn-success float-right login-btn ml-sm-2\" value=\"새로고침\"/>\r\n");
      out.write("					<input type=\"submit\" class=\"btn btn-success float-right login-btn\" value=\"회원등록\"/>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>		\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
