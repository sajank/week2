import com.pal.tracker.PalTrackerApplication;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class)
@WebAppConfiguration
public class ChicagoTableControllerTests {

    static Logger log = LoggerFactory.getLogger(ChicagoTableControllerTests.class.getName());

    private String REST_SERVICE_URL = "http://chicago.cfapps.io/";

    @Before
    public void setup() throws Exception {
//        client = ClientBuilder.newClient();
    }

    @Test
    public void getTest() throws Exception {
        Client client = ClientBuilder.newClient();

        Response response = client
                .target(REST_SERVICE_URL+"/getentry?vehicleId=5")
                .request()
                .get();


        if(response == null) {
            log.error("getTest(): FAILED. Response is null");
        } else if (response.getStatus() != 200) {
            log.error("getTest(): FAILED. Error Code: " + response.getStatus());
        } else {
            String str = response.readEntity(String.class);
            JSONArray jsonArray = new JSONArray(str);
            JSONObject jsonObject = new JSONObject(jsonArray.get(0).toString());

            assertEquals(-100, jsonObject.get("tire_num"));
            assertEquals(5, jsonObject.get("vehicleId"));
            assertEquals("-87.6298", jsonObject.get("longitude"));
            assertEquals("41.8781", jsonObject.get("latitude"));
            String expectedAddress = "310 S Federal St, Chicago, IL 60604, USA";
            assertEquals(expectedAddress, jsonObject.get("address"));
            log.info("getTest(): passed");
        }
        client.close();

    }

    @Test
    public void postTest() throws Exception {
        Client client = ClientBuilder.newClient();

        String request = "{\"vehicleId\":\"6\",\"tire_num\":\"-100\",\"latitude\":\"41.8781\",\"longitude\":\"-87.6298\"}";

        Response response = client
                .target(REST_SERVICE_URL+"/post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(request));

        if(response == null) {
            log.error("postTest(): FAILED. Response is null");
        } else if (response.getStatus() != 200) {
            log.error("postTest(): FAILED. Error Code: " + response.getStatus());
        } else {
            Map<String, Object> jsonObject = response.readEntity(Map.class);
            assertEquals(-100, jsonObject.get("tire_num"));
            assertEquals(6, jsonObject.get("vehicleId"));
            assertEquals("-87.6298", jsonObject.get("longitude"));
            assertEquals("41.8781", jsonObject.get("latitude"));
            String expectedAddress = "310 S Federal St, Chicago, IL 60604, USA";
            assertEquals(expectedAddress, jsonObject.get("address"));
            log.info("getTest(): passed");
        }
        client.close();
    }
}
