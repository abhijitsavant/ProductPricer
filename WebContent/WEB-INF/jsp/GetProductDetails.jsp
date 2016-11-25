<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Details</title>
</head>
<body>
	<div align="center">
		<table border="0">
			<tr>
				<td colspan="2" align="center"><h2>Product Details</h2></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<h3>Here's your Product details:</h3>
				</td>
			</tr>
			<tr>
				<td>Bar Code :</td>
				<td>${productBean.barCode}</td>
			</tr>
			<tr>
				<td>Product Description :</td>
				<td>${productBean.productDesc}</td>
			</tr>
			<tr>
				<td>Lowest Price :</td>
				<td>${productBean.lowestPrice}</td>
			</tr>
			<tr>
				<td>Average Price :</td>
				<td>${productBean.averagePrice}</td>
			</tr>
			<tr>
				<td>Highest Price :</td>
				<td>${productBean.highestPrice}</td>
			</tr>
			<tr>
				<td>Ideal Price :</td>
				<td>${productBean.idealPrice}</td>
			</tr>
			<tr>
				<td>Product Price Count :</td>
				<td>${productBean.productLength}</td>
			</tr>
		</table>
	</div>
</body>
</html>