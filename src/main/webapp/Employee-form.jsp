<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Employee Management  </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${employee == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${employee != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${employee == null}">
            			Add New employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${employee != null}">
					<input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out value='${employee.Name}' />" class="form-control"
						name="Name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Address</label> <input type="text"
						value="<c:out value='${employee.Address}' />" class="form-control"
						name="Address" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Salary</label> <input type="text"
						value="<c:out value='${employee.Salary}' />" class="form-control"
						name="Salary"required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Gender</label><br>
					<input type="radio" id="male" name="Gender" value="male"  >
                    <label for="male">Male</label><br>
					<input type="radio" id="Gender" name="Gender" value="female" >
					<label for="female">Female</label><br>
			
				</fieldset>
				
				<fieldset class="form-group">
					<label>BirthDate</label> <input type="Date"
						value="<c:out value='${employee.BirthDate}' />" class="form-control"
						name="BirthDate"required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>