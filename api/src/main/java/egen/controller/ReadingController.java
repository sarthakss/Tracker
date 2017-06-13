package egen.controller;

import egen.entity.Reading;
import egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @RequestMapping(value = "/readings",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createVehicles(@RequestBody Reading reading) {
        return readingService.putReading(reading);
    }

}