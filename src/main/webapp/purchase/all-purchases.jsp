<%@page import="java.util.stream.Collectors"%>
<%@page import="com.inventory.entity.Product"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.inventory.repository.ProductRepository"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="com.inventory.entity.Purchase"%>
<%@page import="java.util.List"%>
<%@include file="../header.jsp" %>

<div class="container" >
	<h2> List of All purchases </h2>
	<table class="table table-striped">
            <thead class="table-primary">
                <th> Nr.</th>
                <th> Store ID </th>
                <th> Purchase Date</th>
                <th colspan="2">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
             <% 
             List<Purchase> model = (List<Purchase>) request.getAttribute("listAllPurchase");

             for(Purchase item: model)  {
             %>
             	<tr>
                    <th><%= i++ %></th>
                    <td><%= item.getStore().getId() %></td>
                    <td><%= item.getDate() %></td>
                    <td>
                    	<div class="row">
		                    	<div class="col"> 
				                    <form action="${contextPath }/purchase/updatePurchase" method="get">
				                    	<input type="hidden" value="<%= item.getId() %>" name="id" />
				                    	<button type ="submit" class="btn btn-primary btn-md"> Edit </button>  	
				                    </form>
				                 </div>
		                    	<div class="col"> 
				                    <form action="${contextPath }/purchase/delete" method="get">
				                    	<input type="hidden" value="<%= item.getId() %>" name="id"/>
				                    	<button type ="submit" class="btn btn-danger btn-md"> Delete </button>  	
				                    </form>
				                 </div>
				          </div>
                    </td>
                </tr>

             <% } %>
            </tbody>
        </table>
        	<img alt="landscape" src="/images/land.png">
			<!-- Shows in coming message from purchase controller /updatePurchase  -->
			<hr/>
			<span class="text text-success"> <%= request.getAttribute("success") != null ? request.getAttribute("success") : " "%></span>
			<hr/>
	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>