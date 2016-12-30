<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Page Content -->
<main>
<div class="container">

	<div class="row">
	
		<%@include file="../includes/sidebar.jsp"%>
	
		<div class="col-md-9">
			<section class="product-s">
				<h1 class="page-title">Termék neve</h1>
				<div class="row">
					<div class="col-md-3">
						<img class="img-responsive" src="public/images/product/vironal.jpg">
					</div>
					<div class="col-md-8">
						<div class="row">
							<div class="col-md-6">
								<ul>
									<li><span class="fixwidth"><strong>Gyártó: </strong></span><span class="fixwidth">${item.manufacturername}</span></li>
									<li><span class="fixwidth"><strong>Kategória: </strong></span><span >${item.categoryname}</span></li>
<!-- 									<li><span class="fixwidth"><strong>Cikkszám: </strong></span><span class=fixwidth>Űrtartalom</span></li> -->
									<li><span class="fixwidth"><strong>Raktáron: </strong></span><span >
									<c:choose>
						                <c:when test="${item.quantity > 0}">
						                    ${item.quantity}
						                </c:when>
						                <c:otherwise>
						                    0
						                </c:otherwise>
						            </c:choose>
									 db
									</span></li>
									<li><span class="fixwidth"><strong>Űrtartalom: </strong></span><span>${item.itemquantity} ml</span></li>
									
								</ul>
							</div>
							<div class="col-md-6">
								<div class="text-right price-wrapper">
									<span class="price">${item.price} Kr</span>
								</div>
							</div>
						</div>
						
						<form:form class="basket-add-form" modelAttribute="addToBasketDto">
							<div class="form-group">
								<form:input path="quantity" class="product-add-db text-center" type="text" name="product-add-db" value="1"/>
								<form:button class="btn btn-default">Kosárba</form:button>
								<br/>
								<c:if test="${not empty errorMessage}">
									<font size="4" color="red"><b>${errorMessage}</b></font><br/>
								</c:if>
								<c:if test="${not empty message}">
									<font size="4" color="white"><b>${message}</b></font><br/>
								</c:if> 
							</div>
						</form:form>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h3>Leírás</h3>
						<p>${item.description}</p>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>
</main>

<%@include file="../includes/footer.jsp"%>