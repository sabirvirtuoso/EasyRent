<fieldset>
    <div class="row">
        <section class="col col-4">
            <img style="max-width:200px;" class="img-responsive margin-bottom-10" src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageOne" alt="">
            <label><b>Update your image (800 KB, .jpeg only) (Optional)</b></label>
            <input id="one" type="file" name="pictureOne"/>
        </section>
        <section class="col col-4">
            <c:choose>
                <c:when test="${!empty rental.imageTwo}">
                    <img style="max-width:200px;" class="img-responsive margin-bottom-10" src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageTwo" alt=""/>
                </c:when>
                <c:otherwise>
                    <img class="img-responsive margin-bottom-10" src="/EasyRent/resources/assets/img/user.jpg" alt=""/>
                </c:otherwise>
            </c:choose>
            <label><b>Upload your image (800 KB, .jpeg only) (Optional)</b></label>
            <input id="two" type="file" name="pictureTwo"/>
        </section>
        <section class="col col-4">
            <c:choose>
                <c:when test="${!empty rental.imageThree}">
                    <img style="max-width:200px;" class="img-responsive margin-bottom-10" src="/EasyRent/rentalImageDisplay?id=${rental.id}&image=imageThree" alt=""/>
                </c:when>
                <c:otherwise>
                    <img class="img-responsive margin-bottom-10" src="/EasyRent/resources/assets/img/user.jpg" alt=""/>
                </c:otherwise>
            </c:choose>
            <label><b>Upload your image (800 KB, .jpeg only) (Optional)</b></label>
            <input id="three" type="file" name="pictureThree"/>
        </section>
    </div>
</fieldset>