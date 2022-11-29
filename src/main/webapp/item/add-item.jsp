<%@include file="../header.jsp" %>

<div class="container" >
<h2 class="text text-black-50 text-center mb-4"> Add a new Item </h2>
	
	<form:form modelAttribute="puritem" action="${contextPath }/item/create">	
	
	<!-- Get product ID -->
		<div class="col-sm-4 mb-4">
        	<form:select path="product" class="form-select form-select-sm">
        		<form:option value="0">Select A Product</form:option>
        		<c:forEach items="${listProduct }" var="prodElem">
        			<form:option value="${prodElem.getId() } "> ${prodElem.getName() }</form:option>
        		</c:forEach>
        	</form:select>
        	<form:errors path="product" />
        </div>
        
        <!-- Get purchase ID -->
        <div class="col-sm-4 mb-4">
        	<form:select path="purchase" class="form-select form-select-sm">
        		<form:option value="0">Select A Product</form:option>
        		<c:forEach items="${listPurchases }" var="purElem">
        			<form:option value="${purElem.getId() } "> ${purElem.getDate() }</form:option>
        		</c:forEach>
        	</form:select>
        	<form:errors path="purchase" />
        </div>
       
       	<div class="col-sm-4 mb-4" >
       		  <form:label path="quantity" class="mb-2"> Quantity </form:label>
              <form:input type="number" min="1" path="quantity" class="form-control"
                                autofocus="true" />
              <form:errors path="quantity" />
         </div>
         
         <div class="col-sm-4 mb-4">
         		<form:label path="price" class="mb-2"> Price </form:label>
              <form:input type="number" min="1.0" step=".01" path="price" class="form-control"
                                autofocus="true" />
              <form:errors path="price" />
         </div>
         <div class="col-sm-4 mb-4">
         		<form:select path="state" class="form-select form-select-sm" >
         			<c:forEach items="${states }" var="st" >
         				<form:option value="${st } "> ${st }</form:option>
         			</c:forEach>
         		
         		</form:select>
              <form:errors path="state" />
         </div>
        
         <div class="col-sm-4 mb-4">
         	<form:label path="expDate" class="mb-2">Expiration Date</form:label>
              <form:input type="date" path="expDate" class="form-control"
                                autofocus="true" />
              <form:errors path="expDate" />
         </div>
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Add</button>
         </div>
    </form:form>
	
	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>