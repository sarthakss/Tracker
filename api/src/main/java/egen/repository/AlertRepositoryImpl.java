package egen.repository;

import egen.entity.Alert;
import egen.service.AlertService;
import org.springframework.stereotype.Repository;
import com.sun.xml.internal.bind.v2.TODO;
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
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAllAlertsOfSingleVehicle", Alert.class);
        query.setParameter("vin", vin);
        List<Alert> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Alert> findAllAlerts() {
        System.out.println("===============================================================================");
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAllAlerts", Alert.class);
        List<Alert> resultList = query.getResultList();
        return resultList;
    }

}