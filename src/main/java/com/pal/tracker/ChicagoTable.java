package com.pal.tracker;

import java.io.Serializable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="chicago_table")
@EntityListeners(AuditingEntityListener.class)
public class ChicagoTable implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int tire_num;

    @Column(name="vehicle_id")
    private int vehicleId;

    @Column
    private String latitude;

    @Column
    private String longitude;

    @Column
    private String address;

    public ChicagoTable() {};

    public ChicagoTable(Long id, int tire_num, int vehicle_id, String latitude, String longitude, String address) {
        this.id = id;
        this.tire_num = tire_num;
        this.vehicleId = vehicle_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTire_num() {
        return tire_num;
    }

    public void setTire_num(int tire_num) {
        this.tire_num = tire_num;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
