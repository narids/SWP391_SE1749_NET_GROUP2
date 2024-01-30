<%-- 
    Document   : login
    Created on : Jan 20, 2024, 1:06:03 PM
    Author     : owner
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="./assets/css/assets.css">
        <link href="./assets/css/assets.css" rel="stylesheet" type="text/css"/>

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="./assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="./assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <!--<link rel="stylesheet" type="text/css" href="./assets/css/style.css">-->
        <link href="./assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link class="skin" rel="stylesheet" type="text/css" href="./assets/css/color/color-1.css">
        <style>

            .input-group {
                position: relative;
            }
            .toggle-password {
                position: absolute;
                right: 5px;
                top: 50%;
                transform: translateY(-50%);
                cursor: pointer;
                z-index: 99;
            }

            #toast {
                position: fixed;
                top: 20px;
                left: 50%;
                transform: translateX(-50%);
                color : white;
                padding: 20px 40px;
                z-index: 9999;
                box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
                border-radius: 10px;
                opacity: 0;
                visibility: hidden;
                transition: opacity 0.7s;
            }

            .show {
                opacity: 1 !important;
                visibility: visible !important;
            }

        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">

            <div id="toast"></div>

            <div id="loading-icon-bx"></div>
            <div class="account-form">
                <div class="account-head" style="background-image:url(assets/images/background/bg2.jpg);">
                    <a href="index.html"><img src="assets/images/logo-white-2.png" alt=""></a>
                </div>
                <div class="account-form-inner">
                    <div class="account-container">
                        <div class="heading-bx left">
                            <h2 class="title-head">Login to your <span>Account</span></h2>
                            <p>You don't have an account? <a href="register">Register now</a></p>
                        </div>	
                        <form class="contact-bx" id="loginForm" method="post" action="login">
                            <div class="row placeani">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input name="username" placeholder="Username" value="${requestScope.username}" type="text" required="" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <input name="password" id="password" placeholder="Password" value="${requestScope.password}" type="password" class="form-control" required="">
                                            <span class="toggle-password" id="togglePassword">&#x1F441;</span>
                                        </div>
                                    </div>
                                </div>

                                <p  style="color: ${messColor};">${mess}</p>

                                <div class="col-lg-12">
                                    <div class="form-group form-forget">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" name="remember"
                                                   <c:if test="${remember == true}">checked="checked"</c:if>
                                                   class="custom-control-input" id="customControlAutosizing">
                                            <label class="custom-control-label" for="customControlAutosizing">Remember me</label>
                                        </div>
                                        <a href="forgot-password" class="ml-auto">Forgot Password?</a>
                                    </div>
                                </div>
                                <div class="col-lg-12 m-b30">
                                    <button name="submit" type="submit" value="Submit" class="btn button-md">Login</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- External JavaScripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="assets/vendors/counter/waypoints-min.js"></script>
        <script src="assets/vendors/counter/counterup.min.js"></script>
        <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="assets/vendors/masonry/masonry.js"></script>
        <script src="assets/vendors/masonry/filter.js"></script>
        <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            function toastMessageAction(text, color, link) {
                if (text && text !== "") {
                    $('#toast').text(text);
                    $('#toast').css('background-color', color);
                    $('#toast').toggleClass('show');

                    // After 3 seconds, remove the show class from DIV and redirect
                    if (link && link !== "") {
                        setTimeout(function () {
                            window.location.href = link;
                        }, 3000);
                    }
                    setTimeout(function () {
                        $('#toast').text("");
                        $('#toast').toggleClass('show');
                    }, 4000);
                }
            }

            $(document).ready(function () {
                $('#togglePassword').click(function () {
                    var passwordInput = $('#password');
                    var icon = $(this);

                    if (passwordInput.attr('type') === 'password') {
                        passwordInput.attr('type', 'text');
                        icon.html('&#x1F440;'); // Mắt mở
                    } else {
                        passwordInput.attr('type', 'password');
                        icon.html('&#x1F441;'); // Mắt đóng
                    }
                });


                $('#loginForm').submit(function (event) {
                    event.preventDefault();

                    var formData = $(this).serialize();
                    $.ajax({
                        url: "/SWP391_SE1749_NET_GROUP2/login",
                        type: "post",
                        data: formData,
                        success: function (data) {
                            let text = "Login successfully! Sendirect Home...";
                            let color = "green";
                            let link = "/SWP391_SE1749_NET_GROUP2/home";

                            switch (data) {
                                case "success":
                                    break;

                                case "notCorrect":
                                    text = "Username or password are not correct. Please try again!";
                                    color = "red";
                                    link = "";
                                    break;

                                case "inActive":
                                    text = "Your account is inactive. Need verify account";
                                    color = "red";
                                    link = "";
                                    break;
                            }

                            toastMessageAction(text, color, link);
                        },
                        error: function (err) {
                            toastMessageAction(err, "red", "/SWP391_SE1749_NET_GROUP2/login");
                        }
                    });
                });
            });

        </script>
    </body>

</html>

