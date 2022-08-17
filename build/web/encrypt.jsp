<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ENCRYPTION PAGE</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <link rel="stylesheet" href="style.css">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">



    </head>
    <body background="bg-light" class="bg-light">

    <c:import url="/header.jsp" />

        <!-- ********************************************************************************************************************************************       hiii-->
     
        <div class="container-fluid bg-light row m-0 pt-1 px-0"> 
            <div class="col-md-6 px-5  py-0 bg-light">
                <form action="EncryptServlet" onload="" method="post"  class="p-4" enctype="multipart/form-data">
                    <label for="inputGroupFile01"  class="ml-5 h4 font-weight-bold  pb-2  ">Select only (.txt) File For Encryption :</label>
                    <!--                 destination file -->
                                        

                    <div class="destinationfile" style="display: flex; width:106%;">
                        <label class="h6 pl-5  ml-5 w-50 py-2 font-weight-bold" style="font-family: 'Montserrat', sans-serif;background-color:#F0F0F0;border-radius:5px 0px 0px 5px; "
                               id="filename"></label>
                        <div class="iconandtext " style="text-align: center;">
                            <label for="destnationFileInput" style="background-color: rgb(206, 205, 420);" class="btn px-4 py-2"><svg
                                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="14">
                                <path fill-rule="evenodd"
                                      d="M1.75 1A1.75 1.75 0 000 2.75v10.5C0 14.216.784 15 1.75 15h12.5A1.75 1.75 0 0016 13.25v-8.5A1.75 1.75 0 0014.25 3h-6.5a.25.25 0 01-.2-.1l-.9-1.2c-.33-.44-.85-.7-1.4-.7h-3.5z">
                                </path>
                                </svg>&nbsp;&nbsp;&nbsp;Browse</label>
                            
                           
                            <input type="file" accept=".txt" id="destnationFileInput" name="file1" style="display: none;">
                          
                        </div>
                    </div>
                    <br>
                    <script>
                          $(function () {
                            $("#destnationFileInput").change(function (event) {
                                var x = event.target.files[0].name;
                                $("#filename").text(x);
                                $('#encryption').prop('disabled', false);
                               
                            });
                        })
                        
                       </script>
                    <!--                 destination file complete -->

                  

                  

                    <input type="checkbox" id="chkfile" name="chkfile"  class="form-control-lg ml-5" style=" width:25px; height: 25px;" onclick="EnableDisableTextbox(this)"/>
                                                
                    <label for ="chkfile" class="h3 text-primary ml-5">You want to send file.</label>
                    <br> <br>
                    

                    <label for="txtEmailIid" class=" h4 text-dark  ml-5"> Email-Id:</label><br>
                    <input type="text" id="txtEmailId" name="txtEmailId" class=" ml-5 form-control-lg w-75"  disabled="disabled"/>
                    <script type="text/javascript">
                        function EnableDisableTextbox(chkfile)
                        {
                            var txtEmailId = document.getElementById("txtEmailId");
                            txtEmailId.disabled = chkfile.checked ? false : true;
                            
                            if (!txtEmailId.disabled)
                            {
                                txtEmailId.focus();
                               
                            }

                        }
                       $(document).ready(function () {
                                $(".nav li").removeClass("active");//this will remove the active class from  
                                                                   //previously active menu item 
                                $('#encryptionLiId').addClass('active');
                               
                              });
                    </script>
                    <br>
                    <br>
                    <center>
                       
                        <input type="submit"  disabled="true"  id="encryption" class="btn btn-primary btn-lg px-5 " value="ENCRYPT"  > 
                    </center>

                </form>  
            </div>
            <div class="col-md-6  pt-5 bg-light ">
                <img src="datagif_encryption.gif" class="rounded mx-auto d-block pt-5" >
            </div>
        </div>





        <!--f********************************************************************************************************ooter main--> 
        <div class=" row container-fluid bg-dark py-0 pb-5 h-75 pt-3 mx-0 "> <!--footer main-->
            <div class="container col-md-9  p-2 bg-dark text-white" style="text-align: justify">
                <h3 class="text-danger">More About Encryption !</h3><hr class="bg-danger">
                <p class="font-weight-bold"> The process of encoding a message so that it can be read only by the sender and the intended recipient. Encryption systems often use two keys, a public key, available to anyone, and a private key that allows only the recipient to decode the message..</p>
                <p class="font-weight-bold">Encryption is the process of using an algorithm to transform information to make it unreadable for unauthorized users. This cryptographic method protects sensitive data such as credit card numbers by encoding and transforming information into unreadable cipher text. This encoded data may only be decrypted or made readable with a key. Symmetric-key and asymmetric-key are the two primary types of encryption.

                    Encryption is essential for ensured and trusted delivery of sensitive information.<p>

            </div><!--about main-->



            <div  class="  col-md-3 p-1  bg-dark text-white">
                <h3 class="text-primary">Contact Us</h3><br>
                <a   class="ml-2  h5"><i class="fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success"></i>&nbsp; 7021751058</a><br><br>
                <a href="https://mail.google.com/mail/u/0/#inbox" target="_blank"  class="ml-2 h6"><i class="fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>




            </div><!-- main-->
        </div>
        

    </body>
</html>





