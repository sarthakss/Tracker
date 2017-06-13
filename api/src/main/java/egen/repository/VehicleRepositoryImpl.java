package egen.repository;

import egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Vehicle storeVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    @Override
    public Vehicle findVehicle(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }
}