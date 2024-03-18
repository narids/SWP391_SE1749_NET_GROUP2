<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="ttr-sidebar">
    <div class="ttr-sidebar-wrapper content-scroll">
        <!-- side menu logo start -->
        <div class="ttr-sidebar-logo">
            <a href="#"><img alt="" src="admin/assets/images/logo.png" width="122" height="27"></a>
            <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                    <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                    <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
            </div> -->
            <div class="ttr-sidebar-toggle-button">
                <i class="ti-arrow-left"></i>
            </div>
        </div>
        <!-- side menu logo end -->
        <!-- sidebar menu start -->
        <nav class="ttr-sidebar-navi">
            <ul>
                <li>
                    <a href="index.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-home"></i></span>
                        <span class="ttr-label">Dashboard</span>
                    </a>
                </li>
                <c:if test="${sessionScope.account.getRole().getRoleId() eq 1}">
                    <li>
                        <a href="user-list?action=view" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-user"></i></span>
                            <span class="ttr-label">Manage User</span>
                        </a>
                    </li>
                    <li>
                        <a href="news-list" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-email"></i></span>
                            <span class="ttr-label">Manage News</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-bookmark-alt"></i></span>
                            <span class="ttr-label">Manage Subject</span>
                            <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                        </a>
                        <ul>
                            <li>
                                <a href="subdelist" class="ttr-material-button"><span class="ttr-label">Subject Demension</span></a>
                            </li>
                            <li>
                                <a href="mailbox-compose.html" class="ttr-material-button"><span class="ttr-label">Subject</span></a>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.account.getRole().getRoleId() eq 2}">
                    <li>
                        <a href="class" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-user"></i></span>
                            <span class="ttr-label">Manage Class</span>
                        </a>
                    </li>
                    <li>
                        <a href="questionbank" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-calendar"></i></span>
                            <span class="ttr-label">Manage Question</span>
                        </a>
                    </li>
                    <li>
                        <a href="news-list" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-email"></i></span>
                            <span class="ttr-label">Manage News</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.account.getRole().getRoleId() eq 3}">
                    <li>
                        <a href="StudentList" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-user"></i></span>
                            <span class="ttr-label">Manage Student</span>
                        </a>
                    </li>
                </c:if>
                <li class="ttr-seperate"></li>
            </ul>
            <!-- sidebar menu end -->
        </nav>
        <!-- sidebar menu end -->
    </div>
</div>