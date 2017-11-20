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

	<%--<!-- Bootstrap core CSS -->--%>
	<%--<link href="${css}/bootstrap.min.css" rel="stylesheet">--%>

	<!-- Bootstrap Theme CSS -->
	<link href="${css}/bootstrap.yeti.min.css" rel="stylesheet">

	<!-- Font Awesome CSS -->
	<link href="${css}/font-awesome.min.css" rel="stylesheet">

	<!-- DataTables CSS -->
	<link href="${css}/datatables.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="${css}/main.css" rel="stylesheet">

</head>

<body>

<div class="container-fluid">
	<%@include file="../../shared/navbar.jsp"%>

	<div class="row">



