<%@include file="../flows-shared/header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-sm-12">
    <div class="row table-row">
        <div class="offset-md-2 col-md-4">

            <div class="card h-100">

                <div class="card-header">
                    <h4>Personal Information</h4>
                </div>

                <div class="card-body">
                    <h5>${signUpModel.user.firstName} ${signUpModel.user.lastName}</h5>
                    <h5>Email: ${signUpModel.user.email}</h5>
                    <h5>Phone: ${signUpModel.user.phone}</h5>
                    <h5>Role: ${signUpModel.user.role}</h5>
                </div>
                <div class="card-footer">
                    <a href="${flowExecutionUrl}&_eventId_showPersonal" class="btn btn-primary float-right">Edit</a>
                </div>
            </div>

        </div>

        <div class="col-md-4">

            <div class="card h-100">

                <div class="card-header">
                    <h4>Billing Address</h4>
                </div>

                <div class="card-body">
                    <h5>${signUpModel.billingAddress.addressLineOne}</h5>
                    <h5>${signUpModel.billingAddress.addressLineTwo}</h5>
                    <h5>${signUpModel.billingAddress.city}, ${signUpModel.billingAddress.state} ${signUpModel.billingAddress.postalCode}</h5>
                    <h5>${signUpModel.billingAddress.country}</h5>
                </div>
                <div class="card-footer">
                    <a href="${flowExecutionUrl}&_eventId_showBilling" class="btn btn-primary float-right">Edit</a>
                </div>
            </div>

        </div>

    </div>

    <div class="row mt-4">
        <div class="offset-sm-2 col-sm-8">
            <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary float-right">Confirm</a>
        </div>
    </div>

</div>


<%@include file="../flows-shared/footer.jsp" %>
