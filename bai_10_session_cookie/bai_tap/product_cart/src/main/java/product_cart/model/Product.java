package product_cart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private double price ;
    private String description ;
    private String grand ;
    private String dateCreate ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrand() {
        return grand;
    }

    public void setGrand(String grand) {
        this.grand = grand;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(grand, product.grand) &&
                Objects.equals(dateCreate, product.dateCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, grand, dateCreate);
    }
}
