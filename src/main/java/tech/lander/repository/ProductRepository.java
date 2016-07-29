package tech.lander.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.lander.model.Product;

import java.util.List;


/**
 * Created by rory on 6/8/16.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
    public Product findByProductId(String desc);
    public List<Product> findByDescription(String desc);
}
