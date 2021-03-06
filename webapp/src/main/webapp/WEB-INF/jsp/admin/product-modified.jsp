<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div id="wrapper">

	<%@include file="includes/sidenav.jsp"%>

	<div id="page-wrapper">
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Termék Módositás</h1>
					</div>
				</div>
		
				<div class="row">
				<div class="col-lg-12">
					<c:if test="${not empty flashMessage}">
							<div class="alert alert-${flashKind} alert-dismissable">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								${flashMessage}
							</div>
						</div>
					</c:if>
					</div>
				
		
					<div class="col-md-12">
						<form:form enctype="multipart/form-data" method="POST" action="${baseUrl}/admin-product-modified/${itemId}" modelAttribute="itemModDto" class="form-product-modify">
							<div class="form-group">
								<label for="termek-leiras-m">Neve</label> 
								<form:input path="name" type="text" class="form-control" id="termek-leiras-m"/>
							</div>
							<div class="form-group">
								<label for="termek-leiras-m">Űrmérték vagy darabszám</label>
								<form:input path="itemQuantity" type="text" class="form-control" id="termek-leiras-m"/>
							</div>
							<div class="form-group">
								<label for="termek-leiras-m">Mértékegység</label> 
								<form:input path="unit" type="text" class="form-control" id="termek-leiras-m"/>
							</div>
							<div class="form-group">
								<label for="termek-leiras-m">Mennyisége a raktárban</label>
								<form:input path="quantity" type="text" class="form-control" id="termek-leiras-m"/>
							</div>
							<div class="form-group">
								<label for="termek-leiras-m">Ár (kredit)</label> 
								<form:input path="price" type="text" class="form-control" id="termek-leiras-m"/>
							</div>					
							<div class="form-group">
								<label for="termek-leiras-m">Rövid leírás</label> 
								<form:input path="description" type="text" class="form-control" id="termek-leiras-m"/>
							</div>
							<div class="form-group">
								<label for="termek-leiras-m">Részletes leírás</label>
								<form:textarea path="largeDesc" class="form-control" id="termek-leiras-m" rows="10"/>
							</div>
							<div class="form-group">
								<label for="termek-gyarto-m">Gyártó</label> 
								<form:select path="manufacturerId" items="${manufacturers}" class="form-control" id="termek-gyarto-m"/>
							</div>
							<div class="form-group">
								<label for="termek-kategoria-m">Kategória</label>
								<form:select path="categoryId" items="${categories}" class="form-control" id="termek-kategoria-m"/>
							</div>					
							<div class="form-group">
								<label for="termek-kategoria-m">Aktuális kép</label><br/>
								<img src="${baseUrl}/imageDisplay?id=${itemId}" alt="korolen termek">
							</div>
							<div class="form-group">
								<label for="termek-kep-m">Új kép</label> 
							    <input type="file" name="file" value="upload"
									id="termek-kep-m">
								<p class="help-block">A kép mérete max. 1MB méretű lehet.</p>
							</div>
							 <div class="checkbox">
							    <label>
							      <form:checkbox path="isToRemove" name="product-deleted" value="toRemove"/> Termék törlése
							    </label>
							  </div>
							<button type="submit" class="btn btn-default">Alkalmazás</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>