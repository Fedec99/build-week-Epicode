package it.epicode.classi.purchase;

import it.epicode.classi.personal.TravelDocument;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("T")
@NamedQuery(name = "DailyTicket.countBySellerAndDateRange",
        query = "SELECT COUNT(dt) FROM DailyTicket dt " +
                "WHERE dt.seller = :seller " +
                "AND dt.startDate BETWEEN :startDate AND :endDate")
public class DailyTicket extends TravelDocument {

    @Column(nullable = false)
    private boolean validated;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    public DailyTicket() {
    }


    public DailyTicket(Seller seller) {
        super(seller);
        this.validated = false;
        this.startDate = LocalDate.now();
    }


    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

}
