package it.epicode.classi.purchase;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class VendingMachine extends Seller {
    private boolean active = true;

    public VendingMachine() {

    }

    public VendingMachine(String location) {
        super(location);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
