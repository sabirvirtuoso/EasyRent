<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <title>Easy Rent | ${param.title}</title>

    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Favicon -->
    <link rel="shortcut icon" href="/EasyRent/resources/img/favicon.ico">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="/EasyRent/resources/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/EasyRent/resources/assets/css/style.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="/EasyRent/resources/assets/plugins/line-icons/line-icons.css">
    <link rel="stylesheet" href="/EasyRent/resources/assets/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/EasyRent/resources/assets/plugins/sky-forms/version-2.0.1/css/custom-sky-forms.css">

    <!-- CSS Page Style -->
    <link rel="stylesheet" href="/EasyRent/resources/assets/css/pages/page_job.css">
    <link rel="stylesheet" href="/EasyRent/resources/assets/css/pages/page_log_reg_v1.css">

    <!-- CSS Theme -->
    <link rel="stylesheet" href="/EasyRent/resources/assets/css/themes/default.css" id="style_color">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="/EasyRent/resources/assets/css/custom.css">
    <link rel="stylesheet" href="/EasyRent/resources/assets/css/pages/profile.css">
    <link rel="stylesheet" type="text/css" href="/EasyRent/resources/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/EasyRent/resources/css/jquery-gmaps-latlon-picker.css"/>
    <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <link rel="stylesheet" href="/EasyRent/resources/css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>

    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

    <style>
        .error {
            color: #ff0000;
        }

        #map-canvas {
            width: 230px;
            height: 300px;
        }
    </style>
</head>

<body>

<div class="wrapper">
    <!--=== Header ===-->
    <div class="header">
        <!-- Topbar -->
        <div class="topbar">
            <div class="container">
                <!-- Topbar Navigation -->
                <ul class="loginbar pull-right">
                    <c:choose>
                        <c:when test="${!empty sessionScope.user}">
                            <li><a>Logged in as ${user.firstName} ${user.lastName}</a></li>
                            <li class="topbar-devider"></li>
                            <li><a href="/EasyRent/logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/EasyRent/login">Login To Post Rental</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <!-- End Topbar Navigation -->
            </div>
        </div>
        <!-- End Topbar -->
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target=".navbar-responsive-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="fa fa-bars"></span>
                    </button>
                    <a class="navbar-brand">
                        <img id="logo-header" src="/EasyRent/resources/assets/img/easyrent.png" alt="Logo">
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-responsive-collapse">
                    <ul class="nav navbar-nav">
                        <!-- Home -->
                        <li>
                            <a href="/EasyRent/home">
                                Home
                            </a>
                        </li>
                        <!-- End Home -->
                        <c:if test="${!empty sessionScope.user}">
                            <!-- My Rentals -->
                            <li>
                                <a href="/EasyRent/profile/${sessionScope.user.id}">
                                    My Profile
                                </a>
                            </li>
                            <!-- End My Rentals -->
                        </c:if>
                        <!-- About Us -->
                        <li>
                            <a href="/EasyRent/about">
                                About Us
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- End Navbar -->
    </div>
    <!--=== End Header ===-->
