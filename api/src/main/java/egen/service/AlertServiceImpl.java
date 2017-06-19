package egen.service;

import egen.entity.*;
import egen.repository.AlertRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Override
    public void createAlert(Reading reading, Vehicle vehicle) {
        Alert alert;

        if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {
            alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setAlertPriority(AlertPriority.HIGH);
            alert.setAlertMessage("EngineRPM is greater than ReadlineRPM");
            alert.setTimestamp(reading.getTimestamp());
            alertRepository.storeAlert(alert);
        }

        if (reading.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume())) {
            alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setAlertPriority(AlertPriority.MEDIUM);
            alert.setAlertMessage("FuelVolume is less than 10% of MaxFuel");
            alert.setTimestamp(reading.getTimestamp());
            alertRepository.storeAlert(alert);
        }

        if (isTireFaulty(reading.getTires())) {
            alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setAlertPriority(AlertPriority.LOW);
            alert.setAlertMessage("Tire pressure is low");
            alert.setTimestamp(reading.getTimestamp());
            alertRepository.storeAlert(alert);
        }

        if (reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()) {
            alert = new Alert();
            alert.setVin(reading.getVin());
            alert.setAlertPriority(AlertPriority.LOW);
            alert.setAlertMessage("Engine Coolant Low OR Engine Light On");
            alert.setTimestamp(reading.getTimestamp());
            alertRepository.storeAlert(alert);
        }
    }

    @Override
    public List<Alert> getAllAlertsOfAVehicle(String vin) {
        return alertRepository.findAllAlertsOfAVehicle(vin);
    }

    @Override
    public List<Alert> getAllAlerts() {
        return alertRepository.findAllAlerts();
    }

    private boolean isTireFaulty(Tires tires) {
        int frontLeft = tires.getFrontLeft();
        int frontRight = tires.getFrontRight();
        int rearLeft =  tires.getRearLeft();
        int rearRight = tires.getRearRight();

        return ((frontLeft < 32 || frontLeft > 36) || (frontRight < 32 || frontRight > 36)
                || (rearLeft < 32 || rearLeft > 36) || (rearRight < 32 || rearRight > 36));
    }
}