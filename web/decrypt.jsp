<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>DECRYPTION PAGE</title>
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
                    <link rel="stylesheet" href="style.css">

                        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">



                            </head>
                            <body class="bg-light">

                                <c:import url="/header.jsp" />
                                <!-- ********************************************************************************************************************************************       hiii-->


                                <div class="container-fluid bg-light row m-0 pt-1 px-0 ">
                                    <div class="col-md-6 pt-5   bg-light">
                                        <img src="datagif_encryption.gif" class="rounded mx-auto d-block pt-5 pl-5 bg-light "  > 
                                    </div>

                                    <div class="col-md-6 px-5 pt-3 py-0 bg-light ">
                                        <form action="DecryptServlet" method="post"  enctype="multipart/form-data" >
                                            <label for="inputGroupFile01"  class="ml-5 h4 font-weight-bold pt-3 pb-2   ">Select only encrypted File For Decryption :</label>
                                          
                                                 <br>

                                            <div class="destinationfile" style="display: flex; width:106%;">
                                                <label class="h6 pl-5  ml-5  w-50 py-2 font-weight-bold" style="font-family: 'Montserrat', sans-serif;background-color:#F0F0F0; border-radius:5px 0px 0px 5px;"
                                                       id="filename"></label>
                                                <div class="iconandtext " style="text-align: center;">
                                                    <label for="destnationFileInput"  style="background-color: rgb(206, 205, 420 );" class="btn px-4 py-2"><svg
                                                            xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="20" style="background-color: rgb(206, 205, 420 );">
                                                            <path fill-rule="evenodd"
                                                                  d="M1.75 1A1.75 1.75 0 000 2.75v10.5C0 14.216.784 15 1.75 15h12.5A1.75 1.75 0 0016 13.25v-8.5A1.75 1.75 0 0014.25 3h-6.5a.25.25 0 01-.2-.1l-.9-1.2c-.33-.44-.85-.7-1.4-.7h-3.5z">
                                                            </path>
                                                        </svg>&nbsp;&nbsp;&nbsp;Browse</label>                                                   
                                                        <input type="file" id="destnationFileInput" accept=".txt" name="file1" style="display: none;">
                                                            </div>
                                                            </div>
                                                            <script>

                                                                $(function () {

                                                                    $("#destnationFileInput").change(function (event) {
                                                                        var x = event.target.files[0].name;
                                                                        $("#filename").text(x)
                                                                        $('#decryption').prop('disabled', false)

                                                                    });
                                                                })
                                                                $(document).ready(function () {
                                $(".nav li").removeClass("active");//this will remove the active class from  
                                                                   //previously active menu item 
                                $('#decryptLiId').addClass('active');
                               
                              });


                                                            </script>


                                                            <br>


                                                                <input type="checkbox" id="chkfile" name="chkfile" class="form-control-lg ml-5" style=" width:25px; height: 25px;" onclick="EnableDisableTextbox(this)"/>

                                                                <label for ="chkfile" class="h4 text-primary ml-3">You want to send file.</label>
                                                                <br>
                                                                    <br>

                                                                        <label for="txtEmailIid" class=" h4 text-dark  ml-5"> Email-Id:</label>
                                                                        <input type="text" id="txtEmailId" name="txtEmailId" class=" ml-5 form-control-lg w-75 " disabled="disabled"/>
                                                                        <script type="text/javascript">
                                                                            function EnableDisableTextbox(chkfile)
                                                                            {
                                                                                var txtEmailIid = document.getElementById("txtEmailId");
                                                                                txtEmailId.disabled = chkfile.checked ? false : true;
                                                                                sendEncrypt.disabled = chkfile.checked ? false : true;
                                                                                if (!txtEmailId.disabled && !sendEncrypt.disabled)
                                                                                {
                                                                                    txtEmailId.focus();
                                                                                    document.getElementById('sendEncrypt').disabled = false;
                                                                                }

                                                                            }
                                                                        </script>
                                                                        <br>
                                                                            <br>
                                                                                <center class="pb-4">
                                                                                    <input type="submit" class="btn btn-primary btn-lg px-5 mr-5" id="decryption"  disabled="true" value="DECRYPT"  > 

                                                                                </center>

                                                                                </form>   
                                                                                </div>

                                                                                </div>

                                                                                <!--footer main********************************************************************************************************--> 
                                                                                <div class=" row container-fluid bg-dark py-0 pb-3  mx-0 " style="text-align: justify"> <!--footer main-->
            <div class="container col-md-9  p-2 bg-dark text-white">
                <h3 class="text-danger">More About Decryption !</h3><hr class="bg-danger">
                <p class="font-weight-bold"> Decryption is a process of converting encoded/encrypted data in a form that is readable and understood by a human or a computer. Encryption method helps you to protect your confidential data such as passwords and login id...</p>
                <p class="font-weight-bold">One of the reasons for implementing an encryption-decryption system is privacy. As information travels over the Internet, it is necessary to scrutinise the access from unauthorized organisations or individuals. Due to this, the data is encrypted to reduce data loss and theft. Few common items that are encrypted include text files, images, e-mail messages, user data and directories. The recipient of decryption receives a prompt or window in which a password can be entered to access the encrypted data. For decryption, the system extracts and converts the garbled data and transforms it into words and images that are easily understandable not only by a reader but also by a system. Decryption can be done manually or automatically. It may also be performed with a set of keys or passwords.<p>

            </div><!--about main-->



            <div  class="  col-md-3 p-1  bg-dark text-white">
                <h3 class="text-primary">Contact Us</h3><br>
                <a   class="ml-2  h5"><i class="fa fa-phone mx-3 bg-white p-2 rounded-circle px-2 py-1 text-success"></i>&nbsp; 7021751058</a><br><br>
                <a href="https://mail.google.com/mail/u/0/#inbox" target="_blank"  class="ml-2 h6"><i class="fa fa-envelope-o mx-3 bg-white p-2 rounded-circle px-1 py-1 text-danger"></i><b>sudhirgomase2109@gmail.com</b></a><br><br>




            </div><!-- main-->
        </div>                                                                             



</body>
   </html>













































                                                                                                                                                                           