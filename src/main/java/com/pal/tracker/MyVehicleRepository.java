package com.pal.tracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MyVehicleRepository extends JpaRepository<MyVehicle, Long> {

    public ArrayList<MyVehicle> findByVehicleId(int vehicleId);
}