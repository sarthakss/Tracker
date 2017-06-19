package egen.controller;

import egen.entity.Reading;
import egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "readings")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createVehicles(@RequestBody Reading reading) {
        return readingService.putReading(reading);
    }

    @RequestMapping(value = "{vin}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> getAlertsOfAVehicle(@PathVariable("vin") String vin) {

        return readingService.getAllReadingsOfAVehicle(vin);
    }


}