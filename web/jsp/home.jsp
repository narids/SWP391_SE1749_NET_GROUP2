<%-- 
    Document   : home
    Created on : Jan 20, 2024, 12:54:25 PM
    Author     : owner
--%>
<jsp:useBean id="qdao" class="DAOs.QuizDAO" scope="request"></jsp:useBean>
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
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link href="./assets/css/assets.css" rel="stylesheet" type="text/css"/>

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

        <!-- REVOLUTION SLIDER CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/layers.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/settings.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/navigation.css">
        <!-- REVOLUTION SLIDER END -->	
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <jsp:include page="components/header.jsp"></jsp:include>
                <!-- Header Top END ==== -->
                <!-- Content -->
                <div class="page-content bg-white">
                    <!-- Main Slider -->
                    <div class="section-area section-sp1 ovpr-dark bg-fix online-cours" style="background-image:url(assets/images/background/bg1.jpg);">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 text-center text-white">
                                    <h2>Online Quizzes To Study</h2>
                                    <h5>94% of students who use Test helps them get better grades</h5>
                                    <form class="cours-search" action="quiz-search">
                                        <div class="input-group">
                                            <input type="text" name="keyword" class="form-control" placeholder="What do you want to learn today?	">
                                            <div class="input-group-append">
                                                <button class="btn" type="submit">Search</button> 
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="mw800 m-auto">
                                <div class="row">
                                    <div class="col-md-4 col-sm-6">
                                        <div class="cours-search-bx m-b30">
                                            <div class="icon-box">
                                                <h3><i class="ti-user"></i><span class="counter">5</span>M</h3>
                                            </div>
                                            <span class="cours-search-text">Over 5 thousands student</span>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-6">
                                        <div class="cours-search-bx m-b30">
                                            <div class="icon-box">
                                                <h3><i class="ti-book"></i><span class="counter">100</span></h3>
                                            </div>
                                            <span class="cours-search-text">100 Quizzes.</span>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-12">
                                        <div class="cours-search-bx m-b30">
                                            <div class="icon-box">
                                                <h3><i class="ti-layout-list-post"></i><span class="counter">20</span>K</h3>
                                            </div>
                                            <span class="cours-search-text">Learn Anythink Online.</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Main Slider -->
                    <div class="content-block">
                        <!-- Popular Quizzes -->
                        <div class="section-area section-sp2 popular-courses-bx">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12 heading-bx left">
                                        <h2 class="title-head">Online <span>Quizzes</span></h2>
                                        <p>As you answer more questions correctly, you're advanced from easier multiple choice questions to harder, written ones. Be ready for test day with Learn.</p>
                                    </div>
                                </div>
                        </div>
                    </div>
                    <!-- Popular Courses END -->
                    <div class="section-area section-sp2 bg-fix ovbl-dark join-bx text-center" style="background-image:url(assets/images/background/bg1.jpg);">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="join-content-bx text-white">
                                        <h2>Learn a new skill online on <br> your time</h2>
                                        <h4><span class="counter">57,000</span> Online Quizzes</h4>
                                        <p>Learn tracks what terms you struggled 
                                            with and drills you until you know them.</p>
                                        <a href="#" class="btn button-md">Join Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Form END -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-6 m-b30">
                                    <h2 class="title-head ">Learn a new skill online<br> <span class="text-primary"> on your time</span></h2>
                                    <h4><span class="counter">57,000</span> Online Courses</h4>
                                    <p>Learn uses your past study behavior 
                                        to identify what's most challenging 
                                        for you, so your study session is 
                                        more targeted. Make progress with 
                                        short, actionable study sessions.</p>                                    
                                    <a href="#" class="btn button-md">Join Now</a>
                                </div>
                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon1.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Our Philosophy</h5>
                                                    <p>We prioritizes user-friendly interfaces and diversity.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon2.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Kingster's Principle</h5>
                                                    <p>We advocates for inclusivity and equal access to educational resources.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon3.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Key Of Success</h5>
                                                    <p>Key of Success lies in fostering curiosity and continuous self-improvement.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 m-b30">
                                            <div class="feature-container">
                                                <div class="feature-md text-white m-b20">
                                                    <a href="#" class="icon-cell"><img src="assets/images/icon/icon4.png" alt=""></a> 
                                                </div>
                                                <div class="icon-content">
                                                    <h5 class="ttr-tilte">Our Philosophy</h5>
                                                    <p>Our Philosophy emphasizes learning through interactive quizzes and engagement.</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Testimonials -->
                    <div class="section-area section-sp1 bg-fix ovbl-dark text-white" style="background-image:url(assets/images/background/bg1.jpg);">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">3000</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Completed Quizzes</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">2500</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Happy Clients</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">1500</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Questions Answered</span>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 col-sm-6 col-6 m-b30">
                                    <div class="counter-style-1">
                                        <div class="text-white">
                                            <span class="counter">1000</span><span>+</span>
                                        </div>
                                        <span class="counter-text">Classes</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Testimonials END -->
                    <!-- Testimonials ==== -->
                    <div class="section-area section-sp2">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12 heading-bx left">
                                    <h2 class="title-head text-uppercase">what people <span>say</span></h2>
                                    <p>"Discover what users are saying about their quiz experiences!"</p>
                                </div>
                            </div>
                            <div class="testimonial-carousel owl-carousel owl-btn-1 col-12 p-lr0">
                                <div class="item">
                                    <div class="testimonial-bx">
                                        <div class="testimonial-thumb">
                                            <img src="assets/images/testimonials/pic1.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h5 class="name">Peter Packer</h5>
                                            <p>-Art Director</p>
                                        </div>
                                        <div class="testimonial-content">
                                            <p>I have students with IEPs, 
                                                I can find lessons that cater 
                                                to their abilities and 
                                                accommodations while being 
                                                able to give other students 
                                                more rigorous assessments. </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="testimonial-bx">
                                        <div class="testimonial-thumb">
                                            <img src="assets/images/testimonials/pic2.jpg" alt="">
                                        </div>
                                        <div class="testimonial-info">
                                            <h5 class="name">James Newman</h5>
                                            <p>-Math Teacher</p>
                                        </div>
                                        <div class="testimonial-content">
                                            <p>Students are motivated by 
                                                increased strength, grades and 
                                                a sense of competition with 
                                                their classmates. Students 
                                                cheer when a classmate uses 
                                                a power to help everyone, 
                                                and it fosters the community 
                                                that some students 
                                                desperately need.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Testimonials END ==== -->
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
        <script src="assets/vendors/masonry/filter.js"></script>
        <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
    </body>

</html>
