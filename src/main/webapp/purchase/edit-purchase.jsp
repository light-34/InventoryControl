<%@include file="../header.jsp" %>

<div class="container" >
	<form:form modelAttribute="pur" action="${contextPath }/purchase/update" >
		<form:hidden path="id" />
		<div>
        	<form:select path="prodid">
        		<form:option value="0">Select A Product</form:option>
        		<c:forEach items="${prod }" var="prodElem">
        			<form:option value="${prodElem.getId() } "> ${prodElem.getName() }</form:option>
        		</c:forEach>
        	</form:select>
        	<form:errors path="prodid" />
        </div><br/>
       
       	<div class="col-sm-4">
              <form:input type="number" min="1" path="quantity" class="form-control" placeholder="Quantity of Product"
                                autofocus="true"  />
              <form:errors path="quantity" />
         </div>
         
         <div class="col-sm-4">
              <form:input type="number" min="1.0" step=".01" path="price" class="form-control" placeholder="Price of Product"
                                autofocus="true" />
              <form:errors path="price" />
         </div>
         
         <div class="col-sm-4">
              <form:input type="text" path="store" class="form-control" placeholder="Purchased Store"
                                autofocus="true" />
              <form:errors path="store" />
         </div>
        <br />
        
         <div class="col-sm-4">
              <form:input type="date" path="date" class="form-control" autofocus="true"/>
              <form:errors path="date" />
         </div>
         <div>
         		<button class = "btn btn-primary btn-md" type="submit">Update</button>
         </div>
	
	</form:form>

</div>

<%@include file="../footer.jsp"  %>