package it.epicode.classi.purchase;

import it.epicode.classi.BaseEntity;
import it.epicode.classi.personal.TravelDocument;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "seller_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Seller extends BaseEntity {
    @OneToMany(mappedBy = "seller")
    private List<TravelDocument> travelDocuments = new ArrayList<>();
    private String location;

    public Seller() {

    }

    public List<TravelDocument> getTravelDocuments() {
        return travelDocuments;
    }

    public void setTravelDocuments(List<TravelDocument> travelDocuments) {
        this.travelDocuments = travelDocuments;
    }

    public Seller(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}