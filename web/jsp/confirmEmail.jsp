<%-- 
    Document   : login
    Created on : Jan 13, 2024, 12:05:38 AM
    Author     : tudo7
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <!--<link rel="stylesheet" type="text/css" href="assets/css/verifyform.css"/>-->
        <!--<link rel="stylesheet" type="text/css" href="assets/css/snackbar.css">-->
        <!--<link rel="stylesheet" type="text/css" href="assets/css/successtoast.css">-->

        <style>
            .input-group {
                position: relative;
            }
            .toggle-password {
                position: absolute;
                right: 5px;
                top: 8px;
                cursor: pointer;
                z-index: 99;
            }

            #toast, #toastLoading {
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

            #toastLoading {
                background-color: orange;
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
            <div id="toastLoading">Loading...</div>

            <div id="loading-icon-bx"></div>
            <div class="account-form">
                <div class="account-head" style="background-image:url(assets/images/background/bg2.jpg);">
                    <a href="/SWP391_SE1749_NET_GROUP2"><img src="assets/images/logo-white-2.png" alt=""></a>
                </div>
                <div class="account-form-inner">
                    <div class="account-container">
                        <div class="heading-bx left">
                            <h2 class="title-head">Verify your <span>Account</span></h2>
                            <p>Change another email address, <a href="${sessionScope.type == 'register' ? 'register' : 'forgot-password'}">click here</a></p>
                        </div>	
                        <div class="container" style="margin-left: -15px">
                            <h4 class="">Enter Verification Code</h2>

                            <form id="verifyFormfg" class="needs-validation" novalidate method="post">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <input type="hidden"  name="action" value="confirmEmail">
                                            <input name="code" id="code" type="text" pattern="\d{6}" placeholder="Enter 6-digit code" class="form-control" required="">
                                            <input type="button" id="reSendCode" value="Resent Code" style="cursor: pointer">
                                            <div class="invalid-feedback">
                                                Code must be 6 digit
                                            </div>
                                        </div>
                                    </div>

                                    <br/>

                                    <div class="col-lg-12 m-b30">
                                        <!--<button id="reSendCode" class="btn button-md">Resent Code</button>-->
                                        <button id="verifySubmit" type="submit" class="btn button-md" style="margin-left: -15px">Verify</button>
                                    </div>
                                </form>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script>
            function toastMessLoading() {
                $('#toastLoading').toggleClass('show');
            }
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

            const forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    event.preventDefault();
                    event.stopPropagation();

                    if (form.checkValidity()) {
                        $("#verifySubmit").prop("disabled", true);
                        $("#reSendCode").prop("disabled", true);
                        var formData = $("#verifyFormfg").serialize();
                        $.ajax({
                            url: "/SWP391_SE1749_NET_GROUP2/confirmEmail",
                            type: "post",
                            data: formData,
                            success: function (data) {
                                const status = data.toString().split("-")[0];
                                const type = data.toString().split("-")[1];

                                let text = type === "register" ? "Verify successfully! Sendirect Login..." : "Verify successfully! Sendirect resetpassword...";
                                let color = "green";
                                let link = type === "register" ? "/SWP391_SE1749_NET_GROUP2/login" : "/SWP391_SE1749_NET_GROUP2/resetpassword";

                                switch (status) {
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
                                toastMessageAction("Something went wrong", "red", "");
                            }
                        });
                    }

                    form.classList.add('was-validated')
                }, false);
            })

            $('#reSendCode').click(function (event) {
                event.preventDefault();
                toastMessLoading();
                $("#verifySubmit").prop("disabled", true);
                $("#reSendCode").prop("disabled", true);
                $.ajax({
                    url: "/SWP391_SE1749_NET_GROUP2/confirmEmail",
                    type: "post",
                    data: {
                        code: $("#code").val(),
                        action: "resend"
                    },
                    success: function (data) {
                        toastMessLoading();
                        let text = "Resend code successfully! Please check email...";
                        let color = "green";

                        switch (data) {
                            case "success":
                                break;

                            case "failed":
                                text = "Resend failed, please try again";
                                color = "red";
                                break;
                        }

                        toastMessageAction(text, color, "");
                    },
                    error: function (err) {
                        toastMessLoading();
                        toastMessageAction(err, "red", "");
                    }
                });
            });
        </script>
    </body>

</html>

