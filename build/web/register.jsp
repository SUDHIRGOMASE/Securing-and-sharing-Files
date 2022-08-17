<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTER</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            .contact:hover
            {

                color:greenyellow!important;
            }
        </style>
    </head>
    <body>
        <div class=" navbar container-fluid p-1 bg-dark py-3 text-white "> <!-- main division-->
            <div class="contact" style="color:greenyellow">
                <h3 class="ml-3 font-weight-bold ">FILE UTILITY</h3>

                <h6 class="ml-3" style="color:bisque;">Securing & Sharing Files...</h6>
            </div> 
            <h1 class=" text-center font-weight-bold  mr-5" style="color:buttonhighlight;">Welcome</h1>
            <form class="d-flex float-right mr-5"  method="post">

                <a href="login.jsp" class=" d-flex float-right justify-content-end btn btn-success font-weight-bold " value="SIGN-IN">LogIn </a>
            </form>
        </div>
        <div class="container-fluid row p-0 m-0"><!-- sub division 1-->
            <div class="container-fluid col-md-5 bg-light"><!-- sub division 1 [a]-->
                <h3 class=" text-center my-3 contact font-weight-bold "style="color:burlywood;" >REGISTER HERE</h3>
                <form action="RegisterServlet"   onsubmit="myPopup()">
                    <table class="container table">
                        <tr>
                            <td class=" text-center text-danger font-weight-bold" colspan="2" id="alertmsg">

                                <%
                                    if (null != request.getAttribute("errorMessage")) {
                                        out.println(request.getAttribute("errorMessage"));
                                    }
                                %>
                            </td>
                        </tr>                                         
                        <tr>
                            <td class="font-weight-bold">First Name </td>
                            <td> <input type="text" class="form-control " required name="fname" placeholder="First name" >
                                <br>
                            </td>
                        </tr> 
                        <tr>
                            <td class="font-weight-bold">Last Name </td>
                            <td><input type="text" class="form-control" required name="lname" placeholder="Lastname" >
                                <br></td>                           
                        </tr>                       
                        <tr> 
                            <td class="font-weight-bold"> Email-id </td>
                            <td><input type="email" class="form-control " name="Email" placeholder="Email-id" ><div class="invalid-feedback">Email Already Exist</div>
                                <br>
                            </td>                           
                        </tr> 
                        <tr>
                            <td class="font-weight-bold"> Password </td>
                            <td><input type="password" class="form-control"  name="pass1" placeholder="Password" >
                                <br></td>
                        </tr> 
                        <td class="font-weight-bold"> Confirm-Password </td>
                        <td><input type=password class="form-control"  name="pass2" placeholder="Password" >
                            <br>
                        </td>
                        <tr>
                            <td colspan="2" class=" text-center"><input type="submit" onclick="Alertmsg()" href="login.jsp" class="text-center btn btn-success font-weight-bold px-3"value="REGISTER" > </td>
                        </tr> 
                    </table>
                </form>
            </div>
            <div class="col-md-7 bg-light "><!-- sub division 1 [b]--> 
                <img class="card-img m-0 pt-2 p-0 py-2 text-center" height="600vh" width="100%" src="register.jpg">  
            </div>
        </div>
        <div class=" row  bg-darkp-0 m-0 "><!-- FOOTER-->
            <div class="col-md-8 bg-dark pt-2  contact text-white text-center"><!-- FOOTER 1-->
                <h4 class="font-weight-bold m-1 px-5" style="color:greenyellow;">File Utility</h4>
                <h5 class=" font-weight-bold  pt-2 " style="color:bisque">On this website, we are providing utilities based on files like Encryption,Decryption, Split, Merge, Compare.</h5>
                <h6 class="font-weight-bold text-success m-1 ">SPLIT </h6>
                <h6 class="font-weight-bold" >It helps to Segregate your files into multiple. This Feature helps to Stored Big Data in multiple Files.</h6>
                <h6 class="font-weight-bold  text-success m-1 text-success">MERGE</h6>
                <h6 class="font-weight-bold">It helps to combine your files into one file. This Feature merged multiple Files into one File.</h6>
                <h6 class="  m-1 font-weight-bold  text-success">COMPARE</h6>
                <h6 class="font-weight-bold">It helps to compare your files. This Feature provides a comparison between two files.</h6>
            </div>
            <div class=" col-md-4 bg-dark text-primary m-0 "><!-- FOOTER 2-->
                <h4 class="pt-2 font-weight-bold   contact  " style="color:greenyellow;" >Contact us..</h4>
                <b><i> <h6 class=" font-weight-bold"style=" color:cyan;"></h6> </i></b>
                <a   class="ml-2  h5 text-white contact"  ><i class="fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success"></i>&nbsp; 8108320614</a><br><br>
                <a href="https://mail.google.com/mail/u/0/#inbox" target="_blank"  class="ml-2  contact text-white h5"  ><i class="fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>
            </div>
        </div>
    </body>
</html>




