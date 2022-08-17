package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>LOGIN</title>\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <title>Animated Login Form</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"login.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Poppins:600&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/a81368914c.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" >\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" >\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <img class=\"wave \" src=\"lightblue.jpg\" >\n");
      out.write("        <div class=\"container \" >\n");
      out.write("            <div class=\"img \">\n");
      out.write("                <img src=\"bg.svg\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"login-content \">\n");
      out.write("                \n");
      out.write("                <form action=\"LoginServlet\" class=\" rounded    p-5 \" style=\"border:3px solid black\"   method=\"post\">\n");
      out.write("                    <img src=\"avatar.svg\">\n");
      out.write("                    <h2 class=\"title text-adrk\">Welcome</h2>\n");
      out.write("                   \n");
      out.write("\n");
      out.write("                    ");

                        if (null != request.getAttribute("errorMessage")) {
                            out.println(request.getAttribute("errorMessage"));
                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"input-div one\">\n");
      out.write("                        <div class=\"i\">\n");
      out.write("                            <i class=\"fas fa-user mx-3 font-weight-bold bg-primary rounded-circle px-2 py-2 text-dark\"></i>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"div\">\n");
      out.write("                            <h5 class=\"text-dark font-weight-bold\">Email-Id</h5>\n");
      out.write("                            <input type=\"text\"  name=\"Email\"class=\"input\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-div pass\">\n");
      out.write("                        <div class=\"i\"> \n");
      out.write("                            <i class=\"fas fa-lock font-weight-bold mx-3 bg-success rounded-circle px-2 py-2 text-dark\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"div\">\n");
      out.write("                            <h5 class=\"text-dark font-weight-bold\">Password</h5>\n");
      out.write("                            <input type=\"password\" name=\"pass\"  class=\"input\">\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <a href=\"forgot.jsp\" class=\"font-weight-bold text-primary h5\">Forgot Password?</a>\n");
      out.write("                  \n");
      out.write("                    <input type=\"submit\" class=\"btn\" value=\"Login\">\n");
      out.write("                       <a href=\"register.jsp\" class=\"btn pt-3\">REGISTER</a>\n");
      out.write("                   \n");
      out.write("                </form>\n");
      out.write("                   \n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("                     \n");
      out.write("        </div>\n");
      out.write("                    <script>\n");
      out.write("    const inputs = document.querySelectorAll(\".input\");\n");
      out.write("\n");
      out.write("\n");
      out.write("    function addcl() {\n");
      out.write("        let parent = this.parentNode.parentNode;\n");
      out.write("        parent.classList.add(\"focus\");\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function remcl() {\n");
      out.write("        let parent = this.parentNode.parentNode;\n");
      out.write("        if (this.value == \"\") {\n");
      out.write("            parent.classList.remove(\"focus\");\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    inputs.forEach(input => {\n");
      out.write("        input.addEventListener(\"focus\", addcl);\n");
      out.write("        input.addEventListener(\"blur\", remcl);\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("   </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
