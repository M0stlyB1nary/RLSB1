package tech.lander.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.lander.repository.ProductRepository;
import tech.lander.service.NumberGen;


/**
 * Created by rory on 5/20/16.
 */
@CrossOrigin(origins = {"http://localhost:63342", "http://192.168.0.17"})
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
