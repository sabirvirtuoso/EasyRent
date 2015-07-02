<fieldset>
    <div class="row">
        <section class="col col-8">
            <label class="input">
                <i class="icon-prepend fa fa-home"></i>
                <sf:input path="address.addressLine" placeholder="Full Address"/>
            </label>
            <sf:errors path="address.addressLine" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-4">
            <label class="select">
                <sf:select cssClass="form-control" path="address.area">
                    <option selected disabled>Area</option>
                    <sf:options items="${areas}"></sf:options>
                </sf:select>
            </label>
            <sf:errors path="address.area" cssClass="error"/><br/><br/>
        </section>
    </div>

    <div class="row">
        <section class="col col-6">
            <label class="input">
                <i class="icon-prepend fa fa-phone"></i>
                <sf:input path="mobileOne" placeholder="Mobile Number"/>
            </label>
            <sf:errors path="mobileOne" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-6">
            <label class="input">
                <i class="icon-prepend fa fa-phone"></i>
                <sf:input path="mobileTwo" placeholder="Optional Mobile Number"/>
            </label>
            <sf:errors path="mobileTwo" cssClass="error"/><br/><br/>
        </section>
        <input id="latitude" name="latitude" style="display:none" value="${rental.latitude}"/>
        <input id="longitude" name="longitude" style="display:none" value="${rental.longitude}"/>
    </div>
</fieldset>

