<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp">
    <c:param name="title" value="My Rentals"></c:param>
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
    <c:if test="${!empty welcome}">
        <c:import url="successAlert.jsp">
            <c:param name="message" value="${welcome}"></c:param>
        </c:import>
    </c:if>

    <div class="col-md-2 md-margin-bottom-40">
        <img class="img-responsive profile-img margin-bottom-20"
             src="/EasyRent/userImageDisplay?id=${sessionScope.user.id}" alt="">
    </div>

    <div class="profile col-md-8">
        <c:if test="${!empty residentialRentals}">
            <h3>ALL RESIDENTIAL RENTALS</h3>
        </c:if>
        <!--FOR RESIDENTIAL RENT ADS -->
        <c:forEach var="rental" items="${residentialRentals}">
            <div class="profile-body">
                <div class="profile-bio">
                    <div class="row">
                        <%@include file="residentialRentalInfo.jsp"%>
                        <div class="row">
                            <div class="col-md-9"></div>
                            <div class="col-md-3">
                                <a class="btn-u btn-u-sm" href="/EasyRent/rental/view/${rental.id}" >View Details</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <br/>
        <br/>
        <c:if test="${!empty commercialRentals}">
            <h3>ALL COMMERCIAL RENTALS</h3>
        </c:if>
        <!--FOR COMMERCIAL RENT ADS -->
        <c:forEach var="rental" items="${commercialRentals}">
            <div class="profile-body">
                <div class="profile-bio">
                    <div class="row">
                        <%@include file="commercialRentalInfo.jsp"%>
                        <div class="row">
                            <div class="col-md-9"></div>
                            <div class="col-md-3">
                                <a class="btn-u btn-u-sm" href="/EasyRent/rental/view/${rental.id}" >View Details</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- POST RENTAL BUTTON ONLY FOR LOGGED IN USERS-->
    <div class="col-md-2">
        <div class="btn-group">
            <button type="button" class="btn btn-success">Post Rental</button>
            <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                <span class="caret"></span>
                <span class="sr-only">Toggle Dropdown</span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="/EasyRent/residential/add">Residential</a></li>
                <li><a href="/EasyRent/commercial/add">Commercial</a></li>
            </ul>
        </div>
    </div>
</div>
<!--=== End Content Part ===-->

<%@include file="footer.jsp"%>
