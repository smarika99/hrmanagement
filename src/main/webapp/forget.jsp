<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Forgot Password</title>
</head>
<body class="bg-light">
	<jsp:include page="header.jsp" />
	<div class="container">

		<div class="text-center">
			<form id="myForm" class="m-5 p-5" action="forgotpassword" method="post">

				<div class="text-left form-group row ">
					<label class="col-form-label col-sm-2" for="username">Username
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="username" id="username"
							placeholder="Username" required>
					</div>
				</div>

				<div class="text-left form-group row ">
					<label class="col-form-label col-sm-2" for="phone">Mobile
						Number </label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="phone" id="phone"
							placeholder="Mobile Number" required>
					</div>
				</div>

				<div class="text-left form-group row ">
					<label class="col-form-label col-sm-2" for="password">New
						Password </label>
					<div class="col-sm-10">
						<input class="form-control" type="password" name="password" id="password"
							placeholder="Password" required>
					</div>
				</div>

				<div class="text-left form-group row ">
					<label class="col-form-label col-sm-2" for="cpassword">Confirm
						Password </label>
					<div class="col-sm-10">
						<input class="form-control" type="password" name="cpassword" id="cpassword"
							placeholder="Confirm Password" required>
					</div>
				</div>
<span class="font-weight-bold text-danger">
		<%
				if (session.getAttribute("error") != null) {
			%>
			<b><%=session.getAttribute("error")%></b>
			<%
				session.setAttribute("error", null);
				}
			%>
				</span><br />
				<input class="btn btn-primary col-sm-4 p-2 m-2" type="button" value="Change Password" onclick="submitAction()">
			</form>

			
		</div>
	</div>
	<br><br>
	<jsp:include page="footer.jsp" />
	<script type="text/javascript"> 
        function submitAction() {
        	var phonenoexp = /^\d{10}$/;
        	var phoneno = document.getElementById("phone").value;
        	var pass1 = document.getElementById("password").value;
        	var pass2 = document.getElementById("cpassword").value;
        	if(pass1!=pass2){
        		alert( "Passwords did not match.");
        	}
        	else if(pass1.length<6){
        		alert( "Password cannot be less than 6 characters.");
        	}
        	else if(!phoneno.match(phonenoexp)){
        		alert( "Mobile number must be of 10 digits.");
        	}
        	else{
        		document.getElementById("myForm").submit();
        	}
        } 
    </script>
</body>
</html>