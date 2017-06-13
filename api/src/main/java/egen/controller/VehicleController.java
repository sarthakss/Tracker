package egen.controller;

import egen.entity.Vehicle;
import egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(
            value = "/vehicles",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> createVehicles(@RequestBody List<Vehicle> vehicles) {
        return vehicleService.createVehicles(vehicles);
    }

    @RequestMapping(
            value = "/vehicles/getAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return vehicleService.getAllVehicles();
    }

}