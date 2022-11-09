<%@page import="com.inventory.entity.Product"%>
<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.*" %>
<%@include file="./header.jsp" %>

<div class="container" >
<h1>List of All Products</h1>
	 <table class="table table-striped">
            <thead class="table-primary">
                <th> Nr.</th>
                <th> Product Name</th>
                <th> Manufacturer</th>
                <th> ASIN</th>
                <th> Created Date</th>
                <th colspan="2">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
            <c:forEach items="${listProducts}" var="item">          	
                <tr>              
                    <th><%= i++ %></th>
                    <td>${item.name }</td>
                    <td>${item.manufacturer }</td>
                    <td>${item.asin }</td>
                    <fmt:parseDate value="${item.date }" pattern="yyyy-MM-dd'T'HH:mm" var="datepattern" type="both" />
                    <td><fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value = "${datepattern }" /></td>
                    <td>
                    
                    <c:url var="updateLink" value="${contextPath }/updateProduct">
                    	<c:param name="id" value = "${item.id }" />
                    </c:url>
                    
                    <c:url var="deleteLink" value="${contextPath }/deleteProduct">
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

<%@include file="./footer.jsp"  %>