<%-- 
    Document   : login
    Created on : Jan 13, 2024, 12:05:38 AM
    Author     : tudo7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">


    <head>
        <title>Verify Code</title>

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
        <link href="./assets/css/assets.css" rel="stylesheet" type="text/css" >


        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <link rel="stylesheet" type="text/css" href="assets/css/verifyform.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/snackbar.css">
        <link rel="stylesheet" type="text/css" href="assets/css/successtoast.css">

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
                            <h2 class="title-head">Verify your <span>Account</span></h2>
                            <p>Change another email address, <a href="register">click here</a></p>
                        </div>	
                        <div class="container">
                            <h2 class="head">Enter Verification Code</h2>

                            <form id="verifyFormfg" method="post">
                                <input type="hidden"  name="action" value="confirmEmail">
                                <input type="text" id="code" name="code" placeholder="Enter 6-digit code" pattern="\d{6}">
                                <input type="submit" id="verifySubmit" value="Verify">
                            </form>

                            <br/>

                            <div class="col-lg-12 m-b30">
                                <button id="reSendCode" class="btn button-md">Resent Code</button>
                            </div>
                        </div>
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
                        $("#verifySubmit").removeAttr('disabled');
                        $("#reSendCode").removeAttr('disabled');
                        
                        $('#toast').text("");
                        $('#toast').toggleClass('show');
                    }, 4000);
                }
            }

            $('#verifyFormfg').submit(function (event) {
                event.preventDefault();
                $("#verifySubmit").prop("disabled", true);

                var formData = $(this).serialize();
                $.ajax({
                    url: "/SWP391_SE1749_NET_GROUP2/confirmEmail",
                    type: "post",
                    data: formData,
                    success: function (data) {
                        let text = "Verify successfully! Sendirect Login...";
                        let color = "green";
                        let link = "/SWP391_SE1749_NET_GROUP2/login";

                        switch (data) {
                            case "success":
                                break;

                            case "failed":
                                text = "Register failed, please try again";
                                color = "red";
                                link = "";
                                break;

                            case "timeout":
                                text = "Verification code has expired.";
                                color = "red";
                                link = "";
                                break;

                            case "invalid":
                                text = "Invalid verification code.";
                                color = "red";
                                link = "";
                                break;
                        }

                        toastMessageAction(text, color, link);
                    },
                    error: function (err) {
                        toastMessageAction(err, "red", "");
                    }
                });
            });

            $('#reSendCode').click(function (event) {
                event.preventDefault();
                $("#verifySubmit").prop("disabled", true);
                $("#reSendCode").prop("disabled", true);

                var formData = $(this).serialize();
                $.ajax({
                    url: "/SWP391_SE1749_NET_GROUP2/confirmEmail",
                    type: "post",
                    data: {
                        code : $("#code").val();
                        action : "resend"
                    },
                    success: function (data) {
                        let text = "Resend code successfully! Please check email...";
                        let color = "green";
                        let link = "";

                        switch (data) {
                            case "success":
                                break;

                            case "failed":
                                text = "Resend failed, please try again";
                                color = "red";
                                break;
                        }

                        toastMessageAction(text, color, link);
                    },
                    error: function (err) {
                        toastMessageAction(err, "red", "");
                    }
                });
            });
        </script>
    </body>

</html>

