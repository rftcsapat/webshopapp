<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Page Content -->
<main>
<div class="container">

	<div class="row">

		<%@include file="includes/sidebar.jsp"%>

		<div class="col-md-9">
			<section class="contact-s">
				<h1 class="page-title">Kapcsolat</h1>

				<div class="row">
					<div class="col-md-12">
						<h3>Elérhetőségek</h3>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<strong>Cím:</strong>
						<p>Elan-Vital Természetes Egészség Központ 1075 Budapest Síp
							u. 6.
						<p>

							<strong>Nyitvatartási idő</strong>
						<p>
							Hétfő: 10-19h<br> Kedd - Péntek: 10-18h<br> Szombat -
							Vasárnap: zárva
						</p>
					</div>
					<div class="col-md-6">
						<strong>Telefon:</strong>
						<p>06-1-788-25-77, 06-30/498-6305</p>

						<strong>Fax:</strong>
						<p>06-1-788-25-77</p>

						<strong>Email:</strong>
						<p>budapest [kukac] elan-vital.hu</p>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<h3>Lépjen velünk kapcsolatba</h3>
						<form class="form-contact">
							<div class="form-group">
								<label for="name">Név </label> <input
									type="text" class="form-control" id="name"
									placeholder="Adja meg a nevét">
							</div>
							<div class="form-group">
								<label for="email">Email cim</label> <input
									type="text" class="form-control" id="email"
									placeholder="Adja meg email cimét">
							</div>
							<div class="form-group">
								<label for="msg">Üzenet</label> 
								<textarea class="form-control" id="msg"></textarea>
							</div>
							<button type="submit" class="btn btn-default">Küldés</button>
						</form>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>
</main>

<%@include file="includes/footer.jsp"%>