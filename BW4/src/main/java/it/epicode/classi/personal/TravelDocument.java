package it.epicode.classi.personal;

import it.epicode.classi.BaseEntity;
import it.epicode.classi.purchase.Seller;
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ticket_type", discriminatorType = DiscriminatorType.STRING)
public abstract class TravelDocument extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @Column(name = "code", length = 50)
    double code;

    public TravelDocument(Seller seller ) {
        this.code = (int)(Math.random()*1000);
        this.seller = seller;
    }
    public TravelDocument(){

    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }


    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }


}
