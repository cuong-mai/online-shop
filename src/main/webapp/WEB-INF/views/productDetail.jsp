
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
            <div class="img-thumbnail text-center">
                <img src="${contextRoot}/resources/images/products/${product.id}/thumbnail.jpg"
                     alt="${product.name}" class="my-img-product-detail-thumbnail">
            </div>
        </div>
        <div class="col-xs-12 col-sm-8">
            <h3>${product.name}</h3>
            <hr>

            <p>${product.description}</p>
            <hr>

            <h4>Price: <strong> &dollar; ${product.unitPrice}</strong></h4>
            <hr>


            <c:choose>
                <c:when test="${product.quantity < 1}">
                    <h6>Qty. in Stock: <span class="my-text-red">Out of Stock</span></h6>
                    <hr>

                    <a href="javascript:void(0)" class="btn btn-outline-light disabled">
                        <span class="fa fa-cart-plus"></span> Add to Cart
                    </a>
                </c:when>
                <c:otherwise>
                    <h6>Qty. in Stock: ${product.quantity}</h6>
                    <hr>

                    <a href="${contextRoot}/cart/add?productId=${product.id}" class="btn btn-success">
                        <span class="fa fa-cart-plus"></span> Add to Cart
                    </a>
                </c:otherwise>
            </c:choose>


            <%--Get link of previous page for href --%>
            <a href="${previousPageUrl}" class="btn btn-primary">
                Back
            </a>

        </div>
    </div>

</div>