<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Page Content -->
<main>
<div class="container">

	<div class="row">
		<%@include file="../includes/sidebar.jsp"%>
			
		<div class="col-md-9">
			<!-- Ha nincs tal�lat -->
			<!-- <p>Sajn�ljuk a keresett term�k <strong>(x term�k)</strong> nem tal�lhat�!</p> -->
			
			<!--  Ha van tal�lat -->
			<h1 class="page-title">Keresés eredménye a(z) <strong>${keyword}</strong> kifejezésre.</h1>
			<p><small>Találatok száma: ${resultCount} db</small></p>
			
			<div class="row">
			<c:forEach items="${itemsContent}" var="item" >
                   <div class="col-sm-4 col-lg-4 col-md-4">
                       <div class="thumbnail">
                           <img src="/imageDisplay?id=${item.itemid}" alt="korolen termek">
                           <div class="caption">
                               <h4 class="pull-right">${item.price} Ft</h4>
                               <h4><a href="/product/${item.itemid}">${item.itemname}</a></h4>
                               <p>
                              	<c:choose>
					            <c:when test="${empty item.description}">
					                -
					            </c:when>
					            <c:otherwise>
					                ${item.description}
					            </c:otherwise>
					        </c:choose>
					        </p>
                           </div>
                       </div>
                   </div>
              </c:forEach>
<!-- 				 Tal�latok list�z�sa - Term�k box-ok jelennek meg -->
<!-- 				<div class="col-sm-4 col-lg-4 col-md-4"> -->
<!-- 					<div class="thumbnail"> -->
<!-- 						<img src="public/images/product/vironal.jpg" alt="vironal termek"> -->
<!-- 						<div class="caption"> -->
<!-- 							<h4 class="pull-right">6000 Kr</h4> -->
<!-- 							<h4> -->
<!-- 								<a href="/product">Vironal</a> -->
<!-- 							</h4> -->
<!-- 							<p>Bioinformacios, komplex gyogynoveny-koncentratum 16-fele -->
<!-- 								gyogynovenybol</p> -->
<!-- 						</div> -->
<!-- 						<div class="ratings"> -->
<!-- 							<p class="pull-right">15 reviews</p> -->
<!-- 							<p> -->
<!-- 								<span class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				<div class="col-sm-4 col-lg-4 col-md-4"> -->
<!-- 					<div class="thumbnail"> -->
<!-- 						<img src="public/images/product/regalen.jpg" alt="regalen termek"> -->
<!-- 						<div class="caption"> -->
<!-- 							<h4 class="pull-right">7500 Kr</h4> -->
<!-- 							<h4> -->
<!-- 								<a href="/product">Regalen</a> -->
<!-- 							</h4> -->
<!-- 							<p>Bioinformacios, komplex gyogynoveny-koncentratum 14-fele -->
<!-- 								gyogynovenybol</p> -->
<!-- 						</div> -->
<!-- 						<div class="ratings"> -->
<!-- 							<p class="pull-right">15 reviews</p> -->
<!-- 							<p> -->
<!-- 								<span class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				<div class="col-sm-4 col-lg-4 col-md-4"> -->
<!-- 					<div class="thumbnail"> -->
<!-- 						<img src="public/images/product/renol.jpg" alt="renol termek"> -->
<!-- 						<div class="caption"> -->
<!-- 							<h4 class="pull-right">6300 Kr</h4> -->
<!-- 							<h4> -->
<!-- 								<a href="#">Renol</a> -->
<!-- 							</h4> -->
<!-- 							<p>Bioinformacios, komplex gyogynoveny-koncentratum 15-fele -->
<!-- 								gyogynovenybol</p> -->
<!-- 						</div> -->
<!-- 						<div class="ratings"> -->
<!-- 							<p class="pull-right">31 reviews</p> -->
<!-- 							<p> -->
<!-- 								<span class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star-empty"></span> -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				<div class="col-sm-4 col-lg-4 col-md-4"> -->
<!-- 					<div class="thumbnail"> -->
<!-- 						<img src="public/images/product/gynex.jpg" alt="gynex termek"> -->
<!-- 						<div class="caption"> -->
<!-- 							<h4 class="pull-right">7300 Kr</h4> -->
<!-- 							<h4> -->
<!-- 								<a href="#">Gynex</a> -->
<!-- 							</h4> -->
<!-- 							<p>Bioinformacios, komplex gyogynoveny-koncentratum 15-fele -->
<!-- 								gyogynovenybol</p> -->
<!-- 						</div> -->
<!-- 						<div class="ratings"> -->
<!-- 							<p class="pull-right">6 reviews</p> -->
<!-- 							<p> -->
<!-- 								<span class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star-empty"></span> <span -->
<!-- 									class="glyphicon glyphicon-star-empty"></span> -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				<div class="col-sm-4 col-lg-4 col-md-4"> -->
<!-- 					<div class="thumbnail"> -->
<!-- 						<img src="public/images/product/korolen.jpg" alt="korolen termek"> -->
<!-- 						<div class="caption"> -->
<!-- 							<h4 class="pull-right">7200 Kr</h4> -->
<!-- 							<h4> -->
<!-- 								<a href="#">Korolen</a> -->
<!-- 							</h4> -->
<!-- 							<p>Bioinformacios, komplex gyogynoveny-koncentratum 15-fele -->
<!-- 								gyogynovenybol</p> -->
<!-- 						</div> -->
<!-- 						<div class="ratings"> -->
<!-- 							<p class="pull-right">18 reviews</p> -->
<!-- 							<p> -->
<!-- 								<span class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star"></span> <span -->
<!-- 									class="glyphicon glyphicon-star-empty"></span> -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
	</div>
</div>
</main>

<%@include file="../includes/footer.jsp"%>