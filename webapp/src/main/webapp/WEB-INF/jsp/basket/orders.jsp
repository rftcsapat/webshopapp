<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container">
	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title">Rendelés összesitő</h1>
			<div class="basket">
			
				<c:forEach items="${itemsContent}" var="item" >
                    <div class="basket-item row">
						<div class="col-md-2">
							<img src="/imageDisplay?id=${item.itemid}" alt="termek_kep">
						</div>
						<div class="col-md-10">
							<div class="basket-item-1of2">
								<h2 class="basket-item-name"><a href="/product/${item.itemid}"><font color="white">${item.itemname}</font></a></h2>
								<div class="basket-item-info">
									<span><font color="white">Termék azonosító: ${item.itemid}</font></span>
								</div>
							</div>
							<div class="basket-item-2of2">
								<div class="basket-item-db">
									<b><font color="white">${item.quantity}</font></b>
									<span><font color="white">db</font></span> 
								</div>
								<div class="basket-item-price">
									<font color="white">Ár</font><br> 
									<span class="price"><font color="white">${item.price}</font></span>
									<span class="currency"><font color="white">Kr</font></span>
								</div>
							</div>
						</div>
<!-- 						<div class="col-md-2"> -->
<%-- 							<a class="basket-item-del-link" href="/deleteBasketEntry/${item.itemid}/${item.quantity}"><font color="white">Tétel törlése</font></a> --%>
<!-- 						</div> -->
					</div>
                </c:forEach>
			
			</div>
			<hr>
			<div class="row">
				<div class="pull-right basket-amounts">
					Tételek száma: <strong>${count}</strong>
					<br> 
					Fizetendő: <strong><fmt:formatNumber type="number" pattern="###,###" value="${sum}" /> Kr</strong>
					<br><br>
					Egyenleg: <strong><fmt:formatNumber type="number" pattern="###,###" value="${user.coins}" /> Kr</strong>
				</div>
			</div>

			<div class="row">
				<h3>Szállitási adatok</h3>
				<form:form modelAttribute="userUpdateDto" class="form-delivery">
					<div class="form-group">
						<label for="country">Ország</label> 
						<form:input path="country" type="text" class="form-control" id="country" placeholder="Ország"/>
					</div>
					<div class="form-group">
						<label for="city">Város</label> 
						<form:input path="settlement" type="text" class="form-control" id="city" placeholder="Város"/>
					</div>
					<div class="form-group">
						<label for="irszam">Írányitószám</label>
						<form:input path="zipCode" type="text" class="form-control" id="irszam"/>
					</div>
					<div class="form-group">
						<label for="address">Utca, Házszám, Emelet, Ajtószám</label>
						<form:input path="streetDetails" type="text" class="form-control" id="address"/>
					</div>
					<h4>Adjon meg egy elérhetőséget</h4>
					<div class="form-group">
						<label for="email">E-mail</label>
						<form:input path="email" type="text" class="form-control" id="email"/>
					</div>
					<div class="form-group">
						<label for="phone">Telefon</label>
						<form:input path="phone" type="text" class="form-control" id="phone"/>
					</div>
					<h4>Válasz a szállitási módot:</h4>
					<div class="checkbox-wrapper">
						<div class="checkbox">
							<label> <input type="checkbox">Házhozszállitas</label>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox">Csomagátvétel</label>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox">Személyes átvétel</label>
						</div>
					</div>
					<div class="row text-center">
						<button type="submit" class="btn btn-primary btn-lg" >Rendelés Küldése</button>
					</div>
				</form:form>
			</div>

			
			<c:if test="${not empty message}">
				<font size="4" color="red"><b>${message}</b></font><br/>
			</c:if>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>