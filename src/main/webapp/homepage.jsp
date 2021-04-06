<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Employee Details</title>
<style>
table {
	overflow-y: auto;
	height: 50vh; 
}
thead th {
	position: sticky;
	top: 0;
}
</style>
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
		<legend class="w-auto medium">Employee Listings</legend>
  			
				<form class="text-right" action="download" method=GET>
					<a class="btn btn-secondary col-sm-3 p-2 m-2" href="upload"> Upload Employee Details</a>
					<input class="btn btn-secondary col-sm-3 p-2 m-2" type="submit" value="Download Employee Details" />
				</form>

		    <div class="m-2 p-4">
			<table class=" table table-striped table-hover">
				<thead class="thead-light">
					<tr>
						<th>Employee Code</th>
						<th>Employee Name</th>
						<th>Location</th>
						<th>Email</th>
						<th>Date Of Birth</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employeeDtos}" var="employee">
						<tr>
							<td>${employee.getId()}</td>
							<td>${employee.getName()}</td>
							<td>${employee.getLocation()}</td>
							<td>${employee.getEmail()}</td>
							<td>${employee.getDob()}</td>
							<td>
								<form action="edit" method="get">
									<input type="hidden" name="id" value="${employee.getId()}">
									<input class="btn btn-primary" type="submit" value="Update">
								</form>
							</td>
							<td>
								<form action="delete" method="get">
									<input type="hidden" name="id" value="${employee.getId()}">
									<input class="btn btn-danger" type="submit" value="Delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
	</fieldset>
	</div>
	<br><br>
	<jsp:include page="footer.jsp" />
</body>
</html>