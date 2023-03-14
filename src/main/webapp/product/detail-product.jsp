<%@include file="../header.jsp" %>

<div class="container" >
	<h1 class="text text-black-50 text-centre mt-7">Details of A Product</h1>
	<div class="row justify-content-md-center">
		<div class="col col-md-2">
			<img src="/images/product_img/${pr.image }" class="card-img-top" alt="..." height="200" />
			<p>${pr.image }</p>
		</div>
		<div class="col col-lg-4">
			<h3>${pr.name }</h3>
			<p><strong>Category of ${pr.category}</strong></p>
			<p><strong>ASIN: </strong> ${det.asin } </p>
			<p><strong>EAN: </strong>${det.ean }</p>
			<p><strong>INGREDIENTS : </strong></br><%-- ${detail.ingredients } --%></p>
			<p><strong>CERTIFICATE : </strong></br><%-- ${detail.certificate } --%></p>	
		</div>
	</div>
</div>

<%@include file="../footer.jsp"  %>