package egen.service;

import egen.entity.Reading;
import egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AlertService alertService;

    private Set<Date> timeStampSet = new HashSet<>();

    @Override
    @Transactional
    public Reading putReading(Reading reading) {
        Reading returnedReading = null;
        if (vehicleService.isVehiclePresent(reading.getVin())) {
            if (timeStampSet.contains(reading.getTimestamp())) {
                System.out.println("Duplicate Entry. " + reading);
            } else {
                alertService.createAlert(reading, vehicleService.getVehicle(reading.getVin()));
                timeStampSet.add(reading.getTimestamp());
                returnedReading = readingRepository.storeReading(reading);
            }
        } else {

        }

        return returnedReading;
    }
}
