<!-- CAROUSAL OF IMAGES --->
<div id="carousel-example-generic" class="carousel slide margin-bottom-40" data-ride="carousel" data-interval="2000">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <c:if test="${!empty rental.imageTwo}">
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </c:if>
        <c:if test="${!empty rental.imageThree}">
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </c:if>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active" align="center">
            <img src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageOne" alt="...">
        </div>
        <c:if test="${!empty rental.imageTwo}">
            <div class="item" align="center">
                <img src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageTwo" alt="...">
            </div>
        </c:if>
        <c:if test="${!empty rental.imageThree}">
            <div class="item" align="center">
                <img src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageThree" alt="...">
            </div>
        </c:if>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>
<!-- End CAROUSAL OF IMAGES --->

<!--Left Sidebar-->
<div class="col-md-3 md-margin-bottom-40">
    <div id="map-canvas"></div>
    <br/>
    <input id="input-21a" value="${rental.averageRating}" type="number" class="rating" min=0 max=5 step=1 data-size="sm" name="rating" readonly/>
    <div class="fb-share-button" data-href="https://www.facebook.com/easyrentalservices" data-layout="button_count"></div>
</div>
<!--End Left Sidebar-->