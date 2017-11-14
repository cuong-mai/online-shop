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

    <!-- Font Awesome CSS -->
    <link href="${css}/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/main.css" rel="stylesheet">

</head>

<body>

    <div class="body-wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="${contextRoot}/home">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </nav>

        <div class="body-content">

            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="jumbotron">
                            <h1>${errorTitle}</h1>
                            <hr>

                            <blockquote class="blockquote">
                                ${errorDescription}
                            </blockquote>
                            <br>

                            <a href="${contextRoot}/home" class="btn btn-success">Back to Home</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- Footer included -->
        <%@include file="./shared/footer.jsp"%>

        <!-- Bootstrap core JavaScript -->
        <script src="${js}/jquery.min.js"></script>
        <script src="${js}/bootstrap.bundle.min.js"></script>
        <script src="${js}/main.js"></script>

    </div>
</body>

</html>
