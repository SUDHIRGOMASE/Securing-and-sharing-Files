<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPLIT PAGE</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style.css">

    </head>
    <body>
        <c:import url="/header.jsp" />
        <!--     header finish   <***************************************************************************************************************>-->
        <form action="SplitServlet" method="post" enctype="multipart/form-data">

            <div class="container-fluid row  m-0 p-0  " id="fileSplit"  >

                <div class="container-fluid col-md-6 m-0 p-0 bg-light p-4" id="SourceFile">
                   

                    <label for="inputGroupFile01"  class="ml-2 h4 font-weight-bold pt-3 pb-2  ">Select file  For Split :</label>
                       

                    <div class="destinationfile" style="display:flex; width:128%;">
                        <label class="h6 pl-5  ml-3 w-50 py-2 font-weight-bold" style="font-family: 'Montserrat',sans-serif; background-color:#F0F0F0; border-radius:5px 0px 0px 5px;"
                               id="filename"></label>
                        <div class="iconandtext " style="text-align: center;">
                            <label for="destnationFileInput" style="background-color: rgb(206, 205, 420); border-radius:0px 5px 5px 0px!important;" class="btn px-4 py-2"><svg
                                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="14">
                                <path fill-rule="evenodd"
                                      d="M1.75 1A1.75 1.75 0 000 2.75v10.5C0 14.216.784 15 1.75 15h12.5A1.75 1.75 0 0016 13.25v-8.5A1.75 1.75 0 0014.25 3h-6.5a.25.25 0 01-.2-.1l-.9-1.2c-.33-.44-.85-.7-1.4-.7h-3.5z">
                                </path>
                                </svg>&nbsp;&nbsp;&nbsp;Browse</label>
                            <input type="file" id="destnationFileInput"   name="file1" style="display: none;">
                        </div>
                    </div>
                    <script>



                        $(function () {
                            $("#destnationFileInput").change(function (event) {
                                var x = event.target.files[0].name;
                                $("#filename").text(x);
                                $('#splitbtn').prop('disabled', false);
                            });
                        });
$(document).ready(function () {
                                $(".nav li").removeClass("active");//this will remove the active class from  
                                                                   //previously active menu item 
                                $('#splitLiId').addClass('active');
                               
                              });

                    </script>




                    <br>




                    <script>
                        function radioBtnPredefined() {
                            document.getElementById('predefinedDropdown').disabled = false;

                            document.getElementById('splitIntoRadioBtn').disabled = true;
                            document.getElementById('splitEachFileRadioBtn').disabled = true;
                            document.getElementById('splitIntoTxtBox').disabled = true;
                            document.getElementById('splitEachFileTxtBox').disabled = true;
                            document.getElementById('ByteButton').disabled = true;
                            document.getElementById('KbButton').disabled = true;
                            document.getElementById('MbButton').disabled = true;
                        }
                        function radioBtnCustomized() {
                            document.getElementById('splitEachFileRadioBtn').disabled = false;
                            

                            document.getElementById('splitIntoRadioBtn').disabled = false;
                            document.getElementById('splitEachFileRadioBtn').disabled = false;
                            document.getElementById('splitIntoTxtBox').disabled = true;
                            document.getElementById('splitEachFileTxtBox').disabled = true;
                            document.getElementById('predefinedDropdown').disabled = true;
                            document.getElementById('ByteButton').disabled = false;
                            document.getElementById('KbButton').disabled = false;
                            document.getElementById('MbButton').disabled = false;
                        }
                        function radioBtnSplitInto() {
                            document.getElementById('splitEachFileTxtBox').value = "";
                            document.getElementById('splitIntoTxtBox').disabled = false;
                            document.getElementById('splitEachFileTxtBox').disabled = true;
                        }
                        function radioBtnSplitEachFile() {

                            document.getElementById('splitIntoTxtBox').value = "";
                            document.getElementById('splitIntoTxtBox').disabled = true;
                            document.getElementById('splitEachFileTxtBox').disabled = false;
                        }


                    </script>
                    <!-- destination file complete -->

                    <br>
                    <br><br>
                    <br><br>
                    <br>
                    <div class="form-group">
                        <b> <label for="comment" class="h4 font-weight-bold" >Comments:</label></b>
                        <textarea class="form-control ml-2" style="width:594px;" rows="5" id="comment" name="comment"></textarea>
                    </div>


                </div>

                <div class="container-fluid col-md-6 m-0 p-0 bg-light p-4" id="FileSize" >
                    <b> <label class="ml-2 mt-3 h4 font-weight-bold"> File Size :</label></b>
                    <br>
                    <div class="input-group m-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input type="radio" onfocus="radioBtnPredefined()"  name="customizeRadioBtn" id="predefinedRadioBtn" aria-label="Radio button for following text input">

                            </div>
                        </div>
                        <label for="Predefined" class="ml-3">Predefined</label>

                        <select class="btn btn-secondary ml-3 p-0" id="predefinedDropdown" name="predefinedSize"   disabled="true" >
                            <option value="10 KB">10 KB</option>
                            <option value="100 KB">100 KB</option>
                            <option value="120 KB">120 KB</option>
                            <option value="500 KB">500 KB</option>
                            <option value="720 KB">720 KB</option>
                            <option value="1.2 MB">1.2 MB</option>
                            <option value="1.44 MB">1.44 MB</option>
                            <option value="100 MB">100 MB</option>
                            <option value="250 MB">250 MB</option>
                            <option value="650 MB">650 MB</option>


                        </select>
                    </div>

                    <div class="input-group m-3" >
                        <div>
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <input type="radio" onfocus="radioBtnCustomized()" id="customizeRadioBtn" name="customizeRadioBtn" aria-label="Radio button for following text input">
                                </div>

                                <label for="Customize" class="ml-3">Customize</label>

                            </div>
                            <br />
                            <table id="custTable" class=" ml-5  border-0">
                                <tr>
                                    <td><input type="radio" onfocus="radioBtnSplitInto()" disabled="true" id="splitIntoRadioBtn" name="SplitRadioBtn" class="ml-2 "><label class="ml-2 text-center">Split into
                                            :</label></td>
                                    <td><input class="ml-2 files" type="text" name ="splitIntoTxtBox" id="splitIntoTxtBox" disabled="true">  Files</td>
                                </tr>
                                <tr>
                                    <td><input type="radio" disabled="true" onfocus="radioBtnSplitEachFile()" id="splitEachFileRadioBtn" name="SplitRadioBtn" class="ml-2 "><label class="ml-2 text-center">Split each file :
                                    </td>
                                    <td></label><input class="ml-2" type="text" id="splitEachFileTxtBox" name ="splitEachFileTxtBox" disabled="true"></td>
                                </tr>

                                <tr>
                                    <td colspan="2"><input type="radio" id="ByteButton" value="Bytes" disabled="true" name="cust" class="ml-5" ><label class="ml-2 text-center">Bytes
                                        </label>
                                        <input type="radio" disabled="true" value="KB" id="KbButton" name="cust" class="ml-5"><label class="ml-2 text-center">KB
                                        </label>
                                        <input type="radio" name="cust" value="MB" disabled="true" id="MbButton" class="ml-5" ><label class="ml-2 text-center">MB
                                        </label></td>


                                </tr>
                            </table>
                        </div>

                    </div>
                    
                    <div class="container m-5 w-75 p-3 " style="border:2px solid black;border-radius:9px; ">
                        <b> <label>Optional</label></b>
                        <br>

                        <input type="checkbox" id="generateBatchFile" name="generateBatchFile">
                        <label class="ml-3">Generate Batch File For Merging</label>
                    </div>



                </div>
            </div>
            <center class="bg-light">
                <div class="py-5  ">

                    <input type="submit" class="btn btn-primary px-5 py-2 font-weight-bold" id="splitbtn" disabled="true" value="SPLIT">
                    <a href="split.jsp" class="btn btn-secondary px-5 py-2 font-weight-bold"  >CLOSE</a>

                </div>

            </center>
        </form>

       


           <div class=" row container-fluid bg-dark py-0 pb-3 h-50 mx-0 "> <!--footer main-->
            <div class="container col-md-9  p-2 bg-dark text-white">
                <h3 class="text-danger">More About Split !</h3><hr class="bg-danger">
                <p class="font-weight-bold"> In this we are providing to the user the operation like splitting means to divide one file into another file. It is very helpful feature to the user to split file into two for easy to use purpose. It’s simple to split. Split its simply means that a divide or to make a group of people divide into smaller groups.</p>
                <p class="font-weight-bold">Advantage 
Whenever user want to share a big size file sometimes its unable to send large file but if we can use this feature, we can easily split file into two and send it to receiver.
</p>
            </div><!--about main-->



            <div  class="  col-md-3 p-1  bg-dark text-white">
                <h3 class="text-primary">Contact Us</h3><br>
                <a   class="ml-2  h5"><i class="fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success"></i>&nbsp; 7021751058</a><br><br>
                <a href="https://mail.google.com/mail/u/0/#inbox" target="_blank"  class="ml-2 h6"><i class="fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>
            </div>>
           </div>
        






        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
