<%@include file="includes/header2.jsp"%>
<form:form modelAttribute="loginDto" role="form" class="form-horizontal">
  <div class="form-group">
    <form:label path="username" for="username" class="col-sm-2 control-label">Username</form:label>
    <div class="col-sm-10">
      <form:input path="username" type="text" class="form-control" id="username" placeholder="Username"/>
    </div>
  </div>
  <div class="form-group">
    <form:label path="password" for="password" class="col-sm-2 control-label">Password</form:label>
    <div class="col-sm-10">
      <form:input path="password" type="password" class="form-control" id="inputPassword3" placeholder="Password"/>
    </div>
  </div>
  <c:if test="${not empty loginError}"> 
	 <font color="red">${loginError}</font><br/>
  </c:if> 
<!--   <div class="form-group"> -->
<!--     <div class="col-sm-offset-2 col-sm-10"> -->
<!--       <div class="checkbox"> -->
<!--         <label> -->
<!--           <input type="checkbox"> Remember me -->
<!--         </label> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default"> Login </button>
    </div>
  </div>
</form:form>
<%@include file="includes/footer2.jsp" %>