package tech.lander.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import tech.lander.model.Product;
import tech.lander.repository.ProductRepository;
import tech.lander.service.NumberGen;


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

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Integer newRnd(@RequestParam(value = "limit", required = false) Integer limit) {
        NumberGen ng = new NumberGen();
        if(limit == null) {
            limit = 100000;
        }

        return ng.getNewRndNum(limit);
    }
}
