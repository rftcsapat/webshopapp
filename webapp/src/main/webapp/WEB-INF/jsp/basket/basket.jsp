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
							<img src="/imageDisplay?id=${item.itemid}" alt="termek_kep">
						</div>
						<div class="col-md-8">
							<div class="basket-item-1of2">
								<h2 class="basket-item-name"><a href="/product/${item.itemid}">${item.itemname}</a></h2>
<%-- 								<h4><a href="/product/${item.itemid}">${item.itemname}</a></h4> --%>
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
									Ár<br> 
									<span class="price">${item.price}</span>
									<span class="currency">Kr</span>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<a class="basket-item-del-link" href="/deleteBasketEntry/${item.itemid}/${item.quantity}">Tétel törlése</a>
						</div>
					</div>
                </c:forEach>
			</div>
			<hr>
			<div class="row">
				<div class="pull-right basket-amounts">
					Termék darabszám: <strong>${count}</strong><br> 
					Fizetendő: <strong><fmt:formatNumber type="number" pattern="###,###" value="${sum}" /> Kr</strong>
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