<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<h1>Add Employee Form</h1>
		<a href="addEmployee" class="btn btn-primary"> Add Employee </a>
		<div class="row">

			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Password</th>
						<th scope="col">Gender</th>
						<th scope="col">Country</th>
						<th scope="col">Mobile</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${employee}">
						<tr>
							<td class="table-plus">${emp.id}</td>
							<td>${emp.name}</td>
							<td>${emp.email}</td>
							<td>${emp.password}</td>
							<td>${emp.gender}</td>
							<td>${emp.country}</td>
							<td>${emp.mobile}</td>
							<td><a href="editEmployee/${emp.id}" class="btn btn-warning">
									Edit </a></td>
							<td><a href="deleteEmployee/${emp.id}"
								class="btn btn-danger"> Delete </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>