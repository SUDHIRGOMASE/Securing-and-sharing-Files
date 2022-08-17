<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--<html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Md5Checksum Result</title>
 </head>

  <body>
   <table>

    <tr>
       <th colspan="2">THE RESULT OF COMPARING TWO FILE IS:</th>
    </tr>
    <tr><th colspan="2"></th></tr>
        <tr>
            <th>File1 Md5:</th>
            <td>${param.file1Md5}</td>
        </tr>

        <tr>
            <th>File2 Md5:</th>
            <td>${param.file2Md5}</td>
        </tr>

        <tr>
            <th>result</th>
            <td><c:if test="${param.filesEqual}">
                    <span style="color: green">These two files are equal</span>
                </c:if> <c:if test="${!param.filesEqual}">
                    <span style="color: red">These two files are not equal</span>
                </c:if></td>
        </tr>

        <tr>
              <th colspan="2"><a href="." >go back</a></th>
        </tr>
   </table>
  </body>
</html>-->
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME PAGE</title>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body background="Blueimg.jpg" class="blue " style="background:cover;background-repeat:no-repeat;background-size:1900px;" >

    <c:import url="/header.jsp" />

    <center >
        <div class=" container-fluid pt-3 py-3"><!-- main div-->

            <div class="col-md-8 text-center align-self-center "> <!--   left div-->


            </div>
            <div class="container">

                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators"  data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>

                    </ol>
                    <div class="carousel-inner my-4" style="height: 600px;">
                        <div class="carousel-item active" >
                            <img class="d-block w-100"  height="700vh" width="70%" src="data.jpeg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100 " height="700vh" width="70%" src="data1.jpg"
                                 alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100 "height="700vh" width="70%" src="data2.jpg" alt="Third slide">
                        </div>

                    </div>

                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </center>

    <div class=" row container-fluid bg-dark py-0 h-75 mx-0"> <!--footer main-->
        <div class="container col-md-6  p-2 bg-dark text-white">
       <img src="thanks.gif" class="rounded mx-auto d-block m-5"height="200vh" width="69%"  > 
            
           <center>
                <c:if test="${(user == null)}">
                    <button id="login" onclick="location.href = 'login.jsp'" class="btn btn-primary mx-3 text-white px-3 py-2 font-weight-bold ">Log In</button></center>
                </c:if>
        </div><!--about main-->
        <div  class=" col-md-3 p-1 pl-5 bg-dark text-white ">
            <h3 class="text-primary">Follow us on</h3><br>
            <a href="https://touch.facebook.com/" target="_blank" class="ml-2 h5 "><i class="fa fa-facebook mx-3 bg-primary rounded-circle px-2 py-1 text-white"  ></i>  Like us on Facebook</a><br><br>
            <a href="https://www.instagram.com/" target="_blank"  class="ml-2  h5"><i class="fa fa-instagram mx-3 bg-danger p-2 rounded-circle px-2 py-1 text-white"></i>Check us on Instagram</a><br><br>
            <a href="https://www.linkedin.com/feed/" target="_blank"  class="ml-2 h5"><i class="fa fa-linkedin mx-3 bg-white p-2 rounded-circle px-2 py-1 text-primary"></i>Check Us linkedin</a><br><br>
            <a href="https://twitter.com/home" target="_blank"  class="ml-2 h5"><i class="fa fa-twitter mx-3 bg-white p-2 rounded-circle px-2 py-1 text-primary"></i>Follow us on Twitter</a> <br><br>
        </div><!--contact main-->


        <div  class="  col-md-3 p-1  bg-dark text-white">
            <h3 class="text-primary">Contact us</h3><br>
            <a href="https://goo.gl/maps/Fz9j85DUWYNzZ2RQ8" target="_blank" class="ml-2 h5 "style="text-decoration:none;"><i class="fa fa-map-marker mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success "  ></i>    Patkar Varde college</a><br><br>
            <a   class="ml-2  h5"><i class="fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success"></i>&nbsp; 7021751058</a><br><br>
            <a href="https://mail.google.com/mail/u/0/#inbox" target="_blank"  class="ml-2 h6"><i class="fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>
       </div><!-- main-->
    </div>
</body>
<script> const openNav = () => {
        document.getElementById('mySideMenu').style.cssText = "width:200px;padding:20px";
    };
    const closeNav = () => {
        document.getElementById('mySideMenu').style.cssText = "width:0px;";
    };
    $(document).ready(function () {
                                $(".nav li").removeClass("active");//this will remove the active class from  
                                                                   //previously active menu item 
                                $('#home').addClass('active');
                               
                              });
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>



