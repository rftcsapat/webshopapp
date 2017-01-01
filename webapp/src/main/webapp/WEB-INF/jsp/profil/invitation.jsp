<%@include file="../includes/header.jsp"%>	
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
    <div class="container">

        <div class="row">
        
		<%@include file="../includes/sidebar.jsp"%>	
		
			<div class="col-md-9">

				<h1 class="page-title">Meghivó</h1>
				<p>Add meg az email cimet a meghivó kiküldéséhez</p>
				<form class="invitation-form">
					<div class="form-group">
						<label for="mail">Email cim</label>
						<input type="text" name="mail" id="mail" class="form-control">
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" name="submit" id="submit">
					</div>
				</form>
			</div>
		
        </div>

    </div>

<%@include file="../includes/footer.jsp"%>