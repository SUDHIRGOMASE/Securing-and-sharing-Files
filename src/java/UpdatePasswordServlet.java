
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePasswordServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        {
            String p1 = request.getParameter("pass1");
            String p2 = request.getParameter("pass2");
            String email = request.getParameter("email");
            
            

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

                    if (email.matches(regex)) {
                          if (p1.matches(passx)) {
                        if (p1.equals(p2)) {
                            PreparedStatement st = (PreparedStatement) con.prepareStatement("update user set password=?  where email_id=? ");
                            st.setString(2, email);
                            st.setString(1, p1);
                            int row = st.executeUpdate();
                            if (row == 1) {
                                request.setAttribute("sucessMessage", " Your Password is Successfully Updated !!Please go on  <a href=login.jsp> LOGIN</a>");
                                RequestDispatcher rd = request.getRequestDispatcher("/resetpassword.jsp");
                                rd.forward(request, response);

                            } else {
                                out.println("no row updated");

                            }
                        } else {
                            request.setAttribute("errorMessage", "Password is not match");
                            RequestDispatcher rd = request.getRequestDispatcher("/resetpassword.jsp");
                            rd.forward(request, response);
                        }
                         } else{
                            request.setAttribute("errorMessage", "Password must be a Minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter,1 number and 1 special character:eg=Abc@12");
                                RequestDispatcher rd = request.getRequestDispatcher("/resetpassword.jsp");
                                rd.forward(request, response);   
                          }
                    } else {
                        request.setAttribute("errorMessage", "Email-id is Invalid");
                        RequestDispatcher rd = request.getRequestDispatcher("/resetpassword.jsp");
                        rd.forward(request, response);
                    }

                } else {
                    request.setAttribute("errorMessage", "Email-id does not exist");
                    RequestDispatcher rd = request.getRequestDispatcher("/resetpassword.jsp");
                    rd.forward(request, response);
                }

            } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
                out.println(e);
            }
        }
    }
}

