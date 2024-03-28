<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <c:if test="${sessionScope.account ne null}">
                            <li><a href="profile">${sessionScope.account.getUsername()}</a></li>
                                <c:if test="${sessionScope.account.getRole().getRoleId() eq 1}">
                                <li><a href="news-list"></i>Dashboard</a></li>
                                </c:if>
                                <c:if test="${sessionScope.account.getRole().getRoleId() eq 2}">
                                <li><a href="news-list"></i>Dashboard</a></li>
                                </c:if>
                                <c:if test="${sessionScope.account.getRole().getRoleId() eq 3}">
                                <li><a href="news-list"></i>Dashboard</a></li>
                                </c:if>
                            <li><a href="logout"></i>Log out</a></li>
                            </c:if>
                        <c:if test="${sessionScope.account eq null}">
                            <li><a href="register"></i>Register</a></li>
                            <li><a href="login"></i>Login</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="sticky-header navbar-expand-lg">
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
                        <input type="hidden" value="${requestScope.pageSaved}" name="page">
                        <input type="hidden" value="${requestScope.typeSaved}" name="type">
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
                        <li class="active"><a href="home">Home</a>
                        </li>
                        <li class=""><c:if test="${sessionScope.account.getRole().getRoleId() eq 2 or sessionScope.account.getRole().getRoleId() eq 3}"> <a href="subdelist">Subject Dimension</a></c:if>
                        </li>
                        <li class=""><a href="quizzes">Quizzes</a>
                        </li>
                        <li class=""><a href="catalog">Your library</a>
                        </li>
                        <li class=""><a href="News">News</a>
                        </li>
                    </ul>
                </div>
                <!-- Navigation Menu END ==== -->
            </div>
        </div>
    </div>
</header>
