package com.usermanagement;

import com.usermanagement.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@RunWith(SpringRunner.class)
//For unit tests only, use @WebMvcTest
//For integration test, load class into application
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ApplicationTest {

    //use direct rest calls

    //sample unit test, delete later
//    @Test
//    public void contextLoads() throws Exception {
//
//        //to access mock mvcs
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/auth/").accept(MediaType.APPLICATION_JSON)
//        ).andReturn();
//    }

    //sample integration test

}
