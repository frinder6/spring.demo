package ds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by frinder6 on 2016/12/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DistributeControllerTest {

    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
    }

    @Test
    public void distribute() throws Exception {
        String url = "/d/s";
        String animal = "{\"age\":10,\"name\":\"animal\",\"sex\":\"M\"}";
        String plant = "{\"color\":\"green\",\"height\":15,\"name\":\"plant\"}";

        String responseStr = mvc.perform(MockMvcRequestBuilders
                        .post(url, "json")
                        .accept(MediaType.APPLICATION_JSON)
//                .param("actionType", "1")
                        .param("actionType", "2")
//                .param("requestData", animal)
                        .param("requestData", plant)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(responseStr);

    }


    @Test
    public void distributes() throws Exception {
        String url = "/d/m";

        String animals = "[{\"age\":10,\"name\":\"animal1\",\"sex\":\"M\"},{\"age\":10,\"name\":\"animal2\",\"sex\":\"M\"}]";

        String responseStr = mvc.perform(MockMvcRequestBuilders
                .post(url, "json")
                .accept(MediaType.APPLICATION_JSON)
                .param("actionType", "1")
                .param("requestData", animals)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(responseStr);

    }

}