<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
</head>
<body>
<form:form action="alltransaction" method="post" modelAttribute="transaccount" >
<form:hidden path="id"/>
Enter timeStamp:<form:input path="timeStamp"/><form:errors path="timeStamp" class="error"/><br/>
Enter fromAccount:<form:input path="fromAccount"/><form:errors path="fromAccount" class="error"/><br/>
Enter toAccount:<form:input path="toAccount"/><form:errors path="toAccount" class="error"/><br/>
Enter txType:<form:input path="txType"/><form:errors path="txType" class="error"/><br/>
Enter txAmount:<form:input path="txAmount"/><form:errors path="txAmount" class="error"/><br/>
Enter authorityName:<form:input path="authorityName"/><form:errors path="authorityName" class="error"/><br/>
Enter status:<form:input path="status"/><form:errors path="status" class="error"/><br/>
<input type="submit">
</form:form>
</body>
</html>