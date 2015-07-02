<fieldset>
    <div class="row">
        <section class="col col-4">
            <label class="input">
                <i class="icon-prepend fa fa-home"></i>
                <sf:input path="bedrooms" placeholder="Bedrooms"/>
            </label>
            <sf:errors path="bedrooms" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-4">
            <label class="input">
                <i class="icon-prepend fa fa-home"></i>
                <sf:input path="bathrooms" placeholder="Bathrooms"/>
            </label>
            <sf:errors path="bathrooms" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-4">
            <label class="select">
                <sf:select cssClass="form-control" path="facing">
                    <option value="0" selected disabled>Facing</option>
                    <sf:option value="North">North</sf:option>
                    <sf:option value="South">South</sf:option>
                    <sf:option value="East">East</sf:option>
                    <sf:option value="West">West</sf:option>
                </sf:select>
            </label>
            <sf:errors path="facing" cssClass="error"/><br/><br/>
        </section>
    </div>
    <div class="row">
        <section class="col col-3">
            <sf:checkbox path="petAllowed"/> Pet Allowed
        </section>
        <section class="col col-3">
            <sf:checkbox path="furnished"/> Furnished
        </section>
    </div>
</fieldset>
