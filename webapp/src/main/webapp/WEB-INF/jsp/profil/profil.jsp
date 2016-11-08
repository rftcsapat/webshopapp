<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title">Profil</h1>

			<div class="profil">
				<div class="profil-item">
					<h2>Személyes Adatok</h2>
					<form class="person-data-form" method="post">
						<div class="form-group">
							<label for="titulus">Titulus</label> <input type="text"
								class="form-control" id="titulus" placeholder="dr,prof">
						</div>
						<div class="form-group">
							<label for="vnev">Vezetéknév</label> <input type="text"
								class="form-control" id="vnev">
						</div>
						<div class="form-group">
							<label for="knev">Keresztnév</label> <input type="text"
								class="form-control" id="knev">
						</div>
						<div class="form-group">
							<label for="szuldate">Születési dátum</label> <input type="text"
								class="form-control" id="szuldate">
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								class="form-control" id="email">
						</div>
					</form>
				</div>
				<div class="profil-item">
					<h2>Profil Adatok</h2>
					<form class="profil-data-form" method="post">
						<div class="form-group">
							<label for="username">Felhasználónév</label> <input type="text"
								class="form-control" id="username">
						</div>
						<div class="form-group">
							<label for="pass">Jelszó</label> <input type="password"
								class="form-control" id="pass">
						</div>
						<div class="form-group">
							<label for="pass-reset">Jelszó ismét</label> <input
								type="password" class="form-control" id="pass-reset">
						</div>
						<div class="form-group">
							<label for="inv-code">Meghívó kód</label> <input type="text"
								class="form-control" id="inv-code">
						</div>
						<div class="form-group">
							<label for="profil-image">File input</label> <input type="file"
								id="profil-image">
							<p class="help-block">A feltölthető fájl mérete maximum 1MB
								lehet!</p>
						</div>
					</form>
				</div>
				<div class="profil-item">
					<h2>Szállítási Adatok</h2>
					<div class="form-group">
						<label for="address-orszag">Ország</label> <input type="text"
							class="form-control" id="address-orszag">
					</div>
					<div class="form-group">
						<label for="address-megye">Megye</label> <input type="text"
							class="form-control" id="address-megye">
					</div>
					<div class="form-group">
						<label for="address-irszam">Irányítószám</label> <input
							type="text" class="form-control" id="address-irszam">
					</div>
					<div class="form-group">
						<label for="address-varos">Város</label> <input type="text"
							class="form-control" id="address-varos">
					</div>
					<div class="form-group">
						<label for="address-utcahaz">Utca, Házszám</label> <input type="text"
							class="form-control" id="address-utcahaz">
					</div>
				</div>
			</div>
			<div class="row">
				<a class="btn btn-default" href="/">Mégse</a> <a
					class="btn btn-default pull-right" href="/">Mentés</a>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>