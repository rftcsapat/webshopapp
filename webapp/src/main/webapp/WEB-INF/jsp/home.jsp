<%@include file="includes/header.jsp"%>	

    <div class="container">

        <div class="row">
        
		<%@include file="includes/sidebar.jsp"%>	

			<!--  fő tartalom  -->
            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12" align="center">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="/public/images/product/slider02.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/public/images/product/slider03.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="/public/images/product/slider04.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
				<br/>
                <div class="row">
					<c:forEach items="${itemsContent}" var="item" >
				
	                    <div class="col-sm-4 col-lg-4 col-md-4">
	                        <div class="thumbnail">
<!-- 	                            <img src="/public/images/product/korolen.jpg" alt="korolen termek"> -->
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
                </div>
                
                <c:url var="firstUrl" value="/home/${category}/0" />
				<c:url var="prevUrl"  value="/home/${category}/${currentIndex - 2}" />
				<c:url var="nextUrl"  value="/home/${category}/${currentIndex}" />
				<c:url var="lastUrl"  value="/home/${category}/${items.totalPages - 1}" />
	  			<div>
				    <ul class="pagination">
				        <c:choose>
				            <c:when test="${currentIndex == 1}">
				                <li class="disabled"><a href="#">&lt;&lt;</a></li>
				                <li class="disabled"><a href="#">&lt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li><a href="${firstUrl}">&lt;&lt;</a></li>
				                <li><a href="${prevUrl}">&lt;</a></li>
				            </c:otherwise>
				        </c:choose>
				        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				            <c:url var="pageUrl" value="/home/${category}/${i}" />
				            <c:choose>
				                <c:when test="${i == currentIndex - 1}">
				                    <li class="active"><a href="${pageUrl}"><c:out value="${i+1}" /></a></li>
				                </c:when>
				                <c:otherwise>
				                    <li><a href="${pageUrl}"><c:out value="${i+1}" /></a></li>
				                </c:otherwise>
				            </c:choose>
				        </c:forEach>
				        <c:choose>
				            <c:when test="${currentIndex == items.totalPages}">
				                <li class="disabled"><a href="#">&gt;</a></li>
				                <li class="disabled"><a href="#">&gt;&gt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li><a href="${nextUrl}">&gt;</a></li>
				                <li><a href="${lastUrl}">&gt;&gt;</a></li>
				            </c:otherwise>
				        </c:choose>
				    </ul>
				</div>	
                
<!--                 <div class="row"> -->
<!--                 	<nav aria-label="Page navigation"> -->
<!-- 					  <ul class="pagination"> -->
<!-- 					    <li> -->
<!-- 					      <a href="#" aria-label="Previous"> -->
<!-- 					        <span aria-hidden="true">&laquo;</span> -->
<!-- 					      </a> -->
<!-- 					    </li> -->
<!-- 					    <li><a href="#">1</a></li> -->
<!-- 					    <li><a href="#">2</a></li> -->
<!-- 					    <li><a href="#">3</a></li> -->
<!-- 					    <li><a href="#">4</a></li> -->
<!-- 					    <li><a href="#">5</a></li> -->
<!-- 					    <li> -->
<!-- 					      <a href="#" aria-label="Next"> -->
<!-- 					        <span aria-hidden="true">&raquo;</span> -->
<!-- 					      </a> -->
<!-- 					    </li> -->
<!-- 					  </ul> -->
<!-- 					</nav> -->
<!--                 </div> -->

            </div>

        </div>

    </div>

<%@include file="includes/footer.jsp"%>