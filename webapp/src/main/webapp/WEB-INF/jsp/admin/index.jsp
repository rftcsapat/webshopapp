<%@include file="includes/header.jsp"%>

<div class="container">
	<h1 class="page-title text-center">Admin Login</h1>

	<form class="admin-form">
		<div class="form-group">
			<label for="username">Felhaszn�l�n�v</label> <input
				type="text" class="form-control" id="username"
				placeholder="Felhaszn�l�n�v">
		</div>
		<div class="form-group">
			<label for="password">Jelsz�</label> <input
				type="password" class="form-control" id="password"
				placeholder="Password">
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-primary">Bel�pek</button>
		</div>
	</form>
</div>

<%@include file="includes/footer.jsp"%>
