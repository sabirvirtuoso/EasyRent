<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp">
    <c:param name="title" value="Registration Page"></c:param>
</c:import>

<!--=== Content Part ===-->
<div class="container content">
    <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
        <c:if test="${!empty success}">
            <c:import url="successAlert.jsp">
                <c:param name="message" value="${success}"></c:param>
            </c:import>
        </c:if>
        <c:if test="${!empty failure}">
            <c:import url="failureAlert.jsp">
                <c:param name="message" value="${failure}"></c:param>
            </c:import>
        </c:if>
        <sf:form cssClass="reg-page" action="/EasyRent/signup" method="POST" enctype="multipart/form-data" commandName="userSignUp">
            <div class="reg-header">
                <h2>Register a new account</h2>

                <p>Already Signed Up? Click <a href="/EasyRent/login" class="color-green">Sign In</a> to login
                    your account.</p>
            </div>
            <label>First Name <span class="color-brown">(Minimum 3 characters)</span></label>
            <sf:input path="firstName" cssClass="form-control margin-bottom-20" placeholder="First Name"/>
            <sf:errors path="firstName" cssClass="error"/><br/><br/>

            <label>Last Name <span class="color-brown">(Minimum 3 characters)</span></label>
            <sf:input path="lastName" cssClass="form-control margin-bottom-20" placeholder="Last Name"/>
            <sf:errors path="lastName" cssClass="error"/><br/><br/>

            <label>Email Address <span class="color-red">*</span></label>
            <sf:input path="email" cssClass="form-control margin-bottom-20" placeholder="Email" />
            <sf:errors path="email" cssClass="error"/><br/><br/>

            <label>Password <span class="color-red">*</span><span class="color-brown">(Minimum 6 characters)</span></label>
            <sf:password path="password" cssClass="form-control margin-bottom-20" placeholder="Password" />
            <sf:errors path="password" cssClass="error"/><br/><br/>

            <label>Confirm Password <span class="color-red">*</span></label>
            <sf:password path="confirmPassword" cssClass="form-control margin-bottom-20" placeholder="Confirm Password" />
            <sf:errors path="confirmPassword" cssClass="error"/><br/><br/>

            <label>Date Of Birth <span class="color-red">*</span><span class="color-brown">(MM/DD/YYYY)</span></label>
            <%--<sf:input path="dob" id="dob" cssClass="form-control margin-bottom-20 controls input-append" placeholder="DOB"/>--%>
            <input id="dob" name="dob" class="form-control margin-bottom-20 controls input-append" type="date" placeholder="DOB"/>
            <sf:errors path="dob" cssClass="error"/><br/><br/>

            <label>Occupation <span class="color-red">*</span></label>
            <sf:input path="occupation" cssClass="form-control margin-bottom-20" placeholder="Occupation" />
            <sf:errors path="occupation" cssClass="error"/><br/><br/>

            <label>Upload Photo <span class="color-brown">(Maximum 800 KB, .jpeg only)</span></label>
            <input type="file" class="form-control margin-bottom-20" name="picture" >
            <hr>
            <div class="row">
                <div class="col-lg-6 text-right">
                    <button class="btn-u" type="submit">Register</button>
                </div>
            </div>
        </sf:form>
    </div>
</div>
<!--/container-->
<!--=== End Content Part ===-->

