package tp.catalogueproduit.servlet;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tp.catalogueproduit.entities.ProductEntity;

@WebServlet(name = "addProduct", value = "/addProduct")
public class AddProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/addProduct.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        boolean dispo = request.getParameter("dispo") != null;
        String description = request.getParameter("description");


        try {
            new ProductEntity(name, Float.parseFloat(price), dispo, description);
            // redirection vers la page produits
            response.sendRedirect("allproducts");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}