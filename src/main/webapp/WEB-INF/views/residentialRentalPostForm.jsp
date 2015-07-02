<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp">
    <c:param name="title" value="Residential Rental Post"></c:param>
</c:import>

<!--=== Job Img ===-->
<div class="job-img margin-bottom-30">
    <div class="job-banner">
        <h2>Discover the Places You would love to Live or Work in ...</h2>
    </div>
</div>

<!--=== Content Part ===-->
<div class="container content">
    <div class="col-md-1"></div>

    <div class="col-md-10">
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
        <!-- Residential Rental-Form -->
        <sf:form action="/EasyRent/residential/add" cssClass="sky-form" method="POST" enctype="multipart/form-data" commandName="residentialRental">
            <header>Residential Rental Post Form</header>

                <%@include file="commonRentFormFieldsPrimary.jsp"%>

                <%@include file="residentialRentFormExtraFields.jsp"%>

                <%@include file="commonRentFormFieldsSecondary.jsp"%>

                <%@include file="commonRentFormFieldsTertiary.jsp"%>

            <footer>
                    <button type="submit" class="btn-u">Post Rental</button>
                </footer>
        </sf:form>
    <!-- End Residential Rental-Form -->
    </div>

    <div class="col-md-1"></div>
</div>
<!--=== End Content Part ===-->

<%@include file="footer.jsp"%>

<script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script src="/EasyRent/resources/js/jquery-gmaps-latlon-picker.js"></script>
<script src="/EasyRent/resources/js/image-button-toggle.js"></script>
<script src="/EasyRent/resources/js/show-image-preview.js"></script>
