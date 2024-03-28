<%-- 
    Document   : quiz
    Created on : Feb 21, 2024, 10:13:20 PM
    Author     : owner
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <style>
            .input-group {
                position: relative;
            }
            .toggle-password {
                position: absolute;
                right: 25px;
                top: 8px;
                cursor: pointer;
                z-index: 99;
            }

            #toast {
                position: fixed;
                top: 140px;
                left: 50%;
                transform: translateX(-50%);
                color : white;
                padding: 20px 40px;
                z-index: 999;
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

            .quizStatusBtn{
                color: orange;
            }

            .quizStatusBtn.noClick {
                pointer-events: none;
                color: lightgray;
            }
            
            .quizzesList{
                height: unset !important;
            }

        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">

            <div id="toast"></div>

            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <jsp:include page="components/header.jsp"></jsp:include>
                <!-- header END ==== -->
                <!-- Content -->
                <div class="page-content bg-white">
                    <!-- Breadcrumb row -->
                    <div class="breadcrumb-row">
                        <div class="container">
                            <ul class="list-inline">
                                <li><a href="home">Home</a></li>
                                <li>Quizzes</li>
                            </ul>
                        </div>
                    </div>
                    <!-- Breadcrumb row END -->
                    <!-- inner page banner END -->
                    <div class="content-block">
                        <!-- About Us -->
                        <div class="section-area section-sp1">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                        <div class="">
                                            <h3>My Quizzes</h3>
                                            <div class="feature-filters style1 ml-auto">
                                                <ul class="filters" data-toggle="buttons" style="border-color: #e7ecf1; border-style: solid; border-width: 0.5px">
                                                <c:if test="${sessionScope.account.role.roleId != 4}">
                                                    <li data-filter="" class="btnFilter active" id="filterAll">
                                                        <input type="radio">
                                                        <a href=""><span>All</span></a> 
                                                    </li>
                                                    <li data-filter="publish" class="btnFilter" id="filterPublish">
                                                        <input type="radio">
                                                        <a href=""><span>Public</span></a> 
                                                    </li>
                                                    <li data-filter="pending" class="btnFilter" id="filterPrivate">
                                                        <input type="radio">
                                                        <a href=""><span>Private</span></a> 
                                                    </li>
                                                </c:if>
                                            </ul>
                                        </div>
                                    </div>
                                    <div style="display: flex; align-items: center;flex-wrap: wrap; gap: 10px;">
                                        <div style="border-top: 1px solid gray;
                                             margin-bottom: 10px;
                                             padding-top: 10px; width: 100%">Sort by</div>
                                        <select id="sortQuizBy">
                                            <option value="QuizName">Quiz name</option>
                                            <option value="QuizContent">Quiz content</option>
                                            <option value="CreatedDate">Create date</option>
                                            <option value="ClassName">Class name</option>
                                            <option value="SubjectName">Subject name</option>
                                        </select>
                                    </div>
                                    <div style="margin-top: 20px;
                                         border-top: 1px solid gray;
                                         margin-bottom: 10px;
                                         padding-top: 10px;">Search by</div>
                                    <div style="display: flex; align-items: center;flex-wrap: wrap-reverse; gap: 10px;">
                                        <input type="text" id="searchQuiz" placeholder="Enter here.." style='height: 40px; font-size: 12px; border: 1px;width: 100%; border-color: #e7ecf1; border-style: solid; padding-left: 10px; padding-right: 10px'/>
                                        <select id="searchQuizBy">
                                            <option value="QuizName">Quiz name</option>
                                            <option value="QuizContent">Quiz content</option>
                                            <option value="CreatedDate">Create date</option>
                                            <option value="ClassName">Class name</option>
                                            <option value="SubjectName">Subject name</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="courses-filter">
                                        <div class="clearfix">
                                            <ul id="masonry" class="ttr-gallery-listing magnific-image row quizzesList" style="height: unset">
                                                <c:forEach var="q" items="${requestScope.quizzes}">
                                                    <li class='action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish'>
                                                        <div class="cours-bx">
                                                            <div class="action-box">
                                                                <img src='assets/images/courses/pic1.jpg' alt="">
                                                                <a href='quizzes?quizID=${q.quiz.quizId}' class="btn">View More</a>
                                                            </div>
                                                            <div class="info-bx text-center">
                                                                <h5><a href='quizzes?quizID=${q.quiz.quizId}'>${fn:toUpperCase(q.quiz.quizName)}</a></h5>
                                                                <span>${q.quiz.quizContent}</span>
                                                            </div>
                                                            <div class="cours-more-info">
                                                                <div class="review">
                                                                    <c:choose>
                                                                        <c:when test = "${q.quiz.quizStatus == 0}">
                                                                            <span id='quizStatusID-${q.quiz.quizId}' style=" display: flex; align-items: center; gap: 8px; justify-content: space-between;">
                                                                                <span style="color: red;">Private</span><c:if test="${sessionScope.account.role.roleId != 4}"><i onclick="updateStatus(${q.quiz.quizId}, 'toPublish')" class="bi bi-arrow-repeat quizStatusBtn" style="font-size: 19px; cursor: pointer"></c:if></i>
                                                                                </span>
                                                                        </c:when>

                                                                        <c:when test = "${q.quiz.quizStatus == 1}">
                                                                            <span id='quizStatusID-${q.quiz.quizId}' style="display: flex; align-items: center; gap: 8px; justify-content: space-between;">
                                                                                <span style="color: green;">Public</span><c:if test="${sessionScope.account.role.roleId != 4}"><i onclick="updateStatus(${q.quiz.quizId}, 'toPrivate')" class="bi bi-arrow-repeat quizStatusBtn" style="font-size: 19px; cursor: pointer"></i></c:if>
                                                                                </span>
                                                                        </c:when>
                                                                    </c:choose>
                                                                    <ul class="cours-star">
                                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                                        <li class="active"><i class="fa fa-star"></i></li>
                                                                        <li><i class="fa fa-star"></i></li>
                                                                        <li><i class="fa fa-star"></i></li>
                                                                    </ul>
                                                                </div>
                                                                <div class="price">
                                                                    <div style="font-size: 14px; margin-top: 5px">${q.subject.subjectName}</div>
                                                                    <h5>${q.myClass.className}</h5>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- contact area END -->

    </div>
    <!-- Content END-->
    <!-- Footer ==== -->
    <footer>
        <div class="footer-top">
            <div class="pt-exebar">
                <div class="container">
                    <div class="d-flex align-items-stretch">
                        <div class="pt-logo mr-auto">
                            <a href="index.html"><img src="assets/images/logo-white.png" alt=""/></a>
                        </div>
                        <div class="pt-social-link">
                            <ul class="list-inline m-a0">
                                <li><a href="#" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#" class="btn-link"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#" class="btn-link"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                        <div class="pt-btn-join">
                            <a href="#" class="btn ">Join Now</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-12 col-sm-12 footer-col-4">
                        <div class="widget">
                            <h5 class="footer-title">Sign Up For A Newsletter</h5>
                            <p class="text-capitalize m-b20">Weekly Breaking news analysis and cutting edge advices on job searching.</p>
                            <div class="subscribe-form m-b20">
                                <form class="subscription-form" action="http://educhamp.themetrades.com/demo/assets/script/mailchamp.php" method="post">
                                    <div class="ajax-message"></div>
                                    <div class="input-group">
                                        <input name="email" required="required"  class="form-control" placeholder="Your Email Address" type="email">
                                        <span class="input-group-btn">
                                            <button name="submit" value="Submit" type="submit" class="btn"><i class="fa fa-arrow-right"></i></button>
                                        </span> 
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-5 col-md-7 col-sm-12">
                        <div class="row">
                            <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                <div class="widget footer_widget">
                                    <h5 class="footer-title">Company</h5>
                                    <ul>
                                        <li><a href="index.html">Home</a></li>
                                        <li><a href="about-1.html">About</a></li>
                                        <li><a href="faq-1.html">FAQs</a></li>
                                        <li><a href="contact-1.html">Contact</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                <div class="widget footer_widget">
                                    <h5 class="footer-title">Get In Touch</h5>
                                    <ul>
                                        <li><a href="http://educhamp.themetrades.com/admin/index.html">Dashboard</a></li>
                                        <li><a href="blog-classic-grid.html">Blog</a></li>
                                        <li><a href="portfolio.html">Portfolio</a></li>
                                        <li><a href="event.html">Event</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                <div class="widget footer_widget">
                                    <h5 class="footer-title">Quiz</h5>
                                    <ul>
                                        <li><a href="quiz.html">Quiz</a></li>
                                        <li><a href="courses-details.html">Details</a></li>
                                        <li><a href="membership.html">Membership</a></li>
                                        <li><a href="profile.html">Profile</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-3 col-md-5 col-sm-12 footer-col-4">
                        <div class="widget widget_gallery gallery-grid-4">
                            <h5 class="footer-title">Our Gallery</h5>
                            <ul class="magnific-image">
                                <li><a href="assets/images/gallery/pic1.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic1.jpg" alt=""></a></li>
                                <li><a href="assets/images/gallery/pic2.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic2.jpg" alt=""></a></li>
                                <li><a href="assets/images/gallery/pic3.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic3.jpg" alt=""></a></li>
                                <li><a href="assets/images/gallery/pic4.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic4.jpg" alt=""></a></li>
                                <li><a href="assets/images/gallery/pic5.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic5.jpg" alt=""></a></li>
                                <li><a href="assets/images/gallery/pic6.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic6.jpg" alt=""></a></li>
                                <li><a href="assets/images/gallery/pic7.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic7.jpg" alt=""></a></li>
                                <li><a href="assets/images/gallery/pic8.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic8.jpg" alt=""></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">

            </div>
        </div>
    </footer>
    <!-- Footer END ==== -->
    <button class="back-to-top fa fa-chevron-up" ></button>
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
<script>
                                                                                    function toastMessageAction(text, color, link) {
                                                                                        if (text && text !== "") {
                                                                                            $('#toast').text(text);
                                                                                            $('#toast').css('background-color', color);
                                                                                            $('#toast').toggleClass('show');
                                                                                            setTimeout(function () {
                                                                                                $('#toast').text("");
                                                                                                $('#toast').toggleClass('show');
                                                                                                $("#SaveChangePass").removeProp("disabled");
                                                                                                $("#CancelChangePass").removeProp("disabled");
                                                                                            }, 2000);
                                                                                        }
                                                                                    }
                                                                                    function toastChangeStatus(text, color) {
                                                                                        if (text && text !== "") {
                                                                                            $('#toast').text(text);
                                                                                            $('#toast').css('background-color', color);
                                                                                            $('#toast').toggleClass('show');

                                                                                            setTimeout(function () {
                                                                                                $("i.quizStatusBtn").removeClass("noClick");
                                                                                                $('#toast').text("");
                                                                                                $('#toast').toggleClass('show');
                                                                                            }, 2000);
                                                                                        }
                                                                                    }
                                                                                    function updateStatus(id, type) {
                                                                                        $("i.quizStatusBtn").addClass("noClick");
                                                                                        $.ajax({
                                                                                            url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                            type: "post",
                                                                                            data: {
                                                                                                action: "changeQuizStatus",
                                                                                                id: id,
                                                                                                type: type
                                                                                            },
                                                                                            success: function (data) {
                                                                                                let text = "Change status successfully";
                                                                                                let color = "green";

                                                                                                if (data !== "") {
                                                                                                    let IDString = "quizStatusID-" + id;
                                                                                                    var parent = document.getElementById(IDString);
                                                                                                    parent.innerHTML = data;
                                                                                                } else {
                                                                                                    text = "Change status failed";
                                                                                                    color = "red";
                                                                                                }

                                                                                                toastChangeStatus(text, color);
                                                                                            },
                                                                                            error: function (err) {
                                                                                                toastChangeStatus("Something went wrong", "red");
                                                                                            }
                                                                                        });
                                                                                    }

                                                                                    $(document).ready(function () {
                                                                                        $('#togglePassword1').click(function () {
                                                                                            var passwordInput = $('#currentPassword');
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
                                                                                            var passwordInput = $('#newPassword');
                                                                                            var icon = $(this);

                                                                                            if (passwordInput.attr('type') === 'password') {
                                                                                                passwordInput.attr('type', 'text');
                                                                                                icon.html('&#x1F440;'); // Mắt mở
                                                                                            } else {
                                                                                                passwordInput.attr('type', 'password');
                                                                                                icon.html('&#x1F441;'); // Mắt đóng
                                                                                            }
                                                                                        });
                                                                                        $('#togglePassword3').click(function () {
                                                                                            var passwordInput = $('#confirmPassword');
                                                                                            var icon = $(this);

                                                                                            if (passwordInput.attr('type') === 'password') {
                                                                                                passwordInput.attr('type', 'text');
                                                                                                icon.html('&#x1F440;'); // Mắt mở
                                                                                            } else {
                                                                                                passwordInput.attr('type', 'password');
                                                                                                icon.html('&#x1F441;'); // Mắt đóng
                                                                                            }
                                                                                        });

                                                                                        $("#filterAll").click(function () {
                                                                                            var selectVal = $("#sortQuizBy option:selected").val();
                                                                                            $.ajax({
                                                                                                url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                type: "post",
                                                                                                data: {
                                                                                                    action: "quizTabFilter",
                                                                                                    filterStatus: "all",
                                                                                                    sortBy: selectVal
                                                                                                },
                                                                                                success: function (data) {
                                                                                                    if (data !== "") {
                                                                                                        $(".quizzesList").empty();
                                                                                                        $(".quizzesList").html(data);
                                                                                                        $('.quizzesList').css("height", "unset");

                                                                                                    }
                                                                                                },
                                                                                                error: function () {
                                                                                                }
                                                                                            });
                                                                                        });
                                                                                        $("#filterPublish").click(function () {
                                                                                             var selectVal = $("#sortQuizBy option:selected").val();
                                                                                            $.ajax({
                                                                                                url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                type: "post",
                                                                                                data: {
                                                                                                    action: "quizTabFilter",
                                                                                                    filterStatus: "publish",
                                                                                                    sortBy: selectVal
                                                                                                },
                                                                                                success: function (data) {
                                                                                                    if (data !== "") {
                                                                                                        $(".quizzesList").empty();
                                                                                                        $(".quizzesList").html(data);
                                                                                                    }
                                                                                                },
                                                                                                error: function () {
                                                                                                }
                                                                                            });
                                                                                        });
                                                                                        $("#filterPrivate").click(function () {
                                                                                             var selectVal = $("#sortQuizBy option:selected").val();
                                                                                            $.ajax({
                                                                                                url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                type: "post",
                                                                                                data: {
                                                                                                    action: "quizTabFilter",
                                                                                                    filterStatus: "private",
                                                                                                    sortBy: selectVal
                                                                                                },
                                                                                                success: function (data) {
                                                                                                    if (data !== "") {
                                                                                                        $(".quizzesList").empty();
                                                                                                        $(".quizzesList").html(data);
                                                                                                    }
                                                                                                },
                                                                                                error: function () {
                                                                                                }
                                                                                            });
                                                                                        });

                                                                                        $('#sortQuizBy').on('change', function () {
                                                                                            var selectVal = $("#sortQuizBy option:selected").val();

                                                                                            $.ajax({
                                                                                                url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                type: "post",
                                                                                                data: {
                                                                                                    action: "quizTabFilter",
                                                                                                    sortBy: selectVal
                                                                                                },
                                                                                                success: function (data) {
                                                                                                    if (data !== "") {
                                                                                                        var parent = document.getElementsByClassName("quizzesList");
                                                                                                        parent[0].innerHTML = data;
                                                                                                    }
                                                                                                },
                                                                                                error: function () {
                                                                                                }
                                                                                            });
                                                                                        });
                                                                                        $('#searchQuiz').on('input', function () {
                                                                                            var selectVal = $("#searchQuizBy option:selected").val();
                                                                                            var value = $(this).val();

                                                                                            $.ajax({
                                                                                                url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                type: "post",
                                                                                                data: {
                                                                                                    action: "quizTabFilter",
                                                                                                    searchBy: selectVal,
                                                                                                    searchValue: value
                                                                                                },
                                                                                                success: function (data) {
                                                                                                    if (data !== "") {
                                                                                                        var parent = document.getElementsByClassName("quizzesList");
                                                                                                        parent[0].innerHTML = data;

                                                                                                    }
                                                                                                },
                                                                                                error: function () {
                                                                                                }
                                                                                            });
                                                                                        });

                                                                                    });

</script>
</body>

</html>

