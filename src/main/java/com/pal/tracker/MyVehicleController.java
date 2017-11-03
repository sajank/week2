package com.pal.tracker;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@RestController
public class MyVehicleController {

    @Autowired
    private MyVehicleRepository vehicleRepository;

    private Client client;
    private static final String FAIL = "fail";
    static Logger log = LoggerFactory.getLogger(PalTrackerApplication.class.getName());

    @GetMapping("/address")
    public String main() {
        double latitude = 41.8781;
        double longitude = -87.6298;
        return getAddress(latitude, longitude);
    }


    // Get All vehicles
    @GetMapping("/getvehicles")
    public List<MyVehicle> getAllvehicles() {
        return vehicleRepository.findAll();
    }

    @RequestMapping(value = "/postvehicle", method = RequestMethod.POST)
    public MyVehicle postVehicle(@RequestBody MyVehicle v1)
    {
        v1.setAddress(getAddress(Double.parseDouble(v1.getLatitude()) ,Double.parseDouble(v1.getLongitude())));
        vehicleRepository.save(v1);
        return v1;
    }

    @RequestMapping(value="/getvehicle/{vehicleId}", method = RequestMethod.GET)
    public List<MyVehicle> getVehicle(@PathVariable int vehicleId) {
        return vehicleRepository.findByVehicleId(vehicleId);
    }

    public String getAddress(double latitude, double longitude){
        String address = "";
        log.info("Acquiring address with google");
        String REST_SERVICE_URL = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+
                latitude + ","+ longitude+"&key=AIzaSyDC0vxl0zZQR8tF9gGQNgenKQQAn3Ct7Vw";
        this.client = ClientBuilder.newClient();
        Response response = this.client
                .target(REST_SERVICE_URL)
                .request()
                .get();
        if ((response == null) || (response.getStatus() != 200)){
            log.error("Test case name: getTest, Result: " + FAIL);
        } else {
            Map<String, Object> jsonResponse = response.readEntity(Map.class);
            JSONObject a = new JSONObject(jsonResponse);
            JSONArray jArray = a.getJSONArray("results");
            a = new JSONObject(jArray.get(0).toString());
            address = a.getString("formatted_address");
        }
        this.client.close();
        return address;
    }
}