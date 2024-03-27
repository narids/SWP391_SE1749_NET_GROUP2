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
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css">
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
            <jsp:include page="components/header.jsp"></jsp:include>
                <!-- header END ==== -->
                <!-- Content -->
                <div class="page-content bg-white">
                    <!-- Breadcrumb row -->
                    <div class="breadcrumb-row">
                        <div class="container">
                            <ul class="list-inline">
                                <li><a href="home">Home</a></li>
                                <li><a href="catalog">Catalog</a></li>
                                <li>Class Detail</li>
                            </ul>
                        </div>
                    </div>
                    <!-- Breadcrumb row END -->
                    <!-- inner page banner END -->
                    <div class="content-block">
                        <!-- About Us -->
                        <div class="section-area section-sp1" style="padding-top: 30px">
                            <div class="container">
                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link  show active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Subject</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Student</a>
                                    </li>

                                </ul>
                                <div class="tab-content" id="myTabContent">
                                    <div class="tab-pane fade  show active " id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <table id="myTable2">
                                            <thead>
                                                <tr>
                                                    <th scope="col">#</th>
                                                    <th scope="col">SubjectID</th>
                                                    <th scope="col">Subject Name</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${sjList}" var="st" varStatus="loop">
                                                <tr>
                                                    <th scope="row">${loop.index + 1}</th>
                                                    <td>${st.getSubjectId()}</td>
                                                    <td><a href="quizlist?subjectid=${st.getSubjectId()}">${st.getSubjectName()}
                                                        </a></td>   
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab"> 
                                    <table id="myTable1">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">StudentID</th>
                                                <th scope="col">Student Name</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${stList}" var="st" varStatus="loop">
                                                <tr>
                                                    <th scope="row">${loop.index + 1}</th>
                                                    <td><a href="StudentProfile?studentId=${st.getStudentId()}">${st.getStudentId()}
                                                        </a></td>
                                                    <td>${st.getName()}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
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
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Update Question</h1>
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

            <div class="modal fade" id="updateQuizModal" tabindex="-1" aria-labelledby="updateQuizModal" aria-hidden="true">
                <div class="modal-dialog modal-lg" style="margin: 8.75rem auto;">
                    <div class="modal-content" style="border-radius: 20px">
                        <div class="modal-header">
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Update Quiz</h1>
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
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Delete Question</h1>
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
                            <h4 class="modal-title fs-5" id="exampleModalLabel">Delete Answer</h1>
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
        <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>

        <script>
            let table1 = new DataTable('#myTable1', {
                lengthChange: false,
                length: 5
            });
           let table2 = new DataTable('#myTable2', {
                lengthChange: false,
                length: 5
            });
        </script>

    </body>

</html>

