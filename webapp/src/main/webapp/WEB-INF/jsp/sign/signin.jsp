<%@include file="../includes/header.jsp"%>

<div class="container">
	<h1 class="page-title text-center">Bejelentkezés</h1>

	<form class="signin-form">
		<div class="form-group">
			<label for="email">E-mail cím</label> <input
				type="text" class="form-control" id="email"
				placeholder="Email">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input
				type="password" class="form-control" id="password"
				placeholder="Password">
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-primary">Bejelentkezem</button>
		</div>
	</form>
</div>

<%@include file="../includes/footer.jsp"%>
