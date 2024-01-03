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
		<form action="insertEmployee" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter Name">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email"
							placeholder="Enter Email">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
					    <label for="gender">Gender</label>
					    <select class="form-control" id="gender" name="gender">
					        <option value="male">Male</option>
					        <option value="female">Female</option>
					        <option value="other">Other</option>
					    </select>
					</div>

				</div>
				<div class="col">
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter password">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
				    <div class="form-group">
				        <label for="country">Country</label>
				        <select class="form-control" id="country" name="country">
				        	<option value="India">India</option>
				            <option value="USA">USA</option>
				            <option value="UK">UK</option>
				            <option value="Canada">Canada</option>
				            <option value="Japan">Japan</option>
				        </select>
				    </div>
				</div>
				<div class="col">
				    <div class="form-group">
				        <label for="mobile">Mobile</label>
				        <input type="tel" class="form-control" id="mobile" name="mobile" placeholder="Enter Mobile No." pattern="[0-9]{10}" title="Please enter a 10-digit number">
				    </div>
				</div>
			</div>

			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Back </a>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>

</body>
</html>