<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-8">
			<h1 class="page-title"><font color="white">Profil</font></h1>
			<form:form modelAttribute="userUpdateDto" class="person-data-form" method="post">
				<div class="profil">
					<div class="profil-item">
						<font color="white"><h2>Személyes Adatok</h2></font>
						
							<div class="form-group">
								<label for="titulus">Titulus</label> 
								<form:input path="title" type="text" class="form-control" id="titulus" placeholder="dr,prof"/>
							</div>
							<div class="form-group">
								<label for="vnev">Vezetéknév</label> 
								<form:input path="lastname" type="text" class="form-control" id="vnev"/>
							</div>
							<div class="form-group">
								<label for="knev">Keresztnév</label> 
								<form:input path="firstname" type="text" class="form-control" id="knev"/>
							</div>
							<div class="form-group">
								<label for="szuldate">Születési dátum</label> 
								<form:input path="birthDate" type="date" class="form-control" id="szuldate"/>
							</div>
							<div class="form-group">
								<label for="email">Email</label> 
								<form:input path="email" type="text" class="form-control" id="email"/>
							</div>
							<div class="form-group">
								<label for="email">Telefonszám</label> 
								<form:input path="phone" type="text" class="form-control" id="phone"/>
							</div>
					</div>
					<div class="profil-item">
						<font color="white"><h2>Profil Adatok</h2></font>
<!-- 						<form class="profil-data-form" method="post"> -->
							<div class="form-group">
								<label for="username">Felhasználónév</label> 
								<form:input path="username" type="text" class="form-control" id="username" readonly="true"/>
							</div>
							<c:if test="${not empty inviterName}">
								<div class="form-group">
								<label for="username">Meghívó</label> 
								<input type="text" class="form-control" id="username" readonly value="${inviterName}"/>
							</div>
							</c:if>
							<div class="form-group">
								<label for="pass">Új jelszó</label> 
								<form:input path="password" type="password" class="form-control" id="pass"/>
							</div>
							<div class="form-group">
								<label for="pass-reset">Jelszó ismét</label> 
								<form:input path="passwordAgain" type="password" class="form-control" id="pass-reset"/>
								<div class="form-group col-lg-4 col-sm-6 col-xs-12">
									<font color="red">${passwordError}</font>
								</div><br/>
							</div>
<!-- 							<div class="form-group"> -->
<!-- 								<label for="inv-code">Meghívó kód</label> <input type="text" -->
<!-- 									class="form-control" id="inv-code"> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="profil-image">Profilkép</label>  -->
<!-- 								<input type="file" id="profil-image"> -->
<!-- 								<p class="help-block">A feltölthető fájl mérete maximum 1MB lehet!</p> -->
<!-- 							</div> -->
<!-- 						</form> -->
					</div>
					<div class="profil-item">
						<font color="white"><h2>Szállítási Adatok</h2></font>
						<div class="form-group">
							<label for="address-orszag">Ország</label> 
							<form:input path="country" type="text" class="form-control" id="address-orszag"/>
						</div>
<!-- 						<div class="form-group"> -->
<!-- 							<label for="address-megye">Megye</label>  -->
<%-- 							<form:input path="" type="text" class="form-control" id="address-megye"> --%>
<!-- 						</div> -->
						<div class="form-group">
							<label for="address-irszam">Irányítószám</label> 
							<form:input path="zipCode" type="text" class="form-control" id="address-irszam"/>
						</div>
						<div class="form-group">
							<label for="address-varos">Város</label> 
							<form:input path="settlement" type="text" class="form-control" id="address-varos"/>
						</div>
						<div class="form-group">
							<label for="address-utcahaz">Utca, Házszám, Emelet, Ajtószám</label> 
							<form:input path="streetDetails" type="text" class="form-control" id="address-utcahaz"/>
						</div>
					</div>
					<br/>
					<div class="form-group">
						<label for="address-utcahaz">Aktuális jelszó</label> 
						<form:input path="actualPassword" type="password" class="form-control" id="address-utcahaz"/>
						<c:if test="${not empty passwordError}">
							<div class="form-group col-lg-4 col-sm-6 col-xs-12">
									<font color="red">${passwordError}</font>
							</div><br/>
						</c:if>
					</div>
					<br/>
				</div>
				<div class="row">
					<a class="btn btn-default" href="/home/all/0">Mégse</a> 
					<form:button type="submit" class="btn btn-default pull-right">Mentés</form:button>
				</div>
			</form:form>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>

