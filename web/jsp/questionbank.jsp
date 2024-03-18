<%-- 
    Document   : questionbank
    Created on : Mar 4, 2024, 10:07:27 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="admin/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Question bank </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="admin/assets/js/html5shiv.min.js"></script>
        <script src="admin/assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="admin/assets/css/color/color-1.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css">
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="components/admin-header.jsp"></jsp:include>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="components/admin-sidebar.jsp"></jsp:include>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Question list</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Question list</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title d-flex justify-content-between align-items-center">
                                <h4>Question Bank</h4>
                                <a href="addques" class="btn btn-sm info ">
                                    Add a question
                                </a>
                            </div>
                            <table border="1px"> 
                                <tr>
                                    <td>#</td>
                                    <td>Subject</td>
                                    <td>Content</td>
                                </tr>
                                <c:forEach items="${requestScope.queslist}" var="a">
                                    <tr>
                                        <td>${a.questionId}
                                        </td>
                                        <td>
                                            ${a.subject.subjectName}
                                        </td>
                                        <td>
                                            ${a.questionContent}
                                        </td>
                                        <td>
                                                    <a href="questiondetail?questionid=${a.questionId}" class="btn btn-sm yellow outline radius-xl" style="padding: 5px 10px">
                                                        <i class="fa fa-pencil"></i>
                                                    </a>
                                                    <a href="#" class="btn btn-sm red outline radius-xl delete-news" data-toggle="modal" data-target="#deleteModal-${a.questionId}" style="padding: 5px 10px">
                                                        <i class="fa fa-trash"></i>
                                                    </a>
                                                </td>
                                    </tr>   
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>
        <c:forEach items="${queslist}" var="n">
            <div class="modal fade" id="deleteModal-${n.questionId}" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <form action="questionbank" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="deleteModalLabel">Delete Question</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" id="newsIdToDelete" name="quesaction" value="delete">
                                <input type="hidden" id="newsIdToDelete" name="questionid" value="${n.questionId}">
                                Are you sure you want to delete this Question ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-danger" id="confirmDeleteBtn">Delete</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </c:forEach>
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
            <div class="footer-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 text-center"> <a target="_blank" href="https://www.templateshub.net">Templates Hub</a></div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- External JavaScripts -->
        <script src="admin/assets/js/jquery.min.js"></script>
        <script src="admin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="admin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="admin/assets/vendors/counter/counterup.min.js"></script>
        <script src="admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="admin/assets/vendors/masonry/masonry.js"></script>
        <script src="admin/assets/vendors/masonry/filter.js"></script>
        <script src="admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='admin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="admin/assets/js/functions.js"></script>
        <script src="admin/assets/vendors/chart/chart.min.js"></script>
        <script src="admin/assets/js/admin.js"></script>
        <script src='admin/assets/vendors/switcher/switcher.js'></script>
        <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>

        <script>
            let table = new DataTable('#myTable');
        </script>
        <script>
            // Pricing add
            function newMenuItem() {
                var newElem = $('tr.list-item').first().clone();
                newElem.find('input').val('');
                newElem.appendTo('table#item-add');
            }
            if ($("table#item-add").is('*')) {
                $('.add-item').on('click', function (e) {
                    e.preventDefault();
                    newMenuItem();
                });
                $(document).on("click", "#item-add .delete", function (e) {
                    e.preventDefault();
                    $(this).parent().parent().parent().parent().remove();
                });
            }
        </script>

    </body>





</html>
