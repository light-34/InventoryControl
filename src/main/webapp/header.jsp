<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link type="text/css" href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet" />
  <script type="text/javascript" src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js" > </script>
  <link rel="stylesheet" href="/css/main.css" type="text/css" />
  <title>Amazon Inventory Management System</title>

</head>
<body>
<header class="mb-5" >
  <%@include file="./navbar.jsp" %>
</header>
