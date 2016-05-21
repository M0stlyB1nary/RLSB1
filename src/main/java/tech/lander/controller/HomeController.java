package tech.lander.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rory on 5/20/16.
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "All your base are belong to us.";
    }
}
