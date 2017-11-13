<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cuong Shop - ${title}</title>

    <script>
        window.contextRoot = "${contextRoot}";
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Flatly Theme CSS -->
    <link href="${css}/bootstrap.united.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="${css}/datatables.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/main.css" rel="stylesheet">

</head>

<body>

    <div class="body-wrapper">

            <!-- Navigation Bar included -->
            <%@include file="./shared/navbar.jsp"%>

        <div class="body-content">
            <!-- Load Home page content -->
            <c:if test="${userClickHome == true}">
                <%@include file="./home.jsp"%>
            </c:if>

            <!-- Load About page content -->
            <c:if test="${userClickAbout == true}">
                <%@include file="./about.jsp"%>
            </c:if>

            <!-- Load Contact page content -->
            <c:if test="${userClickContact == true}">
                <%@include file="./contact.jsp"%>
            </c:if>

            <!-- Load View Products page content -->
            <c:if test="${userClickAllProducts == true || userClickCategoryProducts == true}">
                <%@include file="./productList.jsp"%>
            </c:if>
        </div>

        <!-- Footer included -->
        <%@include file="./shared/footer.jsp"%>

        <!-- Bootstrap core JavaScript -->
        <script src="${js}/jquery.min.js"></script>
        <script src="${js}/bootstrap.bundle.min.js"></script>
        <script src="${js}/datatables.js"></script>
        <script src="${js}/main.js"></script>

    </div>
</body>

</html>
