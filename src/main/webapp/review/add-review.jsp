<%@include file="../header.jsp" %>

<div class="container" >
<h2 class="text text-black-50 text-center mb-4"> Add Review To ... </h2>
	
	<form:form modelAttribute="rev" action="${contextPath }/review/create">	
	
	<!-- Get product ID -->
				
		<sec:authorize access="isAuthenticated()" >
			Authenticated as : <sec:authentication property="principal.username" />
		</sec:authorize>
		
		
		<form:hidden path="username" value="${use }"/>
		
       	<div class="col-sm-4 mb-4" >
       		  <form:label path="review" class="mb-2"> Review </form:label>
              <form:textarea path="review" class="form-control" autofocus="true" />
              <form:errors path="review" />
         </div>
         
         <div class="col-sm-4 mb-4">
         		<form:label path="rate" class="mb-2"> <strong>Rate</strong> </form:label></br>
         		One <form:radiobutton path="rate" value="1"/>
         		Two <form:radiobutton path="rate" value="2"/>
         		Three <form:radiobutton path="rate" value="3"/>
         		Four <form:radiobutton path="rate" value="4"/>
         		Five<form:radiobutton path="rate" value="5"/>
	              <%-- <form:input type="number" min="1.0" step=".01" path="rate" class="form-control"
	                                autofocus="true" />
	               <span>Please rate (1 - 5)</span> --%>
	              <form:errors path="rate" />
         </div>
         
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Add</button>
         </div>
    </form:form>
	
	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>