<hr>
<dt><strong>Bedroom </strong></dt>
<dd>
    ${rental.bedrooms}
                                                            <%--<span>
                                                                <a class="pull-right">
                                                                    <i class="fa fa-pencil"></i>
                                                                </a>
                                                            </span>--%>
</dd>
<hr>
<dt><strong>Bathroom </strong></dt>
<dd>
    ${rental.bathrooms}
                                                            <%--<span>
                                                                <a class="pull-right">
                                                                    <i class="fa fa-pencil"></i>
                                                                </a>
                                                            </span>--%>
</dd>
<hr>
<dt><strong>Facing </strong></dt>
<dd>
    ${rental.facing}
                                                            <%--<span>
                                                                <a class="pull-right">
                                                                    <i class="fa fa-pencil"></i>
                                                                </a>
                                                            </span>--%>
</dd>
<hr>
<dt><strong>Pet Allowed </strong></dt>
<dd>
    <c:choose>
        <c:when test="${rental.petAllowed}">
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
<dt><strong>Furnished </strong></dt>
<dd>
    <c:choose>
        <c:when test="${rental.furnished}">
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
</dl>
<br/>