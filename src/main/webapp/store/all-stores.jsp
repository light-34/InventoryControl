<%@page import="com.inventory.entity.Store"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@include file="../header.jsp" %>

<div class="container" >
	<h2> List of All Stores</h2>
	<table class="table table-striped">
            <thead class="table-primary">
                <th> Nr.</th>
                <th> Store Name </th>
                <th> Store Location</th>
                <th> Store State</th>
                <th colspan="2">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
             <% 
             List<Store> model = (List<Store>) request.getAttribute("listAllStores");

             for(Store item: model)  {
             %>
             	<tr>
                    <th><%= i++ %></th>
                    <td><%= item.getName() %></td>
                    <td><%= item.getLocation() %></td>
                    <td><%= item.getState() %></td>
                    <td>
                    	<div class="row">
		                    	<div class="col"> 
				                    <form action="${contextPath }/store/updateStore" method="get">
				                    	<input type="hidden" value="<%= item.getId() %>" name="id" />
				                    	<button type ="submit" class="btn btn-primary btn-md"> Edit </button>  	
				                    </form>
				                 </div>
		                    	<div class="col"> 
				                    <form action="${contextPath }/store/delete" method="get">
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
			<!-- Shows in coming message from purchase controller /updatePurchase  -->
			<hr/>
			<span class="text text-success"> <%= request.getAttribute("success") != null ? request.getAttribute("success") : " "%></span>
			<hr/>
	<a href="${contextPath }/home" > Back to Home</a>
</div>

<%@include file="../footer.jsp"  %>