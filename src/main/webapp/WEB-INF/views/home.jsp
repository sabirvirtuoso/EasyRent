<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp">
    <c:param name="title" value="Home Page"></c:param>
</c:import>

<!--=== Job Img ===-->
<div class="job-img margin-bottom-30">
    <div class="job-banner">
         <h2>Discover the Places You would love to Live or Work in ...</h2>
    </div>
</div>
<!--=== End Job Img ===-->

<!--=== Content Part ===-->
<div class="container content">

    <!-- Begin Service Block -->
    <div class="row margin-bottom-40">
        <div class="col-md-4 col-sm-6">
            <div class="servive-block servive-block-sea service-or">
                <div class="service-bg"></div>
                <i class="icon-custom icon-color-light rounded-x fa fa-lightbulb-o"></i>
                <h2 class="heading-md">Post Your Rental</h2>
                <p>An Ideal Place to post your rental and get your desired customer</p>
            </div>
        </div>
        <div class="col-md-4 col-sm-6">
            <div class="servive-block servive-block-red service-or">
                <div class="service-bg"></div>
                <i class="icon-custom icon-color-light rounded-x icon-line icon-fire"></i>
                <h2 class="heading-md">Find Accomodations</h2>
                <p>Search available rentals matching your specific criteria</p>
            </div>
        </div>
        <div class="col-md-4 col-sm-12">
            <div class="servive-block servive-block-blue service-or">
                <div class="service-bg"></div>
                <i class="icon-custom icon-color-light rounded-x icon-line icon-rocket"></i>
                <h2 class="heading-md">Post Review</h2>
                <p>Place a review to help rate the top accomodations</p>
            </div>
        </div>
    </div>
    <!-- End Begin Service Block -->

    <%@include file="rentCategoriesHomePage.jsp"%>

    <div class="headline margin-bottom-35"><h2>Highest Rated Residential Rentals</h2></div>

    <!-- Highest Rated Residential Rents Start -->
    <div class="row high-rated margin-bottom-20">
        <c:forEach var="rental" items="${residentialRentals}">
            <div class="col-md-3 col-sm-6 md-margin-bottom-40">
                <div class="easy-block-v1">
                    <div class="easy-block-v1-badge rgba-default">${residentialCategories[rental.category]}</div>
                    <%@include file="topRatedRentals.jsp" %>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- Highest Rated Residential Rents End -->

    <br/>
    <div class="headline margin-bottom-35"><h2>Highest Rated Commercial Rentals</h2></div>

    <!-- Highest Rated Commercial Rents Start -->
    <div class="row high-rated margin-bottom-20">
        <c:forEach var="rental" items="${commercialRentals}">
            <div class="col-md-3 col-sm-6 md-margin-bottom-40">
                <div class="easy-block-v1">
                    <div class="easy-block-v1-badge rgba-default">${commercialCategories[rental.category]}</div>
                    <%@include file="topRatedRentals.jsp" %>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- Highest Rated Commercial Rents End -->
</div>
<!--=== End Content Part ===-->

<%@include file="footer.jsp" %>

<script>
    $('#carousel-example-generic1').carousel({
        interval: 1000 * 3
    });
</script>