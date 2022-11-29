<%@page import="com.inventory.entity.Product"%>
<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.*" %>
<%@include file="../header.jsp" %>

<div class="container" >
<h1>List of All Products</h1>
	 <table class="table table-striped">
            <thead class="table-primary">
                <th> Nr.</th>
                <th> Product Name</th>
                <th> Manufacturer</th>
                <th> ASIN</th>
                <th>EAN </th>
                <th>Details</th>
                <th> Created Date</th>
                <th colspan="3">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
            <c:forEach items="${listProducts}" var="item">          	
                <tr>              
                    <th><%= i++ %></th>
                    <td>${item.name }</td>
                    <td>${item.manufacturer }</td>
                    <td>${item.asin }</td>
                    <td>${item.ean }</td>
                    <td>${item.details }</td>
                    <fmt:parseDate value="${item.date }" pattern="yyyy-MM-dd'T'HH:mm" var="datepattern" type="both" />
                    <td><fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value = "${datepattern }" /></td>
                    <td>
		                    <c:url var="updateLink" value="${contextPath }/product/updateProduct">
		                    	<c:param name="id" value = "${item.id }" />
		                    </c:url>
		                    
		                    <c:url var="deleteLink" value="${contextPath }/product/delete">
		                    	<c:param name="id" value = "${item.id }" />
		                    </c:url>
		                    
		                    <c:url var="detailLink" value="${contextPath }/product/details">
		                    	<c:param name="id" value = "${item.id }" />
		                    </c:url>
		                    
		                    <div class="row">
		                    	<div class="col col-sm-4"> 
		                    		<a href="${updateLink }" class="btn btn-primary btn-sm-2">Edit</a>
		                    	</div>
		                    	<div class="col col-sm-4">
		                    		<a href="${deleteLink }" class="btn btn-danger btn-sm-2">Delete</a>                  		
		                    	</div>
		                    	<div class="col col-sm-4">
		                    		<a href="${detailLink }" class="btn btn-info btn-sm-2">Details</a>                  		
		                    	</div>
		                    </div>
                    </td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
        <span class="text-danger"><%= request.getAttribute("success") != null ? request.getAttribute("success") : " " %> <%-- <c:out value="${delete }" /> --%></span> </br>
		<span class="text text-danger"><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></span>
</div>

<%@include file="../footer.jsp"  %>