
import com.fileutility.util.ResetPass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgetServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("Email");
        
        
      // String remsg = request.getParameter("resetmsg");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb1", "root", "hero");
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from user where email_id=?");
            stmt.setString(1, email);
            
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
               //String password= rs.getString("pas");
               String firstname = rs.getString("firstName");
               String lastname = rs.getString("lastName");
                
                ResetPass.send(email,"About Reset Password","Hello,"+firstname+ lastname+"<br>We are sending you this Email because you requested a password reset. Click on this link to create a new password <br>.http://localhost:8080/fileutility1/resetpassword.jsp?email="+email+"<br>If you didn't request a  password reset,you can ignore this email your password will not be changed. ",null);
               
               request.setAttribute("sucessMessage", "We have Send you a link to reset your password please check email <br><b><a href=login.jsp>  LOGIN </a></b>   ");
                RequestDispatcher rd = request.getRequestDispatcher("/forgot.jsp");
                        rd.forward(request, response);
                        
               
            }
            else{
                 request.setAttribute("errorMessage", "<h4><b>This Email-id  does not exist</b></h4>");
                    RequestDispatcher rd = request.getRequestDispatcher("/forgot.jsp");
                    rd.forward(request, response);
            }

               
              
               
        }catch (Exception e) {
            out.println(e);
        }
        
    }
}


