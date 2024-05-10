package it.epicode.classi.transport;

import jakarta.persistence.Entity;

import java.time.LocalTime;
@Entity
public class Tram extends Vehicle {
    public Tram(String licensePlate, String departure, String arrive, LocalTime trackDuration, int counterTrack) {
        super(licensePlate, departure, arrive, trackDuration, counterTrack);
        super.setCapacity(80);
        setTotalTime();
    }
    private void setTotalTime() {
        long totalMillis = getTrackDuration().toSecondOfDay() * getCounterTrack() * 1000L;
        LocalTime totalTime = LocalTime.ofSecondOfDay(totalMillis / 1000);
        super.setTotalTime(totalTime);
    }
    public Tram(){

    }
}




