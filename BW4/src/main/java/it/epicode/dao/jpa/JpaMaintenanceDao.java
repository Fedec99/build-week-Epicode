package it.epicode.dao.jpa;

import it.epicode.classi.transport.Maintenance;
import it.epicode.dao.BaseDao;
import it.epicode.dao.interfaces.MaintenanceDao;

public class JpaMaintenanceDao extends BaseDao implements MaintenanceDao {
    @Override
    public void save(Maintenance maintenance) {
        try{
            var t = em.getTransaction();
            t.begin();
            em.persist(maintenance);
            t.commit();
        } catch (Exception ex){
            log.error("Se rirotto tutto", ex);
        }
    }
}
