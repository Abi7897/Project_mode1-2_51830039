<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><table border="1" >

		<thead>
			<tr>
				<th>id</th>
			    <th>timeStamp</th>
				<th>fromAccount</th>
				<th>toAccount</th>
				<th>txType</th>
				<th>txAmount</th>
				<th>authorityName</th>
				<th>status</th>
				
				
				<!-- <th>update</th>
				<th>delete</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transaccount}" var="transaccounts">
			   <tr>
				<td>${account.id }</td>
				<td>${transaccounts.timeStamp }</td>
				<td>${transaccounts.fromAccount }</td>
				<td>${transaccounts.toAccount }</td>
				<td>${transaccounts.txType }</td>
				<td>${transaccounts.txAmount }</td>
				<td>${transaccounts.authorityName }</td>
				<td>${transaccounts.status}</td>
				
			
				<%-- <td><a href="update?id=${account.accountNumber}">update</a></td>
				<td><a href="delete?id=${account.accountNumber}">delete</a></td> --%>
			   </tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- </center>
	<center><a href="transfer">transfer</a></center><br/>
	<center><a href="deposit">deposit</a></center><br/>
	<center><a href="withdraw">withdraw</a></center><br/>
	<center><a href="addaccount">addaccount</a></center><br/>
	<center><a href="logout">logout</a></center> --%>
	
	
	
</body>
</html>