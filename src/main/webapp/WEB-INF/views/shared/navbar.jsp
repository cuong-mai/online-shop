<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <%--<div class="container-fluid">--%>
        <a class="navbar-brand" href="${contextRoot}/home"><span class="fa fa-shopping-bag"></span> &ensp; Cuong Shop</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id="admin" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/admin">Admin Portal</a>
                </li>
                <li id="viewProducts" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/product/list">Products</a>
                </li>
                <li id="about" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/about">About</a>
                </li>
                <li id="contact" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/contact">Contact</a>
                </li>
            </ul>
        </div>
    <%--</div>--%>
</nav>

