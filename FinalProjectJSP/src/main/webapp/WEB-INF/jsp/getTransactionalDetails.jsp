<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactional Details</title>
</head>
<body>
	<table border="1" style="width: 100%">
		<tr>
			<th>transactionId</th>
			<th>transactionDate</th>
			<th>paymentAmount</th>
			<th>capStoreRevenueAmount</th>
			
			
		</tr>
		
			<tr>
				<td>${customer.transactionId}</td>
				<td>${customer.transactionDate}</td>
				<td>${customer.paymentAmount}</td>
				<td>${customer.capStoreRevenueAmount}</td>
				
			
			</tr>
	
	</table>
	<a href="transactionAnalysis" name="Back">Back to transaction analysis Page</a></br>
	
</body>
</html>