package CarTracker.repository;

/**
 * Created by sarth on 6/1/2017.
 */

import CarTracker.Entity.Alert;
import CarTracker.Entity.readings;
import CarTracker.Entity.tiress;

import java.util.List;

public interface readingsRepository {
    List<readings> findAll();
    List<readings> findByVin(String vin);
    void CreateAlert( String vin,String priority, String message);
    readings create(tiress tire, readings read);
    readings create(tiress tire, readings read, Alert obj);
    void delete(readings read);

}
