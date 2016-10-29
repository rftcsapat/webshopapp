<%@include file="../includes/header.jsp"%>

<div class="container">
	<h1 class="page-title text-center">Regisztráció</h1>

	<form class="signup-form">
		<div class="form-group">
			<label for="titulus">Titulus</label> 
			<input
				type="text" class="form-control" id="titulus"
				placeholder="dr,prof">
		</div>
		<div class="form-group">
			<label for="vnev">Vezetéknév</label> 
			<input
				type="text" class="form-control" id="vnev">
		</div>
		<div class="form-group">
			<label for="knev">Keresztnév</label> 
			<input
				type="text" class="form-control" id="knev">
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<input
				type="text" class="form-control" id="email">
		</div>
		<div class="form-group">
			<label for="username">Felhasználónév</label> 
			<input
				type="text" class="form-control" id="username">
		</div>
		<div class="form-group">
			<label for="pass">Jelszó</label> 
			<input
				type="password" class="form-control" id="pass">
		</div>
		<div class="form-group">
			<label for="pass-reset">Jelszó ismét</label> 
			<input
				type="password" class="form-control" id="pass-reset">
		</div>
		<div class="form-group">
			<label for="inv-code">Meghívó kód</label> 
			<input
				type="text" class="form-control" id="inv-code">
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-primary">Küldés</button>
		</div>
	</form>
</div>

<%@include file="../includes/footer.jsp"%>
