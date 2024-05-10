package it.epicode.dao.jpa;

import it.epicode.classi.transport.Vehicle;
import it.epicode.dao.BaseDao;
import it.epicode.dao.interfaces.VehicleDao;

public class JpaVehicleDao extends BaseDao implements VehicleDao {

    @Override
    public void save(Vehicle vehicle) {
        try {
            var t = em.getTransaction();
            t.begin();
            em.persist(vehicle);
            t.commit();
        } catch (Exception ex) {
            log.error("se rotto tutto", ex);
        }
        }

        @Override
        public Vehicle getVehicleById (Long id){
            return em.find(Vehicle.class,id);
        }
    }

