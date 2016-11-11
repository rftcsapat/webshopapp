<%@include file="../includes/header.jsp"%>

<div class="container">
	<form:errors />
	<h1 class="page-title text-center">Regisztr�ci�</h1>

	<form:form modelAttribute="regformDto" role="form">
		<div class="form-group">
			<label for="titulus">Titulus</label> 
			<form:input path="title" type="text" class="form-control" id="titulus" placeholder="dr, prof"/>
		</div>
		<div class="form-group">
			<label for="vnev">Vezet�kn�v</label> 
			<form:input path="lastname" type="text" class="form-control" id="vnev"/>
		</div>
		<div class="form-group">
			<label for="knev">Keresztn�v</label> 
			<form:input path="firstname" type="text" class="form-control" id="knev"/>
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<form:input path="email" type="text" class="form-control" id="email"/>
			<c:if test="${not empty emailError}">
				<font color="red">${emailError}</font><br/>
			</c:if> 
		</div>
		<div class="form-group">
			<label for="username">Felhaszn�l�n�v</label> 
			<form:input path="username" type="text" class="form-control" id="username"/>
			<c:if test="${not empty usernameError}">
				<font color="red">${usernameError}</font><br/>
			</c:if> 
		</div>
		<div class="form-group">
			<form:label path="birthDate" for="birthDate">Date Of Birth: </form:label> 
			<form:input path="birthDate" type="date" class="form-control" id="birthDateInput" placeholder="YYYY-MM-DD"/>
			<form:errors path="birthDate" cssClass="error"/>
		</div>
		<div class="form-group">
			<label for="pass">Jelsz�</label> 
			<form:input path="password" type="password" class="form-control" id="pass"/>
			<form:errors path="password" cssClass="error"/>
		</div>
		<div class="form-group">
			<label for="pass-reset">Jelsz� ism�t</label> 
			<form:input path="passwordAgain" type="password" class="form-control" id="pass-reset"/>
			<div class="form-group col-lg-4 col-sm-6 col-xs-12">
				<font color="red">${passwordError}</font>
			</div><br/>
		</div>
<!-- 		<div class="form-group"> -->
<!-- 			<label for="inv-code">Megh�v� k�d</label> -->
<!-- 			<input type="text" class="form-control" id="inv-code"> -->
<!-- 		</div> -->
		<div class="text-center">
			<button type="submit" class="btn btn-primary">K�ld�s</button>
		</div>
	</form:form>
</div>

<%@include file="../includes/footer.jsp"%>
