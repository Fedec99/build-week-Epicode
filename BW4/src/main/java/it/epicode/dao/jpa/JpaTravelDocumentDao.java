package it.epicode.dao.jpa;

import it.epicode.classi.personal.TravelDocument;
import it.epicode.dao.BaseDao;
import it.epicode.dao.interfaces.TravelDocumentDao;

public class JpaTravelDocumentDao extends BaseDao implements TravelDocumentDao {

    @Override
    public void save(TravelDocument travelDocument) {
        try{
            var t = em.getTransaction();
            t.begin();
            em.persist(travelDocument);
            t.commit();
        }catch (Exception ex){
            log.error("usa il tasto destro che te frega", ex);
        }
    }
}
