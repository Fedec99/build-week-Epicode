package it.epicode.dao.jpa;

import it.epicode.classi.personal.Card;
import it.epicode.dao.BaseDao;
import it.epicode.dao.interfaces.CardDao;

public class JpaCardDao extends BaseDao implements CardDao {
    @Override
    public void save(Card card) {
        try{
            var t = em.getTransaction();
            t.begin();
            em.persist(card);
            t.commit();
        }catch (Exception ex){
            log.error("qualquadra non cosa" + ex);
        }
    }
    @Override
    public Card getCardById(Long id) {
        return em.find(Card.class,id);
    }
}
