<fieldset>
    <div class="row">
        <section class="col col-6">
            <label class="input">
                <i class="icon-prepend fa fa-user"></i>
                <sf:input path="title" placeholder="Title"/>
            </label>
            <sf:errors path="title" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-6">
            <label class="select">
                <sf:select cssClass="form-control" path="category">
                    <option value="0" selected disabled>Category</option>
                    <sf:options items="${categories}"></sf:options>
                </sf:select>
            </label>
            <sf:errors path="category" cssClass="error"/><br/><br/>
        </section>
    </div>
</fieldset>

<fieldset>
    <section>
        <label class="textarea">
            <sf:textarea path="description" rows="3" placeholder="Description"></sf:textarea>
        </label>
        <sf:errors path="description" cssClass="error"/><br/><br/>
    </section>

    <div class="row">
        <section class="col col-4">
            <label class="input">
                <i class="icon-prepend fa fa-envelope"></i>
                <sf:input path="rent" placeholder="Rent"/>
            </label>
            <sf:errors path="rent" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-4">
            <label class="input">
                <i class="icon-prepend fa fa-home"></i>
                <sf:input path="size" placeholder="Size (sq.ft)"/>
            </label>
            <sf:errors path="size" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-4">
            <label class="input">
                <i class="icon-prepend fa fa-home"></i>
                <sf:input path="serviceCharge" placeholder="Service Charge"/>
            </label>
            <sf:errors path="serviceCharge" cssClass="error"/><br/><br/>
        </section>
    </div>

    <div class="row">
        <section class="col col-6">
            <label class="select">
                <sf:select cssClass="form-control" path="advancePeriod">
                    <option value="0" selected disabled>Advance Period</option>
                    <sf:option value="1 month">1 month</sf:option>
                    <sf:option value="2 months">2 months</sf:option>
                    <sf:option value="6 months">6 months</sf:option>
                    <sf:option value="1 year">1 year</sf:option>
                </sf:select>
            </label>
            <sf:errors path="advancePeriod" cssClass="error"/><br/><br/>
        </section>
        <section class="col col-6">
            <label class="select">
                <sf:select cssClass="form-control" path="noticePeriod">
                    <option value="0" selected disabled>Notice Period</option>
                    <sf:option value="15 days">15 days</sf:option>
                    <sf:option value="1 month">1 month</sf:option>
                    <sf:option value="2 months">2 months</sf:option>
                </sf:select>
            </label>
            <sf:errors path="noticePeriod" cssClass="error"/><br/><br/>
        </section>
    </div>
</fieldset>

<fieldset>
    <div class="row">
        <section class="col col-3">
            <sf:checkbox path="carParking"/> Car Parking
        </section>
        <section class="col col-3">
            <sf:checkbox path="generatorFacility"/> Generator
        </section>
        <section class="col col-3">
            <sf:checkbox path="liftFacility"/> Lift Facility
        </section>
        <section class="col col-3">
            <sf:checkbox path="gasSupply"/> Gas Supply
        </section>
    </div>
</fieldset>
