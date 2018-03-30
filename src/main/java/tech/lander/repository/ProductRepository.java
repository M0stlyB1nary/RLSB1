package tech.lander.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import tech.lander.constants.CommonConstant;
import tech.lander.domain.Product;

import java.util.List;


/**
 * Created by rory on 6/8/16.
 */
@Repository
public class ProductRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    void setMongoTemplate(MongoTemplate mongoTemplate) { this.mongoTemplate = mongoTemplate; }

    public List<Product> findByDescription(String desc) {
        Query query = new Query(Criteria.where(CommonConstant.PRODUCT_DESCRIPTION).regex(desc));
        return mongoTemplate.find(query, Product.class, CommonConstant.MONGO_PRODUCT_COLLECTION);
    }

    public List<Product> findAll() {
        return mongoTemplate.findAll(Product.class, CommonConstant.MONGO_PRODUCT_COLLECTION);
    }

    public List<Product> findByStatus(String status) {
        Query query = new Query(Criteria.where(CommonConstant.PRODUCT_STATUS).is(status));
        return mongoTemplate.find(query, Product.class, CommonConstant.MONGO_PRODUCT_COLLECTION);
    }

    public void addProduct(Product product) {
        mongoTemplate.insert(product, CommonConstant.MONGO_PRODUCT_COLLECTION);
    }

    public Product findByProductId(Integer id) {
        Query query = new Query(Criteria.where(CommonConstant.PRODUCT_PRODUCT_ID).is(id));
        return mongoTemplate.findOne(query, Product.class, CommonConstant.MONGO_PRODUCT_COLLECTION);
    }

    public Product findById(String id) {
        Query query = new Query(Criteria.where(CommonConstant.ID).is(id));
        return mongoTemplate.findOne(query, Product.class, CommonConstant.MONGO_PRODUCT_COLLECTION);
    }

    public void deleteProduct(String id) {
        Query query = new Query(Criteria.where(CommonConstant.ID).is(id));
        Product product = mongoTemplate.findOne(query, Product.class, CommonConstant.MONGO_PRODUCT_COLLECTION);
        mongoTemplate.remove(product);
    }

    public void updateProduct(Product product) {
        mongoTemplate.updateFirst(
                new Query(Criteria.where(CommonConstant.ID).is(product.getId())),
                Update.update("productId", product.getProductId())
                .set("description", product.getDescription())
                .set("status", product.getStatus())
                .set("productName", product.getProductName())
                , Product.class);
//        mongoTemplate.save(product);
    }

}
