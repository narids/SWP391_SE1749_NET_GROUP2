<%-- 
    Document   : login
    Created on : Jan 13, 2024, 12:05:38 AM
    Author     : tudo7
--%>

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
        <link href="./assets/css/assets.css" rel="stylesheet" type="text/css" >


        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
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
                            <h2 class="title-head">Reset your <span>Account</span></h2>
                            <p>Have an account? <a href="login">Login</a></p>
                        </div>	
                        <form id="resetForm" class="contact-bx needs-validation" novalidate>
                            <input type="hidden"  name="action" value="changepassword">

                            <div class="row placeani">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <input name="password" type="password" placeholder="Enter password" id="password" required="" class="form-control" pattern="^[A-Za-z0-9]{6,20}$">
                                            <span class="toggle-password" id="togglePassword1">&#x1F441;</span>
                                            <div class="invalid-feedback">
                                                Password must least 6 char, 2 digit and string
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <input  type="password" placeholder="Enter confirm password" id="repassword" class="form-control" required name="repassword">

                                            <span class="toggle-password" id="togglePassword2">&#x1F441;</span>
                                            <div class="invalid-feedback">
                                                Confirm password must input
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12 m-b30">
                                    <button  type="submit" id="savePass" class="btn button-md">Save</button>
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
                    if (link) {
                        setTimeout(function () {
                            window.location.href = link;
                        }, 3000);
                    }
                    setTimeout(function () {
                        $("#savePass").removeAttr('disabled');

                        $('#toast').text("");
                        $('#toast').toggleClass('show');
                    }, 4000);
                }
            }

            $(document).ready(function () {
                $('#togglePassword1').click(function () {
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

                $('#togglePassword2').click(function () {
                    var passwordInput = $('#repassword');
                    var icon = $(this);

                    if (passwordInput.attr('type') === 'password') {
                        passwordInput.attr('type', 'text');
                        icon.html('&#x1F440;'); // Mắt mở
                    } else {
                        passwordInput.attr('type', 'password');
                        icon.html('&#x1F441;'); // Mắt đóng
                    }
                });


                const forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.from(forms).forEach(form => {
                    form.addEventListener('submit', event => {
                        event.preventDefault();
                        var password = $('#password').val();
                        var confirmPassword = $('#repassword').val();

                        if (!form.checkValidity()) {
                            event.stopPropagation()

                        } else if (password !== confirmPassword) {
                            toastMessageAction("Confirm password does not match!", "red");

                        } else {
                            $("#savePass").prop("disabled", true);
                            $.ajax({
                                url: "/SWP391_SE1749_NET_GROUP2/resetpassword",
                                type: "post",
                                data: {
                                    password: $('#password').val()
                                },
                                success: function (data) {
                                    let text = "";
                                    let color = "green";
                                    let link = "";

                                    switch (data) {
                                        case "success":
                                            text = "Reset password successfully! Sendirect login...";
                                            link = "/SWP391_SE1749_NET_GROUP2/login";
                                            break;

                                        case "failed":
                                            text = "Verification code has expired! Sendirect...";
                                            color = "red";
                                            link = "/SWP391_SE1749_NET_GROUP2/forgot-password";
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
                    }, false)
                })

            });

        </script>
    </body>

</html>

