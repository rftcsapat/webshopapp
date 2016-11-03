<%@include file="includes/header2.jsp"%>
Welcome!<br/>You can add a new user using the form below!<br/>
<form:form modelAttribute="regformDto" role="form">
	<form:errors />
	<div class="form-group">
		<form:label path="name" for="name">Your personal name: </form:label> 
		<form:input path="name" type="text" class="form-control" id="nameInput" placeholder="YourName"/>
		<form:errors path="name" cssClass="error"/>
	</div>
	<div class="form-group">
		<form:label path="username" for="username">Username: </form:label> 
		<form:input path="username" type="text" class="form-control" id="usernameInput" placeholder="Your Username"/>
<!-- 		<div class="form-group col-lg-4 col-sm-6 col-xs-12"> -->
<%-- 			<font color="red">${usernameError}</font> --%>
<!-- 		</div><br/> -->
		<c:if test="${not empty usernameError}"> 
			<font color="red">${usernameError}</font><br/>
		</c:if> 
	</div>
	<div class="form-group">
		<form:label path="birthDate" for="birthDate">Date Of Birth: </form:label> 
		<form:input path="birthDate" type="date" class="form-control" id="birthDateInput" placeholder="YYYY-MM-DD"/>
		<form:errors path="birthDate" cssClass="error"/>
	</div>
<!-- 	<div class="form-group"> -->
<!-- 		<label for="email">Email address</label> <input type="email" -->
<!-- 			class="form-control" id="exampleInputEmail1" placeholder="Email"> -->
<!-- 	</div> -->
	<div class="form-group">
		<form:label path="password" for="password">Password:</form:label> 
		<form:input path="password" type="password" class="form-control" id="password"
			placeholder="Password"/>
		<form:errors path="password" cssClass="error"/>
	</div>
	<div class="form-group">
		<form:label path="passwordAgain" for="passwordAgain">Password again:</form:label> 
		<form:input path="passwordAgain" typ-e="password" class="form-control" id="passwordAgain" placeholder="Password again"/>
		<form:errors path="passwordAgain" cssClass="error"/>
		<div class="form-group col-lg-4 col-sm-6 col-xs-12">
			<font color="red">${passwordError}</font>
		</div><br/>
	</div>
<!-- 	<div class="form-group"> -->
<!-- 		<label for="exampleInputFile">File input</label> <input type="file" -->
<!-- 			id="exampleInputFile"> -->
<!-- 		<p class="help-block">Example block-level help text here.</p> -->
<!-- 	</div> -->
<!-- 	<div class="checkbox"> -->
<%-- 		<form:label path="adminCheckbox"> <input type="checkbox"> Admin </form:label> --%>
<!-- 	</div> -->
	<br/>
	<button type="submit" class="btn btn-default"> Register new user </button>
</form:form>
<%@include file="includes/footer2.jsp" %>