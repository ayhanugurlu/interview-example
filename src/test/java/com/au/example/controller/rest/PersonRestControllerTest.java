package com.au.example.controller.rest;

import com.au.example.controller.mvc.PersonController;
import com.au.example.interviewexample.InterviewExampleApplication;
import com.au.example.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
@ContextConfiguration(classes = {InterviewExampleApplication.class})
public class PersonRestControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getPersonInJSON() throws Exception {


        MvcResult mvcResult = this.mvc.perform(get("/rest/persons/1/test"))
                .andExpect(status().isOk()).
                        andExpect(content()
                                .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();


        assertThat(mvcResult.getResponse().getContentAsString().contains("test"));
    }


    @Test
    public void getPersonInJSONResponseEntity() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        MvcResult mvcResult = this.mvc.perform(get("/rest/persons/2/test"))
                .andExpect(status().isAccepted()).
                        andExpect(content()
                                .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();

        Person result = mapper.readValue(mvcResult.getResponse().getContentAsString(), Person.class);
        assertThat(result.getName().equals("test"));
    }


    @Test
    public void getPersonInXML() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/rest/persons/test.xml"))
                .andExpect(status().isOk()).
                        andExpect(content()
                                .contentType("application/xml;charset=UTF-8")).andReturn();

        XmlMapper xmlMapper = new XmlMapper();
        Person result = xmlMapper.readValue(mvcResult.getResponse().getContentAsString(), Person.class);
        assertThat(result.getName().equals("test"));
    }

}
