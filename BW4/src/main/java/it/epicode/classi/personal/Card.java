package it.epicode.classi.personal;

import it.epicode.classi.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
@Entity
public class Card extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "activation_Date")
    private LocalDate activationDate;
    @Column(name = "expiration_Date")
    private LocalDate expirationDate;

    public Card( User user, LocalDate date) {
        this.user = user;
        this.activationDate = date;
        this.expirationDate = activationDate.plusYears(1);
    }

    public Card(){

    }

    @Override
    public String toString() {
        return "Card{" +
                "user=" + user +
                ", activationDate=" + activationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
