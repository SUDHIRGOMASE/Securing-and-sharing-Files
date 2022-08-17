package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>REGISTER</title>\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <style>\n");
      out.write("            .contact:hover\n");
      out.write("            {\n");
      out.write("\n");
      out.write("                color:greenyellow!important;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\" navbar container-fluid p-1 bg-dark py-3 text-white \"> <!-- main division-->\n");
      out.write("            <div class=\"contact\" style=\"color:greenyellow\">\n");
      out.write("                <h3 class=\"ml-3 font-weight-bold \">FILE UTILITY</h3>\n");
      out.write("\n");
      out.write("                <h6 class=\"ml-3\" style=\"color:bisque;\">Securing & Sharing Files...</h6>\n");
      out.write("            </div> \n");
      out.write("            <h1 class=\" text-center font-weight-bold  mr-5\" style=\"color:buttonhighlight;\">Welcome</h1>\n");
      out.write("            <form class=\"d-flex float-right mr-5\"  method=\"post\">\n");
      out.write("\n");
      out.write("                <a href=\"login.jsp\" class=\" d-flex float-right justify-content-end btn btn-success font-weight-bold \" value=\"SIGN-IN\">LogIn </a>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container-fluid row p-0 m-0\"><!-- sub division 1-->\n");
      out.write("            <div class=\"container-fluid col-md-5 bg-light\"><!-- sub division 1 [a]-->\n");
      out.write("                <h3 class=\" text-center my-3 contact font-weight-bold \"style=\"color:burlywood;\" >REGISTER HERE</h3>\n");
      out.write("                <form action=\"RegisterServlet\"   onsubmit=\"myPopup()\">\n");
      out.write("                    <table class=\"container table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\" text-center text-danger font-weight-bold\" colspan=\"2\" id=\"alertmsg\">\n");
      out.write("\n");
      out.write("                                ");

                                    if (null != request.getAttribute("errorMessage")) {
                                        out.println(request.getAttribute("errorMessage"));
                                    }
                                
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>                                         \n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"font-weight-bold\">First Name </td>\n");
      out.write("                            <td> <input type=\"text\" class=\"form-control \" required name=\"fname\" placeholder=\"First name\" >\n");
      out.write("                                <br>\n");
      out.write("                            </td>\n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"font-weight-bold\">Last Name </td>\n");
      out.write("                            <td><input type=\"text\" class=\"form-control\" required name=\"lname\" placeholder=\"Lastname\" >\n");
      out.write("                                <br></td>                           \n");
      out.write("                        </tr>                       \n");
      out.write("                        <tr> \n");
      out.write("                            <td class=\"font-weight-bold\"> Email-id </td>\n");
      out.write("                            <td><input type=\"email\" class=\"form-control \" name=\"Email\" placeholder=\"Email-id\" ><div class=\"invalid-feedback\">Email Already Exist</div>\n");
      out.write("                                <br>\n");
      out.write("                            </td>                           \n");
      out.write("                        </tr> \n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"font-weight-bold\"> Password </td>\n");
      out.write("                            <td><input type=\"password\" class=\"form-control\"  name=\"pass1\" placeholder=\"Password\" >\n");
      out.write("                                <br></td>\n");
      out.write("                        </tr> \n");
      out.write("                        <td class=\"font-weight-bold\"> Confirm-Password </td>\n");
      out.write("                        <td><input type=password class=\"form-control\"  name=\"pass2\" placeholder=\"Password\" >\n");
      out.write("                            <br>\n");
      out.write("                        </td>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"2\" class=\" text-center\"><input type=\"submit\" onclick=\"Alertmsg()\" href=\"login.jsp\" class=\"text-center btn btn-success font-weight-bold px-3\"value=\"REGISTER\" > </td>\n");
      out.write("                        </tr> \n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-7 bg-light \"><!-- sub division 1 [b]--> \n");
      out.write("                <img class=\"card-img m-0 pt-2 p-0 py-2 text-center\" height=\"600vh\" width=\"100%\" src=\"register.jpg\">  \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\" row  bg-darkp-0 m-0 \"><!-- FOOTER-->\n");
      out.write("            <div class=\"col-md-8 bg-dark pt-2  contact text-white text-center\"><!-- FOOTER 1-->\n");
      out.write("                <h4 class=\"font-weight-bold m-1 px-5\" style=\"color:greenyellow;\">File Utility</h4>\n");
      out.write("                <h5 class=\" font-weight-bold  pt-2 \" style=\"color:bisque\">On this website, we are providing utilities based on files like Encryption,Decryption, Split, Merge, Compare.</h5>\n");
      out.write("                <h6 class=\"font-weight-bold text-success m-1 \">SPLIT </h6>\n");
      out.write("                <h6 class=\"font-weight-bold\" >It helps to Segregate your files into multiple. This Feature helps to Stored Big Data in multiple Files.</h6>\n");
      out.write("                <h6 class=\"font-weight-bold  text-success m-1 text-success\">MERGE</h6>\n");
      out.write("                <h6 class=\"font-weight-bold\">It helps to combine your files into one file. This Feature merged multiple Files into one File.</h6>\n");
      out.write("                <h6 class=\"  m-1 font-weight-bold  text-success\">COMPARE</h6>\n");
      out.write("                <h6 class=\"font-weight-bold\">It helps to compare your files. This Feature provides a comparison between two files.</h6>\n");
      out.write("            </div>\n");
      out.write("            <div class=\" col-md-4 bg-dark text-primary m-0 \"><!-- FOOTER 2-->\n");
      out.write("                <h4 class=\"pt-2 font-weight-bold   contact  \" style=\"color:greenyellow;\" >Contact us..</h4>\n");
      out.write("                <b><i> <h6 class=\" font-weight-bold\"style=\" color:cyan;\"></h6> </i></b>\n");
      out.write("                <a   class=\"ml-2  h5 text-white contact\"  ><i class=\"fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success\"></i>&nbsp; 8108320614</a><br><br>\n");
      out.write("                <a href=\"https://mail.google.com/mail/u/0/#inbox\" target=\"_blank\"  class=\"ml-2  contact text-white h5\"  ><i class=\"fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger\"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
