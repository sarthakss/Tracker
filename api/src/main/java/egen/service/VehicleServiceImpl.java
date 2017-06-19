package egen.service;

import egen.entity.Vehicle;
import egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public List<Vehicle> createVehicles(List<Vehicle> vehicles) {
        List<Vehicle> persistedVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if(!isVehiclePresent(vehicle.getVin())) {
                persistedVehicles.add(vehicleRepository.storeVehicle(vehicle));
            } else {
                persistedVehicles.add(vehicleRepository.updateVehicle(vehicle));
            }
        }

        return persistedVehicles;
    }

    @Override
    public boolean isVehiclePresent(String vin) {
        return vehicleRepository.findVehicle(vin) != null;
    }

    @Override
    public Vehicle getVehicle(String vin) {
        return vehicleRepository.findVehicle(vin);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}