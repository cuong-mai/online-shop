
<div class="container">

    <!-- Breadcrumb -->
    <div class="row">
        <div class="col-sm-12">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a> </li>
                <li class="breadcrumb-item"><a href="${contextRoot}/product/list">Products</a> </li>
                <li class="breadcrumb-item active">${product.name}</li>
            </ol>
        </div>
    </div>

    <!-- Product details -->
    <div class="row">
        <div class="col-xs-12 col-sm-4">
            <div class="img-thumbnail">
                <img src="http://placehold.it/900x900" alt="" class="img img-fluid">
            </div>
        </div>
        <div class="col-xs-12 col-sm-8">
            <h3>${product.name}</h3>
            <hr>

            <p>${product.description}</p>
            <hr>

            <h4>Price: <strong> &dollar; ${product.unitPrice}</strong></h4>
            <hr>

            <h6>Qty. in Stock: ${product.quantity}</h6>
            <hr>

            <a href="${contextRoot}/cart/add?productId=${product.id}" class="btn btn-success">
                <span class="fa fa-cart-plus"></span> Add to Cart
            </a>

            <%--Get link of previous page for href --%>
            <a href="${previousPageUrl}" class="btn btn-success">
                Back
            </a>

        </div>
    </div>

</div>