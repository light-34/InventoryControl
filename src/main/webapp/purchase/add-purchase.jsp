<%@include file="../header.jsp" %>

<div class="container" >
<h2 class="text text-black-50 text-center mb-4"> Add a new Purchase </h2>
	
	<form:form modelAttribute="pur" action="${contextPath }/purchase/create">	
         
         <div class="col-sm-4 mb-4">
        	<form:select path="store" class="form-select form-select-sm">
        		<form:option value="0">Select A Store</form:option>
        		<c:forEach items="${listStores }" var="storeElem">
        			<form:option value="${storeElem.getId() } "> ${storeElem.getName() }</form:option>
        		</c:forEach>
        	</form:select>
        	<form:errors path="store" />
        </div>
        
         <div class="col-sm-4 mb-4">
         	<form:label path="date" class="mb-2">Purchase Date</form:label>
              <form:input type="date" path="date" class="form-control"
                                autofocus="true" />
              <form:errors path="date" />
         </div>
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Add</button>
         </div>
    </form:form>
    </br>
	
	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>