<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<%@page import="com.fileutility.util.SendMailSSL"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
    <body background="forgot.jpg" style="background:cover;background-repeat:no-repeat;background-size:1900px;" >
    <center class="my-4 container" > 
        <br>
        <br>
        <h1 class="text-center   font-weight-bold" style="color:cyan;">Reset Password !!</h1>
        <br>
       
       
        <div class=" text-danger font-weight-bold h3">
            <br>
                     <%
                        if (null != request.getAttribute("sucessMessage"))
                        {
                            out.println(request.getAttribute("sucessMessage"));
                        }
                       
                    %>
                    <%
                        if (null != request.getAttribute("errorMessage")) {
                            out.println(request.getAttribute("errorMessage"));
                        }
                    %>
        </div>
        <br>
        <form action="UpdatePasswordServlet" method="post" class="form w-50">

            <input type="hidden" id= "email" name="email" />
            <input type="password" class="form-control " name="pass1"  placeholder="Please enter the new password">
            <br />
            <input type="password" class="form-control " name="pass2" placeholder="Please confirm the password ">
            <br>

            <div class="form-group">
                <input class="btn btn-lg btn-success btn-block mt-3" value="Submit" type="submit" onclick="gettheVerificationCode()">
            </div>
            <script>
                var email = "<%=request.getParameter("email")%>"
                $("#email").val(email);
            </script>
        </form>

    </center>

</body>
</html>
