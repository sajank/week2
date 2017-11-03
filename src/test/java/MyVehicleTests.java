import com.pal.tracker.PalTrackerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class)
public class MyVehicleTests {

    private Client client;
    private String REST_SERVICE_URL = "http://xtest-leafiest-hubble.cfapps.io/";
    private static final String FAIL = "fail";
    static Logger log = LoggerFactory.getLogger(PalTrackerApplication.class.getName());

    @Before
    public void setup(){
        log.info("Initializing tester");
    }

    @Test
    public void testGet(){
        this.client = ClientBuilder.newClient();
        log.info("Testing get request");
        Response response = this.client
                .target(REST_SERVICE_URL+"getvehicle/122")
                .request()
                .get();
        if ((response == null) || (response.getStatus() != 200)){
            log.error("Test case name: getTest, Result: " + FAIL);
        } else {
            System.out.println();
            ArrayList jArray = response.readEntity(ArrayList.class);
            LinkedHashMap jsonResponse = (LinkedHashMap) jArray.get(0);
            assertEquals(jsonResponse.get("tire_num"), 92);
            assertEquals(jsonResponse.get("vehicleId"), 122);
            assertEquals(jsonResponse.get("longitude"), "-84.3880");
            assertEquals(jsonResponse.get("latitude"), "33.7490");
            assertEquals(jsonResponse.get("address"), "Georgia State Capitol, Atlanta, GA 30334, USA");
            log.info("testGet() passed");
        }
        client.close();
    }

    @Test
    public void testPost() {
        this.client = ClientBuilder.newClient();
        log.info("Testing post request");
        String str = "{\"tire_num\" : 992,\"vehicleId\" : 132,\"latitude\" : \"33.7490\",\"longitude\" : \"-84.3880\" }";
        WebTarget webResource = client.target(REST_SERVICE_URL + "postvehicle");
        Response response = webResource.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(str));
        if ((response == null) || (response.getStatus() != 200)){
            log.error("Test case name: getTest, Result: " + FAIL);
        } else {
            System.out.println(">>>>>>>>>>>>>>>>" + response.getStatus());
            Map<String, Object> jsonResponse = response.readEntity(Map.class);
            assertEquals(992, jsonResponse.get("tire_num"));
            assertEquals(132, jsonResponse.get("vehicleId"));
            assertEquals("33.7490", jsonResponse.get("latitude"));
            assertEquals("-84.3880", jsonResponse.get("longitude"));
            assertEquals("Georgia State Capitol, Atlanta, GA 30334, USA", jsonResponse.get("address"));
            log.info("testPost() passed");
        }
        client.close();
    }

}
