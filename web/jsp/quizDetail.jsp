<%-- 
    Document   : quizDetail
    Created on : Feb 25, 2024, 3:07:58 PM
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
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
                top: 80px;
                left: 50%;
                transform: translateX(-50%);
                color : white;
                padding: 20px 40px;
                z-index: 999999;
                box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
                border-radius: 10px;
                opacity: 0;
                visibility: hidden;
                transition: opacity 0.7s;
            }

            .toast.show {
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

            .questionCard{
                display: flex;
                gap: 35px;
                padding-left: 30px;
                padding-right: 30px;
                background-color: #f9f9f9;
                border-radius: 20px;
                padding-top: 15px;
                padding-bottom: 15px;
                position: relative;
                overflow-x: hidden;
            }
            .questionCardAction{
                position: absolute;
                right: 0;
                width: 35px;
                background-color: #2f2e2e;
                height: 100%;
                top: 0;
                border-top-right-radius: 20px;
                border-bottom-right-radius: 20px;
                display: flex;
                flex-direction: column;
                transition: 0.2s all;
                transform: translateX(37px);
                cursor: pointer;
            }
            .questionCard:hover .questionCardAction{
                transform: translateX(0);
            }
        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">

            <div id="toast" class="toast"></div>

            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <header class="header rs-nav">
                <div class="top-bar">
                    <div class="container">
                        <div class="row d-flex justify-content-between">
                            <div class="topbar-left">
                                <ul>
                                    <li><a href="faq-1.html"><i class="fa fa-question-circle"></i>Ask a Question</a></li>
                                    <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>Support@website.com</a></li>
                                </ul>
                            </div>
                            <div class="topbar-right">
                                <ul>
                                    <li>
                                        <select class="header-lang-bx">
                                            <option data-icon="flag flag-uk">English UK</option>
                                            <option data-icon="flag flag-us">English US</option>
                                        </select>
                                    </li>
                                    <li><a href="login">Login</a></li>
                                    <li><a href="register">Register</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sticky-header navbar-expand-lg" style="z-index: 100">
                    <div class="menu-bar clearfix">
                        <div class="container clearfix">
                            <!-- Header Logo ==== -->
                            <div class="menu-logo">
                                <a href="home"><img src="assets/images/logo.png" alt=""></a>
                            </div>
                            <!-- Mobile Nav Button ==== -->
                            <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
                                <span></span>
                                <span></span>
                                <span></span>
                            </button>
                            <!-- Author Nav ==== -->
                            <div class="secondary-menu">
                                <div class="secondary-inner">
                                    <ul>
                                        <!-- Search Button ==== -->
                                        <li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- Search Box ==== -->
                            <div class="nav-search-bar">
                                <form action="quiz-search">
                                    <input name="keyword" value="" type="text" class="form-control" placeholder="Type to search">
                                    <span><i class="ti-search"></i></span>
                                </form>
                                <span id="search-remove"><i class="ti-close"></i></span>
                            </div>
                            <!-- Navigation Menu ==== -->
                            <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                                <div class="menu-logo">
                                    <a href="home"><img src="assets/images/logo.png" alt=""></a>
                                </div>
                                <ul class="nav navbar-nav">	
                                    <li class=""><a href="home">Home</a>
                                    </li>
                                    <li class=""><a href="quizzes">Quizzes</a>
                                    </li>
                                    <li class="active"><a href="catalog">Your library</a>
                                    </li>
                                </ul>
                            </div>
                            <!-- Navigation Menu END ==== -->
                        </div>
                    </div>
                </div>
            </header>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="home">Home</a></li>
                            <li><a href="quizzes">Quizzes</a></li>
                            <li>Quizzes Detail</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1" style="padding-top: 30px">
                        <div class="container">
                            <div class="row d-flex flex-row-reverse">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                    <div class="course-detail-bx">
                                        <div class="course-buy-now text-center">
                                            <c:choose>
                                                <c:when test = "${sessionScope.account.role.roleId != 4}">
                                                    <a class="btn radius-xl text-uppercase" onclick="getQuizID(${quiz.quiz.quizId})" data-bs-toggle="modal" data-bs-target="#updateQuizModal">Update quiz</a>
                                                </c:when>

                                                <c:otherwise>
                                                    <a class="btn radius-xl text-uppercase" id="addFavorite">Add to favorites</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="teacher-bx">
                                            <h5 title="Quiz name" class="text-center">${quiz.quiz.quizName}</h5>
                                            <div title="Quiz descriptions" class="text-center">${quiz.quiz.quizContent}</div>
                                        </div>
                                        <div class="cours-more-info">
                                            <div class="review">
                                                <c:choose>
                                                    <c:when test = "${requestScope.quiz.quiz.quizStatus == 0}">
                                                        <span id='quizStatusID-${requestScope.quiz.quiz.quizId}' style=" display: flex; align-items: center; gap: 8px; justify-content: space-between;">
                                                            <span style="color: red;">Private</span><c:if test="${sessionScope.account.role.roleId != 4}"><i onclick="updateStatus(${requestScope.quiz.quiz.quizId}, 'toPublish')" class="bi bi-arrow-repeat quizStatusBtn" style="font-size: 19px; cursor: pointer"></c:if></i>
                                                            </span>
                                                    </c:when>

                                                    <c:when test = "${requestScope.quiz.quiz.quizStatus == 1}">
                                                        <span id='quizStatusID-${requestScope.quiz.quiz.quizId}' style="display: flex; align-items: center; gap: 8px; justify-content: space-between;">
                                                            <span style="color: green;">Publish</span><c:if test="${sessionScope.account.role.roleId != 4}"><i onclick="updateStatus(${requestScope.quiz.quiz.quizId}, 'toPrivate')" class="bi bi-arrow-repeat quizStatusBtn" style="font-size: 19px; cursor: pointer"></i></c:if>
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
                                            <div class="price categories">
                                                <a title="Subject" href="subjects?subjectID=${requestScope.quiz.subject.subjectId}"><span>${requestScope.quiz.subject.subjectName}</span></a>
                                                <a title="Class" href="classes?classID=${requestScope.quiz.myClass.classID}"><h5 class="text-primary">${requestScope.quiz.myClass.className}</h5></a>
                                            </div>
                                        </div>
                                        <div class="course-info-list scroll-page">
                                            <ul class="navbar">
                                                <li><a class="nav-link" href="#quizzes"><i class="ti-bookmark-alt"></i>Question & Answers</a></li>
                                                <li><a class="nav-link" href="#instructor"><i class="ti-user"></i>Creator</a></li>
                                                <li><a class="nav-link" href="#reviews"><i class="ti-comments"></i>Reviews</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="m-b30" id="quizzes">
                                        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px">
                                            <h4 id="questionLengthCount">Question & Answers (${questions.size()})</h4>
                                            <a class="btn radius-xl text-uppercase" onclick="addQuestionBtnClick(${quiz.subject.subjectId}, ${quiz.quiz.quizId})" data-bs-toggle="modal" data-bs-target="#addQuestionModal">Add question</a>
                                        </div>
                                        <ul class="curriculum-list" id="listQuestions">
                                            <c:forEach var="q" items="${questions}" varStatus="loop">
                                                <li class="questionCard ${q.questionId}">
                                                    <c:set var="correctAnswer" value=""/>
                                                    <div style="width: 100%; min-width: 135px">
                                                        <h5><span>${loop.count}, </span>${q.questionContent}</h5>
                                                        <ul>
                                                            <li style="padding: 15px 0 0 0; border: none">
                                                                <div class="curriculum-list-box">
                                                                    <c:forEach var="a" items="${q.answers}" varStatus="loop">
                                                                        <div style="display: flex; gap: 10px">
                                                                            <c:set var="type" value="&\#${(loop.index+97)}" />
                                                                            <h5>${type}.</h5> ${a.answerContent}
                                                                        </div>

                                                                        <c:if test="${a.isCorrect == true}">
                                                                            <c:choose>
                                                                                <c:when test = "${empty correctAnswer}">
                                                                                    <c:set var="correctAnswer" value="&\#${(loop.index+97)}"/>
                                                                                </c:when>

                                                                                <c:otherwise>
                                                                                    <c:set var="correctAnswer" value="${correctAnswer}, &\#${(loop.index+97)}"/>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <h5 style="color: green; border-left: 1px solid lightgray; padding: 0 35px; min-width: 120px; width: 120px">${correctAnswer}</h5>

                                                    <c:if test="${sessionScope.account.role.roleId != 4}">
                                                        <div class="questionCardAction">
                                                            <i onclick="updateQuestionBtnClick(${q.questionId}, ${quiz.quiz.quizId}, ${quiz.subject.subjectId})" data-bs-toggle="modal" data-bs-target="#updateCardModal" title="Update" class="bi bi-pencil-fill" style="color: orange; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center; border-bottom: 1px solid #cccccc"></i>
                                                            <i onclick="deleteQuestionBtnClick(${q.questionId}, ${quiz.quiz.quizId}, ${quiz.subject.subjectId})" data-bs-toggle="modal" data-bs-target="#deleteCardModal" title="Delete" class="bi bi-trash3-fill" style="color: red; width: 100%; height: 100%; display: flex; align-items: center; justify-content: center"></i>
                                                        </div>
                                                    </c:if>
                                                </li>
                                            </c:forEach>

                                        </ul>
                                    </div>
                                    <div class="" id="instructor">
                                        <h4>Creator</h4>
                                        <div class="instructor-bx">
                                            <div class="instructor-author">
                                                <img src="assets/images/testimonials/pic1.jpg" alt="">
                                            </div>
                                            <div class="instructor-info">
                                                <h6>${teacherFullname}</h6>
                                                <span>Teacher</span>
                                                <ul class="list-inline m-tb10">
                                                    <li><a href="#" class="btn sharp-sm facebook"><i class="fa fa-facebook"></i></a></li>
                                                    <li><a href="#" class="btn sharp-sm twitter"><i class="fa fa-twitter"></i></a></li>
                                                    <li><a href="#" class="btn sharp-sm linkedin"><i class="fa fa-linkedin"></i></a></li>
                                                    <li><a href="#" class="btn sharp-sm google-plus"><i class="fa fa-google-plus"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="" id="reviews">
                                        <h4>Reviews</h4>

                                        <div class="review-bx">
                                            <div class="all-review">
                                                <h2 class="rating-type">3</h2>
                                                <ul class="cours-star">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li><i class="fa fa-star"></i></li>
                                                    <li><i class="fa fa-star"></i></li>
                                                </ul>
                                                <span>3 Rating</span>
                                            </div>
                                            <div class="review-bar">
                                                <div class="bar-bx">
                                                    <div class="side">
                                                        <div>5 star</div>
                                                    </div>
                                                    <div class="middle">
                                                        <div class="bar-container">
                                                            <div class="bar-5" style="width:90%;"></div>
                                                        </div>
                                                    </div>
                                                    <div class="side right">
                                                        <div>150</div>
                                                    </div>
                                                </div>
                                                <div class="bar-bx">
                                                    <div class="side">
                                                        <div>4 star</div>
                                                    </div>
                                                    <div class="middle">
                                                        <div class="bar-container">
                                                            <div class="bar-5" style="width:70%;"></div>
                                                        </div>
                                                    </div>
                                                    <div class="side right">
                                                        <div>140</div>
                                                    </div>
                                                </div>
                                                <div class="bar-bx">
                                                    <div class="side">
                                                        <div>3 star</div>
                                                    </div>
                                                    <div class="middle">
                                                        <div class="bar-container">
                                                            <div class="bar-5" style="width:50%;"></div>
                                                        </div>
                                                    </div>
                                                    <div class="side right">
                                                        <div>120</div>
                                                    </div>
                                                </div>
                                                <div class="bar-bx">
                                                    <div class="side">
                                                        <div>2 star</div>
                                                    </div>
                                                    <div class="middle">
                                                        <div class="bar-container">
                                                            <div class="bar-5" style="width:40%;"></div>
                                                        </div>
                                                    </div>
                                                    <div class="side right">
                                                        <div>110</div>
                                                    </div>
                                                </div>
                                                <div class="bar-bx">
                                                    <div class="side">
                                                        <div>1 star</div>
                                                    </div>
                                                    <div class="middle">
                                                        <div class="bar-container">
                                                            <div class="bar-5" style="width:20%;"></div>
                                                        </div>
                                                    </div>
                                                    <div class="side right">
                                                        <div>80</div>
                                                    </div>
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
                                            <h5 class="footer-title">Courses</h5>
                                            <ul>
                                                <li><a href="quiz.html">Courses</a></li>
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
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 text-center"><a target="_blank" href="https://www.templateshub.net">Templates Hub</a></div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- Footer END ==== -->
            <button class="back-to-top fa fa-chevron-up" ></button>



            <div class="modal fade" id="updateCardModal" tabindex="-1" aria-labelledby="updateCardModal" aria-hidden="true">
                <div class="modal-dialog modal-lg" style="margin: 8.75rem auto;">
                    <div class="modal-content" style="border-radius: 20px">
                        <div class="modal-header">
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Update Question</h4>
                            <i class="bi bi-x-lg" data-bs-dismiss="modal" aria-label="Close" style="cursor: pointer"></i>
                        </div>
                        <div class="modal-body" style="height: 320px;">
                            <form id="updateQuestionForm" class="needs-validation" novalidate method="post">
                                <div class="row placeani">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <div class="">Question:</div>
                                            <div class="input-group">
                                                <input name="question" id="questionInput" placeholder="Enter question" value="" minlength="6" type="text" required class="form-control">
                                                <div class="invalid-feedback">
                                                    Question must least 6 char
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row placeani">
                                    <div class="col-lg-12" style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 10px">
                                        <div>Answers:</div>
                                        <button class="btn radius-xl text-uppercase" style="font-size: 10px; padding: 7px 15px;" id="addAnswer">Add answer</button>
                                    </div>
                                    <div class="col-lg-12" id="answersWrapper">
                                        <div class="form-group" style="display: flex; align-items: center; gap: 17px;">
                                            <input type="checkbox" id="option1" name="options[]" class="checkbox">
                                            <span>A,</span>
                                            <span class="input-group">
                                                <input name="answer" placeholder="Enter answer" value="" minlength="6" type="text" required class="form-control">
                                                <div class="invalid-feedback">
                                                    Answer must least 6 char
                                                </div>
                                            </span>
                                        </div>
                                        <div class="form-group" style="display: flex; align-items: center; gap: 17px;">
                                            <input type="checkbox" id="option1" name="options[]" class="checkbox">
                                            <span>A,</span>
                                            <span class="input-group">
                                                <input name="answer" placeholder="Enter answer" value="" minlength="6" type="text" required class="form-control">
                                                <div class="invalid-feedback">
                                                    Answer must least 6 char
                                                </div>
                                            </span>
                                        </div>
                                        <div class="form-group" style="display: flex; align-items: center; gap: 17px;">
                                            <input type="checkbox" id="option1" name="options[]" class="checkbox">
                                            <span>A,</span>
                                            <span class="input-group">
                                                <input name="answer" placeholder="Enter answer" value="" minlength="6" type="text" required class="form-control">
                                                <div class="invalid-feedback">
                                                    Answer must least 6 char
                                                </div>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" id="updateQuestionSubmit" class="btn btn-primary">Update</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="addQuestionModal" tabindex="-1" aria-labelledby="addQuestionModal" aria-hidden="true">
                <div class="modal-dialog" style="margin: 8.75rem auto; display: flex; max-width: 1000px;">
                    <form id="addQuestionForm" class="needs-validation" novalidate method="post">
                        <div class="modal-content" style="border-top-left-radius: 20px; min-width: 600px">
                            <div class="modal-header">
                                <h4 class="modal-title fs-5" id="exampleModalLabel">Create Question</h4>
                            </div>
                            <div class="modal-body" style="height: 320px;">
                                <div class="row placeani">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <div class="">Question:</div>
                                            <div class="input-group">
                                                <input name="question" id="questionInput" placeholder="Enter question" value="" minlength="6" type="text" required class="form-control">
                                                <div class="invalid-feedback">
                                                    Question must least 6 char
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row placeani">
                                    <div class="col-lg-12" style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 10px">
                                        <div>Answers:</div>
                                        <button class="btn radius-xl text-uppercase" style="font-size: 10px; padding: 7px 15px;" id="addAnswer">Add answer</button>
                                    </div>
                                    <div class="col-lg-12" id="answersWrapper">
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                <button id="addQuestionSubmit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form>

                    <div class="modal-content" style="border-top-right-radius: 20px; min-width: 400px;">
                        <div class="modal-header">
                            <h4 class="modal-title fs-5" id="exampleModalLabel">${quiz.subject.subjectName}</h4>
                            <i class="bi bi-x-lg" data-bs-dismiss="modal" aria-label="Close" style="cursor: pointer"></i>
                        </div>
                        <div class="modal-body placeani" id="questionsBySubject" style="padding: 15px; height: 320px; overflow-y: auto">
                            <div class="question-group" style="display: flex; gap: 15px; margin-bottom: 15px; padding: 10px 14px; box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px; height: fit-content; border-radius: 20px">
                                <div class="question">Which is the most appropriate way when you want to resolve the disagreement requirement between Corporate customers?</div>
                                <i class="bi bi-plus-circle-fill" style="color: green; margin-top: 2px; font-size: 25px; cursor: pointer"></i>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="modal fade" id="updateQuizModal" tabindex="-1" aria-labelledby="updateQuizModal" aria-hidden="true">
                <div class="modal-dialog modal-lg" style="margin: 8.75rem auto;">
                    <div class="modal-content" style="border-radius: 20px">
                        <div class="modal-header">
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Update Quiz</h4>
                            <i class="bi bi-x-lg" data-bs-dismiss="modal" aria-label="Close" style="cursor: pointer"></i>
                        </div>
                        <div class="modal-body">
                            <form id="verifyFormfg" class="needs-validation" novalidate method="post">

                                <div class="row placeani">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <div class="">Quiz name:</div>
                                            <div class="input-group">
                                                <input name="username" pattern="^[A-Za-z0-9]{6,20}$" placeholder="Enter username" value="${requestScope.username}" type="text" required class="form-control">
                                                <div class="invalid-feedback">
                                                    Username must least 6 char, only include string and digit.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <div class="">Quiz descriptions:</div>
                                            <div class="input-group"> 
                                                <input style="outline: none" name="password" id="password" pattern="^[A-Za-z0-9]{6,20}$" placeholder="Enter password" value="${requestScope.password}" type="password" class="form-control" required="">
                                                <span class="toggle-password" id="togglePassword">&#x1F441;</span>
                                                <div class="invalid-feedback">
                                                    Password must least 6 char, only include string and digit.
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="button" id="updateSubmit" class="btn btn-primary">Update</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="deleteCardModal" tabindex="-1" aria-labelledby="deleteCardModal" aria-hidden="true">
                <div class="modal-dialog" style="margin: 8.75rem auto;">
                    <div class="modal-content" style="border-radius: 20px">
                        <div class="modal-header">
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Delete Question</h4>
                            <i class="bi bi-x-lg" data-bs-dismiss="modal" aria-label="Close" style="cursor: pointer"></i>
                        </div>
                        <div class="modal-body">
                            Are you sure delete question?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="button" id="deleteQuestionSubmit" class="btn btn-primary">Delete</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="deleteAnswerModal" tabindex="-1" aria-labelledby="deleteAnswerModal" aria-hidden="true">
                <div class="modal-dialog" style="margin: 8.75rem auto;">
                    <div class="modal-content" style="border-radius: 20px">
                        <div class="modal-header">
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Delete Answer</h4>
                            <i class="bi bi-x-lg" data-bs-dismiss="modal" aria-label="Close" style="cursor: pointer"></i>
                        </div>
                        <div class="modal-body">
                            Are you sure delete answer?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="button" id="deleteAnswerSubmit" class="btn btn-primary">Delete</button>
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
        <script src="assets/js/jquery.scroller.js"></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src="assets/vendors/switcher/switcher.js"></script>
        <script>
                                                                let questionID = "";
                                                                let quizID = "";
                                                                let subjectId = "";
                                                                let indexAnswerDelete = 0;
                                                                let answersDelete = [];
                                                                let answerDeleteID = 0;

                                                                function getQuizID(quizID1) {
                                                                    quizID = quizID1;
                                                                }
                                                                function deleteQuestionBtnClick(questionID1, quizID1, subjectId1) {
                                                                    questionID = questionID1;
                                                                    quizID = quizID1;
                                                                    subjectId = subjectId1;
                                                                }
                                                                function updateQuestionBtnClick(questionID1, quizID1, subjectId1) {
                                                                    questionID = questionID1;
                                                                    quizID = quizID1;
                                                                    subjectId = subjectId1;

                                                                    $.ajax({
                                                                        url: "/SWP391_SE1749_NET_GROUP2/quizzes",
                                                                        type: "post",
                                                                        data: {
                                                                            questionID: questionID,
                                                                            action: "getQuestion"
                                                                        },
                                                                        success: function (data) {
                                                                            if (data !== "") {
                                                                                $("#updateQuestionForm").empty();
                                                                                let parent = document.getElementById("updateQuestionForm");
                                                                                parent.insertAdjacentHTML('beforeend', data);

                                                                            } else {
                                                                                toastMessageAction("Get Question failed!", "red");
                                                                            }

                                                                        },
                                                                        error: function () {
                                                                            toastMessageAction("Something went wrong", "red");
                                                                        }
                                                                    });
                                                                }
                                                                function addQuestionBtnClick(subjectId1, quizID1) {
                                                                    quizID = quizID1;
                                                                    subjectId = subjectId1;

                                                                    $.ajax({
                                                                        url: "/SWP391_SE1749_NET_GROUP2/quizzes",
                                                                        type: "post",
                                                                        data: {
                                                                            subjectId: subjectId1,
                                                                            quizID: quizID,
                                                                            action: "getQuestionsBySubject"
                                                                        },
                                                                        success: function (data) {
                                                                            let mess = "Get Question successfuly!";
                                                                            let color = "green";

                                                                            switch (data) {
                                                                                case "failed":
                                                                                    mess = "Get Question failed!";
                                                                                    color = "red";
                                                                                    toastMessageAction(mess, color);
                                                                                    break;
                                                                                case "empty":
                                                                                    $("#questionsBySubject").html("<div>Dont have any questions</div>");
                                                                                    break;

                                                                                default:
                                                                                    document.getElementById("addQuestionForm").reset();

                                                                                    $("#questionsBySubject").empty();
                                                                                    $("#questionsBySubject").html(data);

                                                                                    break;
                                                                            }

                                                                            toastMessageAction(mess, color);
                                                                        },
                                                                        error: function () {
                                                                            toastMessageAction("Something went wrong", "red");
                                                                        }
                                                                    });
                                                                }
                                                                function addToQuestionList(questionID) {
                                                                    $(".addQuestionToListBtn").addClass("disable");
                                                                    const questionsLength = $(".questionCard").length;

                                                                    $.ajax({
                                                                        url: "/SWP391_SE1749_NET_GROUP2/quizzes",
                                                                        type: "post",
                                                                        data: {
                                                                            questionID: questionID,
                                                                            quizID: quizID,
                                                                            subjectId: subjectId,
                                                                            questionsLength: questionsLength + 1,
                                                                            action: "addToQuestionList"
                                                                        },
                                                                        success: function (data) {
                                                                            let mess = "Add Question to List successfuly!";
                                                                            let color = "green";

                                                                            switch (data) {
                                                                                case "failed":
                                                                                    mess = "Add Question to List failed!";
                                                                                    color = "red";

                                                                                    toastMessageAction(mess, color);

                                                                                    $(".addQuestionToListBtn").removeClass("disable");
                                                                                    break;

                                                                                default:
                                                                                    $(".addQuestionToListBtn").removeClass("disable");

                                                                                    let questionAddToListClass = ".question-group." + questionID;
                                                                                    $(questionAddToListClass).remove();

                                                                                    $("#listQuestions").append(data);

                                                                                    $("#questionLengthCount").text("Question & Answers (" + $(".questionCard").length + ")");
                                                                                    break;
                                                                            }

                                                                            toastMessageAction(mess, color);
                                                                        },
                                                                        error: function () {
                                                                            toastMessageAction("Something went wrong", "red");
                                                                        }
                                                                    });
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
                                                                            }, 2000);
                                                                        }
                                                                        setTimeout(function () {
                                                                            $('#toast').text("");
                                                                            $('#toast').toggleClass('show');
                                                                        }, 3000);
                                                                    }
                                                                }
                                                                function reloadListAnswers(resultArray, index) {
                                                                    resultArray.splice(index - 1, 1);

                                                                    let parent = document.getElementById("answersWrapper");

                                                                    if (resultArray.length < 6) {
                                                                        $("#addAnswer").show();
                                                                    } else {
                                                                        $("#addAnswer").hide();
                                                                    }

                                                                    let data = "";
                                                                    for (let i = 0; i < resultArray.length; i++) {
                                                                        const type = String.fromCharCode(i + 1 + 64);
                                                                        const checked = resultArray[i].checked ? "checked" : "";
                                                                        const count = i + 1;

                                                                        data += "<div class=\"form-group\" style=\"display: flex; align-items: center; gap: 17px;\">\n"
                                                                                + "                                            <input type=\"text\" hidden value='" + resultArray[i].id + "' name='answerID' class=\"answerID\">\n"
                                                                                + "                                            <input " + checked + " type=\"checkbox\" id=\"option1\" name=\"options[]\" class=\"checkbox\">\n"
                                                                                + "                                            <span>" + type + ",</span>\n"
                                                                                + "                                            <span class=\"input-group\">\n"
                                                                                + "                                                <input name=\"answer\" placeholder=\"Enter answer\" value='" + resultArray[i].value + "' minlength=\"6\" type=\"text\" required class=\"form-control\">\n"
                                                                                + "                                                <div class=\"invalid-feedback\">\n"
                                                                                + "                                                    Answer must least 6 char\n"
                                                                                + "                                                </div>\n"
                                                                                + "                                            </span>\n"
                                                                                + "                                        <i onclick='removeAnswer(" + count + ")' style='cursor:pointer; color: red;' class=\"bi bi-dash-circle-fill deleteAnswer\"></i>\n"
                                                                                + "                                        </div>";
                                                                    }

                                                                    $("#answersWrapper").empty();
                                                                    parent.insertAdjacentHTML('beforeend', data);

                                                                    indexAnswerDelete = 0;
                                                                    answersDelete = [];
                                                                }

                                                                function addAnswerInUpdateModal() {
                                                                    let parent = document.getElementById("answersWrapper");
                                                                    var numberAnswers = document.querySelectorAll('#answersWrapper .form-group').length;
                                                                    const type = String.fromCharCode(numberAnswers + 1 + 64);

                                                                    if (numberAnswers < 5) {
                                                                        $("#addAnswer").show();
                                                                    } else {
                                                                        $("#addAnswer").hide();

                                                                    }

                                                                    let data = "<div class=\"form-group\" style=\"display: flex; align-items: center; gap: 17px;\">\n"
                                                                            + "                                            <input type=\"text\" hidden value='-1' name='answerID' class=\"answerID\">\n"
                                                                            + "                                            <input type=\"checkbox\" id=\"option1\" name=\"options[]\" class=\"checkbox\">\n"
                                                                            + "                                            <span>" + type + ",</span>\n"
                                                                            + "                                            <span class=\"input-group\">\n"
                                                                            + "                                                <input name=\"answer\" placeholder=\"Enter answer\" value=\"\" minlength=\"6\" type=\"text\" required class=\"form-control\">\n"
                                                                            + "                                                <div class=\"invalid-feedback\">\n"
                                                                            + "                                                    Answer must least 6 char\n"
                                                                            + "                                                </div>\n"
                                                                            + "                                            </span>\n"
                                                                            + "                                        <i onclick='removeAnswer(" + (numberAnswers + 1) + ")' style='cursor:pointer; color: red;' class=\"bi bi-dash-circle-fill deleteAnswer\"></i>"
                                                                            + "                                        </div>";
                                                                    parent.insertAdjacentHTML('beforeend', data);
                                                                }
                                                                function removeAnswer(index) {
                                                                    let resultArray = [];

                                                                    // Lặp qua mỗi form-group
                                                                    $('#answersWrapper .form-group').each(function () {
                                                                        // Lấy giá trị của checkbox (true hoặc false)
                                                                        const checkboxValue = $(this).find('.checkbox').prop('checked');

                                                                        // Lấy giá trị của input có name="answer"
                                                                        const answerID = $(this).find('input[name="answerID"]').val();
                                                                        const answerValue = $(this).find('input[name="answer"]').val();

                                                                        // Thêm cặp giá trị vào mảng
                                                                        if (checkboxValue !== undefined) {
                                                                            resultArray.push({checked: checkboxValue, id: answerID, value: answerValue});
                                                                        }
                                                                    });



                                                                    if (resultArray.at(index - 1).id == -1) {
                                                                        reloadListAnswers(resultArray, index);
                                                                    } else {
                                                                        indexAnswerDelete = index;
                                                                        answersDelete = [...resultArray];
                                                                        answerDeleteID = resultArray.at(index - 1).id;

                                                                        $('#deleteAnswerModal').modal('show');
                                                                    }


                                                                }

                                                                $('#deleteAnswerSubmit').click(function () {
                                                                    let questionClass = ".questionCard." + questionID;
                                                                    const indexOfQuestionUpdate = $(questionClass).index() + 1;

                                                                    $.ajax({
                                                                        url: "/SWP391_SE1749_NET_GROUP2/quizzes",
                                                                        type: "post",
                                                                        data: {
                                                                            answerID: answerDeleteID,
                                                                            questionID: questionID,
                                                                            subjectId: subjectId,
                                                                            countQuestionUpdate: indexOfQuestionUpdate,
                                                                            action: "deleteAnswer"
                                                                        },
                                                                        success: function (data) {
                                                                            let text = "Delete answer successfully!";
                                                                            let color = "green";

                                                                            if (data === "failed") {
                                                                                text = "Delete failed!";
                                                                                color = "red";
                                                                            } else {
                                                                                reloadListAnswers(answersDelete, indexAnswerDelete);
                                                                                $('#deleteAnswerModal').modal('hide');

                                                                                let parent = document.getElementsByClassName("questionCard")[indexOfQuestionUpdate - 1];

                                                                                $(questionClass).empty();
                                                                                parent.insertAdjacentHTML('beforeend', data);
                                                                            }

                                                                            toastMessageAction(text, color);
                                                                        },
                                                                        error: function () {
                                                                            toastMessageAction("Something went wrong", "red");
                                                                        }
                                                                    });
                                                                });
                                                                $('#deleteQuestionSubmit').click(function () {
                                                                    $.ajax({
                                                                        url: "/SWP391_SE1749_NET_GROUP2/quizzes",
                                                                        type: "post",
                                                                        data: {
                                                                            questionID: questionID,
                                                                            quizID: quizID,
                                                                            subjectId: subjectId,
                                                                            action: "deleteQuestion"
                                                                        },
                                                                        success: function (data) {
                                                                            let text = "Delete question successfully!";
                                                                            let color = "green";

                                                                            switch (data) {
                                                                                case "failed":
                                                                                    text = "Delete failed!";
                                                                                    color = "red";
                                                                                    break;

                                                                                default :
                                                                                    let parent = document.getElementById("quizzes");

                                                                                    $("#quizzes").empty();
                                                                                    $("#quizzes").html(data);

                                                                                    $('#deleteCardModal').modal('hide');
                                                                                    break;
                                                                            }

                                                                            toastMessageAction(text, color);
                                                                        },
                                                                        error: function () {
                                                                            toastMessageAction("Something went wrong", "red");
                                                                        }
                                                                    });
                                                                });
                                                                $("#updateQuestionSubmit").click(function () {
                                                                    const answerCount = $('#answersWrapper .form-group').length;

                                                                    if (answerCount === 0) {
                                                                        toastMessageAction("Must be at least 1 answer", "red");
                                                                    } else {
                                                                        const questionValue = $('#updateQuestionForm #questionInput').val();
                                                                        let questionClass = ".questionCard." + questionID;
                                                                        const indexOfQuestionUpdate = $(questionClass).index() + 1;
                                                                        let arr = [];

                                                                        // Lặp qua mỗi form-group
                                                                        $('#answersWrapper .form-group').each(function () {
                                                                            // Lấy giá trị của checkbox (true hoặc false)
                                                                            const checkboxValue = $(this).find('.checkbox').prop('checked');

                                                                            // Lấy giá trị của input có name="answer"
                                                                            const answerID = $(this).find('input[name="answerID"]').val();
                                                                            const answerValue = $(this).find('input[name="answer"]').val();

                                                                            // Thêm cặp giá trị vào mảng
                                                                            if (checkboxValue !== undefined) {
                                                                                arr.push({isCorrect: checkboxValue, answerId: answerID, answerContent: answerValue, questionId: questionID});
                                                                            }
                                                                        });

                                                                        $.ajax({
                                                                            url: "/SWP391_SE1749_NET_GROUP2/quizzes",
                                                                            type: "post",
                                                                            data: {
                                                                                action: "updateQuestion",
                                                                                quizID: quizID,
                                                                                questionID: questionID,
                                                                                subjectId: subjectId,
                                                                                questionValue: questionValue,
                                                                                answers: JSON.stringify(arr),
                                                                                countQuestionUpdate: indexOfQuestionUpdate
                                                                            },
                                                                            success: function (data) {
                                                                                let text = "Update question and answers successfully!";
                                                                                let color = "green";

                                                                                switch (data) {
                                                                                    case "answers_failed":
                                                                                        text = "Update answers failed!";
                                                                                        color = "red";
                                                                                        break;
                                                                                    case "question_failed":
                                                                                        text = "Update question failed!";
                                                                                        color = "red";
                                                                                        break;

                                                                                    default:
                                                                                        let parent = document.getElementsByClassName("questionCard")[indexOfQuestionUpdate - 1];

                                                                                        $(questionClass).empty();
                                                                                        parent.insertAdjacentHTML('beforeend', data);

                                                                                        $('#updateCardModal').modal('hide');
                                                                                        break;
                                                                                }

                                                                                toastMessageAction(text, color);
                                                                            },
                                                                            error: function () {
                                                                                toastMessageAction("Something went wrong", "red");
                                                                            }
                                                                        });
                                                                    }
                                                                });

        </script>
    </body>

</html>

