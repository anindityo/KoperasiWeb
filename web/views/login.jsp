<%-- 
    Document   : login
    Created on : Aug 13, 2018, 4:24:54 PM
    Author     : Gusma
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="../styleLogin/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../styleLogin/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../styleLogin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../styleLogin/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../styleLogin/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="../styleLogin/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../styleLogin/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../styleLogin/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="../styleLogin/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../styleLogin/css/util.css">
        <link rel="stylesheet" type="text/css" href="../styleLogin/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-form-title" style="background-image: url(../styleLogin/images/bg-01.jpg);">
                        <span class="login100-form-title-1">
                           Log In
                        </span>
                    </div>
                    <form class="login100-form validate-form" action="loginServlet" method="POST">
                        <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="kode" placeholder="Enter username">
                            <span class="focus-input100"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
                            <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="pass" placeholder="Enter password">
                            <span class="focus-input100"></span>
                        </div>              
                        <div class="container-login100-form-btn">         
                            <input  type="submit" value="Login" class="login100-form-btn">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--===============================================================================================-->
        <script src="../styleLogin/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="../styleLogin/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="../styleLogin/vendor/bootstrap/js/popper.js"></script>
        <script src="../styleLogin/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="../styleLogin/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="../styleLogin/vendor/daterangepicker/moment.min.js"></script>
        <script src="../styleLogin/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="../styleLogin/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="../styleLogin/js/main.js"></script>
    </body>
</html>