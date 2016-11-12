<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="hu">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Webshop">

    <title>Energy WebAruhaz</title>

    <!-- Bootstrap Core CSS -->
    <link href="public/lib/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="public/lib/ion.rangeSlider-2.1.4/css/ion.rangeSlider.css" rel="stylesheet">
	<link href="public/lib/ion.rangeSlider-2.1.4/css/ion.rangeSlider.skinNice.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="public/css/styles.css" rel="stylesheet">

</head>

<body>

    <nav class="navbar navbar-inverse" role="navigation">
    	<div class="container">
        	<div class="navbar-header">
        		<img src="public/images/product/icon.png" vspace="8" hspace="5" align="left">
        		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        		<span class="sr-only">Toggle navigation</span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	            </button>
	            <c:if test="${not empty user}">
	            	<a class="navbar-brand" href="/home">Energy Webshop</a>
	            </c:if>
	            <c:if test="${empty user}">
	            	<a class="navbar-brand" href="/">Energy Webshop</a>
	            </c:if>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Szolgáltatások</a>
                    </li>
                    <li>
                        <a href="#">Kapcsolat</a>
                    </li>
                </ul>
                <c:if test="${empty user}">
	                <div class="pull-right">
	                	<ul class="navbar-list">
	                		<li><a href="/signin">Bejelentkezés</a></li>
	                		<li><a href="/signup">Regisztráció</a></li>
	                	</ul>
	                </div>
                </c:if>
                <c:if test="${not empty user}">
	                <div class="pull-right">
	                	<ul class="navbar-list">
	                		<li><a href="/profil">Beállítások</a></li>
	                		<li><a href="/logout">Kijelentkezés</a></li>
	                	</ul>
	                </div>
                </c:if>
            </div>
        </div>
    </nav>
		<c:if test="${not empty flashMessage}">
			<div class="container">
			<div class="alert alert-${flashKind} alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times; </button>
				${flashMessage}
			</div>
			</div>
		</c:if>