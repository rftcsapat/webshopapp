<%@include file="../includes/header.jsp"%>

<div class="container">
	<h1 class="page-title text-center"><font color="white">Bejelentkez�s</font></h1>

	<form:form modelAttribute="loginDto" class="signin-form">
		<div class="form-group">
			<label for="email">Felhaszn�l�n�v</label> 
			<form:input path="username" type="text" class="form-control" id="username" placeholder="Felhaszn�l�n�v"/>
		</div>
		<div class="form-group">
			<label for="password">Jelsz�</label> 
			<form:input path="password" type="password" class="form-control" id="password" placeholder="Jelsz�"/>
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
