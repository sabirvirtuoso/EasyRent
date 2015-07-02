<!-- Review Form-->
<sf:form action="/EasyRent/review/${rental.id}" method="POST" cssClass="sky-form" commandName="review">

    <header>Review form</header>

    <fieldset>
        <section>
            <label class="textarea">
                <i class="icon-append fa fa-comment"></i>
                <sf:textarea path="comment" placeholder="Text of the review"></sf:textarea>
            </label>
            <sf:errors path="comment" cssClass="error"/><br/><br/>
        </section>
        <input id="rating" name="rating" value="1" type="number" class="rating" min=0 max=5 step=1 data-size="sm"/>
        Overall rating
        <sf:errors path="rating" cssClass="error"/><br/><br/>
    </fieldset>

    <footer>
        <button type="submit" class="btn-u">Submit a review</button>
    </footer>
</sf:form>
<!-- End Review Form-->