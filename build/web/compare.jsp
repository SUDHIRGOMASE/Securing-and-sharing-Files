
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COMPARE Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style.css">


        <style>


            .scroll {
               
                padding-left: 14px;

                width: 90%;
                height: 300px;
/*                overflow-x: hidden;*/
                overflow-y: auto;

            }
        </style>
    </head>
    <body class="bg-light">
        <form action="CompareServlet" method="post" enctype="multipart/form-data">

            <c:import url="/header.jsp" />
            <!-- HEADER FINISH********************************************************************************************************************************************       hiii-->

            <div class="container-fluid bg-light row  pt-1 px-1 mx-0"> 

                <div class="col-md-6  pt-1 py-0 bg-light  mx-0">
                    <br>
                    <!-- first file -->
                    <label for="firstFile" class="ml-4 h4 font-weight-bold">First (.txt) File :</label> <!-- first browse-->
                   


                    <div class="firstfile" style="display: flex; width:100%;">
                        <label class="h6 ml-4 w-50 py-2 font-weight-bold"
                               style="font-family: 'Montserrat', sans-serif; background-color:#F0F0F0;border-radius:5px 0px 0px 5px;"
                               id="filename">
                            <!-- example.pdf -->
                        </label>

                        <div class="iconandtext " style="text-align: center;">
                            <label for="firstFileInput"
                                   style="background-color: rgb(206, 205, 420);border-radius:0px 5px 5px 0px!important; "
                                   class="btn px-4 py-2"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16"
                                                       height="14">
                                <path fill-rule="evenodd"
                                      d="M1.75 1A1.75 1.75 0 000 2.75v10.5C0 14.216.784 15 1.75 15h12.5A1.75 1.75 0 0016 13.25v-8.5A1.75 1.75 0 0014.25 3h-6.5a.25.25 0 01-.2-.1l-.9-1.2c-.33-.44-.85-.7-1.4-.7h-3.5z">
                                </path>
                                </svg>&nbsp;&nbsp;&nbsp;Browse</label>
                            <input type="file" id="firstFileInput" accept=".txt" name ="firstFileInput" style="display: none;">
                        </div>
                    </div>

                    <script>
                        $(function () {
                            $("#firstFileInput").change(function (event) {
                                var x = event.target.files[0].name;
                                $("#filename").text(x);

                            });
                        });
                    </script><br>

                    <br>
                    <label class="pt-1 ml-3  h3 text-center text-primary font-weight-bold"> ${file1Name} </label>
                    <div class=" scroll">


                        <c:forEach items="${compareList}" var="item">

                            <span  style="white-space: pre-wrap; color: ${item.colour}; border: 10px ridge(1,8,1);">${item.line1}</span>
                            <br>
                        </c:forEach>

                    </div>
                </div>


                <div class="  col-md-6 pt-1  bg-light mx-0">
                    <br>
                    <label for="secondfile" class="ml-2 h4 font-weight-bold">Second  (.txt) file:</label>
 
                    <!-- second browse -->
                    <div class="secondfile" style="display: flex; width:100%;">
                        <label class="h6  w-50 py-2 font-weight-bold"
                               style="font-family: 'Montserrat', sans-serif; background-color:#F0F0F0;border-radius:5px 0px 0px 5px;"
                               id="secondfilename">
                            <!-- example.pdf -->
                        </label>
                        <div class="iconandtext " style="text-align: center;">
                            <label for="secondFileInput"
                                   style="background-color: rgb(206, 205, 420);border-radius:0px 5px 5px 0px!important; "
                                   class="btn px-4 py-2"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16"
                                                       height="14">
                                <path fill-rule="evenodd"
                                      d="M1.75 1A1.75 1.75 0 000 2.75v10.5C0 14.216.784 15 1.75 15h12.5A1.75 1.75 0 0016 13.25v-8.5A1.75 1.75 0 0014.25 3h-6.5a.25.25 0 01-.2-.1l-.9-1.2c-.33-.44-.85-.7-1.4-.7h-3.5z">
                                </path>
                                </svg>&nbsp;&nbsp;&nbsp;Browse</label>
                            <input type="file" id="secondFileInput" accept=".txt" name="secondFileInput" style="display: none;">
                        </div>
                    </div>
                    <script>
                        $(function () {
                            $("#secondFileInput").change(function (event) {
                                var y = event.target.files[0].name;
                                $("#secondfilename").text(y);
                                $('#comparebtn').prop('disabled', false);
                            });
                        });
                        $(document).ready(function () {
                                $(".nav li").removeClass("active");//this will remove the active class from  
                                                                   //previously active menu item 
                                $('#compareLiId').addClass('active');
                               
                              });
                    </script> <br>




                    <br>
                    <label class="pt-1   h3 text-center text-primary font-weight-bold"> ${file2Name} </label>

                    <div class=" scroll">

                        <c:forEach items="${compareList}" var="item">


                            <span  style="color: ${item.colour}; border: 10px ridge(1,8,1)">${item.line2}</span>
                            <br/>
                        </c:forEach>

                    </div>
                </div>


            </div>



            <br>
            <br>
            <br>
            <br>
            <center class="bg-light pb-3 pt-3">

                <!-- Comments section complete -->
                <input type="submit" class="btn btn-primary px-5 py-2 font-weight-bold" id="comparebtn" disabled="true" value="COMPARE">
                <a href="compare.jsp" class="btn btn-secondary px-5 py-2 font-weight-bold"  >CLOSE</a>

            </center><br>

            <!-- FOOTER STARTS*****************************************************************************************************************************************************************-->
           <div class=" row container-fluid bg-dark py-0 pb-3 h-50 mx-0 "> <!--footer main-->
            <div class="container col-md-9  p-2 bg-dark text-white">
                <h3 class="text-danger">More About Compare !</h3><hr class="bg-danger">
                <p class="font-weight-bold">Comparison or comparing is the act of evaluating two or more things by determining the relevant, comparable characteristics of each thing, and then determining which characteristics of each are similar to the other, which are different, and to what degree. Where characteristics are different, the differences may then be evaluated to determine which thing is best suited for a particular purpose. The description of similarities and differences found between the two things is also called a comparison. Comparison can take many distinct forms, varying by field.</p>
                <p class="font-weight-bold">It is very helpful feature in our project to the user. By using this feature user can compare one text file to another text file. In this file1 and file2 having same content then it will show the same content.
</p>
            </div><!--about main-->



            <div  class="  col-md-3 p-1  bg-dark text-white">
                <h3 class="text-primary">Contact Us</h3><br>
                <a   class="ml-2  h5"><i class="fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success"></i>&nbsp; 7021751058</a><br><br>
                <a href="https://mail.google.com/mail/u/0/#inbox" target="_blank"  class="ml-2 h6"><i class="fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>
            </div>
           </div>


        </form>
    </body>
</html>
