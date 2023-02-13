<%@include file="../header.jsp" %>

<div class="container">
    <h1 class="h1 text-center text-black-50 mt-lg-3"> Registration Page </h1>
    <div class='col-5 mx-auto'>
        <div class="card">
            <div class='card-header'>
                <p class="h6">Login</p>
            </div>
            <div class="card-body">
                <form:form action="${contextPath }/log/register" method="POST" modelAttribute="user">
                	<div class="row">
                        <div class="col">
                            <form:input type="text" path="fName" class="form-control-md" placeholder="First Name" />
                            <form:errors path="fName" class="text-danger"/>  
                        </div>
                    </div><br/>
                    <div class="row">
                        <div class="col">
                            <form:input type="text" path="lName" class="form-control-md" placeholder="Last Name" />
                            <form:errors path="lName" class="text-danger"/>  
                        </div>
                    </div><br/>
                    <div class="row">
                        <div class="col">
                            <form:input type="email" path="username" class="form-control-md" placeholder="Email" />
                            <form:errors path="username" class="text-danger"/>  
                        </div>
                    </div><br/>
                    <div class="row">
                        <div class="col">
                            <form:input type="password" path="password" class="form-control-md" placeholder="Password" />
                            <form:errors path="password" class="text-danger" />
                        </div>
                    </div> <br/>
                  
                    <div class="row">
                        <div class="col">
                            <input type="submit" id="btn" name="btn" class="btn btn-primary" value="Register" />
                        </div>
                    </div>
                </form:form><br />
                <p class="text-body">Back to, <a href="${pageContext.request.contextPath}/">Home</a></p>
                <span class="text-danger"><%= request.getAttribute("error") != null ? request.getAttribute("error") : ""%></span>
            </div>
        </div>
    </div>
</div>

<%@include file="../footer.jsp" %>