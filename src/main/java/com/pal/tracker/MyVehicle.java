package com.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "x_table")
@EntityListeners(AuditingEntityListener.class)
public class MyVehicle implements Serializable {

    @Id
    @Column
    private long id;
    @Column
    int tire_num;
    @Column(name = "vehicle_id")
    int vehicleId;
    @Column
    String latitude;
    @Column
    String longitude;
    @Column
    String address;

    public MyVehicle(long id, int tire_num, int vehicleId, String latitude, String longitude) {
        this.id = id;
        this.tire_num = tire_num;
        this.vehicleId = vehicleId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = "";
    }

    public MyVehicle() {
        System.out.println("Null Cons");
    }

    public int getTire_num() {
        return tire_num;
    }

    public void setTire_num(int tire_num) {
        this.tire_num = tire_num;
    }

    public int getvehicleId() {
        return vehicleId;
    }

    public void setvehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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
}
