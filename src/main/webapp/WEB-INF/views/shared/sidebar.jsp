<!-- Side bar -->

<div class="list-group">
    <div class="list-group-item bg-light">Categories</div>
    <a href="${contextRoot}/product/list" class="list-group-item">All Products</a>
    <c:forEach var="category" items="${categoryList}" >
        <a href="${contextRoot}/product/list?categoryId=${category.id}" class="list-group-item bg-primary text-white">${category.name}</a>
    </c:forEach>
</div>