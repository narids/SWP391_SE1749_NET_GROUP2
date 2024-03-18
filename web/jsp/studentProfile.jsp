<%-- 
    Document   : studentProfile
    Created on : Jan 30, 2024, 3:25:21 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Profile </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="./assets/css/assets.css">
        <link href="./assets/css/assets.css" rel="stylesheet" type="text/css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="./assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="./assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="./assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="./assets/css/color/color-1.css">
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <jsp:include page="components/header.jsp"></jsp:include>
                <!-- header END ==== -->
                <!-- Content -->
                <div class="page-content bg-white">
                    <!-- inner page banner -->
                    <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner1.jpg);">
                        <div class="container">
                            <div class="page-banner-entry">
                                <h1 class="text-white">Profile</h1>
                            </div>
                        </div>
                    </div>
                    <!-- Breadcrumb row -->
                    <div class="breadcrumb-row">
                        <div class="container">
                            <ul class="list-inline">
                                <li><a href="#">Home</a></li>
                                <li>Profile</li>
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
                                        <div class="profile-bx text-center">
                                            <div class="user-profile-thumb">
                                                <img src=${sessionScope.account.getAvatar()} alt=""/>
                                        </div>
                                        <div class="profile-info">
                                            <h4>${sessionScope.account.getUsername()}</h4>
                                            <span>${sessionScope.account.getEmail()}</span>
                                        </div>
                                        <div class="profile-social">
                                            <ul class="list-inline m-a0">
                                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="profile-tabnav">
                                            <ul class="nav nav-tabs">
                                                <li class="nav-item">
                                                    <a class="nav-link active" data-toggle="tab" href="#courses"><i class="ti-book"></i>Courses</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="#edit-profile"><i class="ti-pencil-alt"></i>Edit Profile</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="jsp/resetpass.jsp"><i class="ti-pencil-alt"></i>Forgot Password</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12 m-b30">
                                    <div class="profile-content-bx">
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="courses">
                                                <div class="profile-head">
                                                    <h3>My Quiz</h3>
                                                    <div class="feature-filters style1 ml-auto">
                                                        <ul class="filters" data-toggle="buttons">
                                                            <li data-filter="" class="btn active">
                                                                <input type="radio">
                                                                <a href="#"><span>All</span></a> 
                                                            </li>
                                                            <li data-filter="publish" class="btn">
                                                                <input type="radio">
                                                                <a href="#"><span>Publish</span></a> 
                                                            </li>
                                                            <li data-filter="pending" class="btn">
                                                                <input type="radio">
                                                                <a href="#"><span>Pending</span></a> 
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="courses-filter">
                                                    <div class="clearfix">
                                                        <ul id="masonry" class="ttr-gallery-listing magnific-image row">
                                                            <c:forEach items="${requestScope.quizlist}" var="ab">
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic1.jpg" alt="">
                                                                            <a href="quizzes?quizID=${ab.quiz.quizId}" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href='quizzes?quizID=${ab.quiz.quizId}'>${fn:toUpperCase(ab.quiz.quizName)}</a></h5>
                                                                            <span>${ab.subject.subjectName}</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>

                                                                        </div>

                                                                    </div>
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>



                                            <div class="tab-pane" id="edit-profile">
                                                <div class="profile-head">
                                                    <h3>Edit Profile</h3>
                                                </div>
                                                <form class="edit-profile" action="profile" method="POST">
                                                    <div class="">
                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3>1. Personal Details</h3>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Full Name</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" name="fullname" type="text" value="${account.fullName}">
                                                            </div>
                                                        </div>

                                                        <input type="hidden" id="userid" name="userid" value="${account.userId}">

                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Address</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" name="email" type="text" value="${account.email}">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="">
                                                        <div class="">
                                                            <div class="row">
                                                                <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                                </div>
                                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                    <button type="submit" class="btn">Save changes</button>
                                                                    <button type="reset" class="btn-secondry">Cancel</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
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
                                        <a href="index.html"></a>
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
                                                    <li><a href="courses.html">Courses</a></li>
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
            </div>
            <div class="footer-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 text-center"> <a target="_blank" href="https://www.templateshub.net">Templates Hub</a></div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer END ==== -->
        <button class="back-to-top fa fa-chevron-up" ></button>
    </div>
</div>

<!-- contact area END -->
</div>
<!-- Content END-->
<!-- Footer ==== -->
<jsp:include page="components/footer.jsp"></jsp:include>
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
<script src="assets/vendors/masonry/filter.js"></script> [
<script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
<script src="assets/js/functions.js"></script>
<script src="assets/js/contact.js"></script>
<script src='assets/vendors/switcher/switcher.js'></script>
</body>
</html>
