<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet" />
  	<script type="text/javascript" src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js" > </script>
  	<link rel="stylesheet" href="/css/main.css" type="text/css" />
    <title>Login To AIMS</title>
</head>
<body>
<div class="container">
    <h1 class="h1 text-center text-black-50 mt-lg-3"> Login Page </h1>
    <div class='col-5 mx-auto'>
        <div class="card">
            <div class='card-header'>
                <p class="h6">Login</p>
            </div>
            <div class="card-body">
                <form:form action="/log/login" modelAttribute="user" method="post">
                	<div class="row">
                        <div class="col">
                            <c:if test="${param.logout != null }">
                            	<p class="text text-success"> You have been logged out</p>
                            </c:if>  
                        </div>
                    </div><br/>
       
                    <div class="row">
                        <div class="col">
                            <form:input type="text" path="username" class="form-control-md" placeholder="Username" />
                            <form:errors path = "username" class="text-danger"/>  
                        </div>
                    </div><br/>
                    <div class="row">
                        <div class="col">
                            <form:input type="password" path="password" class="form-control-md" placeholder="Password" />
                            <form:errors path = "password" class="text-danger"/>
                        </div>
                    </div> <br/>
                    <div class="row">
                    <c:if test="${param.error != null }" >
                    	<span class="text-danger">Wrong password or username</span>
                    </c:if>
                    </div> <br/>
                    <div class="row">
                        <div class="col">
                            <button type="submit"  class="btn btn-primary">Log In</button>
                        </div>
                    </div>
                </form:form><br />
                <p class="text-body">If you don't have an account, <a href="${pageContext.request.contextPath}/log/register">Register</a></p>
                <span class="text-danger"><%= request.getAttribute("error") != null ? request.getAttribute("error") : ""%></span>
            </div>
        </div>
    </div>
</div>

</body>
</html>