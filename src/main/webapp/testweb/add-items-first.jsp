<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.inventory.dto.Items"%>
<%@page import="com.inventory.entity.Purchase"%>
<%@page import="com.inventory.entity.Item"%>
<%@page import="java.util.List"%>
<%@include file="../header.jsp" %>

<div class="container" >
<h2 class="text text-black-50 text-center mb-4"> Add a new Item </h2>

<% 
	Purchase pur = (Purchase) request.getAttribute("thePurchase");
	Items it = (Items) request.getAttribute("purit");
	
	for (int i = 0; i < pur.getNrItem(); i++) { 
		  it.addItems(new Item());
	  } 
	
	
	List<Item> items  = it.getItemList();
	%>
	<p><%= items.size()  %></p>
	
<form:form modelAttribute="purit" action="${contextPath }/test/createItems">	

	<%	for(int i = 0; i < pur.getNrItem(); i++)  {%>
			<div class="row">
				<form:hidden path="${items.get(i).purchase }" value="${pur.getId()}" />
					<!-- Get product ID -->
				<div class="col-sm-2 mb-6">
		        	<form:select path="${items.get(i).product }" class="form-select form-select-sm">
		        		<form:option value="0">Select A Product</form:option>
		        		<c:forEach items="${listProduct }" var="prodElem">
		        			<form:option value="${prodElem.getId() } "> ${prodElem.getName() }</form:option>
		        		</c:forEach>
		        	</form:select>
		        	<form:errors path="${items.get(i).product }" />
		        </div>
		        
		       	<div class="col-sm-2 mb-4" >
		       		  <form:label path="${items.get(i).quantity }" class="mb-1"> Quantity </form:label>
		              <form:input type="number" min="1" path="${items.get(i).quantity }" class="form-control"
		                                autofocus="true" />
		              <form:errors path="${items.get(i).quantity }" />
		         </div>
		         
		         <div class="col-sm-2 mb-4">
		         		<form:label path="${items.get(i).price}" class="mb-1"> Price </form:label>
		              <form:input type="number" min="1.0" step=".01" path="${items.get(i).price}" class="form-control"
		                                autofocus="true" />
		              <form:errors path="${items.get(i).price}" />
		         </div>
		         <div class="col-sm-2 mb-4">
		         		<form:label path="${items.get(i).state}" class="mb-1"> State </form:label>
		         		<form:select path="${items.get(i).state}" class="form-select form-select-sm" >
		         			<c:forEach items="${states }" var="st" >
		         				<form:option value="${st } "> ${st }</form:option>
		         			</c:forEach>
		         		
		         		</form:select>
		              <form:errors path="${items.get(i).state}" />
		         </div>
		         	        
		         <div class="col-sm-2 mb-2">
		         	<form:label path="${items.get(i).expDate}" class="mb-2">Exp Date</form:label>
		              <form:input type="date" path="${items.get(i).expDate}" class="form-control"
		                                autofocus="true" />
		              <form:errors path="${items.get(i).expDate}" />
		         </div>
			</div>

	<% } %>
	
         <div class="col-sm-4 mb-4">
         		<button class = "btn btn-primary btn-md" type="submit">Add</button>
         </div>
    </form:form>
	
	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>