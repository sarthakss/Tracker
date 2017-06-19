package egen.repository;

import egen.entity.Reading;
import egen.entity.Vehicle;
import java.util.List;


public interface ReadingRepository {

    Reading storeReading(Reading reading);

    List<Reading> findReadingsOfAVehicle(String vin);
}