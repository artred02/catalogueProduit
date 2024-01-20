<%@ page import="tp.catalogueproduit.entities.ProductEntity" %><%--
<%--
  Created by IntelliJ IDEA.
  User: asens
  Date: 19/01/2024
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search the product</title>
</head>
<body>
<h3> what are u searching for ? </h3>
<% ProductEntity produit = (ProductEntity) request.getAttribute("product"); %>
    <h1>Search for product</h1>
    <form action="searchproduct" method="post">
        <label for="name">Product name :</label>
        <input type="text" id="name" name="nameProduct" placeholder="Enter the product name" required>
        <br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
