<%@include file="includes/header.jsp"%>

<div id="wrapper">

	<%@include file="includes/sidenav.jsp"%>

	<div id="page-wrapper">

		<div class="container-fluid">

			<div class="row">
				<div class="col-lg-12">
					<c:if test="${not empty flashMessage}">
							<div class="alert alert-${flashKind} alert-dismissable">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								${flashMessage}
							</div>
						</div>
					</c:if>
			</div>

			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-12 panel-item text-right">
									<div class="huge"><fmt:formatNumber type="number" pattern="###,###" value="${usersCount}" /></div>
									<div>Regisztrált felhasználók</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-12 panel-item text-right">
									<div class="huge"><fmt:formatNumber type="number" pattern="###,###" value="${orderCount}" /></div>
									<div>Napi megrendelések</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-12 panel-item text-right">
									<div class="huge">
									<fmt:formatNumber type="number" pattern="###,###" value="${productsCount}" />
									</div>
									<div>Termékek száma</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-12 panel-item text-right">
									<div class="huge">
									<fmt:formatNumber type="number" pattern="###,###" value="${incomeCount}" /> Kr</div>
									<div>Havi bevétel</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->

</div>

<%@include file="includes/footer.jsp"%>