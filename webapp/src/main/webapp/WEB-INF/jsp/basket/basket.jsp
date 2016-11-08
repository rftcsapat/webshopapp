<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>
		
		<div class="col-md-9">
			<h1 class="page-title">Kosár</h1>
			
			<div class="basket">
				<div class="basket-item row">
					<div class="col-md-3">
						<img src="public/images/product/vironal.jpg" alt="vironal termek">
					</div>
					<div class="col-md-7">
						<h2>Termék title</h2>
						<table class="table table-hover">
							<tr>
								<td>Cikkszám</td>
								<td>Mennyiség</td>
								<td>Fogyasztói Ár</td>
								<td>Összesen</td>				
							</tr>
							<tr>
								<td>21331312</td>
								<td>2</td>
								<td>4500 Ft</td>
								<td>9000 Ft</td>	
							</tr>
						</table>
					</div>
					<div class="col-md-2">
						<a href="#">Tétel törlése</a>
					</div>
				</div>
				<div class="basket-item row">
					<div class="col-md-3">
						<img src="public/images/product/vironal.jpg" alt="vironal termek">
					</div>
					<div class="col-md-7">
						<h2>Termék title</h2>
						<table class="table table-hover">
							<tr>
								<td>Cikkszám</td>
								<td>Mennyiség</td>
								<td>Fogyasztói Ár</td>
								<td>֖Összesen</td>				
							</tr>
							<tr>
								<td>21331312</td>
								<td>2</td>
								<td>4500 Ft</td>
								<td>9000 Ft</td>	
							</tr>
						</table>
					</div>
					<div class="col-md-2">
						<a href="#">Tétel törlése</a>
					</div>
				</div>
				<div class="basket-item row">
					<div class="col-md-3">
						<img src="public/images/product/vironal.jpg" alt="vironal termek">
					</div>
					<div class="col-md-7">
						<h2>Termék title</h2>
						<table class="table table-hover">
							<tr>
								<td>Cikkszám</td>
								<td>Mennyiség</td>
								<td>Fogyasztói ár</td>
								<td>Összesen</td>				
							</tr>
							<tr>
								<td>21331312</td>
								<td>2</td>
								<td>4500 Ft</td>
								<td>9000 Ft</td>	
							</tr>
						</table>
					</div>
					<div class="col-md-2">
						<a href="#">Tétel törlése</a>
					</div>
				</div>
			</div>
			<div class="row">
				<a class="btn btn-default btn-lg" href="/">Vásárlás folytatása</a>
				<a class="btn-btn-default btn-lg pull-right" href="/">Pénztár</a>
			</div>	
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>