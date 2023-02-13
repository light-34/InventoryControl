<%@include file="../header.jsp" %>

<div class="container" >
	<form:form modelAttribute="prodDetail" action="${contextPath }/product/addDetails" >
		<h2> Add details of the <strong>${prodId.name }</strong></h2>
		
		<!-- product property -->
		<form:hidden path="product" value="${prodId.id }" />
		
		<!-- brand property -->
        <div class="col-sm-4 mb-4">
        		<form:label path="brand" class="mb-2"> Brand Name </form:label>
              <form:input type="text" path="brand" class="form-control" 
                                autofocus="true" />
              <form:errors path="brand" class="text-danger"/>
         </div>
         
         <!-- asin property -->
         <div class="col-sm-4 mb-4">
        		<form:label path="asin" class="mb-2">ASIN of Product </form:label>
              <form:input type="text" path="asin" class="form-control" 
                                autofocus="true" />
              <form:errors path="asin" class="text-danger"/>
         </div>
         
         <!-- ean property -->
         <div class="col-sm-4 mb-4">
        		<form:label path="ean" class="mb-2">EAN of Product </form:label>
              <form:input type="text" path="ean" class="form-control" 
                                autofocus="true" />
              <form:errors path="ean" class="text-danger"/>
         </div>
         
         <!-- ingredients property -->
         <div class="col-sm-4 mb-4">
        		<form:label path="ingredients" class="mb-2">Ingredients </form:label>
              <form:textarea  path="ingredients" class="form-control" rows="15" cols="30" autofocus="true" />
              <form:errors path="ingredients" class="text-danger"/>
         </div>
         
         <!-- certificates property -->
         <div class="col-sm-4 mb-4">
        	  <form:label path="certificates" class="mb-2">Ingredients </form:label>
              <form:checkboxes  items = "${certificateModelAttribute }" path="certificates" class="form-check-input" autofocus="true" />       
         </div>
         
         <!-- button for submit -->
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Add</button>
         </div>
	</form:form>
	<br/>
	<span class="text text-danger"><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></span>
	<a href="${contextPath }/home" > Back to Home</a>

</div>

<%@include file="../footer.jsp"  %>