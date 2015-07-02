<div class="col-md-5">
    <img class="img-responsive md-margin-bottom-10" src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageOne" alt="">
</div>

<div class="col-md-7">
    <h2>${rental.title}</h2>
    <div class="star-vote">
        <ul class="list-inline">
            <c:forEach begin="1" end="${rental.averageRating}" var="val">
                <li><i class="color-green fa fa-star"></i></li>
            </c:forEach>
            <c:forEach begin="${rental.averageRating}" end="4" var="val">
                <li><i class="color-green fa fa-star-o"></i></li>
            </c:forEach>
        </ul>
    </div>
    <span><strong>Size : </strong>${rental.size}</span>
    <span><strong>Rent : </strong> tk. ${rental.rent}</span>
    <span><strong>Location : </strong> ${rental.address.addressLine}, ${rental.address.area}</span>
    <span><strong>Posted At : </strong> ${rental.created}</span>
    <hr>
    <p>${rental.description}</p>

    <br/>
    <br/>
</div>