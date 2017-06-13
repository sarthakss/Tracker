package egen.repository;

import egen.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {

    Vehicle storeVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    Vehicle findVehicle(String vin);

    List<Vehicle> findAll();
}