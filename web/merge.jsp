<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MERGE Page</title>
    </head>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css">
    <body>
        <c:import url="/header.jsp" />
        <!-- ********************************************************************************************************************************************       hiii-->
        <form action="MergeServlet" method="post"  enctype="multipart/form-data">
            <!-- creating a row container and dividing it into two parts -->
            <div class="container-fluid bg-light row m-0 pt-3 px-0">
                <!-- first part - left side -->

                <div class="col-md-6 border border-dark border-bottom-0 border-left-0  ">
                    <br>

                    <label for="SsplitFile" class="ml-4 h4 font-weight-bold">Select zipped split File For Merge:</label>

                    <!-- split file -->
                    <div class="splitfile" style="display: flex; width:106%;">
                        <label class="h6 pl-5  ml-3 w-50 py-2 font-weight-bold"
                               style="font-family: 'Montserrat', sans-serif; background-color:#F0F0F0;border-radius:5px 0px 0px 5px;"
                               id="filename">
                            <!-- example.pdf -->
                        </label>
                        <div class="iconandtext " style="text-align: center;">
                            <label for="splitFileInput"
                                   style="background-color: rgb(206, 205, 420);border-radius:0px 5px 5px 0px!important; "
                                   class="btn px-4   py-2"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="25"
                                                     height="20">
                                <path fill-rule="evenodd"
                                      d="M1.75 1A1.75 1.75 0 000 2.75v10.5C0 14.216.784 15 1.75 15h12.5A1.75 1.75 0 0016 13.25v-8.5A1.75 1.75 0 0014.25 3h-6.5a.25.25 0 01-.2-.1l-.9-1.2c-.33-.44-.85-.7-1.4-.7h-3.5z">
                                </path>
                                </svg>&nbsp;&nbsp;&nbsp;Browse</label>
                            <input type="file" name="splitFileInput" accept=".zip" id="splitFileInput"    style="display: none;">
                        </div>
                    </div>
                    <script>



                        $(function () {
                            $("#splitFileInput").change(function (event) {
                                var x = event.target.files[0].name;
                                $("#filename").text(x)
                                $('#mergebtn').prop('disabled', false)
                                $('#viewbtn').prop('disabled', false)
                                $('#commentbtn').prop('disabled', false)

                            });
                        })
$(document).ready(function () {
                                $(".nav li").removeClass("active");//this will remove the active class from  
                                                                   //previously active menu item 
                                $('#mergeLiId').addClass('active');
                               
                              });

                    </script>
                    <!-- split file complete -->
                    <br /><br />
                    <br>
                    <!-- Comments section -->
                    <div class="form-group p-2">
                        
                        <label for="comment" class="ml-2 h4 font-weight-bold">Comment:</label>
                        <textarea class="form-control w-75" name = "commentTxt" rows="5"  id="comment" disabled="true"> ${commentTxt}</textarea>
                    <label for="commentMessage" class="ml-2 h4 font-weight-bold">${commentTxtMessage}</label>
                    </div>
                    <!-- Comments section complete -->

                    <br>

                    <!--checkbox delete split after merging   -->
                    <center>

                    </center>

                    <!--checkbox delete split after merging complete   -->
                </div>
                <!-- Second part - right side -->
                <div class="col-md-6  border  border-right-0 border-bottom-0  border-dark  ">


                    <fieldset>
                        <legend class="h4 font-weight-bold pt-4  pb-2">Details :</legend>
                        <label for="Original_File" style="height:70px;">Original File : ${originalFile}</label> <br>
                        <label for="Original_Size" style="height:70px;">Original Size : ${originalSize}</label><br>
                        <label for="Number_of_Splits" style="height:70px;">Number of Splits : ${noOfSplits}</label><br>
                        <label for="Each_split_size" style="height:70px;">Each split size : ${eachSplitSize} </label><br>
                        <label for="Last _split_size" style="height:70px;">Last split size : ${lastSplitSize}</label><br>
                        <label for="Comments" style="height:70px;">Comments :${haveComments}</label> <br>
                        <label for="Batchfile" style="height:70px;">Batch File :${haveBatchfile} </label>
                    </fieldset>

                </div>
            </div>
            <div class="bg-light py-4 border border-dark border-bottom-0 border-left-0 border-right-0">
                <center>

                    <input type="submit" name = "merge" value="Merge" id="mergebtn"  disabled="true" class="btn btn-primary px-5 py-2 border border-dark mx-2 font-weight-bold ">
                    <input type="submit" name = "comment" value="Get Comment" id="commentbtn" disabled="true" class="btn btn-primary px-5 py-2 border border-dark mx-2 font-weight-bold ">
                    <input type="submit" name = "details" value="View Details" id="viewbtn" disabled="true" class="btn btn-primary px-5 py-2 border border-dark mx-2 font-weight-bold ">
                    <a href="merge.jsp"   class="btn btn-secondary px-5 py-2 border border-dark mx-2 font-weight-bold ">CLOSE</a>

                </center>
            </div>

            <!--footer main-->
           <div class=" row container-fluid bg-dark py-0 pb-3 h-50 mx-0 "> <!--footer main-->
            <div class="container col-md-9  p-2 bg-dark text-white">
                <h3 class="text-danger">More About Merge !</h3><hr class="bg-danger">
                <p class="font-weight-bold">Merge is simply meaning that a to become combined, united, swallowed up, or absorbed; lose identity by uniting or blending.in this feature user can able to merge files. If user want merge 2 files and send it once to receiver than this feature helpful to the user.</p>
                <p class="font-weight-bold">Here the sender can send a two file at once by using merge.it is easy to use and so helpful in business and education fields.
</p>
            </div><!--about main-->



            <div  class="  col-md-3 p-1  bg-dark text-white">
                <h3 class="text-primary">Contact Us</h3><br>
                <a   class="ml-2  h5"><i class="fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success"></i>&nbsp; 7021751058</a><br><br>
                <a href="https://mail.google.com/mail/u/0/#inbox" target="_blank"  class="ml-2 h6"><i class="fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>
            </div>>
           </div>       </form> </body> </html>
