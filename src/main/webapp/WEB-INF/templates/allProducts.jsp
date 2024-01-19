<%@ page import="tp.catalogueproduit.entities.ProductEntity" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 19/01/2024
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>Title</title>
</head>
<body>
<h1>hello world</h1>

<% List<ProductEntity> products = (List<ProductEntity>) request.getAttribute("products"); %>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>dispo</th>
        <th>description</th>
        <th>Modifier</th>
        <th>Supprimer</th>
    </tr>
    <% for(ProductEntity product : products) { %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <% if(product.getDispo()) { %>
        <td>Oui</td> <% } else { %>
        <td>Non</td>
        <% } %>
        <td><%= product.getDescription() %></td>
        <td>
            <form action="modifyProduct" method="get" style="display: contents">
                <input type="hidden" value="<%= product.getId() %>" name="id">
                <input type="submit" value="Modifier">
            </form>
        </td>
        <td>
            <form action="allproducts" method="post" style="display: contents">
                <input type="hidden" value="<%= product.getId() %>" name="id">
                <input type="submit" value="Supprimer">
            </form>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>
