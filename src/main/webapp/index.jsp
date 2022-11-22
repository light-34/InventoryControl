<%@include file="./header.jsp" %>

<div class="container" >
<h2> This is index Page Welcome </h2>
	<a href="${contextPath }/product/add" > Add a Product</a><br/>
	<a href="${contextPath }/product/all" > View all Products</a><br/>
	<a href="${contextPath }/purchase/add" > Add Purchase</a><br/>
	<a href="${contextPath }/purchase/all" >View all Purchases</a><br/>
</div>

<%@include file="./footer.jsp"  %>