package tech.lander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.lander.model.Product;
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

//    @RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
//    public Product update(@PathVariable String id, @RequestBody Product product){
//        Product existingShipwreck = productRepository.findOne(id);
//        BeanUtils.copyProperties(product, existingShipwreck);
//        //return productRepository.saveAndFlush(existingShipwreck);
//        return ProductStub.update(id, product);
//    }

    ///TODO: Finish this.
//    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
//    public Product delete(@PathVariable String id) {
//        return ProductStub.delete(id);
//
////        Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
////        shipwreckRepository.delete(existingShipwreck);
////        return existingShipwreck;
//    }
}
