<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title">Kreditek</h1>
			<div class="kredit-actual well">
				<h2>Aktuális egyenleg</h2>
				<p>23.000 Ft</p>
			</div>
			<form class="form-kredit">
				<div class="form-group">
					<input type="text" class="form-control" name="kredit_db" placeholder="Ide ird az összeget">
					<span class="currency">Ft</span>
				</div>
				<button type="submit" class="btn btn-lg btn-primary" href="">Kredit feltöltése</button>
			</form>	
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>

