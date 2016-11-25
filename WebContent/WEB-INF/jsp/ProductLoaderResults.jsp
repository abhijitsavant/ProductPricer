<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Loader</title>
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Product Loader</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Here's the review of your details:</h3>
                </td>
            </tr>
            <tr>
                <td>Store Name : </td>
                <td>${productLoaderForm.storeName}</td>
            </tr>
            <tr>
                <td>Bar Code : </td>
                <td>${productLoaderForm.barCode}</td>
            </tr>
            <tr>
                <td>Price : </td>
                <td>${productLoaderForm.productPrice}</td>
            </tr>
            <tr>
                <td>Notes : </td>
                <td>${productLoaderForm.notes}</td>
            </tr>
        </table>
    </div>
</body>
</html>