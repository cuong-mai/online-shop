<%@include file="../flows-shared/header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="offset-md-3 col-md-6">

	<div class="card">

		<div class="card-header">
			<h4>Sign Up - Address</h4>
		</div>

		<div class="card-body">

			<form:form
					method="POST"
					modelAttribute="billingAddress"
					cssClass="form"
					id="billingAddressForm">

				<div class="form-group row">
					<label class="control-label col-md-4">Address Line 1</label>
					<div class="col-md-8">
						<form:input type="text" path="addressLineOne" class="form-control"
									placeholder=""/>
						<form:errors path="addressLineOne" cssClass="form-control-feedback small my-text-red" element="em"/>
					</div>
				</div>

				<div class="form-group row">
					<label class="control-label col-md-4">Address Line 2</label>
					<div class="col-md-8">
						<form:input type="text" path="addressLineTwo" class="form-control"
									placeholder=""/>
						<form:errors path="addressLineTwo" cssClass="form-control-feedback small my-text-red" element="em"/>
					</div>
				</div>

				<div class="form-group row">
					<label class="control-label col-md-4">City</label>
					<div class="col-md-8">
						<form:input type="text" path="city" class="form-control"
									placeholder=""/>
						<form:errors path="city" cssClass="form-control-feedback small my-text-red" element="em"/>
					</div>
				</div>

				<div class="form-group row">
					<label class="control-label col-md-4">State</label>
					<div class="col-md-8">
						<form:input type="text" path="state" class="form-control"
									placeholder=""/>
						<form:errors path="state" cssClass="form-control-feedback small my-text-red" element="em"/>
					</div>
				</div>

                <div class="form-group row">
                    <label class="control-label col-md-4">Postal Code</label>
                    <div class="col-md-8">
                        <form:input type="text" path="postalCode" class="form-control"
                                    placeholder=""/>
                        <form:errors path="postalCode" cssClass="form-control-feedback small my-text-red" element="em"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-md-4">Country</label>
                    <div class="col-md-8">
                        <form:input type="text" path="country" class="form-control"
                                    placeholder=""/>
                        <form:errors path="country" cssClass="form-control-feedback small my-text-red" element="em"/>
                    </div>
                </div>

                <div class="form-group row">
					<div class="col-md-12">
                        <button type="submit" name="_eventId_showPersonal" class="btn btn-primary float-left">
                            <span class="fa fa-chevron-left"></span>&nbsp; Back - Personal
                        </button>

                        <button type="submit" name="_eventId_showConfirm" class="btn btn-primary float-right">
							Next - Confirm &nbsp;<span class="fa fa-chevron-right"></span>
						</button>
					</div>
				</div>


			</form:form>


		</div>


	</div>


</div>

<%@include file="../flows-shared/footer.jsp" %>
