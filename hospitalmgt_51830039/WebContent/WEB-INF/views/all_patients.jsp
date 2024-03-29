<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	welcome ${user.name }
	<br />
	<a href="logout">logout</a>
	<br />
	<br />
	<br />
	
	<div class="container">
		<div class="row">
			<div class="col-sm-6">

				<table class="table table-striped">


 
		<thead>
		
			<tr>
				<th>id</th>
				<th>name</th>
				<th>city</th>
				<th>patient</th>
				<th>phoneno</th>
				<th>roomno</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${patients}" var="patient">
				<tr>
					<td>${patient.id}</td>
					<td>${patient.name}</td>
					<td>${patient.city}</td>
					<td>${patient.age}</td>
					<td>${patient.phoneno}</td>
					<td>${patient.roomno}</td>
					
					<c:if test="${user.profile == 'admin'}">
						
					<td><a href="update?id=${patient.id}">update</a></td>
					<td><a href="delete?id=${patient.id}">delete</a></td>
					
					</c:if>

				
				</tr>
			</c:forEach>
		</tbody>


	</table>
	</div>
</div>
</div>

	<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">
	
	<a href="addpatient">addpatient</a>
</c:if>
</body>


</html>