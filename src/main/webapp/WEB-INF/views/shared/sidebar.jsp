<!-- Side bar -->

<h3 class="my-4">Cuong Shop</h3>

<div class="list-group">
    <c:forEach var="category" items="${categoryList}" >
        <a href="${contextRoot}/product/list?categoryId=${category.id}" class="list-group-item">${category.name}</a>
    </c:forEach>
</div>