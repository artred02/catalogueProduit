package tp.catalogueproduit.entities;

import jakarta.persistence.*;
import tp.catalogueproduit.database.ConnectionDatabase;

import java.io.Serializable;
import java.sql.*;

@Entity
@Table (name="product")
public class ProductEntity implements Serializable {
    @Id
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="price")
    private Float price;

    @Column(name="dispo")
    private int dispo;

    @Column(name="description", length = 100)
    private String description;

    public ProductEntity(String name, Float price, Boolean dispo, String description) throws Exception {
        this.name = name;
        this.price = price;
        if(dispo) this.dispo = 1;
        else this.dispo = 0;
        this.description = description;

        Connection conn = new ConnectionDatabase().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO product (name, price, dispo, description) VALUES (?, ?, ?, ?)");
        ps.setString(1, name);
        ps.setFloat(2, price);
        ps.setInt(3, this.dispo);
        ps.setString(4, description);
        ps.executeUpdate();
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

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
