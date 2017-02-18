package tech.lander.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.lander.repository.EarthQuakeRepository;

/**
 * Created by rory on 2/16/17.
 */
@RestController
public class EarthquakeController {
    @RequestMapping("eqFetch")
    public String home() {
        EarthQuakeRepository earthQuakeRepository = new EarthQuakeRepository();
        String response = earthQuakeRepository.fetchLatestEq();
        return response;
    }

}
