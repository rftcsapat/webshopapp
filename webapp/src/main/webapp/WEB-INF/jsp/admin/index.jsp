<%@include file="includes/header.jsp"%>

<div class="container">
	<h1 class="page-title text-center">Admin Login</h1>

	<form class="admin-form">
		<div class="form-group">
			<label for="username">Felhasználónév</label> <input
				type="text" class="form-control" id="username"
				placeholder="Felhasználónév">
		</div>
		<div class="form-group">
			<label for="password">Jelszó</label> <input
				type="password" class="form-control" id="password"
				placeholder="Password">
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-primary">Belépek</button>
		</div>
	</form>
</div>

<%@include file="includes/footer.jsp"%>
