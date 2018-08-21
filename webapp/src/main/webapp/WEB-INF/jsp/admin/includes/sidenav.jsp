
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="${baseUrl}/dashboard">Energy Admin</a>
	</div>
	<!-- Top Menu Items -->
	<ul class="nav navbar-right top-nav">

		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"><i class="fa fa-user"></i> Admin<b
				class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="${baseUrl}/admin-profil/"><i class="fa fa-fw fa-user"></i> Profil</a></li>
<!-- 				<li><a href="/admin-settings/"><i class="fa fa-fw fa-gear"></i> Beállítások</a></li> -->
				<li class="divider"></li>
				<li><a href="${baseUrl}/admin-logout"><i class="fa fa-fw fa-power-off"></i> Kijelentkezés</a></li>
			</ul></li>
	</ul>
	<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<c:if test="${menuIndex == 1}">
				<li class="active">
			</c:if>
			<c:if test="${menuIndex != 1}">
				<li>
			</c:if>
					<a href="${baseUrl}/dashboard"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
				</li>
			<c:if test="${menuIndex == 2}">
				<li class="active">
			</c:if>
			<c:if test="${menuIndex != 2}">
				<li>
			</c:if>
					<a href="${baseUrl}/admin-termek"><i class="fa fa-fw fa-bar-chart-o"></i>Termékek</a>
				</li>
<!-- 			<li><a href="/admin-raktar"><i -->
<!-- 					class="fa fa-fw fa-desktop"></i>Raktárkezelés</a></li> -->
			<c:if test="${menuIndex == 3}">
				<li class="active">
			</c:if>
			<c:if test="${menuIndex != 3}">
				<li>
			</c:if>
					<a href="${baseUrl}/admin-reg"><i class="fa fa-fw fa-desktop"></i>Admin regisztráció</a>
				</li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>
