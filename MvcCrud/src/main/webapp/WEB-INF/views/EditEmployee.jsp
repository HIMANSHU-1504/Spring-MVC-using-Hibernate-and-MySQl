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

		<h1>Edit Employee Form</h1>
		<form action="updateEmployee" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="id">Id</label> <input type="text"
							value="${employee.id}" class="form-control" id="id" name="id"
							readonly="readonly">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							value="${employee.name }" class="form-control" id="name"
							name="name" placeholder="Enter Name">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="designation">Email</label> <input type="text"
							value="${employee.email }" class="form-control"
							id="email" name="email"
							placeholder="Enter Email">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="department">Gender</label> <input
							type="text" class="form-control" id="gender"
							value="${employee.gender }" name="gender"
							placeholder="Enter Gender">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							value="${employee.password }" class="form-control" id="password"
							name="password" placeholder="Enter password">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="department">Country</label> <input
							type="text" class="form-control" id="country"
							value="${employee.country }" name="country"
							placeholder="Enter Country">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="password">Mobile</label> <input type="tel"
							value="${employee.password }" class="form-control" id="mobile"
							name="mobile" placeholder="Enter mobile">
					</div>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>

</body>
</html>