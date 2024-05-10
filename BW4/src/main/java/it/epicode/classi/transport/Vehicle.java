package it.epicode.classi.transport;


import it.epicode.classi.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalTime;
@Entity
public abstract class Vehicle extends BaseEntity {
    @Column(name="license_plate", length = 7, nullable = false )
    private String licensePlate;
    @Column(name="departure", length = 50, nullable = false )
    private String departure;
    @Column(name="arrive", length = 50, nullable = false )
    private String arrive;
    @Column(name= "route_duration", nullable = false)
    private LocalTime trackDuration;
    @Column(name= "counter_track", nullable = false)
    private int counterTrack;
    @Column(name="capacity", nullable = false)
    private int capacity;
    @Column(name = "total_time", nullable = false)
    private LocalTime totalTime;

    public Vehicle(String licensePlate, String departure, String arrive, LocalTime trackDuration, int counterTrack) {
        this.licensePlate = licensePlate;
        this.departure = departure;
        this.arrive = arrive;
        this.trackDuration = trackDuration;
        this.counterTrack = counterTrack;

    }
    public Vehicle(){

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "capacity=" + capacity +
                ", counterTrack=" + counterTrack +
                ", trackDuration=" + trackDuration +
                ", arrive='" + arrive + '\'' +
                ", departure='" + departure + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public LocalTime getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(LocalTime trackDuration) {
        this.trackDuration = trackDuration;
    }

    public int getCounterTrack() {
        return counterTrack;
    }

    public void setCounterTrack(int counterTrack) {
        this.counterTrack = counterTrack;
    }

    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }
}
