package it.epicode.classi.transport;


import it.epicode.classi.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;


@Entity
public class Maintenance extends BaseEntity {
    @ManyToOne
    private Vehicle vehicle;
    @Column(name = "start_maintenance", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_maintenance", nullable = true)
    private LocalDate endDate;

    public Maintenance(){};

    public Maintenance(Vehicle vehicle, LocalDate startDate) {
        this.vehicle = vehicle;
        this.startDate = startDate;

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "vehicle=" + vehicle +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
