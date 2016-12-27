<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title">Kosár</h1>

		<div class="basket">
		
				<c:forEach items="${itemsContent}" var="item" >
                    <div class="basket-item row">
						<div class="col-md-2">
							<img src="public/images/product/vironal.jpg" alt="vironal termek">
						</div>
						<div class="col-md-8">
							<div class="basket-item-1of2">
								<h2 class="basket-item-name">${item.itemname}</h2>
								<div class="basket-item-info">
									<span>Termék azonosító: ${item.itemid}</span>
								</div>
							</div>
							<div class="basket-item-2of2">
								<div class="basket-item-db">
									<b>${item.quantity}</b>
									<span>db</span> 
								</div>
								<div class="basket-item-price">
									Ár<br> <span class="price">${item.price}</span><span
										class="currency">Kr</span>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<a class="basket-item-del-link" href="#">Tétel törlése</a>
						</div>
					</div>
                </c:forEach>
			
				
				
			
			
<!-- 				<div class="basket-item row"> -->
<!-- 					<div class="col-md-2"> -->
<!-- 						<img src="public/images/product/vironal.jpg" alt="vironal termek"> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-8"> -->
<!-- 						<div class="basket-item-1of2"> -->
<!-- 							<h2 class="basket-item-name">Vironal</h2> -->
<!-- 							<div class="basket-item-info"> -->
<!-- 								<span>Cikkszám: 2121212</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="basket-item-2of2"> -->
<!-- 							<div class="basket-item-db"> -->
<!-- 								<b>1</b> -->
<!-- 								<span>db</span>  -->
<!-- 							</div> -->
<!-- 							<div class="basket-item-price"> -->
<!-- 								Ár<br> <span class="price">6000</span><span -->
<!-- 									class="currency">Kr</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<!-- 						<a class="basket-item-del-link" href="#">Tétel törlése</a> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="basket-item row"> -->
<!-- 					<div class="col-md-2"> -->
<!-- 						<img src="public/images/product/regalen.jpg" alt="vironal termek"> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-8"> -->
<!-- 						<div class="basket-item-1of2"> -->
<!-- 							<h2 class="basket-item-name">regalen</h2> -->
<!-- 							<div class="basket-item-info"> -->
<!-- 								<span>Cikkszám: 2121212</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="basket-item-2of2"> -->
<!-- 							<div class="basket-item-db"> -->
<!-- 								<b>1</b> -->
<!-- 								<span>db</span> 		 
<!-- 							</div> -->
<!-- 							<div class="basket-item-price"> -->
<!-- 								Ár<br> <span class="price">5000</span><span -->
<!-- 									class="currency">Kr</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<!-- 						<a class="basket-item-del-link" href="#">Tétel törlése</a> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="basket-item row"> -->
<!-- 					<div class="col-md-2"> -->
<!-- 						<img src="public/images/product/gynex.jpg" alt="vironal termek"> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-8"> -->
<!-- 						<div class="basket-item-1of2"> -->
<!-- 							<h2 class="basket-item-name">Gynex</h2> -->
<!-- 							<div class="basket-item-info"> -->
<!-- 								<span>Cikkszám: 2121212</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="basket-item-2of2"> -->
<!-- 							<div class="basket-item-db"> -->
<!-- 								<select class="form-control"> -->
<!-- 									<option>1</option> -->
<!-- 									<option>2</option> -->
<!-- 									<option>3</option> -->
<!-- 									<option>4</option> -->
<!-- 								</select> <span>db</span> -->
<!-- 							</div> -->
<!-- 							<div class="basket-item-price"> -->
<!-- 								Ár<br> <span class="price">6200</span><span -->
<!-- 									class="currency">Kr</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-2"> -->
<!-- 						<a class="basket-item-del-link" href="#">Tétel törlése</a> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
			<hr>
			<div class="row">
				<div class="pull-right basket-amounts">
					Termék darabszám: <strong>3</strong><br> Fizetendő: <strong>17.200
						Kr</strong>
				</div>
			</div>
			<div class="row">
				<a class="btn btn-default btn-lg" href="/">Vásárlás folytatása</a> <a
					class="btn btn-default btn-lg pull-right" href="/orders">Pénztár</a>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>