<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">

    <!-- Side Bar included -->
    <div class="col-lg-2">
        <%@include file="./shared/sidebarAdmin.jsp" %>
    </div>

    <!-- to display the actual products -->
    <div class="col-lg-10">
        <!-- Added breadcrumb component -->
        <div class="row">
            <div class="col-lg-12">
                <c:if test="${userClickAdmin == true}">
                    <ol class="breadcrumb bg-warning my-breadcrumb">
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item active">Admin Portal</li>
                    </ol>
                </c:if>

                <c:if test="${userClickAdminProduct == true}">
                    <ol class="breadcrumb bg-warning my-breadcrumb">
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/admin">Admin Portal</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item active">Manage Products</li>
                    </ol>
                </c:if>

                <c:if test="${userClickEditProduct == true}">
                    <ol class="breadcrumb bg-warning my-breadcrumb">
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/admin">Admin Portal</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item"><a href="${contextRoot}/admin/product/list">Manage Products</a></li>
                        <li class="breadcrumb-item my-breadcrumb-item active">${title}</li>
                    </ol>
                </c:if>
            </div>
        </div>

        <!-- Edit Product Form loaded --!>
        <c:if test="${userClickEditProduct == true}">
            <%@include file="./productEdit.jsp"%>
            <br>
        </c:if>

        <!-- Product List for Admin page included -->
        <c:if test="${userClickAdminProduct == true || userClickEditProduct == true}">
            <%@include file="productListTableAdmin.jsp" %>
        </c:if>


    </div>
</div>
