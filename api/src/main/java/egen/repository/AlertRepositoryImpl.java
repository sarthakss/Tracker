package egen.repository;

import egen.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Alert storeAlert(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }

    @Override
    public List<Alert> findAllAlertsOfAVehicle(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAllAlerts", Alert.class);
        query.setParameter("vin", vin);
        List<Alert> resultList = query.getResultList();
        return resultList;
    }


}