package tech.lander.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import tech.lander.model.Product;
import tech.lander.repository.ProductRepository;



/**
 * Created by rory on 5/20/16.
 */
@RestController
public class HomeController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping("/")
    public String home() {
        return "All your base are belong to us.";
    }
}
