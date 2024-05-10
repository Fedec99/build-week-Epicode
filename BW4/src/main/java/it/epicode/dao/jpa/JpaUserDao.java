package it.epicode.dao.jpa;

import it.epicode.classi.personal.Card;
import it.epicode.classi.personal.User;
import it.epicode.dao.BaseDao;
import it.epicode.dao.interfaces.UserDao;

public class JpaUserDao extends BaseDao implements UserDao {


    @Override
    public void save(User user) {
        try{
            Card card = user.getCard();
            var t = em.getTransaction();
            t.begin();
            em.persist(user);
            em.persist(card);
            t.commit();
        }catch (Exception ex){
            log.error("e andata male" + ex);
        }
    }


    @Override
    public User getUserById(Long id) {
        return em.find(User.class,id);
    }
}

