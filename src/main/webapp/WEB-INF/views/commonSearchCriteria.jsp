<div class="col-sm-3">
    <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-tag"></i></span>
        <input name="minSize" placeholder="minimum size (sq. ft)" class="form-control"/>
    </div>
</div>
<div class="col-sm-3 md-margin-bottom-5">
    <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-tag"></i></span>
        <input name="maxBudget" placeholder="maximum budget" class="form-control"/>
    </div>
</div>
<div class="col-sm-3">
    <div class="input-group">
        <span class="input-group-addon"><i class="fa fa-tag"></i></span>
        <select class="form-control" name="area">
            <option selected disabled>Area</option>
            <c:forEach var="area" items="${areas}">
                <option value="${area}">${area}</option>
            </c:forEach>
        </select>
    </div>
</div>

