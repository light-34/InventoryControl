<%@include file="../header.jsp" %>

<div class="container" >
<h2 class="text text-black-50 text-center mb-4"> Update Store </h2>
	
	<form:form modelAttribute="store" action="${contextPath }/store/update">	
	<form:hidden path="id" />
	<!-- Get States -->
		<div class="col-sm-4 mb-4">
        	<form:select path="state" class="form-select form-select-sm">
        		<form:option value="0">Select A State</form:option>
        		<c:forEach items="${listState }" var="stateElem">
        			<form:option value="${stateElem} "> ${stateElem}</form:option>
        		</c:forEach>
        	</form:select>
        	<form:errors path="state" />
        </div>
       
       	<div class="col-sm-4 mb-4" >
       		  <form:label path="name" class="mb-2"> Store Name </form:label>
              <form:input type="text"  path="name" class="form-control"
                                autofocus="true" />
              <form:errors path="name" />
         </div>
         
         <div class="col-sm-4 mb-4" >
       		  <form:label path="location" class="mb-2"> Location </form:label>
              <form:input type="text"  path="location" class="form-control"
                                autofocus="true" />
              <form:errors path="location" />
         </div>
                  
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Update</button>
         </div>
    </form:form>
	
	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>