<%@include file="./header.jsp" %>

<div class="container" >
<h2> This is index Page Welcome </h2>
	<a href="${contextPath }/addProduct" > Add a Product</a><br/>
	<a href="${contextPath }/products" > View all Products</a><br/>
	<a href="${contextPath }/addPurchase" > Add Purchase</a><br/>
	<a href="${contextPath }/listPurchase" >View all Purchases</a><br/>
</div>

<%@include file="./footer.jsp"  %>