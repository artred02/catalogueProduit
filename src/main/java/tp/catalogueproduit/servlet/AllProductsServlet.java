package tp.catalogueproduit.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tp.catalogueproduit.database.ConnectionDatabase;
import tp.catalogueproduit.entities.ProductEntity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "allproducts", value = "/allproducts")
public class AllProductsServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Catalogue";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get all products

        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        Connection conn = connectionDatabase.getConnection();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<table><tr><th>id</th><th>name</th><th>price</th><th>dispo</th><th>description</th></tr>");
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getFloat("price") + "</td>");
                out.println("<td>" + rs.getInt("dispo") + "</td>");
                out.println("<td>" + rs.getString("description") + "</td>");
                out.println("</tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        out.println("</table>");

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void destroy() {
    }
}
