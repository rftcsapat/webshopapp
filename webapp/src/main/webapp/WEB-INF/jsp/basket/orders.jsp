<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title">Rendelés összesitő</h1>
			<div class="basket">
				<div class="basket-item row">
					<div class="col-md-2">
						<img src="public/images/product/vironal.jpg" alt="vironal termek">
					</div>
					<div class="col-md-10">
						<div class="basket-item-1of2">
							<h2 class="basket-item-name">Vironal</h2>
							<div class="basket-item-info">
								<span>Cikkszám: 2121212</span>
							</div>
						</div>
						<div class="basket-item-2of2">
							<div class="basket-item-db">
								<span>3 db</span>
							</div>
							<div class="basket-item-price">
								Ár<br> <span class="price">6000</span><span
									class="currency">Kr</span>
							</div>
						</div>
					</div>
				</div>
				<div class="basket-item row">
					<div class="col-md-2">
						<img src="public/images/product/regalen.jpg" alt="vironal termek">
					</div>
					<div class="col-md-10">
						<div class="basket-item-1of2">
							<h2 class="basket-item-name">Regalen</h2>
							<div class="basket-item-info">
								<span>Cikkszám: 2121212</span>
							</div>
						</div>
						<div class="basket-item-2of2">
							<div class="basket-item-db">
								<span>23 db</span>
							</div>
							<div class="basket-item-price">
								Ár<br> <span class="price">6000</span><span
									class="currency">Kr</span>
							</div>
						</div>
					</div>
				</div>
				<div class="basket-item row">
					<div class="col-md-2">
						<img src="public/images/product/gynex.jpg" alt="vironal termek">
					</div>
					<div class="col-md-10">
						<div class="basket-item-1of2">
							<h2 class="basket-item-name">Gynex</h2>
							<div class="basket-item-info">
								<span>Cikkszám: 2121212</span>
							</div>
						</div>
						<div class="basket-item-2of2">
							<div class="basket-item-db">
								<span>9 db</span>
							</div>
							<div class="basket-item-price">
								Ár<br> <span class="price">6000</span><span
									class="currency">Kr</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="pull-right basket-amounts">
					Termék darabszám: <strong>30</strong><br> Fizetendő: <strong>17.200
						Kr</strong>
				</div>
			</div>

			<div class="row">
				<h3>Szállitási adatok</h3>
				<form class="form-delivery">
					<div class="form-group">
						<label for="country">Ország</label> <input type="text"
							class="form-control" id="country" placeholder="Ország">
					</div>
					<div class="form-group">
						<label for="city">Város</label> <input type="text"
							class="form-control" id="city" placeholder="Város">
					</div>
					<div class="form-group">
						<label for="irszam">Írányitószám</label><input type="text"
							class="form-control" id="irszam">
					</div>
					<div class="form-group">
						<label for="address">Cim</label><input type="text"
							class="form-control" id="address">
					</div>
					<h4>Adjon meg egy elérhetőséget</h4>
					<div class="form-group">
						<label for="email">E-mail</label><input type="text"
							class="form-control" id="email">
					</div>
					<div class="form-group">
						<label for="phone">Telefon</label><input type="text"
							class="form-control" id="phone">
					</div>
					<h4>Válasz a szállitási módot:</h4>
					<div class="checkbox-wrapper">
						<div class="checkbox">
							<label> <input type="checkbox">Házhozszállitas
							</label>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox">Csomagátvétel
							</label>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox">Személyes átvétel
							</label>
						</div>
					</div>
				</form>
			</div>

			<div class="row text-center">
				<a class="btn btn-primary btn-lg" href="/">Rendelés Küldése</a>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>