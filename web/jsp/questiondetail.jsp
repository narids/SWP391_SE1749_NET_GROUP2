<%-- 
    Document   : questiondetail
    Created on : Mar 9, 2024, 8:13:48 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
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
        <title>Question Detail </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="admin/assets/js/html5shiv.min.js"></script>
        <script src="admin/assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendors/calendar/fullcalendar.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendors/summernote/summernote.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendors/file-upload/imageuploadify.min.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="admin/assets/css/color/color-1.css">

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="components/admin-header.jsp"></jsp:include>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="components/admin-sidebar.jsp"></jsp:include>
        <main class="ttr-wrapper">
            <div class="form-container">
                <h2>Update a Question</h2>
                <form action="questiondetail" method="POST">
                   ID: ${questiondetail.questionId}
                    <input name="questioniddetail"  type="hidden" value="${questiondetail.questionId}" required>
                    <div class="form-group">
                        <label for="content">Content: ${questiondetail.questionContent}</label>
                        <br>
                        <input type="text"  name="quescontentdetail"  required>
                    </div>
                    <div class="form-group">
                        <label for="explain">Explain: ${questiondetail.explain}</label>
                                                <br>
                        <input type="text"  name="quesexplaindetail"  required>
                    </div>
                    <label for="subjectsdetail">Subject: ${questiondetail.subject.subjectName}</label>
                                            <br>
                    <input list="subjectsdetail" name="subjectdetail" id="subjectdetail">
                    <datalist id="subjectsdetail">
                        <c:forEach items="${requestScope.sublistt}" var="ba">
                            <option value="${ba.subjectName}" >
                            </c:forEach>
                    </datalist>
                    <div id="options">
                        <div class="option">
                            <label for="option1">Option 1:</label>
                                                    <br>
                            <input type="text" class="option-text" name="options[]" required >
                            <input type="checkbox" class="correct-checkbox" name="corrects[]" value="1">
                            <label for="correct1">Correct</label><br>
                        </div>
                    </div>

                    <button type="button" onclick="addOption()">Add Option</button><br><br>

                    <input type="submit" value="Submit">
                </form>

                <script>
                    function addOption() {
                        var optionsDiv = document.getElementById('options');
                        var optionCount = optionsDiv.getElementsByClassName('option').length + 1;

                        var newOptionDiv = document.createElement('div');
                        newOptionDiv.className = 'option';

                        var optionLabel = document.createElement('label');
                        optionLabel.htmlFor = 'option' + optionCount;
                        optionLabel.textContent = 'Option ' + optionCount + ':';
                        newOptionDiv.appendChild(optionLabel);
                         
                        var newBr = document.createElement('br');
                        newOptionDiv.appendChild(newBr);
                        var optionInput = document.createElement('input');
                        optionInput.type = 'text';
                        optionInput.className = 'option-text';
                        optionInput.name = 'options[]';
                        optionInput.required = true;
                        newOptionDiv.appendChild(optionInput);

                        var correctCheckbox = document.createElement('input');
                        correctCheckbox.type = 'checkbox';
                        correctCheckbox.className = 'correct-checkbox';
                        correctCheckbox.name = 'corrects[]';
                        correctCheckbox.value = optionCount;
                        newOptionDiv.appendChild(correctCheckbox);

                        var correctLabel = document.createElement('label');
                        correctLabel.htmlFor = 'correct' + optionCount;
                        correctLabel.textContent = 'Correct';
                        newOptionDiv.appendChild(correctLabel);

                        optionsDiv.appendChild(newOptionDiv);
                    }
                </script>
        </main>
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
        <script src="admin/assets/vendors/summernote/summernote.js"></script>
        <script src="admin/assets/vendors/file-upload/imageuploadify.min.js"></script>
        <script src='admin/assets/vendors/switcher/switcher.js'></script>
    </body>
</html>
