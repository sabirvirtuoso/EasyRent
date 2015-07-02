<h2 class="heading-md">${rental.title}</h2>
<br/>
<p>${rental.description}</p>
<br/>
<dl class="dl-horizontal">
    <dt><strong>Category </strong></dt>
    <dd>
        ${categories[rental.category]}
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Rent </strong></dt>
    <dd>
       tk. ${rental.rent}
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Size </strong></dt>
    <dd>
        ${rental.size} sft
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Advance Period </strong></dt>
    <dd>
        ${rental.advancePeriod}
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Notice Period </strong></dt>
    <dd>
        ${rental.noticePeriod}
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Service Charge </strong></dt>
    <dd>
        tk. ${rental.serviceCharge}
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Car Parking </strong></dt>
    <dd>
        <c:choose>
            <c:when test="${rental.carParking}">
                <i class="fa fa-check"></i>
            </c:when>
            <c:otherwise>
               x
            </c:otherwise>
        </c:choose>

                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Generator </strong></dt>
    <dd>
        <c:choose>
            <c:when test="${rental.generatorFacility}">
                <i class="fa fa-check"></i>
            </c:when>
            <c:otherwise>
                x
            </c:otherwise>
        </c:choose>
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Lift </strong></dt>
    <dd>
        <c:choose>
            <c:when test="${rental.liftFacility}">
                <i class="fa fa-check"></i>
            </c:when>
            <c:otherwise>
                x
            </c:otherwise>
        </c:choose>
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Gas Supply </strong></dt>
    <dd>
        <c:choose>
            <c:when test="${rental.gasSupply}">
                <i class="fa fa-check"></i>
            </c:when>
            <c:otherwise>
                x
            </c:otherwise>
        </c:choose>
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Owner </strong></dt>
    <dd>
        ${rental.user.firstName} ${rental.user.lastName}
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Address </strong></dt>
    <dd>
        ${rental.address.addressLine}, ${rental.address.area}
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>
    <hr>
    <dt><strong>Mobile </strong></dt>
    <dd>
        ${rental.mobileOne}
            <c:if test="${!empty rental.mobileTwo}">
                ,${rental.mobileTwo}
            </c:if>
                                                                <%--<span>
                                                                    <a class="pull-right">
                                                                        <i class="fa fa-pencil"></i>
                                                                    </a>
                                                                </span>--%>
    </dd>

