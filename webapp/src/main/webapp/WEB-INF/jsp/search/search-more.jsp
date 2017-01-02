<%@include file="../includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- Page Content -->
<main>
<div class="container">

	<div class="row">

		<%@include file="../includes/sidebar.jsp"%>

		<div class="col-md-9">
			<h1 class="page-title"><font color="white">Részletes keresés</font></h1>

			<form:form modelAttribute="searchMoreDto" class="form-search-more form-inline">
				<div class="form-group">
					<label for="termek-nev">Termék név</label> 
					<form:input path="name" type="text" class="form-control" id="termeknev" placeholder="termek-nev"/>
				</div>
				<br/>
				<br/>
				<div class="form-group">
					<label for="gyarto">Gyártó</label>
					<form:select path="manufacturerId" class="form-control" items="${manufacturers}" id="gyarto"/>
				</div>
				<div class="form-group">
					<label for="kategoriak">Kategória</label>
					<form:select path="categoryId" items="${categories}" class="form-control" id="kategoriak"/>
				</div>
				<br>
				<div class="form-group">
					<label for="price">Ár</label>
					<div class="ar-valaszto-holder">
					<form:input path="priceMin" type="text" class="form-control" id="also-hatar" placeholder="Alsó határ"/> 
					<font color="white"> - </font>
					<form:input path="priceMax" type="text" class="form-control" id="felso-hatar" placeholder="Felső határ"/>
					<font color="white">Kr</font>
<!-- 						<input type="text" id="ar-valaszto" name="ar-valaszto" value=""> -->
					</div>
				</div>
				<br>
				<button type="submit" class="btn btn-default btn-md">Keresés</button>
			</form:form>


			<!--  találatok listázása -->
			<div class="row">
				
				<c:if  test="${fn:length(itemsContent) > 0}">
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
                </c:if>
                <c:if  test="${fn:length(itemsContent) < 1 }">
                	<font size="4" color="white">Nincs megjeleníthető elem</font>
                </c:if>
                
<%--                	<c:if test="${not empty items}"> --%>
<%-- 	                <c:url var="firstUrl" value="/search-more/0" /> --%>
<%-- 					<c:url var="prevUrl"  value="/search-more/${currentIndex - 2}" /> --%>
<%-- 					<c:url var="nextUrl"  value="/search-more/${currentIndex}" /> --%>
<%-- 					<c:url var="lastUrl"  value="/search-more/${items.totalPages - 1}" /> --%>
<!-- 		  			<div> -->
<!-- 					    <ul class="pagination"> -->
<%-- 					        <c:choose> --%>
<%-- 					            <c:when test="${currentIndex == 1}"> --%>
<!-- 					                <li class="disabled"><a href="#">&lt;&lt;</a></li> -->
<!-- 					                <li class="disabled"><a href="#">&lt;</a></li> -->
<%-- 					            </c:when> --%>
<%-- 					            <c:otherwise> --%>
<%-- 					                <li><a href="${firstUrl}">&lt;&lt;</a></li> --%>
<%-- 					                <li><a href="${prevUrl}">&lt;</a></li> --%>
<%-- 					            </c:otherwise> --%>
<%-- 					        </c:choose> --%>
<%-- 					        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}"> --%>
<%-- 					            <c:url var="pageUrl" value="/search-more/${i}" /> --%>
<%-- 					            <c:choose> --%>
<%-- 					                <c:when test="${i == currentIndex - 1}"> --%>
<%-- 					                    <li class="active"><a href="${pageUrl}"><c:out value="${i+1}" /></a></li> --%>
<%-- 					                </c:when> --%>
<%-- 					                <c:otherwise> --%>
<%-- 					                    <li><a href="${pageUrl}"><c:out value="${i+1}" /></a></li> --%>
<%-- 					                </c:otherwise> --%>
<%-- 					            </c:choose> --%>
<%-- 					        </c:forEach> --%>
<%-- 					        <c:choose> --%>
<%-- 					            <c:when test="${currentIndex == items.totalPages}"> --%>
<!-- 					                <li class="disabled"><a href="#">&gt;</a></li> -->
<!-- 					                <li class="disabled"><a href="#">&gt;&gt;</a></li> -->
<%-- 					            </c:when> --%>
<%-- 					            <c:otherwise> --%>
<%-- 					                <li><a href="${nextUrl}">&gt;</a></li> --%>
<%-- 					                <li><a href="${lastUrl}">&gt;&gt;</a></li> --%>
<%-- 					            </c:otherwise> --%>
<%-- 					        </c:choose> --%>
<!-- 					    </ul> -->
<!-- 					</div>	 -->
<%-- 				</c:if> --%>
			</div>
		</div>
	</div>
</div>
</main>

<%@include file="../includes/footer.jsp"%>