<%@page import="com.nagarro.training.dto.EmployeeDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Details</title>
</head>
<body class="bg-light">
<%if(session.getAttribute("authorized")==null){
		String redirectURL = "http://localhost:8080/hr-authentication/logout.jsp";
	    response.sendRedirect(redirectURL);
	}
	else if(session.getAttribute("authorized").equals("false")){
		String redirectURL = "http://localhost:8080/hr-authentication/logout.jsp";
	    response.sendRedirect(redirectURL);
	}
	%>
	<jsp:include page="header.jsp" />
	<div class="container">
	<br>
	<fieldset class="border p-2">
		<legend class="w-auto medium">Edit Employee Details</legend>
		<div class="text-center">
			<form class=" m-5 p-5" action="edit" method="post">
				
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="id">Id
					</label>
					<div class="col-sm-10">
						<input type="text" name="id" id="id" readonly value="${employeeDto.getId()}" class="form-control" >
					</div>
				</div>
				
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="name">Name
					</label>
					<div class="col-sm-10">
						<input type="text" name="name" id="name"
							value="${employeeDto.getName()}" class="form-control" required>
					</div>
				</div>
				
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="email">Email
					</label>
					<div class="col-sm-10">
						<input type="text" name="email" id="email"
							value="${employeeDto.getEmail()}"  class="form-control" required>
					</div>
				</div>
				
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="location">Location
					</label>
					<div class="col-sm-10">
						<input type="text" name="location" id="location"
							value="${employeeDto.getLocation()}"  class="form-control" required>
					</div>
				</div>
				
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="dob">Date of birth
					</label>
					<div class="col-sm-10">
						<input type="date" name="dob" id="dob"
							  value="${employeeDto.getDob()}" class="form-control" required>
					</div>
				</div>
				
				<br /> 
				<input class="btn btn-primary col-sm-4 p-2 m-2" type="submit" value="Save">
				<a class="btn btn-danger col-sm-4 p-2 m-2"	href="homepage">Cancel</a>
				
			</form>
			
		</div>
		</fieldset>
	</div>
	<br><br>
	<jsp:include page="footer.jsp" />
</body>
</html>