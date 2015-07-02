<!-- REVIEW PANEL-->
<div class="panel panel-profile">
    <div class="panel-heading overflow-h">
        <h2 class="panel-title heading-sm pull-left"><i class="fa fa-comments"></i>Comments and Reviews</h2>
        <a><i class="fa fa-cog pull-right"></i></a>
    </div>
    <div class="panel-body margin-bottom-50">
        <c:forEach var="review" items="${rental.reviews}">
            <div class="media media-v2">
                <a class="pull-left">
                    <img class="media-object rounded-x" src="/EasyRent/userImageDisplay?id=${review.user.id}" alt="">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">
                        <strong><a>${review.user.firstName} ${review.user.lastName}</a></strong> ${review.user.email}
                        <small>${review.created}</small>
                    </h4>
                    <p>${review.comment}</p>
                    <div class="star-vote">
                        <ul class="list-inline">
                            <c:forEach begin="1" end="${review.rating}" var="val">
                                <li><i class="color-green fa fa-star"></i></li>
                            </c:forEach>
                            <c:forEach begin="${review.rating}" end="4" var="val">
                                <li><i class="color-green fa fa-star-o"></i></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<!-- END REVIEW PANEL-->