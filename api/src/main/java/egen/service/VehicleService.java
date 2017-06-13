package egen.service;

import egen.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> createVehicles(List<Vehicle> vehicles);

    boolean isVehiclePresent(String vin);

    Vehicle getVehicle(String vin);

    List<Vehicle> getAllVehicles();
}