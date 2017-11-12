<!-- Side bar -->

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<h1 class="my-4">Cuong Shop</h1>
<div class="list-group">

    <c:forEach var="category" items="${categoryList}" >
        <a href="${contextRoot}/product/list?categoryId=${category.id}" class="list-group-item">${category.name}</a>
    </c:forEach>

</div>