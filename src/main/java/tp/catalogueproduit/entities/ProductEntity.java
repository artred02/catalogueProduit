package tp.catalogueproduit.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name="product")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name="price")
    private Float price;

    @Column(name="dispo")
    private Boolean dispo;

    @Column(name="description", length = 100)
    private String description;

    public ProductEntity(String name, Float price, Boolean dispo, String description) {
        this.name = name;
        this.price = price;
        this.dispo = dispo;
        this.description = description;
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
