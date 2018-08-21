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
					<a class="btn btn-default" href="${baseUrl}/admin-product-add">Termék hozzáadás</a>
					<a class="btn btn-default" href="${baseUrl}/admin-product-select">Termék módosítás</a>
				</div>

			</div>
		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>