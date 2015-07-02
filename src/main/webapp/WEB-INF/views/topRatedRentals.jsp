<!-- LOOP THROUGH THE RENTALS -->
<div id="carousel-example-generic1" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li class="rounded-x active" data-target="#carousel-example-generic" data-slide-to="0"></li>
        <li class="rounded-x" data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li class="rounded-x" data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img alt="" src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageOne">
        </div>
        <c:if test="${!empty rental.imageTwo}">
            <div class="item">
                <img alt="" src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageTwo">
            </div>
        </c:if>
        <c:if test="${!empty rental.imageThree}">
            <div class="item">
                <img alt="" src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageThree">
            </div>
        </c:if>
    </div>
</div>
<div class="overflow-h">
    <h3>${rental.title}</h3>
    <div class="star-vote pull-right">
        <ul class="list-inline">
            <c:forEach begin="1" end="${rental.averageRating}" var="val">
                <li><i class="color-green fa fa-star"></i></li>
            </c:forEach>
            <c:forEach begin="${rental.averageRating}" end="4" var="val">
                <li><i class="color-green fa fa-star-o"></i></li>
            </c:forEach>
        </ul>
    </div>
</div>
<ul class="list-unstyled">
    <li><span class="color-green">Size : </span> ${rental.size} sq.ft</li>
    <li><span class="color-green">Rent : </span> tk. ${rental.rent}</li>
    <li><span class="color-green">Location : </span>${rental.address.area}</li>
</ul>
<a class="btn-u btn-u-sm" href="/EasyRent/rental/view/${rental.id}">View More</a>
<!-- END LOOP THROUGH THE RENTALS -->