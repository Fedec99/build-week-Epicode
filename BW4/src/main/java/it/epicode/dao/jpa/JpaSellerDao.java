package it.epicode.dao.jpa;

import it.epicode.classi.purchase.Seller;
import it.epicode.dao.BaseDao;
import it.epicode.dao.interfaces.SellerDao;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

public class JpaSellerDao extends BaseDao implements SellerDao {


    @Override
    public void save(Seller seller) {
        try {
            var t = em.getTransaction();
            t.begin();
            em.persist(seller);
            t.commit();
        } catch (Exception ex) {
            log.error("qualquadra non cosa" + ex);
        }
    }

    public int countTotalDailyTickets(Long sellerId, LocalDate startDate, LocalDate endDate) {
        try {
            Seller seller = em.find(Seller.class, sellerId);
            if (seller == null) {
                // Se il venditore non esiste, ritorna 0
                return 0;
            }
            TypedQuery<Long> query = em.createNamedQuery("DailyTicket.countBySellerAndDateRange", Long.class)
                    .setParameter("seller", seller)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);
            return query.getSingleResult().intValue();
        } catch (NoResultException e) {
            return 0; // Ritorna 0 se non ci sono risultati
        }
    }

    public int countTotalSubscriptions(Long sellerId, LocalDate startDate, LocalDate endDate) {
        try {
            Seller seller = em.find(Seller.class, sellerId);
            if (seller == null) {
                // Se il venditore non esiste, ritorna 0
                return 0;
            }
            TypedQuery<Long> query = em.createNamedQuery("Subscription.countBySellerAndDateRange", Long.class)
                    .setParameter("seller", seller)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);
            return query.getSingleResult().intValue();
        } catch (NoResultException e) {
            return 0; // Ritorna 0 se non ci sono risultati
        }
    }
}
