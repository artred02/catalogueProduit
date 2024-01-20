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

@WebServlet(name = "searchproduct", value = "/searchproduct")
public class searchProduct extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/searchProduct.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            ProductEntity productEntity = new ProductEntity();
            String productName = request.getParameter("nameProduct");
            PrintWriter out = response.getWriter();

            List<ProductEntity> products = productEntity.GetListProductByName(productName);

            if(products.isEmpty()){
                out.println("<html><body>");
                out.println("<h2> PRODUCT NOT FOUND !!!!!!! </h2>");
                out.println("</html></body>");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/allProducts.jsp");
                try {
                    request.setAttribute("products", products);
                    rd.forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (Exception e) {
           // response.sendRedirect("searchproduct");
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}
