package tp.catalogueproduit.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp.catalogueproduit.database.ConnectionDatabase;
import tp.catalogueproduit.entities.ProductEntity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "allproducts", value = "/allproducts")
public class AllProductsServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Catalogue";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        Connection conn = connectionDatabase.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM product WHERE 1");
            ResultSet rs = ps.executeQuery();

            List<ProductEntity> products = new ArrayList<>();
            while(rs.next()) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.GetProductById(rs.getInt("id"));
                products.add(productEntity);
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/allProducts.jsp");
            try {
                request.setAttribute("products", products);
                rd.forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + request.getParameter("id") + "</h1>");
        ProductEntity productEntity = new ProductEntity();
        productEntity.DeleteProductEntity(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("allproducts");
    }

    public void Faitrien(){}

    public void destroy() {
    }
}
