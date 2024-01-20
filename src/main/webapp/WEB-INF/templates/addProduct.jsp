<%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 20/01/2024
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
</head>
<body>

<%--form to add product--%>
<%--<form action="addProduct" method="post">--%>
<%--    <label for="name">Nom</label>--%>
<%--    <input type="text" name="name" id="name">--%>
<%--    <label for="price">Prix</label>--%>
<%--    <input type="text" name="price" id="price">--%>
<%--    <label for="description">Description</label>--%>
<%--    <input type="text" name="description" id="description">--%>
<%--    <label for="dispo">Dispo</label>--%>
<%--    <input type="checkbox" name="dispo" id="dispo">--%>
<%--    <input type="submit" value="Ajouter">--%>
<%--</form>--%>

<%-- with bootstrap : --%>
<div class="container">
    <form action="addProduct" method="post" style="max-width: 300px">
        <div class="form-group">
            <label for="name">Nom</label>
            <input type="text" name="name" id="name" class="form-control">
        </div>
        <br>
        <div class="form-group">
            <label for="price">Prix</label>
            <input type="text" name="price" id="price" class="form-control">
        </div>
        <br>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" name="description" id="description" class="form-control">
        </div>
        <br>
        <div class="form-check">
            <label for="dispo">Dispo</label>
            <input type="checkbox" name="dispo" id="dispo" class="form-check-input">
        </div>
        <input type="submit" value="Ajouter" class="btn btn-primary" style="float: right">
    </form>
</div>

</body>
</html>
