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
					<h1 class="page-header">Termék hozzáadás</h1>
				</div>
			</div>

			<div class="row">

				<div class="col-md-12">

					<form:form modelAttribute="itemModDto" class="form-product-modify">
						<div class="form-group">
							<label for="termek-leiras-m">Neve</label>
							<form:input path="name" type="text" class="form-control"
								id="termek-leiras-m" required="true" />
						</div>
						<div class="form-group">
							<label for="termek-leiras-m">Űrmérték vagy darabszám</label>
							<form:input path="itemQuantity" type="text" class="form-control"
								id="termek-leiras-m" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-leiras-m">Mértékegység</label>
							<form:input path="unit" type="text" class="form-control"
								id="termek-leiras-m" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-leiras-m">Mennyisége a raktárban</label>
							<form:input path="quantity" type="text" class="form-control"
								id="termek-leiras-m" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-leiras-m">Ár (kredit)</label>
							<form:input path="price" type="text" class="form-control"
								id="termek-leiras-m" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-leiras-m">Rövid leírás</label>
							<form:input path="description" type="text" class="form-control"
								id="termek-leiras-m" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-leiras-m">Részletes leírás</label>
							<form:textarea path="largeDesc" class="form-control"
								id="termek-leiras-m" rows="10" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-gyarto-m">Gyártó</label>
							<form:select path="manufacturerId" items="${manufacturers}"
								class="form-control" id="termek-gyarto-m" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-kategoria-m">Kategória</label>
							<form:select path="categoryId" items="${categories}"
								class="form-control" id="termek-kategoria-m" required="true"/>
						</div>
						<div class="form-group">
							<label for="termek-kep-m">Kép</label> <input type="file"
								id="termek-kep-m">
							<p class="help-block" required="true">A kép mérete max. 1MB méretű lehet.</p>
						</div>
						<button type="submit" class="btn btn-default">Mentés</button>
					</form:form>
				</div>
			</div>
		</div>

	</div>
</div>

<%@include file="includes/footer.jsp"%>
