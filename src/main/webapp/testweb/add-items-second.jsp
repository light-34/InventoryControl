<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.inventory.dto.Items"%>
<%@page import="com.inventory.entity.Purchase"%>
<%@page import="com.inventory.entity.Item"%>
<%@page import="java.util.List"%>
<%@include file="../header.jsp" %>

<div class="container" >
<h2 class="text text-black-50 text-center mb-4"> Add a new Item </h2>

<% 
	Items itemsForList = (Items) request.getAttribute("listItems");
	
	List<Item> items  = itemsForList.getItemList();
	%>
	
	<%	for(int i = 0; i < items.size(); i++)  {%>
			<div class="row">
				<div class="col-sm-2 mb-6">
		        	<p> <%= items.get(i).getPrice() %></p>
		        </div>
		        <div class="col-sm-2 mb-6">
		        	<p> <%= items.get(i).getQuantity() %></p>
		        </div>
		        <div class="col-sm-2 mb-6">
		        	<p> <%= items.get(i).getState() %></p>
		        </div>
		        <div class="col-sm-2 mb-6">
		        	<p> <%= items.get(i).getPurchase() %></p>
		        </div>
			</div>

	<% } %>

	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>