<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Product loader</title>
</head>
<body>
	<form:form action="/PrizyPricer/addProductInformationForm"
		method="post" commandName="productLoaderForm">
		<div align="center">
			<table>
				<tr>
					<td colspan="2" align="center"><h2>Product loader
							Information</h2></td>
				</tr>
				<tr>
					<td><form:label path="storeId">Stores : </form:label></td>
					<td><form:select path="storeId" items="${stores}">
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="barCode">Product Bar Code : </form:label></td>
					<td><form:input path="barCode" /></td>
				</tr>
				<tr>
					<td><form:label path="productPrice">Price : </form:label></td>
					<td><form:input path="productPrice" /></td>
				</tr>
				<tr>
					<td><form:label path="notes">Notes : </form:label></td>
					<td><form:input path="notes" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
				<tr>
					<td>${isProductSaved}</td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>