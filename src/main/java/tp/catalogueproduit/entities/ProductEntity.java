package tp.catalogueproduit.entities;

import jakarta.persistence.*;
import tp.catalogueproduit.database.ConnectionDatabase;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductEntity implements Serializable {
    @Id
    private int id;

    private String name;

    private Float price;

    private Boolean dispo;

    private String description;

    public ProductEntity(String name, Float price, Boolean dispo, String description) throws Exception {
        this.name = name;
        this.price = price;
        this.dispo = dispo;
        this.description = description;
        this.insertProduct();
    }

    // Load a product
    public void GetProductById(int id) throws Exception {
        Connection conn = new ConnectionDatabase().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.price = rs.getFloat("price");
            this.dispo = rs.getBoolean("dispo");
            this.description = rs.getString("description");
        }
        else
        {
            throw new Exception("Product not found");
        }
    }

    public void insertProduct() throws Exception {
        Connection conn = new ConnectionDatabase().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO product (name, price, dispo, description) VALUES (?, ?, ?, ?)");
        ps.setString(1, this.name);
        ps.setFloat(2, this.price);
        ps.setBoolean(3, this.dispo);
        ps.setString(4, this.description);
        ps.executeUpdate();
    }

    public void DeleteProductEntity(int id)
    {
        Connection conn = new ConnectionDatabase().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM product WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProduct() throws Exception {
        Connection conn = new ConnectionDatabase().getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE product SET name = ?, price = ?, dispo = ?, description = ? WHERE id = ?");
        ps.setString(1, this.name);
        ps.setFloat(2, this.price);
        ps.setBoolean(3, this.dispo);
        ps.setString(4, this.description);
        ps.setInt(5, this.id);
        ps.executeUpdate();
    }

    public void GetProductByName(String name) throws Exception {
        Connection conn = new ConnectionDatabase().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();


        if(rs.next())
        {
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.price = rs.getFloat("price");
            this.dispo = rs.getBoolean("dispo");
            this.description = rs.getString("description");
        }
        else
        {
            throw new Exception("Product not found");
        }
    }

    public List<ProductEntity> GetListProductByName(String name) throws Exception {
        Connection conn = new ConnectionDatabase().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        List<ProductEntity> products = new ArrayList<>();
        while(rs.next()) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.GetProductById(rs.getInt("id"));
            products.add(productEntity);
        }
        return products;
    }


    public ProductEntity() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getDispo() {
        return dispo;
    }

    public void setDispo(Boolean dispo) {
        this.dispo = dispo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
