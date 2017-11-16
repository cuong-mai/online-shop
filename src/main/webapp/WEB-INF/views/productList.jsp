<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Carousel included -->
<%@include file="./shared/carousel.jsp"%>

<div class="row">

    <!-- Side Bar included -->
    <div class="col-lg-2">
        <%@include file="./shared/sidebar.jsp" %>
    </div>

    <!-- to display the actual products -->
    <div class="col-lg-10">
        <!-- Added breadcrumb component -->
        <div class="row">
            <div class="col-lg-12">
                <c:if test="${userClickAllProducts == true}">
                    <script>
                        window.categoryId = "";
                    </script>

                    <ol class="breadcrumb bg-warning my-breadcrumb">
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item active">Products</li>
                    </ol>
                </c:if>

                <c:if test="${userClickCategoryProducts == true}">
                    <script>
                        window.categoryId = "${category.id}";
                    </script>

                    <ol class="breadcrumb bg-warning my-breadcrumb">
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/product/list">Products</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item active">${category.name}</li>
                    </ol>
                </c:if>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <table id="productListTable" class="table my-data-table">
                    <thead>
                        <tr>
                            <th class="border-bottom-0"></th>
                            <th class="border-bottom-0">Name</th>
                            <th class="border-bottom-0">Brand</th>
                            <th class="border-bottom-0">Price</th>
                            <th class="border-bottom-0">In Stock</th>
                            <th class="border-bottom-0"></th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
