package CarTracker.service;

/**
 * Created by sarth on 5/1/2017.
 */
import CarTracker.Entity.readings;

import java.util.List;


public interface readingsService {

    List<readings> findAll();
    readings create(readings reading);
    void delete(String vin);
}