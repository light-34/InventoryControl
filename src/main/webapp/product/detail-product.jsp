<%@page import="com.inventory.entity.Product"%>
<%@page import="org.hibernate.sql.Delete"%>
<%@page import="java.util.*" %>
<%@include file="../header.jsp" %>

<div class="container" >
	<h1 class="text text-black-50 text-centre mt-7">Details of A Product</h1>
	<div class="row justify-content-md-center">
		<div class="col col-md-2">
			<img src="/images/product_img/${detail.image }" class="card-img-top" alt="..." height="200" />
		</div>
		<div class="col col-lg-4">
			<h3>${detail.name }</h3>
			<p><strong>By ${detail.manufacturer }</strong></p>
			<p><strong>ASIN: </strong>${detail.asin }</p>
			<p><strong>EAN: </strong>${detail.ean }</p>
			<p><strong>DETAILS : </strong></br>${detail.details }</p>	
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col col-lg-4">
			<div class="card">
				<img src="/images/product_img/${detail.image }" class="card-img-top" alt="..." height="200" />
				<div class="card-body">
					<div class="card-title">${detail.name }</div>
					<div class="card-subtitle mb-2 text-muted">By ${detail.manufacturer }</div>
					<div class="card-text">ASIN: ${detail.asin }</div>
					<div class="card-text">EAN: ${detail.ean }</div>
					<div class="card-text">DETAILS: ${detail.details }</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../footer.jsp"  %>