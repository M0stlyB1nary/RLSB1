package tech.lander.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by rory on 5/23/16.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    Integer productId;
    String description;
    String status;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Product() {}

    public Product(String id, Integer productId, String description, String status) {
        this.id = id;
        this.productId = productId;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%s, productId=%s, description='%s', status='%s']",
                id, productId, description, status);
    }
}
