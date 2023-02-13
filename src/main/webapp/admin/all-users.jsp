<%@page import="com.inventory.entity.Item"%>
<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.*" %>
<%@page import="com.inventory.dto.Items"%>
<%@include file="../header.jsp" %>

<div class="container" >
<h1>List of All Products</h1>
	 <table class="table table-striped">
            <thead class="table-primary">
                <th> Nr.</th>
                <th> User First Name</th>
                <th> User Last Name</th>
                <th>User Name</th>
                <th>Is Expired </th>
                <th>Is Locked </th>
                <th>Is Credential </th>
                <th>Is Enabled </th>
                <th>Roles</th>    
                <th colspan="2">Operations</th>
            </thead>
            <tbody>
             <% int i = 1; %>
            <c:forEach items="${listUsers}" var="item">          	
                <tr>              
                    <th><%= i++ %></th>
                    <td>${item.fName }</td>
                    <td>${item.lName }</td>
                    <td>${item.username }</td>
                    
                    <td>${item.expired }</td>
                    <td>${item.locked }</td>
                    <td>${item.credExpired}</td>
                    <td>${item.enabeled}</td>
                    <td>
                    <c:forEach items="${item.roles }" var="ro" >
                    	${ro } 
                    </c:forEach>
                    
                    </td>
                    <td>
		                    <c:url var="updateLink" value="${contextPath }/admin/userUp">
		                    	<c:param name="id" value = "${item.id }" />
		                    </c:url>
		                    
		                    <c:url var="deleteLink" value="${contextPath }/admin/userDel">
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

</div>

<%@include file="../footer.jsp"  %>