<%@include file="../includes/header.jsp"%>

<div class="container">
	<h1 class="page-title text-center"><font color="white">Bejelentkezés</font></h1>

	<form:form modelAttribute="loginDto" class="signin-form">
		<div class="form-group">
			<label for="email">Felhasználónév</label> 
			<form:input path="username" type="text" class="form-control" id="username" placeholder="Felhasználónév"/>
		</div>
		<div class="form-group">
			<label for="password">Jelszó</label> 
			<form:input path="password" type="password" class="form-control" id="password" placeholder="Jelszó"/>
			<c:if test="${not empty loginError}">
				<br/>
				<font color="red">${loginError}</font><br/>
			</c:if> 	
		</div>
		
		<div class="text-center">
			<button type="submit" class="btn btn-primary">Bejelentkezem</button>
		</div>
		
	</form:form>
</div>

<%@include file="../includes/footer.jsp"%>
