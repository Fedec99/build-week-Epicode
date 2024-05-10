package it.epicode.classi.personal;

import it.epicode.classi.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
@Entity
public class User extends BaseEntity {
    @OneToOne(mappedBy = "user")
    private Card card;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;
    private LocalDate birthDate;

    public User( String name, String lastName, LocalDate birthDate) {
        this.card = new Card(this, LocalDate.now());
        this.card.setUser(this);
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    public User (){

    }

    @Override
    public String toString() {
        return "User{" +
                "card=" + card +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
