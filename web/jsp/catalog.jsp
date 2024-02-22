<%-- 
    Document   : catalog
    Created on : Jan 28, 2024, 7:38:29 PM
    Author     : admin
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
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
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

        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">

            <div id="toast"></div>

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
                                    <li class="active"><a href="javascript:;">Your library</a>
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
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner1.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Your library</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="home">Home</a></li>
                            <li>Catalog</li>
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
                                            <img src="${requestScope.account.avatar}" alt=""/>
                                        </div>
                                        <div class="profile-info">
                                            <h4>${requestScope.account.username}</h4>
                                            <span>${requestScope.account.email}</span>
                                        </div>
                                        <div class="profile-tabnav">
                                            <ul class="nav nav-tabs">
                                                <li class="nav-item">
                                                    <a class="nav-link ${param.tabPane == null ? 'active' : ''}" data-toggle="tab" href="#courses"><i class="ti-book"></i>Classes</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="#quiz-results"><i class="ti-bookmark-alt"></i>Quiz Results </a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="#edit-profile"><i class="ti-pencil-alt"></i>Edit Profile</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link ${param.tabPane == "changePassword" ? 'active' : ''}" data-toggle="tab" href="#change-password"><i class="ti-lock"></i>Change Password</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12 m-b30">
                                    <div class="profile-content-bx">
                                        <div class="tab-content">
                                            <div class="tab-pane ${param.tabPane == null ? 'active' : ''}" id="courses">
                                                <div class="profile-head">
                                                    <h3>My Courses</h3>
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
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic1.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic2.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic3.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic4.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic5.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic6.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic7.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 book">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic8.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic9.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
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
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="quiz-results">
                                                <div class="profile-head">
                                                    <h3>Quiz Results</h3>
                                                </div>
                                                <div class="courses-filter">
                                                    <div class="row">
                                                        <div class="col-md-6 col-lg-6">
                                                            <ul class="course-features">
                                                                <li><i class="ti-book"></i> <span class="label">Lectures</span> <span class="value">8</span></li>
                                                                <li><i class="ti-help-alt"></i> <span class="label">Quizzes</span> <span class="value">1</span></li>
                                                                <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">60 hours</span></li>
                                                                <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">Beginner</span></li>
                                                                <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
                                                                <li><i class="ti-user"></i> <span class="label">Students</span> <span class="value">32</span></li>
                                                                <li><i class="ti-check-box"></i> <span class="label">Assessments</span> <span class="value">Yes</span></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-md-6 col-lg-6">
                                                            <ul class="course-features">
                                                                <li><i class="ti-book"></i> <span class="label">Lectures</span> <span class="value">8</span></li>
                                                                <li><i class="ti-help-alt"></i> <span class="label">Quizzes</span> <span class="value">1</span></li>
                                                                <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">60 hours</span></li>
                                                                <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">Beginner</span></li>
                                                                <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
                                                                <li><i class="ti-user"></i> <span class="label">Students</span> <span class="value">32</span></li>
                                                                <li><i class="ti-check-box"></i> <span class="label">Assessments</span> <span class="value">Yes</span></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="edit-profile">
                                                <div class="profile-head">
                                                    <h3>Edit Profile</h3>
                                                </div>
                                                <form class="edit-profile">
                                                    <div class="">
                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3>1. Personal Details</h3>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Full Name</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="Mark Andre">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Occupation</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="CTO">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Company Name</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="EduChamp">
                                                                <span class="help">If you want your invoices addressed to a company. Leave blank to use your full name.</span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Phone No.</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="+120 012345 6789">
                                                            </div>
                                                        </div>

                                                        <div class="seperator"></div>

                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3>2. Address</h3>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Address</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="5-S2-20 Dummy City, UK">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">City</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="US">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">State</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="California">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Postcode</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="000702">
                                                            </div>
                                                        </div>

                                                        <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>

                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3 class="m-form__section">3. Social Links</h3>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Linkedin</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="www.linkedin.com">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Facebook</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="www.facebook.com">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Twitter</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="www.twitter.com">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Instagram</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="www.instagram.com">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="">
                                                        <div class="">
                                                            <div class="row">
                                                                <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                                </div>
                                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                    <button type="reset" class="btn">Save changes</button>
                                                                    <button type="reset" class="btn-secondry">Cancel</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="tab-pane ${param.tabPane == "changePassword" ? 'active' : ''}" id="change-password">
                                                <div class="profile-head">
                                                    <h3>Change Password</h3>
                                                </div>
                                                <form class="edit-profile needs-validation" novalidate id="changePassForm" method="post" action="catalog">
                                                    <input type="hidden" name="action" value="changePassForm">
                                                    <div class="">
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-4 col-md-4 col-lg-3 col-form-label">Current Password</label>
                                                            <div class="col-12 col-sm-8 col-md-8 col-lg-7 input-group">
                                                                <input name="currentPassword" id="currentPassword" type="password" class="form-control" required="">
                                                                <span class="toggle-password" id="togglePassword1">&#x1F441;</span>
                                                                <div class="invalid-feedback">
                                                                    Password not be empty
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-4 col-md-4 col-lg-3 col-form-label">New Password</label>
                                                            <div class="col-12 col-sm-8 col-md-8 col-lg-7 input-group">
                                                                <input name="newPassword" id="newPassword" pattern="^[A-Za-z0-9]{6,20}$" type="password" class="form-control" required="">
                                                                <span class="toggle-password" id="togglePassword2">&#x1F441;</span>
                                                                <div class="invalid-feedback">
                                                                    Password must least 6 char, only include string and digit.
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-4 col-md-4 col-lg-3 col-form-label">Confirm Password</label>
                                                            <div class="col-12 col-sm-8 col-md-8 col-lg-7 input-group">
                                                                <input name="confirmPassword" id="confirmPassword" type="password" class="form-control" required="">
                                                                <span class="toggle-password" id="togglePassword3">&#x1F441;</span>
                                                                <div class="invalid-feedback">
                                                                    Confirm password not be empty
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-12 col-sm-4 col-md-4 col-lg-3">
                                                        </div>
                                                        <div class="col-12 col-sm-8 col-md-8 col-lg-7">
                                                            <button type="submit" id="SaveChangePass" class="btn">Save changes</button>
                                                            <button type="reset" id="CancelChangePass" class="btn-secondry">Cancel</button>
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

                    // After 3 seconds, remove the show class from DIV and redirect
//                    if (link && link !== "") {
//                        setTimeout(function () {
//                            window.location.href = link;
//                        }, 3000);
//                    }
                    setTimeout(function () {
                        $("#SaveChangePass").removeAttr('disabled');
                        $("#CancelChangePass").removeAttr('disabled');
                        $('#toast').text("");
                        $('#toast').toggleClass('show');
                    }, 4000);
                }
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


                const forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.from(forms).forEach(form => {
                    form.addEventListener('submit', event => {
                        event.preventDefault();

                        const currentPassword = $('#currentPassword').val();
                        const newPassword = $('#newPassword').val();
                        const confirmPassword = $('#confirmPassword').val();

                        if (!form.checkValidity()) {
                            event.stopPropagation();

                        } else {
                            $("#SaveChangePass").prop("disabled", true);
                            $("#CancelChangePass").prop("disabled", true);
                            var formData = $("#changePassForm").serialize();
                            $.ajax({
                                url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                type: "post",
                                data: formData,
                                success: function (data) {
                                    let text = "Change password successfully!";
                                    let color = "green";
                                    let link = "/SWP391_SE1749_NET_GROUP2/catalog?tabPane=changePassword";

                                    switch (data) {
                                        case "success":
                                            $("#changePassForm")[0].reset();
                                            window.location.href = link;
                                            break;

                                        case "duplicate":
                                            text = "New password has duplicate!";
                                            color = "red";
                                            link = "";
                                            break;

                                        case "notMatch":
                                            text = "Confirm password does not match!";
                                            color = "red";
                                            link = "";
                                            break;

                                        case "passNotCorrect":
                                            text = "Current password not correct!";
                                            color = "red";
                                            link = "";
                                            break;
                                    }

                                    toastMessageAction(text, color, link);
                                },
                                error: function () {
                                    toastMessageAction("Something went wrong", "red", "/SWP391_SE1749_NET_GROUP2/catalog?tabPane=changePassword");
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

