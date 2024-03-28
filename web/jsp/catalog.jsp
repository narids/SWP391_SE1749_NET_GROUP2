<%-- 
    Document   : catalog
    Created on : Jan 28, 2024, 7:38:29 PM
    Author     : admin
--%>
<%@page import="Ultils.ConvertTime" %>
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
                                                    <a class="nav-link ${param.tabPane == "quizTab" ? 'active' : ''}" data-toggle="tab" href="#quiz"><i class="bi bi-card-checklist"></i>Quizzes</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="#quiz-results"><i class="ti-bookmark-alt"></i>Quiz Results </a>
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
                                                                <a href="#"><span>Public</span></a> 
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
                                                        <form action="ViewClass" method="get">
                                                            <ul id="masonry" class="ttr-gallery-listing magnific-image row" style="justify-content: flex-start">
                                                                <c:forEach items="${classes}" var="c">
                                                                    <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                        <div class="cours-bx">
                                                                            <div class="action-box">
                                                                                <img src="assets/images/courses/pic2.jpg" alt="">
                                                                                <a href="ViewClass?classId=${c.getClassID()}" class="btn">Read More</a>
                                                                            </div>
                                                                            <div class="info-bx text-center">
                                                                                <h5><a href="ViewClass?classId=${c.getClassID()}">${c.getClassName()}
                                                                                    </a></h5>
                                                                         
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

                                                                                    <h5>Teacher: ${c.getName()}</h5>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </li>
                                                                    <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                    </c:forEach>
                                                            </ul>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane ${param.tabPane == "quizTab" ? 'active' : ''}" id="quiz">
                                                <div class="profile-head">
                                                    <h3>My Quizzes</h3>
                                                    <div class="feature-filters style1 ml-auto">
                                                        <ul class="filters" data-toggle="buttons">
                                                            <c:if test="${sessionScope.account.role.roleId != 4}">
                                                                <li data-filter="" class="btn active" id="filterAll">
                                                                    <input type="radio">
                                                                    <a href=""><span>All</span></a> 
                                                                </li>
                                                                <li data-filter="publish" class="btn" id="filterPublish">
                                                                    <input type="radio">
                                                                    <a href=""><span>Public</span></a> 
                                                                </li>
                                                                <li data-filter="pending" class="btn" id="filterPrivate">
                                                                    <input type="radio">
                                                                    <a href=""><span>Private</span></a> 
                                                                </li>
                                                            </c:if>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div style="display: flex; align-items: center; justify-content: space-between; gap: 10px; width: 100%; padding-top: 10px; padding-right: 15px; padding-bottom: 10px;padding-left: 30px">
                                                    <div style="display: flex; align-items: center; gap: 10px;">
                                                        <div style="text-wrap: nowrap;">Sort by</div>
                                                        <select id="sortQuizBy">
                                                            <option value="QuizName">Quiz name</option>
                                                            <option value="QuizContent">Quiz content</option>
                                                            <option value="CreatedDate">Create date</option>
                                                            <option value="ClassName">Class name</option>
                                                            <option value="SubjectName">Subject name</option>
                                                        </select>
                                                    </div>
                                                    <div style="display: flex; align-items: center; gap: 10px;">
                                                        <input type="text" id="searchQuiz" placeholder="Search by" style='height: 40px; border: 1px; border-color: #e7ecf1; border-style: solid; padding-left: 10px; padding-right: 10px'/>
                                                        <select id="searchQuizBy">
                                                            <option value="QuizName">Quiz name</option>
                                                            <option value="QuizContent">Quiz content</option>
                                                            <option value="CreatedDate">Create date</option>
                                                            <option value="ClassName">Class name</option>
                                                            <option value="SubjectName">Subject name</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="courses-filter">
                                                    <div class="clearfix">
                                                        <ul id="masonry" class="ttr-gallery-listing magnific-image row quizzesList">
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
                                            <div class="tab-pane" id="quiz-results">
                                                <table
                                                    id="myTable"
                                                    class="table table-bordered display"
                                                    style="width: 100%"
                                                    >
                                                    <thead>
                                                        <tr>
                                                            <th scope="col" style="width: 35%">Title</th>
                                                            <th scope="col" style="width: 10%">Score</th>
                                                            <th scope="col" style="width: 15%">Time</th>
                                                            <th scope="col" style="width: 15%">Date</th>
                                                            <th scope="col" style="width: 25%">Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${ltScore}" var="s">
                                                            <tr>
                                                                <td>${s.quiz.quizName}</td>
                                                                <td>${s.score}</td>
                                                                <td>${ConvertTime.secondsToTime(s.time)}</td>
                                                                <td>${s.createDate}</td>
                                                                <td>
                                                                    <a href="quiz-review?scoreId=${s.testId}" class="btn btn-sm yellow outline radius-xl ">
                                                                        Review
                                                                    </a>
                                                                    <a href="quiz-handle?quizId=${s.quiz.quizId}" class="btn btn-sm red outline radius-xl">
                                                                        Retake
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
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
                                                                    Password not be empty !
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
                                                                    Confirm password not be empty !
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
                                                                                                                                form.classList.remove('was-validated');
//                                                                                                                                window.location.href = link;
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

                                                                                                    $("#filterAll").click(function () {
                                                                                                        $.ajax({
                                                                                                            url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                            type: "post",
                                                                                                            data: {
                                                                                                                action: "quizTabFilter",
                                                                                                                filterStatus: "all"
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
                                                                                                    $("#filterPublish").click(function () {
                                                                                                        $.ajax({
                                                                                                            url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                            type: "post",
                                                                                                            data: {
                                                                                                                action: "quizTabFilter",
                                                                                                                filterStatus: "publish"
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
                                                                                                    $("#filterPrivate").click(function () {
                                                                                                        $.ajax({
                                                                                                            url: "/SWP391_SE1749_NET_GROUP2/catalog",
                                                                                                            type: "post",
                                                                                                            data: {
                                                                                                                action: "quizTabFilter",
                                                                                                                filterStatus: "private"
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

