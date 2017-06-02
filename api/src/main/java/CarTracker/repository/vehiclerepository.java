package CarTracker.repository;

/**
 * Created by sarth on 6/1/2017.
 */
import CarTracker.Entity.vehicle;

import java.util.List;

public interface vehiclerepository {
    List<vehicle> findAll();
    vehicle findByVin(String vin);
    void create(vehicle vcl);
    void update(vehicle vcl);
    void delete(vehicle para);
}