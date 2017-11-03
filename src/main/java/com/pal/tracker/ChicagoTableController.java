package com.pal.tracker;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@RestController()
public class ChicagoTableController {

    static Logger log = LoggerFactory.getLogger(ChicagoTableController.class.getName());

    @Autowired
    ChicagoTableRepository csr;

    @GetMapping("/getentry")
    public ArrayList<ChicagoTable> getChicagoTableEntry(@RequestParam int vehicleId) {
        ArrayList<ChicagoTable> ct = csr.findByVehicleId(vehicleId);
        log.info("getChicagoTableEntry: The ChicagoTable entry retrieved is: " + ct);
        return ct;
    }

    @PostMapping("/post")
    public ChicagoTable addChicagoTableEntry(@RequestBody ChicagoTableInput cti) {
        ChicagoTable ct = new ChicagoTable();
        ct.setVehicleId(Integer.parseInt(cti.getVehicleId()));
        ct.setLatitude(cti.getLatitude());
        ct.setLongitude(cti.getLongitude());
        ct.setTire_num(Integer.parseInt(cti.getTire_num()));

        Client client = ClientBuilder.newClient();
        String REST_SERVICE_URL = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+cti.getLatitude()+","+cti.getLongitude()+"&result_type=street_address&key=AIzaSyAtJSGhm2A-Hn9clmn5HxcCn1cjBePV_hA";
        Response response = client
                .target(REST_SERVICE_URL)
                .request()
                .get();
        client.close();

        Map<String, Object> jsonResponse = response.readEntity(Map.class);
        JSONObject json = new JSONObject(jsonResponse);
        JSONArray jsonarr = json.getJSONArray("results");
        json = new JSONObject(jsonarr.get(0).toString());
        String address = json.getString("formatted_address");

        ct.setAddress(address);
        csr.save(ct);
        log.info("addChicagoTableEntry(): The entry saved was: " + ct);
        return ct;
    }
}
