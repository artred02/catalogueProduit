package tp.catalogueproduit.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp.catalogueproduit.entities.ProductEntity;

import java.io.IOException;
import java.io.PrintWriter;

public class AllProductsServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Catalogue";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get all products
        ProductEntity product = new ProductEntity();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void destroy() {
    }
}
