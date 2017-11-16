<!-- Side bar -->

<div class="list-group">
    <div class="list-group-item bg-primary text-white">Categories</div>
    <a href="${contextRoot}/product/list" class="list-group-item">All</a>
    <c:forEach var="category" items="${categoryList}" >
        <a href="${contextRoot}/product/list?categoryId=${category.id}" class="list-group-item">${category.name}</a>
    </c:forEach>
</div>

<hr>

<div class="list-group">
    <div class="list-group-item bg-primary text-white">Brands</div>
    <a href="${contextRoot}/product/list" class="list-group-item">All</a>
    <c:forEach var="category" items="${categoryList}" >
        <a href="${contextRoot}/product/list?categoryId=${category.id}" class="list-group-item">${category.name}</a>
    </c:forEach>
</div>