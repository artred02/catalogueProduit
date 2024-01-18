package tp.catalogueproduit.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tp.catalogueproduit.entities.ProductEntity;

@WebServlet(name = "catalogue", value = "/catalogue")
public class CatalogueServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Catalogue";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Formulaire d'ajout
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form action=\"catalogue\" method=\"post\">");
        out.println("<label for=\"name\">Nom du produit</label>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\"><br><br>");
        out.println("<label for=\"price\">Prix du produit</label>");
        out.println("<input type=\"text\" id=\"price\" name=\"price\"><br><br>");
        out.println("<label for=\"dispo\">Disponibilité du produit</label>");
        out.println("<input type=\"checkbox\" id=\"dispo\" name=\"dispo\"><br><br>");
        out.println("<label for=\"description\">Description du produit</label>");
        out.println("<input type=\"text\" id=\"description\" name=\"description\"><br><br>");
        out.println("<input type=\"submit\" value=\"Ajouter\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String dispo = request.getParameter("dispo");
        String description = request.getParameter("description");

        new ProductEntity(name, Float.parseFloat(price), Boolean.parseBoolean(dispo), description);
    }

    public void destroy() {
    }
}