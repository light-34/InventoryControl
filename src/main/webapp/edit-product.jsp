<%@include file="./header.jsp" %>

<div class="container" >
	<form:form modelAttribute="prod" action="${contextPath }/prodUpdate" method="POST">
		<h2> Create a new Product</h2>
		<form:hidden path="id" />
        <div class="col-sm-4">
        	
              <form:input type="text" path="name" class="form-control" placeholder="Product name"
                                autofocus="true"  />
              <form:errors path="name" />
         </div>
         <div class="col-sm-4">
              <form:input type="text" path="manufacturer" class="form-control" placeholder="Manufacturer"
                                autofocus="true" />
              <form:errors path="manufacturer" />
         </div>
         <div class="col-sm-4">
              <form:input type="text" path="asin" class="form-control" placeholder="ASIN code"
                                autofocus="true" />
              <form:errors path="asin" />
         </div>
         <br />
         <div>
         		<button class = "btn btn-primary btn-md" type="submit">Add</button>
         </div>
	
	</form:form>

</div>

<%@include file="./footer.jsp"  %>