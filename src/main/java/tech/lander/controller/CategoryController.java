package tech.lander.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rory on 6/1/16.
 */
@RestController
public class CategoryController {
    @RequestMapping("RL/")
    public String home() {
        return "Drop the bass.";
    }
}
