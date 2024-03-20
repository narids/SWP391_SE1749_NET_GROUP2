<%-- 
    Document   : Class-list
    Created on : Jan 27, 2024, 3:39:03 PM
    Author     : nghia
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <link rel="stylesheet" type="text/css" href="admin/assets/css/assets.css">
        <link href="admin/assets/css/assets.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="admin/assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="admin/assets/css/color/color-1.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/css/dashboard.css">

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
                    <h4 class="breadcrumb-title">Classes</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Classes</li>
                    </ul>
                </div>	
                <div class="row">

                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title d-flex justify-content-between align-items-center">
                                <h4>Class list</h4>
                                <a href="addClass" class="btn btn-sm info ">
                                    Add a class
                                </a>
                            </div>
                            <div class="widget-inner">
                                <table id="Mytable" class="table table-hover" border="0px">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Class Name</th>
                                            <th scope="col">Teacher</th>
                                            <th scope="col">Action</th>
                                     
                                         
                                        </tr>
                                    </thead>
                                                                      
                                        <c:forEach  var="n" items="${ClassList}">
                                            <tr>

                                                <th style="">${n.getClassID()}
                                                </th> 

                                                <td style="width:50%; white-space: nowrap; text-overflow:ellipsis; overflow: hidden; max-width:1px;"><a href="ClassDetail?id=${n.getClassID()}
                                                                ">${n.className} </a> </td>
                                                <td style="width:10%">${n.name}</td>

                                                <td>
                                                    <a href="ClassDetail?id=${n.getClassID()}" class="btn btn-sm yellow outline radius-xl ">
                                                        <i class="fa fa-pencil"></i>
                                                    </a>
                                                    <a href="#" class="btn btn-sm red outline radius-xl delete-news" data-toggle="modal" data-target="#deleteModal-${n.getClassID()}">
                                                        <i class="fa fa-trash"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <        <div class="ttr-overlay"></div>
        <c:forEach items="${ClassList}" var="n">
            <div class="modal fade" id="deleteModal-${n.getClassID()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <form action="class" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="deleteModalLabel">Delete Class</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" id="newsIdToDelete" name="action" value="delete">
                                <input type="hidden" id="newsIdToDelete" name="ClassID" value="${n.getClassID()}">
                                Are you sure you want to delete this class: ?
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

        <!-- External JavaScripts -->
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
        <script src='assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/vendors/chart/chart.min.js"></script>
        <script src="assets/js/admin.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
        <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>

         <script>
            let table = new DataTable('#Mytable' , {
                lengthChange: false,
                length: 5
            });
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
