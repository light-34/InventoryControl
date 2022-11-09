<%@page import="java.util.stream.Collectors"%>
<%@page import="com.inventory.entity.Product"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.inventory.repository.ProductRepository"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="com.inventory.entity.Purchase"%>
<%@page import="java.util.List"%>
<%@include file="./header.jsp" %>

<div class="container" >
	<h2> List of All purchases </h2>
	<table class="table table-striped">
            <thead class="table-primary">
                <th> Nr.</th>
                <th> Product Name</th>
                <th> Store </th>
                <th> Purchase Date</th>
                <th> Quantity</th>
                <th>Price </th>
                <th>Subtotal </th>
                <th colspan="2">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
             <% 
             List<Purchase> model = (List<Purchase>) request.getAttribute("listAllPurchase");
             List<Product> products = (List<Product>) request.getAttribute("repo");

             for(Purchase item: model)  {

             	List<Product> name = products.stream().filter(x -> x.getId() == item.getId()).collect(Collectors.toList());
             %>
             	<tr>
                    <th><%= i++ %></th>
                    <td><%= name.get(0).getName()%> </td>
                    <td><%= item.getStore() %></td>
                    <td><%= item.getDate() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td><%= item.getPrice() %></td>
                    <td><%= item.getPrice() * item.getQuantity() %></td>
                    <td>
	                    <form action="${contextPath }/purUpdate" method="get">
	                    	<input type="hidden" value="<%= item.getId() %>" name="id" />
	                    	<button type ="submit" class="btn btn-primary btn-md"> Edit </button>  	
	                    </form>
	                    
	                    <form action="${contextPath }/deletePurchase" method="get">
	                    	<input type="hidden" value="<%= item.getId() %>" name="id"/>
	                    	<button type ="submit" class="btn btn-danger btn-md"> Delete </button>  	
	                    </form>
                    </td>
                </tr>

             <% } %>
            </tbody>
        </table>
			<!-- Shows in coming message from purchase controller /updatePurchase  -->
			<hr/>
			<span class="text text-success"> <%= request.getAttribute("success") != null ? request.getAttribute("success") : " "%></span>
			<hr/>
	<a href="${contextPath }/" > Back to Home</a>
</div>

<%@include file="./footer.jsp"  %>