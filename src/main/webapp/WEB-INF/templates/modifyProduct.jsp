<%@ page import="tp.catalogueproduit.entities.ProductEntity" %><%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 19/01/2024
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>Modifier le produit</title>
</head>
<body>
<% ProductEntity produit = (ProductEntity) request.getAttribute("product"); %>
<%--<h1>Modifier le produit</h1>--%>
<%--<form action="modifyProduct" method="post">--%>
<%--    <input type="hidden" name="id" value="<%= produit.getId() %>">--%>
<%--    <label for="name">Nom</label>--%>
<%--    <input type="text" name="name" id="name" value="<%= produit.getName() %>">--%>
<%--    <label for="price">Prix</label>--%>
<%--    <input type="text" name="price" id="price" value="<%= produit.getPrice() %>">--%>
<%--    <label for="description">Description</label>--%>
<%--    <input type="text" name="description" id="description" value="<%= produit.getDescription() %>">--%>
<%--    <label for="dispo">Dispo</label>--%>
<%--    <input type="checkbox" name="dispo" id="dispo" value="<%= produit.getDispo() %>" <% if(produit.getDispo()) { %> checked <% }%>>--%>
<%--    <input type="submit" value="Modifier">--%>
<%--</form>--%>

<%-- same with bootstrap --%>

<div class="container">
    <h1>Modifier le produit</h1>
    <form action="modifyProduct" method="post" style="max-width: 300px">
        <input type="hidden" name="id" value="<%= produit.getId() %>">
        <div class="form-group">
            <label for="name">Nom</label>
            <input type="text" name="name" id="name" value="<%= produit.getName() %>" class="form-control">
        </div>
        <br>
        <div class="form-group">
            <label for="price">Prix</label>
            <input type="text" name="price" id="price" value="<%= produit.getPrice() %>" class="form-control">
        </div>
        <br>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" name="description" id="description" value="<%= produit.getDescription() %>" class="form-control">
        </div>
        <br>
        <div class="form-group">
            <label for="dispo">Dispo</label>
            <input type="checkbox" name="dispo" id="dispo" value="<%= produit.getDispo() %>" <% if(produit.getDispo()) { %> checked <% }%>>
        </div>
        <input type="submit" value="Modifier" class="btn btn-primary" style="float: right">
    </form>
</div>
</body>
</html>
