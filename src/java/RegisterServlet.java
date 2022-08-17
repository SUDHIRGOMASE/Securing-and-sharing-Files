import com.fileutility.util.SendMailSSL;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        {
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");

            String p1 = request.getParameter("pass1");
            String p2 = request.getParameter("pass2");
            String email = request.getParameter("Email");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb1", "root", "hero");

                String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"; 
                              
                String passx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

                String sql = "select email_id from user where email_id= ? ";
                PreparedStatement prepStmt = con.prepareStatement(sql);
                prepStmt.setString(1, email);
                ResultSet rs = prepStmt.executeQuery();

                if (rs.next()) {

                    request.setAttribute("errorMessage", "This user already exist ");
                    RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                    rd.forward(request, response);
                } else {

                    if (email.matches(regex)) {
                        if (p1.matches(passx)) {
                            if (p1.equals(p2)) {

                                PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into user values(?,?,?,?)");
                                stmt.setString(1, fname);
                                stmt.setString(2, lname);
                                stmt.setString(3, email);
                                stmt.setString(4, p1);

                                int row = stmt.executeUpdate();
                                if (row == 1) {

                                    SendMailSSL.send(email, "Securing and Sharing files Registration", "Thank you for registration!! Hope this website will helpful for you..Have a great day!", null);
                                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                                    rd.forward(request, response);

                                } else {
                                    out.println("no row updated");

                                }
                            } else {

                                request.setAttribute("errorMessage", "Password is not match");
                                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                                rd.forward(request, response);
                            }
                        } else {
                                 request.setAttribute("errorMessage", "Password must be a Minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter,1 number and 1 special character:eg=Abc@12");
                                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                                rd.forward(request, response);   
                        }

                    } else {

                        request.setAttribute("errorMessage", "Please provide valid Email-Id");
                        RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                        rd.forward(request, response);
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

//                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
//                rd.forward(request, response);
out.println(ex);
                request.setAttribute("errorMessage", "This Email-Id is already exist");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
