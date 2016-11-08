<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div id="wrapper">

	<%@include file="includes/sidenav.jsp"%>

	<div id="page-wrapper">

		<div class="container-fluid">

			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Termékek kezelése</h1>
				</div>
			</div>

			<div class="row">

				<div class="col-md-12">
					<!-- Tabs -->
					<div id="product-tabs">
						<ul>
							<li><a href="#tabs-1">Termék hozzáadás</a></li>
							<li><a href="#tabs-2">Termék módosítás</a></li>
						</ul>
						<div id="tabs-1">
							<form class="form-product-add">
								<div class="form-group">
									<label for="termek-neve">Termék neve</label> <input
										type="email" class="form-control" id="termek-neve">
								</div>
								<div class="form-group">
									<label for="termek-cikkszam">Termék cikkszám</label> <input
										type="text" class="form-control" id="termek-cikkszam">
								</div>
								<div class="form-group">
									<label for="termek-leiras">Termék rövid leírás</label> <input
										type="text" class="form-control" id="termek-leiras">
								</div>
								<div class="form-group">
									<label for="termek-leiras">Termék részletes leírás</label>
									<textarea class="form-control" id="termek-leiras"></textarea>
								</div>
								<div class="form-group">
									<label for="termek-gyarto">Termék gyártó</label> <select
										class="form-control" id="termek-gyarto">
										<option>Gyártó 1</option>
										<option>Gyártó 2</option>
										<option>Gyártó 3</option>
										<option>Gyártó 4</option>
										<option>Gyártó 5</option>
									</select>
								</div>
								<div class="form-group">
									<label for="termek-kategoria">Termék kategória</label>
									<select
										class="form-control" id="termek-kategoria">
										<option>Kategória 1</option>
										<option>Kategória 2</option>
										<option>Kategória 3</option>
										<option>Kategória 4</option>
										<option>Kategória 5</option>
									</select>
								</div>
								<div class="form-group">
									<label for="termek-kep">Termék kép</label> <input type="file"
										id="termek-kep">
									<p class="help-block">A kép mérete max. 1MB méretű lehet.</p>
								</div>
								<button type="submit" class="btn btn-default">Mentés</button>
							</form>
						</div>
						<div id="tabs-2">
							<form class="form-product-modify">
								<div class="form-group">
									<label for="termek-neve-m">Termék neve</label>
									<select class="form-control" id="termek-neve-m">
										<option>Valásszon a terméket</option>
										<option>Termék 1</option>
										<option>Termék 2</option>
										<option>Termék 3</option>
										<option>Termék 4</option>
										<option>Termék 5</option>
									</select>
								</div>
								<div class="form-group">
									<label for="termek-cikkszam-m">Termék cikkszám</label> <input
										type="text" class="form-control" id="termek-cikkszam-m">
								</div>
								<div class="form-group">
									<label for="termek-leiras-m">Termék rövid leírás</label> <input
										type="text" class="form-control" id="termek-leiras-m">
								</div>
								<div class="form-group">
									<label for="termek-leiras-m">Termék részletes leírás</label>
									<textarea class="form-control" id="termek-leiras-m"></textarea>
								</div>
								<div class="form-group">
									<label for="termek-gyarto-m">Termék gyártó</label> <select
										class="form-control" id="termek-gyarto-m">
										<option>Gyártó 1</option>
										<option>Gyártó 2</option>
										<option>Gyártó 3</option>
										<option>Gyártó 4</option>
										<option>Gyártó 5</option>
									</select>
								</div>
								<div class="form-group">
									<label for="termek-kategoria-m">Termék kategória</label>
									<select
										class="form-control" id="termek-kategoria-m">
										<option>Kategória 1</option>
										<option>Kategória 2</option>
										<option>Kategória 3</option>
										<option>Kategória 4</option>
										<option>Kategória 5</option>
									</select>
								</div>
								<div class="form-group">
									<label for="termek-kep-m">Termék kép</label> <input type="file"
										id="termek-kep-m">
									<p class="help-block">A kép mérete max. 1MB méretű lehet.</p>
								</div>
								<button type="submit" class="btn btn-default">Mentés</button>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>