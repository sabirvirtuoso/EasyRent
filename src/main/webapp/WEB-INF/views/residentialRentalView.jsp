<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp">
    <c:param name="title" value="Rental View"></c:param>
</c:import>

<!--=== Job Img ===-->
<div class="job-img margin-bottom-30">
    <div class="job-banner">
        <h2>Discover the Places You would love to Live or Work in ...</h2>
    </div>
</div>
<!--=== End Job Img ===-->

<div id="fb-root"></div>

<!--=== Profile ===-->
<div class="profile">
    <div class="container content">
        <div class="row">

            <%@include file="rentalViewMapAndCarousal.jsp"%>

            <div class="col-md-9">
                <c:if test="${!empty success}">
                    <c:import url="successAlert.jsp">
                        <c:param name="message" value="${success}"></c:param>
                    </c:import>
                </c:if>
                <c:if test="${!empty failure}">
                    <c:import url="failureAlert.jsp">
                        <c:param name="message" value="${failure}"></c:param>
                    </c:import>
                </c:if>

                <!--Profile Body-->
                <div class="profile-body margin-bottom-20">
                    <div class="tab-v1">
                        <ul class="nav nav-justified nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#rentalView">View Rental</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="rentalView" class="profile-edit tab-pane fade in active">

                                <%@include file="commonRentViewFields.jsp"%>

                                <%@include file="residentialRentViewExtraFields.jsp"%>

                                <input id="latitude" name="latitude" style="display:none" value="${rental.latitude}"/>
                                <input id="longitude" name="longitude" style="display:none" value="${rental.longitude}"/>

                                <c:if test="${sessionScope.user.id eq rental.user.id}">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <form action="/EasyRent/rental/delete/${rental.id}" method="POST">
                                                <button type="submit" class="btn-u">Delete</button>
                                            </form>
                                        </div>
                                        <div class="col-md-10">
                                            <a class="btn-u btn-u-md" href="/EasyRent/residential/edit/${rental.id}" >Edit Rental</a>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>

                    <br/>

                    <%@include file="reviewPanel.jsp"%>
                </div>
                <!--End Profile Body-->

                <div class="margin-bottom-40"></div>

                <c:if test="${!empty sessionScope.user and sessionScope.user.id ne rental.user.id}">
                    <%@include file="reviewForm.jsp"%>
                </c:if>
            </div>
        </div><!--/end row-->
    </div><!--/container-->
</div>

<%@include file="footer.jsp"%>

<script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script src="/EasyRent/resources/js/init-map-facebook.js"></script>