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
				<h1 class="page-title"><font color="white">Kapcsolat</font></h1>

				<div class="row">
					<div class="col-md-12">
						<h3><font color="white">Elérhetőségek</font></h3>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<font color="white"><b>Cím:</b></font>
						<p><font color="white">Elan-Vital Természetes Egészség Központ 1075 Budapest Síp
							u. 6.</font>
						<p>

							<font color="white"><b>Nyitvatartási idő</b></font>
						<p>
							<font color="white">Hétfő: 10-19h<br> Kedd - Péntek: 10-18h<br> Szombat -
							Vasárnap: zárva</font>
						</p>
					</div>
					<div class="col-md-6">
						<font color="white"><b>Telefon:</b></font>
						<font color="white"><p>06-1-788-25-77, 06-30/498-6305</p></font>

						<font color="white"><b>Fax:</b></font>
						<font color="white"><p>06-1-788-25-77</p></font>

						<font color="white"><b>Email:</b></font>
						<font color="white"><p>budapest [kukac] elan-vital [pont] hu</p></font>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<font color="white"><h3>Lépjen velünk kapcsolatba</h3></font>
						<form class="form-contact">
							<div class="form-group">
								<label for="name"><font color="white">Név </font></label> 
								<input type="text" class="form-control" id="name" placeholder="Adja meg a nevét">
							</div>
							<div class="form-group">
								<font color="white"><label for="email"><font color="white">Email cim</font></label></font> 
								<input type="text" class="form-control" id="email" placeholder="Adja meg email cimét">
							</div>
							<div class="form-group">
								<label for="msg"><font color="white">Üzenet</font></label> 
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