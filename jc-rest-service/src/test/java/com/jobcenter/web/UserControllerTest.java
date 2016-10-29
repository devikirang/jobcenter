package com.jobcenter.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jobcenter.dao.UserDao;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Created on 10/29/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserDao userDao;


    @Test
    public void testRegisterCandidate() throws Exception {
        userDao.deleteAll();
        String jsonContent = "{\"email\":\"test.interviewee@gmail.com\", \"password\": \"test\", \"name\": \"Devi Kiran\", \"phone\": \"123-456-7895\" }";
        this.mockMvc.perform(post("/registerCandidate").content(jsonContent).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("result.email").value("test.interviewee@gmail.com"));
    }

    @Test
    public void testIntervieweeUser() throws Exception {
        this.mockMvc.perform(get("/user").param("email", "test.interviewee@gmail.com")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("role").value("INTERVIEWEE"));
    }
}
