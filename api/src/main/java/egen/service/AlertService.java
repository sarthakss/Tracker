package egen.service;

import egen.entity.Alert;
import egen.entity.Reading;
import egen.entity.Vehicle;

import java.util.List;

public interface AlertService {

    void createAlert(Reading reading, Vehicle vehicle);

    List<Alert> getHighPriorityAlerts();

    List<Alert> getAllAlertsOfAVehicle(String vin);
}