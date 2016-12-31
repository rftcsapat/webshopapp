<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container">

	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>
		<div class="col-md-9">

			<h1 class="page-title">Kreditek</h1>
			<form:form modelAttribute="creditDto">
			<div class="panel panel-default credit-card-box">
				<div class="panel-heading display-table">
					<div class="row display-tr">
						<h3 class="panel-title display-td">Payment Details</h3>
						<div class="display-td">
							<img class="img-responsive pull-right"
								src="http://i76.imgup.net/accepted_c22e0.png">
						</div>
					</div>
				</div>
				
				<div class="panel-body">
<!-- 					<form role="form" id="payment-form" method="POST" -->
<!-- 						action="javascript:void(0);"> -->
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="cardNumber">CARD NUMBER</label>
									<div class="input-group">
										<form:input 
											path="cardNumber" type="tel" class="form-control" name="cardNumber"
											placeholder="Valid Card Number" autocomplete="cc-number"
											required="true" autofocus="true" />
<!-- 											required autofocus />  -->
										<span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span
										class="visible-xs-inline">EXP</span> DATE</label> 
									<form:input path="cardExpiration" type="tel" class="form-control" name="cardExpiry" placeholder="MM / YY"  
										autocomplete="cc-exp" required="true" />
								</div>
							</div>
							<div class="col-xs-5 col-md-5 pull-right">
								<div class="form-group">
									<label for="cardCVC">CV CODE</label> 
									<form:input path="cardCvc" type="tel" class="form-control" name="cardCVC" placeholder="CVC"
										autocomplete="cc-csc" required="true" />
								</div>
							</div>
						</div>
<!-- 						<div class="row"> -->
<!-- 							<div class="col-xs-12"> -->
<!-- 								<button class="btn btn-lg btn-primary" type="button">Fizetés</button> -->
<!-- 							</div> -->
<!-- 						</div> -->
						<div class="row" style="display: none;">
							<div class="col-xs-12">
								<p class="payment-errors"></p>
							</div>
						</div>
<!-- 					</form> -->
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 col-md-4">
					
						<div class="well">
							<h2>Standard</h2>
							<p>
								<strong>5.000 Ft</strong>
							</p>
							<p>
								<strong>7.500 Kr</strong>
							</p>

							<div class="radio">
								<label> 
								<form:radiobutton path="packageName" name="optionsRadios" checked="true" value="standard"/>
<%-- 								<form:radiobutton path="packageName" type="radio" name="optionsRadios" checked="true"/> --%>
								</label>
							</div>

						</div>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="well">
						<h2>Premium</h2>
						<p>
							<strong>10.000 Ft</strong>
						</p>
						<p>
							<strong>18.000 Kr</strong>
					    </p>
						<div class="radio">
							<label> 
<%-- 							<form:input path="packageName" type="radio" name="optionsRadios"/> --%>
							<form:radiobutton path="packageName" name="optionsRadios" value="premium"/>
							</label>
						</div>

					</div>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="well">
						<h2>Elite</h2>
						<p>
							<strong>20.000 Ft</strong>
						</p>
						<p>
							<strong>43.000 Kr</strong>
						</p>
						<div class="radio">
							<label> 
<%-- 							<form:input path="packageName" type="radio" name="optionsRadios"/> --%>
							<form:radiobutton path="packageName" name="optionsRadios" value="elite"/>
							</label>
						</div>
					</div>
				</div>
			</div>
				<div class="kredit-actual well" >
					<h2>Aktuális egyenleg</h2>
<%-- 					<p>${user.coins} Kr</p> --%>
					<p><fmt:formatNumber type="number" pattern="###,###" value="${user.coins}" /> Kr</p>
					
				</div>
				<button type="submit" class="btn btn-lg btn-primary">Kredit feltöltése</button>
			</form:form>
	</div>
			
<!-- 			<form class="form-kredit"> -->
<!-- 				<div class="form-group"> -->
<!-- 					<input type="text" class="form-control" name="kredit_db" -->
<!-- 						placeholder="Ide ird az összeget"> <span class="currency">Kr</span> -->
<!-- 				</div> -->
				
<!-- 			</form> -->
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>

