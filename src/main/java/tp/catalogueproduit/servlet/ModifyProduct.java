package tp.catalogueproduit.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp.catalogueproduit.database.ConnectionDatabase;
import tp.catalogueproduit.entities.ProductEntity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "modifyProduct", value = "/modifyProduct")
public class ModifyProduct extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.GetProductById(Integer.parseInt(request.getParameter("id")));

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/modifyProduct.jsp");
            try {
                request.setAttribute("product", productEntity);
                rd.forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.GetProductById(Integer.parseInt(request.getParameter("id")));
            productEntity.setName(request.getParameter("name"));
            productEntity.setPrice(Float.parseFloat(request.getParameter("price")));
            productEntity.setDispo(request.getParameter("dispo") != null);
            productEntity.setDescription(request.getParameter("description"));
            productEntity.updateProduct();

            response.sendRedirect("allproducts");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
