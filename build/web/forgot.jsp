<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head><title>FORGOT Password</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body background="forgot.jpg" style="background:cover;background-repeat:no-repeat;background-size:1900px;" >


        <div class="container my-5 pt-5 w-50 text-danger font-weight-bold h4">

            <center style="padding:50px 0px 50px 0px;" >  
                <h1 class="  font-weight-bold" style="color:cyan;">Forgot Password</h1>
                   <%
                        if (null != request.getAttribute("sucessMessage"))
                        {
                            out.println(request.getAttribute("sucessMessage"));
                        }
                   %>
                    <br>
                    <%
                         if
                        (null != request.getAttribute("errorMessage"))
                        {
                            out.println(request.getAttribute("errorMessage"));
                        }
                        %>
                        <br>
                    
   
                        

                        <form class="form w-75  " action="ForgetServlet" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                           
                                        <input type="hidden" id= "firstname" name="firstname" />
                                        <input type="hidden" id= "lastname" name="lastname" />
                                        
                                        <input id="emailInput" placeholder="email address" name="Email" class="form-control" type="email" oninvalid="setCustomValidity('Please enter a valid email address!')" onchange="try {
                                                    setCustomValidity('');
                                                } catch (e) {
                                                }" required="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input class="btn btn-lg btn-success btn-block" value="Submit" type="submit" onclick="gettheVerificationCode()">
                                </div>
                            </fieldset>

                        </form>
                             <script>
                var firstname = "<%=request.getParameter("firstname")%>";
                $("#firstname").val(firstname);
                 var lastname = "<%=request.getParameter("lastname")%>";
                $("#lastname").val(lastname);
                
            </script>


                       


                        </div>

                        </body>


                        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

                        </html>