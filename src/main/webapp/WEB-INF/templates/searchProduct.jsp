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
    <jsp:include page="header.jsp"/>
</head>
<body>
<%--    <form action="searchproduct" method="post">--%>
<%--        <label for="name">Product name :</label>--%>
<%--        <input type="text" id="name" name="nameProduct" placeholder="Enter the product name" required>--%>
<%--        <input type="submit" value="Search">--%>
<%--    </form>--%>

    <%-- same form with bootstrap --%>
    <form action="searchproduct" method="post" style="max-width: 300px">
        <div class="form-group">
            <h4><label for="name">Product name :</label></h4>
            <input type="text" class="form-control" id="name" name="nameProduct" placeholder="Enter the product name" required>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

</body>
</html>
