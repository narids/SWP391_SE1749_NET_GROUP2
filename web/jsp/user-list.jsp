<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>EduChamp : Education HTML Template </title>

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
        <style>
            /* The snackbar - position it at the bottom and in the middle of the screen */
            #snackbar {
                visibility: hidden; /* Hidden by default. Visible on click */
                min-width: 250px; /* Set a default minimum width */
                margin-left: -125px; /* Divide value of min-width by 2 */
                background-color: #f7b205; /* Black background color */
                color: #000; /* White text color */
                text-align: center; /* Centered text */
                border-radius: 2px; /* Rounded borders */
                padding: 16px; /* Padding */
                position: fixed; /* Sit on top of the screen */
                z-index: 10000000; /* Add a z-index if needed */
                left: 90%; /* Center the snackbar */
                bottom: 30px; /* 30px from the bottom */
            }

            /* Show the snackbar when clicking on a button (class added with JavaScript) */
            #snackbar.show {
                visibility: visible; /* Show the snackbar */
                /* Add animation: Take 0.5 seconds to fade in and out the snackbar.
                However, delay the fade out process for 2.5 seconds */
                -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
                animation: fadein 0.5s, fadeout 0.5s 2.5s;
            }

            /* Animations to fade the snackbar in and out */
            @-webkit-keyframes fadein {
                from {
                    bottom: 0;
                    opacity: 0;
                }
                to {
                    bottom: 30px;
                    opacity: 1;
                }
            }

            @keyframes fadein {
                from {
                    bottom: 0;
                    opacity: 0;
                }
                to {
                    bottom: 30px;
                    opacity: 1;
                }
            }

            @-webkit-keyframes fadeout {
                from {
                    bottom: 30px;
                    opacity: 1;
                }
                to {
                    bottom: 0;
                    opacity: 0;
                }
            }

            @keyframes fadeout {
                from {
                    bottom: 30px;
                    opacity: 1;
                }
                to {
                    bottom: 0;
                    opacity: 0;
                }
            }
        </style>
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
                        <h4 class="breadcrumb-title">User list</h4>
                        <ul class="db-breadcrumb-list">
                            <li><a href="dashboard"><i class="fa fa-home"></i>Home</a></li>
                            <li>User list</li>
                        </ul>
                    </div>	
                    <div class="row">
                        <!-- Your Profile Views Chart -->
                        <div class="col-lg-12 m-b30">
                            <div class="widget-box">
                                <div class="wc-title d-flex justify-content-between align-items-center">
                                    <h4>User list</h4>
                                    <a href="#" class="btn btn-sm info" data-toggle="modal" data-target="#insertUserModal">
                                        Add new user
                                    </a>
                                </div>
                                <div class="widget-inner">
                                    <table id="myTable" class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Username</th>
                                                <th scope="col">Full Name</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Role</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${accounts}" var="a">
                                            <tr>
                                                <th>${a.userId}</th>
                                                <td>${a.username}</td>
                                                <td>${a.fullName}</td>
                                                <td>${a.email}</td>
                                                <td>${a.role.roleName}</td>
                                                <td>${a.status eq true ? 'Active' : 'Inactive'}</td>
                                                <td>
                                                    <a href="user-list?action=detail&id=${a.userId}" class="btn btn-sm yellow outline radius-xl ">
                                                        <i class="fa fa-pencil"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>
        <div id="snackbar"></div>
        <div class="modal fade" id="insertUserModal" tabindex="-1" role="dialog" aria-labelledby="insertUserModal" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                <form id="addUserForm" action="user-list" method="post">
                    <input type="hidden" name="action" value="insert">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="deleteModalLabel">Insert new user</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                <!--NOTIFICATION-->

                                <!--FORM-->
                                <div class="row">                
                                    <div class="col-12 col-sm-12" id="existedAlert">
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <div class="form-group">
                                            <label>Username</label>
                                            <input 
                                                type="text" 
                                                name="username" 
                                                class="form-control" 
                                                required>
                                            <div class="invalid-feedback">
                                                Please provide a valid phone number.
                                            </div>                        
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input 
                                                type="text" 
                                                name="email" 
                                                class="form-control" 
                                                required>
                                            <div class="invalid-feedback">
                                                Please provide a valid email.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <div class="form-group">
                                            <label>Full Name</label>
                                            <input 
                                                type="text" 
                                                class="form-control" 
                                                name="fullname" 
                                                required>
                                            <div class="invalid-feedback">
                                                Please provide a valid name.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <div class="form-group">
                                            <label>Role</label>
                                            <br>
                                            <select name="role" id="cars">
                                                <c:forEach items="${roles}" var="r">
                                                    <option value="${r.roleId}">${r.roleName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-12">
                                        <div class="form-group">
                                            <label>Status</label>
                                            <br>
                                            <input type="radio" id="html" name="status" value="1">
                                            <label for="html">Active</label><br>
                                            <input type="radio" id="css" name="status" value="0" checked>
                                            <label for="css">Inactive</label><br>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-12">
                                        <ul class="mb-0">
                                            <li>
                                                <small class="text-muted">
                                                    This account along with 
                                                    auto-generated password will be 
                                                    automatically sent to user by email.
                                                </small>
                                            </li>
                                            <li>
                                                <small class="text-muted">
                                                    Insert process may takes a few minutes.
                                                </small>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-danger" id="confirmDeleteBtn">Insert</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

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
            let table = new DataTable('#myTable', {
                "lengthChange": false, // Disable the number of entries option
                "pageLength": 5 // Set the number of entries per page
            });
            $(document).ready(function () {
            <c:if test="${sessionScope.isAddSuccess eq true}">
                var x = document.getElementById("snackbar");
                x.innerHTML = 'Added successfully';
                // Add the "show" class to DIV
                x.className = "show";
                // After 3 seconds, remove the show class from DIV
                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);
            </c:if>
            <c:if test="${sessionScope.isUpdateSuccess eq true}">
                var x = document.getElementById("snackbar");
                x.innerHTML = 'Updated successfully';
                // Add the "show" class to DIV
                x.className = "show";
                // After 3 seconds, remove the show class from DIV
                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);
            </c:if>
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
            $(document).ready(function () {
                $("#addUserForm").submit(function (event) {
                    event.preventDefault();
                    var formData = $(this).serialize();
                    $.ajax({
                        type: "POST",
                        url: "user-list?action=insert",
                        data: formData,
                        success: function (response) {
                            console.log('asdasd');
                            if (response.trim() === 'success') {
                                window.location.href = 'user-list?action=view';
                            } else {
//                                document.getElementById('existedAlert').innerHTML = '<div class="alert alert-danger alert-dismissible"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>This user is existed</div>';
                                var x = document.getElementById("snackbar");
                                x.innerHTML = 'This user is existed';
                                // Add the "show" class to DIV
                                x.className = "show";
                                // After 3 seconds, remove the show class from DIV
                                setTimeout(function () {
                                    x.className = x.className.replace("show", "");
                                }, 3000);
                            }
                        }
                    });
                });
            });
        </script>

    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
<% 
    session.removeAttribute("isAddSuccess");
    session.removeAttribute("isUpdateSuccess"); 
%>