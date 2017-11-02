package com.pal.tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ChicagoTableRepository extends JpaRepository<ChicagoTable, Long> {

    public ArrayList<ChicagoTable> findByVehicleId(int vehicleId);

}
