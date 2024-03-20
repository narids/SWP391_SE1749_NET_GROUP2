<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="Models.NewsComment" %>
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
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

        <style>
            /* Add your styles here */
            .pad-ver {
                margin-top: 20px;
            }

            .comment-form {
                margin-top: 10px;
                display: none;
            }
            .update-form{
                margin-top: 10px;
                display: none;
            }
            body{
                margin-top:20px;
                background:#ebeef0;
            }

            .img-sm {
                width: 46px;
                height: 46px;
                border-radius: 50px;
                margin-right: 10px;
            }

            .panel {
                box-shadow: 0 2px 0 rgba(0,0,0,0.075);
                border-radius: 0;
                border: 0;
                margin-bottom: 15px;
            }

            .panel .panel-footer, .panel>:last-child {
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }

            .panel .panel-heading, .panel>:first-child {
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }

            .panel-body {
                padding: 25px 20px;
            }

            .media-block .media-left {
                display: block;
                float: left
            }

            .media-block .media-right {
                float: right
            }

            .media-block .media-body {
                display: block;
                overflow: hidden;
                width: auto
            }

            .middle .media-left,
            .middle .media-right,
            .middle .media-body {
                vertical-align: middle
            }

            .thumbnail {
                border-radius: 0;
                border-color: #e9e9e9
            }

            .tag.tag-sm, .btn-group-sm>.tag {
                padding: 5px 10px;
            }

            .tag:not(.label) {
                background-color: #fff;
                padding: 6px 12px;
                border-radius: 2px;
                border: 1px solid #cdd6e1;
                font-size: 12px;
                line-height: 1.42857;
                vertical-align: middle;
                -webkit-transition: all .15s;
                transition: all .15s;
            }
            .text-muted, a.text-muted:hover, a.text-muted:focus {
                color: #acacac;
            }
            .text-sm {
                font-size: 0.9em;
            }
            .text-5x, .text-4x, .text-5x, .text-2x, .text-lg, .text-sm, .text-xs {
                line-height: 1.25;
            }

            .btn-trans {
                background-color: transparent;
                border-color: transparent;
                color: #929292;
            }

            .btn-icon {
                padding-left: 9px;
                padding-right: 9px;
            }

            .btn-sm, .btn-group-sm>.btn, .btn-icon.btn-sm {
                padding: 5px 10px !important;
            }

            .mar-top {
                margin-top: 15px;
            }
        </style>

        <%
    List<NewsComment> commentList = (List<NewsComment>) request.getAttribute("commentList");
        %>

    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <div class="onepage"></div>
            <jsp:include page="components/header.jsp"></jsp:include>
                <!-- Content -->
                <div class="page-content bg-white">
                    <!-- inner page banner -->
                    <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner1.jpg);">
                        <div class="container">
                            <div class="page-banner-entry">
                                <h1 class="text-white">Courses Details</h1>
                            </div>
                        </div>
                    </div>
                    <!-- Breadcrumb row -->
                    <div class="breadcrumb-row">
                        <div class="container">
                            <ul class="list-inline">
                                <li><a href="#">Home</a></li>
                                <li>Courses Details</li>
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
                                    <div class="col-lg-8 col-md-7 col-sm-12">
                                        <div class="courses-post">
                                            <div class="ttr-post-media media-effect">
                                                <a href="#"><img src="${thumbnail}" alt=""></a>
                                        </div>
                                        <div class="ttr-post-info">
                                            <div class="ttr-post-title ">
                                                <h2 class="post-title">${title}</h2>
                                            </div>
                                            <div class="ttr-post-text">
                                                <p>${summary}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="courese-overview" id="overview">
                                        <div class="row">

                                            <div class="col-md-12 col-lg-7">
                                                <h5 class="m-b5">Certification</h5>
                                                <p>${content}</p>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-5 col-sm-12 m-b30">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="col-md-12">
                            <h2>Leave a comment</h2>
                            <div class="panel">
                                <div class="panel-body">
                                    <form action="NewsComment" method="post">
                                        <input type="hidden" name="newsId" id="newsId" value="${param.newsId}">
                                        <textarea class="form-control" rows="2" name="content" placeholder="What are you thinking?"></textarea>
                                        <div class="mar-top clearfix">
                                            <button class="btn btn-sm btn-primary pull-right" type="submit"><i class="fa fa-pencil fa-fw"></i> Share</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="panel">
                                <div class="panel-body">
                                    <!-- Newsfeed Content -->
                                    <!--===================================================-->
                                    <% for(NewsComment parentComment : commentList) {
                                            if(parentComment.getParentId() == 0) { %>
                                    <div class="media-block">
                                        <a class="media-left"><img class="img-circle img-sm" alt="Profile Picture" src="https://images.rawpixel.com/image_png_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA0L3BmLWljb240LWppcjIwNjItcG9yLWwtam9iNzg4LnBuZw.png"></a>
                                        <div class="media-body">
                                            <div class="mar-btm">
                                                <div class="row">
                                                    <div class="col col-6">
                                                        <a class="btn-link text-semibold media-heading box-inline"><%= parentComment.getName() %></a>
                                                        <p class="text-muted text-sm"><%= parentComment.getCreatedDay()%></p>
                                                    </div>
                                                    <div style ="display: flex; justify-content: flex-end;" class="col col-6">
                                                        <button class="btn btn-sm btn-default btn-hover-primary" style="margin-left:5px;height: 30px;" onclick="toggleUpdateForm('<%= parentComment.getCommentId() %>')">
                                                            <i class="fa fa-pencil"></i>
                                                        </button>
                                                        <button class="btn btn-sm btn-default btn-hover-primary" style="margin-left: 5px; height: 30px;">
                                                            <a href="DeleteComment?newsId=${param.newsId}&commentId=<%=parentComment.getCommentId()%>">
                                                                <i class="fa fa-trash"></i>
                                                            </a>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                            <p id="commentContent_<%= parentComment.getCommentId() %>"> <%= parentComment.getContent() %></p>
                                            <div class="update-form" id="updateComment_<%= parentComment.getCommentId() %>">
                                                <form id="updateForm" action="UpdateComment" method="post">
                                                    <input type="hidden" name="newsId" id="newsId" value="${param.newsId}">
                                                    <input type="hidden" name="commentId" value="<%= parentComment.getCommentId() %>">
                                                    <textarea class="form-control" name="content" rows="4" cols="50"><%= parentComment.getContent() %></textarea>
                                                    <br>
                                                    <button class="btn btn-sm btn-primary pull-right" style="margin-bottom: 10px" type="submit">Submit Comment</button>
                                                </form>
                                            </div>
                                            <div class="pad-ver">
                                                <button class="btn btn-sm btn-default btn-hover-primary" id="commentButton_<%= parentComment.getCommentId() %>"
                                                        onclick="toggleCommentForm('<%= parentComment.getCommentId() %>')">Comment</button>
                                            </div>
                                            <div class="comment-form" id="commentForm_<%= parentComment.getCommentId() %>">
                                                <form action="NewsComment" method="post">
                                                    <input type="hidden" name="newsId" id="newsId" value="${param.newsId}">
                                                    <input type="hidden" name="parentId" value="<%= parentComment.getCommentId() %>">
                                                    <textarea class="form-control" name="content" rows="4" cols="50" placeholder="Enter your comment"></textarea>
                                                    <br>
                                                    <button class="btn btn-sm btn-primary pull-right" style="margin-bottom: 10px" type="submit">Submit Comment</button>
                                                </form>
                                            </div>
                                            <hr>

                                            <!-- Comments -->
                                            <% for(NewsComment childComment : commentList) {
                                                    if(childComment.getParentId() == parentComment.getCommentId()) { %>
                                            <div>
                                                <div class="media-block">
                                                    <a class="media-left"><img class="img-circle img-sm" alt="Profile Picture" src="https://images.rawpixel.com/image_png_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA0L3BmLWljb240LWppcjIwNjItcG9yLWwtam9iNzg4LnBuZw.png"></a>
                                                    <div class="media-body">
                                                        <div class="mar-btm">
                                                            <div class="row">
                                                                <div class="col col-6">
                                                                    <a class="btn-link text-semibold media-heading box-inline"><%= childComment.getName() %></a>
                                                                    <p class="text-muted text-sm"><%= childComment.getCreatedDay()%></p>
                                                                </div>
                                                                <div style ="display: flex; justify-content: flex-end;" class="col col-6">
                                                                    <button class="btn btn-sm btn-default btn-hover-primary" style="margin-left:5px;height: 30px;" onclick="toggleUpdateForm('<%= childComment.getCommentId() %>')">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </button>
                                                                    <button class="btn btn-sm btn-default btn-hover-primary" style="margin-left: 5px; height: 30px;">
                                                                        <a href="DeleteComment?newsId=${param.newsId}&commentId=<%=childComment.getCommentId()%>">
                                                                            <i class="fa fa-trash"></i>
                                                                        </a>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <p id="commentContent_<%= childComment.getCommentId() %>"><%= childComment.getContent() %></p>
                                                        <div class="update-form" id="updateComment_<%= childComment.getCommentId() %>">
                                                            <form id="updateForm" action="UpdateComment" method="post">
                                                                <input type="hidden" name="newsId" id="newsId" value="${param.newsId}">
                                                                <input type="hidden" name="commentId" value="<%= childComment.getCommentId() %>">
                                                                <textarea class="form-control" name="content" rows="4" cols="50"><%= childComment.getContent() %></textarea>
                                                                <br>
                                                                <button class="btn btn-sm btn-primary pull-right" style="margin-bottom: 10px" type="submit">Submit Comment</button>
                                                            </form>
                                                        </div>
                                                        <hr>
                                                    </div>
                                                </div>
                                            </div>
                                            <% }
                                        } %>
                                        </div>
                                        <% }
                                    } %>
                                    </div>
                                    <!--===================================================-->
                                    <!-- End Newsfeed Content -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
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
<script>
                                                                        // JavaScript to toggle update form visibility
                                                                        var toggleButtons = document.querySelectorAll('.toggle-update');
                                                                        toggleButtons.forEach(function (button) {
                                                                            button.addEventListener('click', function () {
                                                                                var updateForm = this.nextElementSibling; // Assuming the update form is the next element
                                                                                if (updateForm.style.display === 'none' || updateForm.style.display === '') {
                                                                                    updateForm.style.display = 'block';
                                                                                } else {
                                                                                    updateForm.style.display = 'none';
                                                                                }
                                                                            });
                                                                        });
</script>
<script>
    function toggleUpdateForm(commentId) {
        var updateForm = document.getElementById('updateComment_' + commentId);
        var commentContent = document.getElementById('commentContent_' + commentId);
        var commentButton = document.getElementById('commentButton_' + commentId);
        var commentForm = document.getElementById('commentForm_' + commentId);

        // Toggle the visibility of the comment form, content, and button
        if (updateForm.style.display === 'block') {
            updateForm.style.display = 'none';
            commentContent.style.display = 'block';
            commentButton.style.display = 'block';
            commentForm.style.display = 'none'; // hide comment form when update form is toggled
        } else {
            updateForm.style.display = 'block';
            commentContent.style.display = 'none';
            commentButton.style.display = 'none';
            commentForm.style.display = 'none'; // hide comment form initially when update form is displayed
        }
    }

    function toggleCommentForm(commentId) {
        var commentForm = document.getElementById('commentForm_' + commentId);

        // Toggle the visibility of the comment form
        if (commentForm.style.display === 'block') {
            commentForm.style.display = 'none';
        } else {
            commentForm.style.display = 'block';
        }
    }

    function submitComment(commentId) {
        // Hide the comment form and show the comment content after submission
        var updateForm = document.getElementById('updateComment_' + commentId);
        var commentContent = document.getElementById('commentContent_' + commentId);

        updateForm.style.display = 'none';
        commentContent.style.display = 'block';
    }
</script>
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
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>

</html>
