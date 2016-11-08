<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Page Content -->
<main>
<div class="container">

	<div class="row">

		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title">Részletes keresés</h1>

			<form class="form-search-more form-inline">
				<div class="form-group">
					<label for="termek-nev">Termék név</label> <input type="text"
						class="form-control" id="termeknev" placeholder="termek-nev">
				</div>
				<div class="form-group">
					<label for="gyarto">Gyártó</label>
					<select class="form-control" id="gyarto">
							<option>Gyártó 1</option>
							<option>Gyártó 2</option>
							<option>Gyártó 3</option>
							<option>Gyártó 4</option>
							<option>Gyártó 5</option>
					</select>
				</div>
				<div class="form-group">
					<label for="kategoriak">Kategória</label>
					<select class="form-control" id="kategoriak">
							<option>Kategória 1</option>
							<option>Kategória 2</option>
							<option>Kategória 3</option>
							<option>Kategória 4</option>
							<option>Kategória 5</option>
					</select>
				</div>
				<br>
				<div class="form-group">
					<label for="price">Ár</label>
					<div class="ar-valaszto-holder">
						<input type="text" id="ar-valaszto" name="ar-valaszto" value="">
					</div>
				</div>
				<br>
				<button type="submit" class="btn btn-default btn-md">Keresés</button>
			</form>


			<!--  találatok listázása -->
			<div class="row">
				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="public/images/product/vironal.jpg" alt="vironal termek">
						<div class="caption">
							<h4 class="pull-right">6000 Ft</h4>
							<h4>
								<a href="/product">Vironal</a>
							</h4>
							<p>Bioinformacios, komplex gyogynoveny-koncentratum 16-fele
								gyogynovenybol</p>
						</div>
						<div class="ratings">
							<p class="pull-right">15 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="public/images/product/regalen.jpg" alt="regalen termek">
						<div class="caption">
							<h4 class="pull-right">7500 Ft</h4>
							<h4>
								<a href="/product">Regalen</a>
							</h4>
							<p>Bioinformacios, komplex gyogynoveny-koncentratum 14-fele
								gyogynovenybol</p>
						</div>
						<div class="ratings">
							<p class="pull-right">15 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="public/images/product/renol.jpg" alt="renol termek">
						<div class="caption">
							<h4 class="pull-right">6300 Ft</h4>
							<h4>
								<a href="#">Renol</a>
							</h4>
							<p>Bioinformacios, komplex gyogynoveny-koncentratum 15-fele
								gyogynovenybol</p>
						</div>
						<div class="ratings">
							<p class="pull-right">31 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star-empty"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="public/images/product/gynex.jpg" alt="gynex termek">
						<div class="caption">
							<h4 class="pull-right">7300 Ft</h4>
							<h4>
								<a href="#">Gynex</a>
							</h4>
							<p>Bioinformacios, komplex gyogynoveny-koncentratum 15-fele
								gyogynovenybol</p>
						</div>
						<div class="ratings">
							<p class="pull-right">6 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star-empty"></span> <span
									class="glyphicon glyphicon-star-empty"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="public/images/product/korolen.jpg" alt="korolen termek">
						<div class="caption">
							<h4 class="pull-right">7200 Ft</h4>
							<h4>
								<a href="#">Korolen</a>
							</h4>
							<p>Bioinformacios, komplex gyogynoveny-koncentratum 15-fele
								gyogynovenybol</p>
						</div>
						<div class="ratings">
							<p class="pull-right">18 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star-empty"></span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</main>

<%@include file="../includes/footer.jsp"%>