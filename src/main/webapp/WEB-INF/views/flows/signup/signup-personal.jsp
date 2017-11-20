<%@include file="../flows-shared/header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="offset-md-3 col-md-6">

    <div class="card">

        <div class="card-header">
            <h4>Sign Up - Personal Information</h4>
        </div>

        <div class="card-body">

            <form:form
                    method="POST"
                    modelAttribute="user"
                    cssClass="form"
                    id="personalForm">

                <div class="form-group row">
                    <label class="control-label col-md-4">First Name</label>
                    <div class="col-md-8">
                        <form:input type="text" path="firstName" class="form-control"
                                    placeholder="First Name"/>
                        <form:errors path="firstName" cssClass="form-control-feedback small my-text-red" element="em"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-md-4">Last Name</label>
                    <div class="col-md-8">
                        <form:input type="text" path="lastName" class="form-control"
                                    placeholder="Last Name"/>
                        <form:errors path="lastName" cssClass="form-control-feedback small my-text-red" element="em"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-md-4">Email</label>
                    <div class="col-md-8">
                        <form:input type="text" path="email" class="form-control"
                                    placeholder="abc@zyx.com"/>
                        <form:errors path="email" cssClass="form-control-feedback small my-text-red" element="em"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-md-4">Contact Number</label>
                    <div class="col-md-8">
                        <form:input type="text" path="phone" class="form-control"
                                    placeholder="XXXXXXXXXX" maxlength="10"/>
                        <form:errors path="phone" cssClass="form-control-feedback small my-text-red" element="em"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-md-4">Password</label>
                    <div class="col-md-8">
                        <form:input type="password" path="password" class="form-control"
                                    placeholder="Password"/>
                        <form:errors path="password" cssClass="form-control-feedback small my-text-red" element="em"/>
                    </div>
                </div>
                <%----%>
                <%--<div class="form-group row">--%>
                <%--<label class="control-label col-md-4">Confirm Password</label>--%>
                <%--<div class="col-md-8">--%>
                <%--<form:input type="password" path="confirmPassword" class="form-control"--%>
                <%--placeholder="Re-type password" />--%>
                <%--<form:errors path="confirmPassword" cssClass="help-block" element="em"/>										 --%>
                <%--</div>--%>
                <%--</div>--%>

                <div class="form-group row">
                    <label class="control-label col-md-4">Select Role</label>
                    <div class="col-md-8">
                        <label class="radio-button">
                            <form:radiobutton path="role" value="USER" checked="checked"/> User
                        </label>
                        <label class="radio-inline">
                            <form:radiobutton path="role" value="SUPPLIER"/> Supplier
                        </label>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-md-12">
                        <button type="submit" name="_eventId_showBilling" class="btn btn-primary float-right">
                            Next - Billing &nbsp;<span class="fa fa-chevron-right"></span>
                        </button>
                    </div>
                </div>

            </form:form>

        </div>

    </div>

</div>

<%@include file="../flows-shared/footer.jsp" %>
