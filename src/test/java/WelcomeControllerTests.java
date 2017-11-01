import com.pal.tracker.PalTrackerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class)
@WebAppConfiguration
public class WelcomeControllerTests {


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

//    //testing if gives correct response
//    @Test
//    public void postTest() throws Exception {
//        String request = "{\"firstName\" : \"Mayur\",\"lastName\" : \"Santani\"}";
//        mockMvc.perform(post("http://xtest-leafiest-hubble.cfapps.i")
//                .content(request)
//                .contentType(contentType))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("name", is("Mayur Santani")));
//    }

    // Negative testing
    // whether response to <FirstName: Mayur, LastName: Santani> does not return "Hello Mr. Xing Liu"
//    @Test
//    public void negativeTest() throws Exception {
//        String request = "{\"firstName\" : \"Mayur\",\"lastName\" : \"Santani\"}";
//        mockMvc.perform(post("http://localhost:8080" + "/")
//                .content(request)
//                .contentType(contentType))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("name", not("Hello Mr. Xing Liu")));
//    }

    //testing if gives correct response
    @Test
    public void getTest() throws Exception {
        String request = "{\"firstName\" : \"Mayur\",\"lastName\" : \"Santani\"}";
        mockMvc.perform(get("http://xtest-leafiest-hubble.cfapps.io/myname")
                .content(request)
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("firstName", is("Xing")));
    }
}
