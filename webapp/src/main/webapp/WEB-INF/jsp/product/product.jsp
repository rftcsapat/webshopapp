<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Page Content -->
<main>
<div class="container">

	<div class="row">
	
		<%@include file="../includes/sidebar.jsp"%>
	
		<div class="col-md-9">
			<section class="product-s">
				<h1 class="page-title">Termék neve</h1>
				<div class="row">
					<div class="col-md-3">
						<img class="img-responsive" src="public/images/product/vironal.jpg">
					</div>
					<div class="col-md-6">
						<ul>
							<li><span><strong>Gyártó</strong></span><span>Xzy
									kft.</span></li>
							<li><span><strong>Kategória</strong></span><span>Koncentrátum</span>
							</li>
							<li><span><strong>Cikkszám</strong></span><span>Űrtartalom</span>
							</li>
							<li><span><strong>Mennyiség</strong></span><span>200ml</span>
							</li>
							<li><span><strong>Ár</strong></span><span>2500 ft</span></li>
						</ul>
						
						<form class="basket-add-form">
							<div class="form-group">
								<input class="product-add-db" type="text" name="product-add-db" value="1">
								<button class="btn btn-default">Kosárba</button>
							</div>
						</form>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h3>Leírás</h3>
						<p>Donec aliquam, erat sed lacinia hendrerit, est massa
							fringilla elit, id sagittis arcu ante at purus. Aenean sit amet
							dolor sed tellus egestas hendrerit. Mauris ut pulvinar justo,
							eget semper nunc. Duis aliquam commodo vehicula. Quisque
							vestibulum nec quam ac convallis. Vestibulum vitae porttitor
							orci. Aenean facilisis nisl vitae magna tincidunt aliquam. Duis
							id eleifend neque. Mauris id nisl a diam venenatis pulvinar. Sed
							posuere neque a tortor rutrum aliquet in nec velit. Class aptent
							taciti sociosqu ad litora torquent per conubia nostra, per
							inceptos himenaeos. Nam risus leo, tristique ac eleifend et,
							eleifend ac sapien. Pellentesque eget lacinia mauris, eu
							convallis lacus. Cras pretium eget velit quis finibus. Etiam
							dictum tempus nibh eget euismod. Integer eget luctus ante, in
							dictum nibh. Nullam ut dui vestibulum, viverra mauris sit amet,
							hendrerit leo. In blandit dui quis mauris fermentum, vitae
							egestas urna scelerisque. Aliquam scelerisque massa eget
							tristique laoreet. Cras quis libero eu eros tempor efficitur.
							Vestibulum feugiat diam nec mi feugiat efficitur. Donec consequat
							massa at ipsum scelerisque, a dapibus felis scelerisque.
							Pellentesque habitant morbi tristique senectus et netus et
							malesuada fames ac turpis egestas. Sed fermentum ultrices tortor
							vel egestas. Suspendisse elementum nisl quis nibh congue, nec
							rutrum quam tincidunt. Pellentesque habitant morbi tristique
							senectus et netus et malesuada fames ac turpis egestas. Donec
							rutrum dui quis mauris interdum, quis tristique arcu semper.
							Donec venenatis commodo ultricies. Donec quam arcu, vestibulum eu
							eros sed, ullamcorper facilisis lorem.</p>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>
</main>

<%@include file="../includes/footer.jsp"%>