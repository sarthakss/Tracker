package egen.repository;

import egen.entity.Reading;
import egen.entity.Alert;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Reading storeReading(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }

    @Override
    public List<Reading> findReadingsOfAVehicle(String vin) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findReadingsOfSingleVehicle", Reading.class);
        query.setParameter("vin", vin);
        List<Reading> resultList = query.getResultList();
        return resultList;
    }
}