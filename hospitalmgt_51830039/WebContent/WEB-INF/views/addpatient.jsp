<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
<style type="text/css">
.error{
color: red;
}
</style>
</head>
<body>
<form:form action="addpatient" method="post" modelAttribute="patient">
<form:hidden path="id"/>
Enter name:<form:input path="name"/><form:errors path="name" class="error"/><br/>
Enter city:<form:input path="city"/><form:errors path="city" class="error"/><br/>
Enter age:<form:input path="age"/><form:errors path="age" class="error"/><br/>
Enter phoneno:<form:input path="phoneno"/><form:errors path="phoneno" class="error"/><br/>
Enter roomno:<form:input path="roomno"/><form:errors path="roomno" class="error"/><br/>

<input type="submit"/>
</form:form>


</body>
</html>