package CarTracker.controller;

/**
 * Created by sarth on 5/1/2017.
 */


import CarTracker.Entity.readings;
import CarTracker.service.readingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TypedQuery;
import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "readings")
public class readingsController {
    @Autowired
    private readingsService service;

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<readings> findAll(){
        return service.findAll();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public readings create(@RequestBody readings read){
        return service.create(read);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("vin") String vin){
        service.delete(vin);
    }

}