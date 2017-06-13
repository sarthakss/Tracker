package egen.repository;

import egen.entity.Reading;
import org.springframework.stereotype.Repository;

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
}