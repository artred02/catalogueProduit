<%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 20/01/2024
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title></title>
</head>
<body>
<%--<nav class="navbar navbar-light bg-light">--%>
<%--    <div class="container-fluid">--%>
<%--        <a href="${pageContext.request.contextPath}/" class="navbar-brand">Accueil</a>--%>
<%--        <a href="allproducts">Liste des produits</a>--%>
<%--        <div class="d-flex">--%>
<%--            <a href="addProduct">Ajouter un produit</a>--%>
<%--            <a href="searchproduct">Rechercher un produit</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light"  style="margin-bottom: 40px">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="allproducts">Catalogue</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addProduct">Ajouter un produit</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="searchproduct">Rechercher un produit</a>
                </li>
            </ul>
            <form class="d-flex" action="searchproduct" method="post" style="margin: 0">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="nameProduct">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
</body>
</html>
