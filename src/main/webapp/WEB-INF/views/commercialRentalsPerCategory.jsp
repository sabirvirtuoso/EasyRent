<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp">
    <c:param name="title" value="Commercial Rentals"></c:param>
</c:import>

<!--=== Job Img ===-->
<div class="job-img margin-bottom-30">
    <div class="job-banner">
        <h2>Discover the Places You would love to Live or Work in ...</h2>
    </div>
</div>
<!--=== End Job Img ===-->

<form action="/EasyRent/filter/commercial/${categoryId}" method="POST">
    <div class="row">
        <%@include file="commonSearchCriteria.jsp"%>
        <div class="col-sm-3">
            <button type="submit" class="btn-u btn-block btn-u-dark"> Search Rents</button>
        </div>
    </div>
</form>

<!--=== Content Part ===-->
<div class="container content">
    <div class="col-md-1"></div>

    <div class="profile col-md-8">
        <h3>${commercialCategories[categoryId]} Rentals</h3>

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

        <!--FOR COMMERCIAL RENT ADS -->
        <c:forEach var="rental" items="${commercialRental}">
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

        <c:forEach begin="1" end="${pages}" varStatus="status">
            <c:choose>
                <c:when test="${status.count eq param.page}">
                    <a href="/EasyRent/search/commercial/${categoryId}?page=${status.count}" class="btn-u-sm btn-success">${status.count}</a>
                </c:when>
                <c:otherwise>
                    <a href="/EasyRent/search/commercial/${categoryId}?page=${status.count}" class="btn-u-sm btn-default">${status.count}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>

    <div class="col-md-3">
        <%@include file="rentCategoriesRightSidebar.jsp"%>
    </div>
</div>
<!--=== End Content Part ===-->

<%@include file="footer.jsp" %>
