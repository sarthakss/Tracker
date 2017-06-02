package CarTracker.service;

/**
 * Created by sarth on 5/1/2017.
 */
import CarTracker.Entity.vehicle;

import java.util.List;

public interface vehicleService {
    List<vehicle>  findAll();
    vehicle create(vehicle[] vhcl);
    void delete(String para);
}
