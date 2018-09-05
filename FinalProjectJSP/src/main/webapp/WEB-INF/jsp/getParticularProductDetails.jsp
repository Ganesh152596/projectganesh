<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details for Particular Product</title>
</head>
<body>
	 <table border="1" style="width: 100%">
		<tr>
			<th>merchantId</th>
			<th>merchantName</th>
			<th>phoneNo</th>
			<th>type</th>
			
			
		</tr>
		
			<tr>
				<td>${customer.emailId}</td>
				<td>${customer.merchantName}</td>
				<td>${customer.phoneNo}</td>
				<td>${customer.type}</td>
				
			</tr>
		
	</table> 
	<a href="merchant" name="Back">Back to Particular Product Page</a></br>
	
</body>
</html>