<!-- Rent Categories -->
<div class="headline"><h2>Rent Categories</h2></div>
<div class="row job-content margin-bottom-40">
    <div class="col-md-4 col-sm-4 md-margin-bottom-40">
        <ul class="list-unstyled categories">
            <h3 class="heading-md"><strong>Residential</strong></h3>
            <c:forEach var="category" items="${residentialCategories}">
                <li><a href="/EasyRent/search/residential/${category.key}?page=1">${category.value}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-4 col-sm-4 md-margin-bottom-40">
        <ul class="list-unstyled categories">
            <h3 class="heading-md"><strong>Commercial</strong></h3>
            <c:forEach var="category" items="${commercialCategories}" varStatus="status">
                <c:if test="${status.count lt 11}">
                    <li><a href="/EasyRent/search/commercial/${category.key}?page=1">${category.value}</a></li>
                </c:if>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-4 col-sm-4 md-margin-bottom-40">
        <ul class="list-unstyled categories">
            <c:forEach var="category" items="${commercialCategories}" varStatus="status">
                <c:if test="${status.count gt 10}">
                    <li><a href="/EasyRent/search/commercial/${category.key}?page=1">${category.value}</a></li>
                </c:if>
            </c:forEach>
        </ul>
    </div>
</div>
<!-- End Rent Categories -->