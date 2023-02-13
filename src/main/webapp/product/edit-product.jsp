<%@include file="../header.jsp" %>

<div class="container" >
	<form:form modelAttribute="prod" action="${contextPath }/product/update" enctype="multipart/form-data">
		<h2> Update the product details</h2>
		
		<!-- id property -->
		<form:hidden path="id" />
		
        <!-- name property -->
        <div class="col-sm-4 mb-4">
        		<form:label path="name" class="mb-2"> Product Name </form:label>
              <form:input type="text" path="name" class="form-control" 
                                autofocus="true" />
              <form:errors path="name" class="text-danger"/>
         </div>
         
         <!-- category property -->
         <div class="col-sm-4 mb-4">
        	<form:select path="category" class="form-select form-select-sm">
        		<form:option value="0">Select A Category</form:option>
        		<c:forEach items="${listCategory }" var="cat">
        			<form:option value="${cat} "> ${cat }</form:option>
        		</c:forEach>
        	</form:select>
        	<form:errors path="category" />
        </div>
         
         <!-- price property -->
         <div class="col-sm-4 mb-4">
         		<form:label path="price" class="mb-2">Product MSRP</form:label>
              <form:input type="number" min="1.0" step=".01" path="price" class="form-control"
                                autofocus="true" />
              <form:errors path="price" />
         </div>
   
         <!-- image property -->
         <div class="col-sm-4 mb-4">
         	<label for="file">Select an image</label>
         	<input type="file" name="file" />
         </div>
         
         <!-- button for submit -->
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Update</button>
         </div>
	
	</form:form>

</div>

<%@include file="../footer.jsp"  %>