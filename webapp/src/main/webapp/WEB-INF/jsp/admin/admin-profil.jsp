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
						<h1 class="page-header">Admin beállítások</h1>
					</div>
				</div>

				<div class="row">

					<div class="col-md-12">
						<form:form modelAttribute="userUpdateDto" class="form-user-modify">
							<div class="form-group">
								<label for="vnev">Vezetéknév</label>
								<form:input path="lastname" type="text" class="form-control" id="vnev" />
							</div>
							<div class="form-group">
								<label for="knev">Keresztnév</label>
								<form:input path="firstname" type="text" class="form-control" id="knev" />
							</div>
							<div class="form-group">
								<label for="szuldat">Születési dátum</label>
								<form:input path="birthDate" type="text" class="form-control" id="szuldat" />
							</div>
							<div class="form-group">
								<label for="email">Email-cím</label>
								<form:input path="email" type="text" class="form-control" id="email" />
							</div>
							<div class="form-group">
								<label for="phone">Telefonszám</label>
								<form:input path="phone" type="text" class="form-control" id="phone" />
							</div>
							<div class="form-group">
								<label for="username">Felhasználónév</label>
								<form:input path="username" type="text" class="form-control" id="username" />
							</div>
							<div class="form-group">
								<label for="pass">Új jelszó</label>
								<form:input path="password" type="password" class="form-control" id="pass" />
							</div>
							<div class="form-group">
								<label for="pass-reset">Jelszó ismét</label>
								<form:input path="passwordAgain" type="password" class="form-control" id="pass-reset" />
								<div class="form-group col-lg-4 col-sm-6 col-xs-12">
									<font color="red">${passwordError}</font>
								</div>
								<br />
							</div>
							<div class="form-group">
								<label for="address-utcahaz">Aktuális jelszó</label>
								<form:input path="actualPassword" type="password" class="form-control" id="address-utcahaz" />
								<c:if test="${not empty passwordError}">
									<div class="form-group col-lg-4 col-sm-6 col-xs-12">
										<font color="red">${passwordError}</font>
									</div>
									<br/>
								</c:if>
							</div>
							<button type="submit" class="btn btn-default">Mentés</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>