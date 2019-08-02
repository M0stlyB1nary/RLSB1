package tech.lander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.lander.constants.CommonConstant;
import tech.lander.domain.Vehicle;
import tech.lander.repository.VehicleRepository;

import java.util.List;

@RestController
@RequestMapping(CommonConstant.URL_VEH_API)
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @RequestMapping(value = "vehicle", method = RequestMethod.POST)
    public void insertVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newV = vehicleRepository.insert(vehicle);
        System.out.println(newV.getMake());
    }

    @RequestMapping(value = "vehicle", method = RequestMethod.GET)
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
