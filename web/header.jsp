<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Securing and Sharing files Registration</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style.css">
    </head>

    <body> 
        <div>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark pb-2">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse pt-3 " id="navbarTogglerDemo02">

                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0" id="test">


                        <li class="nav-item" id="home">
                            <a class=" NavMenu nav-link font-weight-bold "  href="home.jsp"><i class="fa fa-home mx-3 bg-light p-1 rounded-circle  text-primary "  ></i>HOME <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item  mx-3 " id="encryptionLiId" >
                            <a class=" NavMenu nav-link font-weight-bold" href="encrypt.jsp"><i class="fa fa-key mx-3 bg-danger p-1 rounded-circle  text-white"></i>ENCRYPTION</a>
                        </li>
                        <li class="nav-item mx-3 " id="decryptLiId">
                            <a class=" NavMenu nav-link font-weight-bold "   href="decrypt.jsp"><i class="fa fa-unlock mx-3 bg-success p-1 rounded-circle  text-white "></i>DECRYPTION</a>
                        </li>
                        <li class="nav-item  mx-3 " id="splitLiId">
                            <a class=" NavMenu nav-link font-weight-bold"   href="split.jsp"><i class="fa fa-columns mx-3 bg-primary p-1 rounded-circle  text-white" ></i>SPLIT</a>
                        </li>
                        <li class="nav-item mx-3 " id="mergeLiId" >
                            <a class=" NavMenu nav-link font-weight-bold"  href="merge.jsp"><i class="fa fa-compress mx-2 bg-success p-1 rounded-circle text-white"></i> MERGE</a>
                        </li>
                        <li class="nav-item mx-3 " id="compareLiId">
                            <a class="NavMenu nav-link font-weight-bold"   href="compare.jsp"><i class="fa fa-files-o mx-3 bg-danger p-1 rounded-circle  text-white" ></i>COMPARISION</a>
                        </li>  
                        <li class="nav-item mx-3 ">


                            <div class="dropdown show"><!--dropdown-->
                                <a class="   pr-3 font-weight-bold nav-link dropdown-toggle NavMenu"  role="button" id="dropdownMenuLink"data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-user pr-2 mx-3 bg-light p-1 rounded-circle px-1 py-1 text-success"aria-hidden="true"></i>
                                    ${user.firstName} ${user.lastName}
                                </a>

                                <div class=" bg-dark dropdown-menu  outline-none " >

                                    <c:choose>
                                        <c:when test="${user.firstName == null or user.lastName == null}"> 
                                            <a class="  NavMenu   font-weight-bold dropdown-item  "  id="drop2" href="register.jsp"><i class="fa fa-registered mx-3" ></i>Register</a>

                                            <a class="  NavMenu  dropdown-item  font-weight-bold " id="drop3" href="login.jsp"><i class="fa fa-sign-out mx-3"></i>Log In</a>

                                        </c:when>
                                        <c:otherwise>

                                            <a class="  NavMenu  dropdown-item  font-weight-bold " id="drop3" href="/fileutility1/UserLogoutServlet"><i class="fa fa-sign-out mx-3"></i>Log Out</a>

                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </li>
                    </ul>
                    
                </div>
            </nav>      
        </div>

    </body>
</html>