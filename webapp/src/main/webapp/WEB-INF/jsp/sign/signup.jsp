<%@include file="../includes/header.jsp"%>

<div class="container">
	<h1 class="page-title text-center">Regisztr�ci�</h1>

	<form class="signup-form">
		<div class="form-group">
			<label for="titulus">Titulus</label> 
			<input
				type="text" class="form-control" id="titulus"
				placeholder="dr,prof">
		</div>
		<div class="form-group">
			<label for="vnev">Vezet�kn�v</label> 
			<input
				type="text" class="form-control" id="vnev">
		</div>
		<div class="form-group">
			<label for="knev">Keresztn�v</label> 
			<input
				type="text" class="form-control" id="knev">
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<input
				type="text" class="form-control" id="email">
		</div>
		<div class="form-group">
			<label for="username">Felhaszn�l�n�v</label> 
			<input
				type="text" class="form-control" id="username">
		</div>
		<div class="form-group">
			<label for="pass">Jelsz�</label> 
			<input
				type="password" class="form-control" id="pass">
		</div>
		<div class="form-group">
			<label for="pass-reset">Jelsz� ism�t</label> 
			<input
				type="password" class="form-control" id="pass-reset">
		</div>
		<div class="form-group">
			<label for="inv-code">Megh�v� k�d</label> 
			<input
				type="text" class="form-control" id="inv-code">
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-primary">K�ld�s</button>
		</div>
	</form>
</div>

<%@include file="../includes/footer.jsp"%>
