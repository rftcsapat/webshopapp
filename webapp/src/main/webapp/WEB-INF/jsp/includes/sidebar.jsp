<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="col-md-3">
	<p class="lead">Kategóriák</p>
	<div class="list-group">
		<a href="/product-category" class="list-group-item">Koncentratumok</a> <a
			href="/product-category" class="list-group-item">Kremek</a> <a href="/product-category"
			class="list-group-item">Biokozmetika</a> <a href="/product-category"
			class="list-group-item">Testapolas</a> <a href="/product-category"
			class="list-group-item">Zold elelmiszerek</a>
	</div>

	<form class="searchForm" method="post">
		<div class="form-group">
			<label for="search">Keresés</label> <input type="text"
				class="form-control" id="search" placeholder="Termék kereső">
		</div>
		<div>
			<a href="/search-more">Részletes keresés</a>
		</div>
		<button type="submit" class="btn btn-default">Keresés</button>
	</form>
</div>

