package tech.lander.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.lander.domain.Product;

import java.util.List;

public interface ProductRepoNew extends MongoRepository<Product, String> {
    public List<Product> findByDescription(String description);

    public List<Product> findByStatus(String status);
}
