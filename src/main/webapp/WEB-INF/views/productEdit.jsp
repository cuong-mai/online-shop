<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="offset-md-2 col-md-8">
            <!-- Panel -->
            <div class="card">
                <h4 class="card-header">Product Management</h4>

                <div class="card-body">
                    <h5 class="card-title">Enter Product Information</h5>
                    <hr>

                    <form:form action="${contextRoot}/manage/product/save" method="post" modelAttribute="product">
                        <div class="form-group row">
                            <label for="name" class="col-md-4 col-form-label">Product Name</label>
                            <div class="col-md-8">
                                <form:input id="name" path="name" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="brand" class="col-md-4 col-form-label">Brand Name</label>
                            <div class="col-md-8">
                                <form:input id="brand" path="brand" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="description" class="col-md-4 col-form-label">Description</label>
                            <div class="col-md-8">
                                <form:textarea id="description" path="description" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="unitPrice" class="col-md-4 col-form-label">Unit Price</label>
                            <div class="col-md-8">
                                <form:input type="number" id="unitPrice" path="unitPrice" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="quantity" class="col-md-4 col-form-label">Qty. in Stock</label>
                            <div class="col-md-8">
                                <form:input id="quantity" path="quantity" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="categoryId" class="col-md-4 col-form-label">Category</label>
                            <div class="col-md-8">
                                <form:select id="categoryId" path="categoryId" cssClass="form-control"
                                             items="${categoryList}"
                                             itemValue="id"
                                             itemLabel="name" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="offset-md-4 col-md-8">
                                <input type="submit" id="submit" value="Save" class="btn btn-success" />
                            </div>
                        </div>

                        <form:hidden path="id"/>
                        <form:hidden path="code"/>
                        <form:hidden path="active"/>
                        <form:hidden path="supplierId"/>
                        <form:hidden path="purchases"/>
                        <form:hidden path="views"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</div>