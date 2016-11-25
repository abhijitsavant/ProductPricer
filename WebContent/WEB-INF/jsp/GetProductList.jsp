<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Product List</title>
</head>
<body>
	<form:form action="/PrizyPricer/getProductDetails" method="post"
		commandName="productLoaderForm">
		<div align="center">
			<table>
				<tr>
					<td colspan="2" align="center">
						<h2>....Product List....</h2></td>
				</tr>
				<tr>
					<td><form:label path="barCode">Product : </form:label></td>
					<td><form:select path="barCode" items="${products}">
						</form:select></td>
				</tr>
				<tr>
					<td colspan="1"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>