<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title"><font color="white">Kosár</font></h1>

		<div class="basket">
		
				<c:forEach items="${itemsContent}" var="item" >
                    <div class="basket-item row">
						<div class="col-md-2">
							<img src="public/images/product/vironal.jpg" alt="vironal termek">
						</div>
						<div class="col-md-8">
							<div class="basket-item-1of2">
								<h2 class="basket-item-name"><font color="white">${item.itemname}</font></h2>
								<div class="basket-item-info">
									<span><font color="white">Termék azonosító: ${item.itemid}</font></span>
								</div>
							</div>
							<div class="basket-item-2of2">
								<div class="basket-item-db">
									<b><font color="white">${item.quantity}</font></b>
									<span><font color="white">db</font></span> 
								</div>
								<div class="basket-item-price">
									<font color="white">Ár</font><br> 
									<span class="price"><font color="white">${item.price}</font></span>
									<span class="currency"><font color="white">Kr</font></span>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<a class="basket-item-del-link" href="#"><font color="white">Tétel törlése</font></a>
						</div>
					</div>
                </c:forEach>
			</div>
			<hr>
			<div class="row">
				<div class="pull-right basket-amounts">
					Termék darabszám: <strong>${count}</strong><br> 
					Fizetendő: <strong>${sum} Kr</strong>
				</div>
			</div>
			<div class="row">
				<a class="btn btn-default btn-lg" href="/home/all/0">Vásárlás folytatása</a> 
				<a class="btn btn-default btn-lg pull-right" href="/orders">Pénztár</a>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>