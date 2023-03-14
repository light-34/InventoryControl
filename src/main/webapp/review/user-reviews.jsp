<%@page import="com.inventory.entity.Item"%>
<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.*" %>
<%@page import="com.inventory.dto.Items"%>
<%@include file="../header.jsp" %>

<div class="container" >
<h1>Reviews done by .... </h1>
	 <table class="table table-striped">
            <thead class="table-primary">
                <th> Product </th>
                <th> Review</th>
                <th> Rating </th>
                <th colspan="2">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
            <c:forEach items="${listReviews}" var="item">          	
                <tr>              
                    <th><%= i++ %></th>
                    <td>${item.product.name }</td>
                    <td>${item.reveiw }</td>
                    <td>${item.rate }</td>
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