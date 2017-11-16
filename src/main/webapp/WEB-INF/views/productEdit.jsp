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

                    <form:form
                            action="${contextRoot}/admin/product/save"
                            method="post"
                            enctype="multipart/form-data"
                            modelAttribute="product">

                        <div class="form-group has-feedback row">
                            <label for="name" class="col-md-4 col-form-label">Product Name</label>
                            <div class="col-md-8">
                                <form:input id="name" path="name" cssClass="form-control"/>
                                <form:errors path="name" cssClass="form-control-feedback small my-text-red" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="brand" class="col-md-4 col-form-label">Brand Name</label>
                            <div class="col-md-8">
                                <form:input id="brand" path="brand" cssClass="form-control"/>
                                <form:errors path="brand" cssClass="form-control-feedback small my-text-red" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="description" class="col-md-4 col-form-label">Description</label>
                            <div class="col-md-8">
                                <form:textarea id="description" path="description" cssClass="form-control"/>
                                <form:errors path="description" cssClass="form-control-feedback small my-text-red" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="unitPrice" class="col-md-4 col-form-label">Unit Price</label>
                            <div class="col-md-8">
                                <form:input id="unitPrice" path="unitPrice" cssClass="form-control"/>
                                <form:errors path="unitPrice" cssClass="form-control-feedback small my-text-red" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="quantity" class="col-md-4 col-form-label">Qty. in Stock</label>
                            <div class="col-md-8">
                                <form:input type="number" id="quantity" path="quantity" cssClass="form-control"/>
                                <form:errors path="quantity" cssClass="form-control-feedback small my-text-red" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="thumbnailImage" class="col-md-4 col-form-label">Thumbnail Image</label>
                            <div class="col-md-8">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <img src="${contextRoot}/resources/images/products/${product.id}/thumbnail.jpg"
                                             alt="<No thumbnail>"
                                             class="img-thumbnail my-img-product-edit-thumbnail">
                                        <form:input type="file" id="thumbnailImage" path="thumbnailImage"
                                                        cssClass=""/>
                                        <form:errors path="thumbnailImage" cssClass="form-control-feedback small my-text-red" element="em"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="categoryId" class="col-md-4 col-form-label">Category</label>
                            <div class="col-md-8">
                                <form:select id="categoryId" path="categoryId" cssClass="form-control">
                                    <option value="0" disabled selected>Select a category</option>
                                    <form:options
                                            items="${categoryList}"
                                            itemValue="id"
                                            itemLabel="name"/>
                                </form:select>
                                <form:errors path="categoryId" cssClass="form-control-feedback small my-text-red" element="em"/>
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
                        <form:hidden path="thumbnailPath"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</div>