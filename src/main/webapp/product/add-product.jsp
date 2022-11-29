<%@include file="../header.jsp" %>

<div class="container" >
	<form:form modelAttribute="prod" action="${contextPath }/product/create" enctype="multipart/form-data">
		<h2> Create a new Product</h2>
        <div class="col-sm-4 mb-4">
        		<form:label path="name" class="mb-2"> Product Name </form:label>
              <form:input type="text" path="name" class="form-control" 
                                autofocus="true" />
              <form:errors path="name" class="text-danger"/>
         </div>
         <div class="col-sm-4 mb-4">
         		<form:label path="manufacturer" class="mb-2"> Manufacturer </form:label>
              <form:input type="text" path="manufacturer" class="form-control"
                                autofocus="true" />
              <form:errors path="manufacturer" class="text-danger"/>
         </div>
         <div class="col-sm-4 mb-4">
         		<form:label path="asin" class="mb-2"> ASIN of Product </form:label>
              <form:input type="text" path="asin" class="form-control" 
                                autofocus="true" />
              <form:errors path="asin" class="text-danger"/>
         </div>
         <div class="col-sm-4 mb-4">
         	<form:label path="ean" class="mb-2"> EAN number </form:label>
              <form:input type="text" path="ean" class="form-control"
                                autofocus="true" />
              <form:errors path="ean" class="text-danger" />
         </div>
         <div class="col-sm-4 mb-4">
         	<label for="file">Select an image</label>
         	<input type="file" name="file" />
         	<%-- <form:label path="image" class="mb-2"> Select an Image</form:label>
              <form:input type="file" path="image" class="form-control"
                                autofocus="true" />
              <form:errors path="image" class="text-danger" /> --%>
         </div>
         <div class="col-sm-4 mb-4">
         	<form:label path="details" class="mb-2"> Details of the product </form:label>
              <form:textarea  path="details" rows="5" cols="30" class="form-control"
                                autofocus="true" />
              <form:errors path="details" class="text-danger"/>
         </div>
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Add</button>
         </div>
	
	</form:form>
	<br/>
	<span class="text text-danger"><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></span>
	<a href="${contextPath }/home" > Back to Home</a>

</div>

<%@include file="../footer.jsp"  %>