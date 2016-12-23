<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="col-md-3 sidebar">
	<p class="lead">Kategóriák</p>
	<div class="list-group">
		<a href="/product-category" class="list-group-item">Koncentrátumok</a> <a
			href="/product-category" class="list-group-item">Krémek</a> <a href="/product-category"
			class="list-group-item">Biokozmetika</a> <a href="/product-category"
			class="list-group-item">Testápolás</a> <a href="/product-category"
			class="list-group-item">Zöld élelmiszerek</a>
	</div>

	<form class="searchForm" method="post">
		<div class="form-group">
			<label for="search">Keresés</label> <input type="text"
				class="form-control" id="search" placeholder="Termék kereső">
		</div>
		<button type="submit" class="btn btn-default">Keresés</button>
		<div class="search-more-link">
			<a href="/search-more">Részletes keresés</a>
		</div>
	</form>
</div>

