package it.epicode.classi.transport;

import jakarta.persistence.Entity;

import java.time.LocalTime;
@Entity
public class Bus extends Vehicle {
    public Bus(String licensePlate, String departure, String arrive, LocalTime trackDuration, int counterTrack) {
        super(licensePlate, departure, arrive, trackDuration, counterTrack);
        super.setCapacity(50);
        setTotalTime();
    }
    private void setTotalTime() {
        long totalMillis = getTrackDuration().toSecondOfDay() * getCounterTrack() * 1000L;
        LocalTime totalTime = LocalTime.ofSecondOfDay(totalMillis / 1000);
        super.setTotalTime(totalTime);
    }
    public Bus (){

    }
}
