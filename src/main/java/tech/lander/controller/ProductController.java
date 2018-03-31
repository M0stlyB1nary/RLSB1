package tech.lander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.lander.constants.CommonConstant;
import tech.lander.domain.Product;
import tech.lander.repository.ProductRepoNew;
import tech.lander.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:63342", "http://192.168.0.17", "*"})
@RestController
@RequestMapping("api/v1/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductRepoNew productRepoNew;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<Product> list() {
        return productRepoNew.findAll();
    }

    @RequestMapping(value = "products/desc", method = RequestMethod.GET)
    public List<Product> listByDesc(@RequestParam String desc) {
        return productRepoNew.findByDescription(desc);
    }

    @RequestMapping(value = "products/status", method = RequestMethod.GET)
    public List<Product> listByStatus(@RequestParam String status) {
        return productRepoNew.findByStatus(status);
    }

    @RequestMapping(value = "product/add", method = RequestMethod.POST)
    ResponseEntity<?> addProduct(@RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            try {
                productRepository.addProduct(product);
                return new ResponseEntity<String>(HttpStatus.CREATED);
            }
            catch (Exception e){
                return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
            }
        }
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.GET)
    public Product  get(@PathVariable String id) {
        Optional<Product> foundProduct = productRepoNew.findById(id);
        return foundProduct.get();
        //TODO Add try catch
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Product product){
        try {
            product.setId(id);
            productRepoNew.save(product);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        productRepository.deleteProduct(id);
        return CommonConstant.MESSAGE_PRODUCT_DELETED;
    }
}
