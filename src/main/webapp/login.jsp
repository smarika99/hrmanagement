<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body class="bg-light">
<%-- <%
	if (session.getAttribute("authorized")!=null){  
		if(session.getAttribute("authorized").equals("true")){
		String redirectURL = "http://localhost:8080/hr-authentication/ok";
	    response.sendRedirect(redirectURL); 
	}}
%> --%>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="text-center">
			<form class=" m-5 p-5" action="login" method="post">
				<div class="form-group row">
					<label class="col-form-label col-sm-2" for="username">Username
					</label>
					<div class="col-sm-10">
						<input type="text" name="username" id="username"
							placeholder="Username" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label class="col-form-label col-sm-2" for="password">Password
					</label>
					<div class="col-sm-10">
						<input type="password" name="password" id="password"
							placeholder="Password" class="form-control" required>
					</div>
				</div>
				<span class="font-weight-bold text-danger">
					<%
		if (session.getAttribute("error") != null) {
	%> <%=session.getAttribute("error")%> <a href="forgotpassword">Reset
						Password ?</a> <%
		session.setAttribute("error", null);
		}
	%>
				</span><br /> <input class="btn btn-primary col-sm-4 p-2 m-2" type="submit"
					value="Log in"> <a class="btn btn-danger col-sm-4 p-2 m-2"
					href="signup">Sign Up </a>

			</form>
		</div>
	</div>
	<br><br>
	<jsp:include page="footer.jsp" />
</body>
</html>