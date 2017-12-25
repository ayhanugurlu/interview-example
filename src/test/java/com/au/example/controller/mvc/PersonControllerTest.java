package com.au.example.controller.mvc;

import com.au.example.interviewexample.InterviewExampleApplication;
import com.au.example.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
@ContextConfiguration(classes = {InterviewExampleApplication.class})
public class PersonControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getPersonView() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/persons/test.view"))
                .andExpect(status().isOk()).
                        andExpect(content()
                                .contentType(MediaType.TEXT_HTML+";charset=UTF-8")).andReturn();
        assertThat(mvcResult.getResponse().getContentAsString().contains("test"));
    }


    @Test
    public void getPersonInJSON() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = this.mvc.perform(get("/persons/test"))
                .andExpect(status().isOk()).
                        andExpect(content()
                                .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();

        Person result = mapper.readValue(mvcResult.getResponse().getContentAsString(), Person.class);
        assertThat(result.getName().equals("test"));

        System.out.println(result);

    }


    @Test
    public void getPersonInXML() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/persons/test.xml"))
                .andExpect(status().isOk()).
                        andExpect(content()
                                .contentType("application/xml;charset=UTF-8")).andReturn();


        XmlMapper xmlMapper = new XmlMapper();
        Person result = xmlMapper.readValue(mvcResult.getResponse().getContentAsString(), Person.class);
        assertThat(result.getName().equals("test"));

        System.out.println(result);

    }

}
