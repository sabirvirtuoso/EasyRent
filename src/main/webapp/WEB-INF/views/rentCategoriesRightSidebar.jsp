<div class="panel-group acc-v1" id="accordion-1">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-1" href="#collapse-One">
                    Residential Categories
                </a>
            </h4>
        </div>
        <div id="collapse-One" class="panel-collapse collapse in">
            <div class="panel-body">
                <div class="blog-twitter">
                    <c:forEach var="category" items="${residentialCategories}">
                        <div class="blog-twitter-inner">
                            <i class="icon-twitter"></i>
                            <a href="/EasyRent/search/residential/${category.key}?page=1">${category.value}</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-1" href="#collapse-Two">
                    Commercial Categories
                </a>
            </h4>
        </div>
        <div id="collapse-Two" class="panel-collapse collapse">
            <div class="panel-body">
                <div class="row">
                    <div class="blog-twitter">
                        <c:forEach var="category" items="${commercialCategories}">
                            <div class="blog-twitter-inner">
                                <i class="icon-twitter"></i>
                                <a href="/EasyRent/search/commercial/${category.key}?page=1">${category.value}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>