<%@include file="includes/header.jsp"%>

<div id="wrapper">

	<%@include file="includes/sidenav.jsp"%>

	<div id="page-wrapper">

		<div class="container-fluid">

			<div class="row">
				<div class="col-md-12">
				<h2>Admin felvétel</h2>	
				<form:form modelAttribute="regformDto" cssClass="signup-form"
					role="form">
					<form:errors />
					<div class="form-group">
						<form:label path="firstname" for="name">Vezetéknév </form:label>
						<form:input path="firstname" type="text" class="form-control"
							id="nameInput" placeholder="YourName" />
						<form:errors path="firstname" cssClass="error" />
					</div>
					<div class="form-group">
						<form:label path="lastname" for="name">Keresztnév</form:label>
						<form:input path="lastname" type="text" class="form-control"
							id="nameInput" placeholder="YourName" />
						<form:errors path="lastname" cssClass="error" />
					</div>
					<div class="form-group">
					<label for="email">Email</label> 
					<form:input path="email" type="text" class="form-control" id="email"/>
					<c:if test="${not empty emailError}">
					<font color="red">${emailError}</font><br/>
					</c:if> 
					</div>
					<div class="form-group">
						<form:label path="username" for="username">Felhasználónév</form:label>
						<form:input path="username" type="text" class="form-control"
							id="usernameInput" placeholder="Your Username" />
						<!-- 		<div class="form-group col-lg-4 col-sm-6 col-xs-12"> -->
						<%-- 			<font color="red">${usernameError}</font> --%>
						<!-- 		</div><br/> -->
						<c:if test="${not empty usernameError}">
							<font color="red">${usernameError}</font>
							<br />
						</c:if>
					</div> 
					<div class="form-group">
						<form:label path="birthDate" for="birthDate">Születési dátum</form:label>
						<form:input path="birthDate" type="date" class="form-control"
							id="birthDateInput" placeholder="YYYY-MM-DD" />
						<form:errors path="birthDate" cssClass="error" />
					</div>
					<!-- 	<div class="form-group"> -->
					<!-- 		<label for="email">Email address</label> <input type="email" -->
					<!-- 			class="form-control" id="exampleInputEmail1" placeholder="Email"> -->
					<!-- 	</div> -->
					<div class="form-group">
						<form:label path="password" for="password">Jelszó</form:label>
						<form:input path="password" type="password" class="form-control"
							id="password" placeholder="Password" />
						<form:errors path="password" cssClass="error" />
					</div>
					<div class="form-group">
						<form:label path="passwordAgain" for="passwordAgain">Jelszó ismét:</form:label>
						<form:input path="passwordAgain" type="password"
							class="form-control" id="passwordAgain"
							placeholder="Password again" />
						<form:errors path="passwordAgain" cssClass="error" />
						<div class="form-group col-lg-4 col-sm-6 col-xs-12">
							<font color="red">${passwordError}</font>
						</div>
						<br />
					</div>
					<button type="submit" class="btn btn-default">Létrehozás</button>
				</form:form>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->

</div>

<%@include file="includes/footer.jsp"%>