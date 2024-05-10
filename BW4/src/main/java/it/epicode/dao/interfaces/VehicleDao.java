package it.epicode.dao.interfaces;

import it.epicode.classi.transport.Vehicle;

public interface VehicleDao {
    void save(Vehicle vehicle);
    Vehicle getVehicleById(Long id);
}

