<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="col-md-3 sidebar">
	<p class="lead">Kategóriák</p>
	<div class="list-group">
		<a href="/home/koncentrátumok/0" class="list-group-item">Koncentrátumok</a> 
		<a href="/home/krémek/0" class="list-group-item">Krémek</a> 
		<a href="/home/biokozmetika/0" class="list-group-item">Biokozmetika</a> 
		<a href="/home/testápolás/0" class="list-group-item">Testápolás</a> 
		<a href="/home/zöld_élelmiszerek/0" class="list-group-item">Zöld élelmiszerek</a>
	</div>

	<form:form modelAttribute="searchDto" class="searchForm" method="post">
	 	<c:url var="actualMapping" value="${requestScope['javax.servlet.forward.request_uri']}" />
		<c:if test="${fn:containsIgnoreCase(actualMapping, '/home/')}">
			<div class="form-group">
				<label for="search">Keresés</label> 
				<form:input path="keyword" type="text" class="form-control" id="search" placeholder="Termék kereső"/>
			</div>
			<button type="submit" class="btn btn-default">Keresés</button>
		</c:if>
		<div class="search-more-link">
			<a href="/search-more/0">Részletes keresés</a>
		</div>
	</form:form>
</div>

