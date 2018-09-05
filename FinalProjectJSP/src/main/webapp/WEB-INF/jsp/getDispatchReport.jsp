<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dispatch Report</title>
</head>
<body>
	<table border="1" style="width: 100%">
		<tr>
			<th>orderId</th>
			<th>dateOfDelivery</th>
			<th>deliveryDate</th>
			<th>minBillingAmount</th>
			<th>orderStatus</th>
			<th>paymentMethod</th>
			<th>quantity</th>
			<th>total</th>
			
		</tr>
			<tr>
				<td>${customer.orderId}</td>
				<td>${customer.dateOfDelivery}</td>
				<td>${customer.deliveryDate}</td>
				<td>${customer.minBillingAmount}</td>
				<td>${customer.orderStatus}</td>
				<td>${customer.paymentMethod}</td>
				<td>${customer.quantity}</td>
				<td>${customer.total}</td>
			
			</tr>
		
	</table>
	<a href="order" name="Back">Back to Get Dispatch Report Page</a></br>

</body>
</html>