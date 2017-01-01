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
					<h1 class="page-header">Termékek Módositás</h1>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<form:form class="form-product-modify" modelAttribute="productSelectDto">
						<div class="form-group">
							<label for="termek-neve-m">Termék neve</label>
							<form:select path="itemId" items="${items}" class="form-control" id="termek-neve-m"/>
						</div>
						<button type="submit" class="btn btn-default">Mentés</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>