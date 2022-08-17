import com.fileutiliy.dto.User;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      //  String unam = request.getParameter("uname");
        String email = request.getParameter("Email");
        String pass = request.getParameter("pass");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb1", "root", "hero");
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from user where email_id=?");
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                if (pass.equals(rs.getString("password"))) {
                
                    User user = new User();
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + "/home.jsp");
                } else {
                    request.setAttribute("errorMessage", "<h4><b>Email-Id/Password Invalid</b></h4>");
                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);

                }
            } else {
                request.setAttribute("errorMessage", "<h4><b>Email-id does't exist</b></h4>");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);

            }

        } catch (Exception e) {
            out.println(e);
        }

    }

}
