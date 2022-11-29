<%@page import="com.inventory.entity.Item"%>
<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.*" %>
<%@include file="../header.jsp" %>

<div class="container" >
<h1>List of All Products</h1>
	 <table class="table table-striped">
            <thead class="table-primary">
                <th> Nr.</th>
                <th> Product ID</th>
                <th> Purchase ID</th>
                <th>State</th>
                <th> Expiration Date</th>
                <th> Quantity</th>
                <th>Price </th>
                
                <th colspan="2">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
            <c:forEach items="${listItems}" var="item">          	
                <tr>              
                    <th><%= i++ %></th>
                    <td>${item.product.id }</td>
                    <td>${item.purchase.id }</td>
                    <td>${item.state }</td>
                    <fmt:parseDate value="${item.expDate }" pattern="yyyy-MM-dd" var="datepattern" type="date" />
                    <td><fmt:formatDate pattern="dd/MMM/yyyy" value = "${datepattern }" /></td>
                    <td>${item.quantity }</td>
                    <td>${item.price}</td>
                    
                    <td>
		                    <c:url var="updateLink" value="${contextPath }/item/updateItem">
		                    	<c:param name="id" value = "${item.id }" />
		                    </c:url>
		                    
		                    <c:url var="deleteLink" value="${contextPath }/item/delete">
		                    	<c:param name="id" value = "${item.id }" />
		                    </c:url>
		                    
		                    <div class="row">
		                    	<div class="col"> 
		                    		<a href="${updateLink }" class="btn btn-primary btn-md">Edit</a>
		                    	</div>
		                    	<div class="col">
		                    		<a href="${deleteLink }" class="btn btn-danger btn-md">Delete</a>                  		
		                    	</div>
		                    </div>
                    </td>
                </tr>
              </c:forEach>

            </tbody>
        </table>
        <span class="text-danger"><c:out value="${delete }" /></span>

</div>

<%@include file="../footer.jsp"  %>