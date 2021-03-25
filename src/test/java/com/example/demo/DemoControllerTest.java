package com.example.demo;
import static org.junit.Assert.assertEquals;

import com.example.demo.AbstractTest;
import com.example.demo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class DemoControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }



    @Test
    public void createUser() throws Exception {
        String uri = "/create-user";
        User user = new User();
        user.setId("1001");
        user.setName("TestUser");
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }

    @Test
    public void updateUser() throws Exception {
        String uri = "/update-user";
        User user = getUser("1001", "Krishna","Tech Architect");
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.NO_CONTENT.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }

    @Test
    public void getAUser() throws Exception {
        MvcResult result  = mvc.perform(MockMvcRequestBuilders.get("/get-user/1001")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        User user = getUser("1001", "TestUser",null);
        String inputJson = super.mapToJson(user);
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        String content = result.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }
    @Test
    public void getAllUsers() throws Exception {
        MvcResult result  = mvc.perform(MockMvcRequestBuilders.get("/get-all-users")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }

    private User getUser(String id, String name, String designation) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDesignation(designation);
        return user;
    }

    @Test
    public void deleteUser() throws Exception {
        String uri = "/delete-user";
        User user_tobe_deleted = getUser("1001","Krishna","Tech Architect");
        String inputJson = mapToJson(user_tobe_deleted);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.NO_CONTENT.value(), status);
    }

}
