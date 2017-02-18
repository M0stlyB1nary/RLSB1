package tech.lander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.lander.constants.CommonConstant;
import tech.lander.domain.Product;
import tech.lander.repository.ProductRepository;

import java.util.List;

/**
 * Created by rory on 5/27/16.
 */


@RestController
@RequestMapping("api/v1/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<Product> list() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "products/desc", method = RequestMethod.GET)
    public List<Product> listByDesc(@RequestParam String desc) {
        return productRepository.findByDescription(desc);
    }

    @RequestMapping(value = "products/status", method = RequestMethod.GET)
    public List<Product> listByStatus(@RequestParam String status) {
        return productRepository.findByStatus(status);
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
    public Product  get(@PathVariable Integer id) {
        return productRepository.findByProductId(id);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id, @RequestBody Product product){
        product.setId(id);
        productRepository.updateProduct(product);
        return CommonConstant.MESSAGE_PRODUCT_UDPATED;
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        productRepository.deleteProduct(id);
        return CommonConstant.MESSAGE_PRODUCT_DELETED;
    }
}
