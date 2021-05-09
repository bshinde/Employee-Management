<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isErrorPage="true"%>
<html>
<head>
<title>Error</title>
</head>
<body>
	<center>
		<h1>Error</h1>
		<h2><%=exception.getMessage() %><br/> </h2>
	</center>	
</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Management</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">



   <style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
 
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 25%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #4CAF50;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}
</style>
</head>

<body>
<a class="navbar navbar-expand-md bg-dark navbar-dark" ><b>Employee Management</b></a>
<nav>
 <ul>
 <li><a href="Employee_List.jsp"> Employee List</a></li>
 <li><a href="addEmployee.jsp">Add Employee</a></li>
 <li><a href="modify_Employee.jsp">Modify Employee</a></li>
</ul>
</nav>
<div style="margin-left:25%;padding:1px 16px;height:1000px;">
<h2>Hello</h2>
</div>
</body>
</html>
