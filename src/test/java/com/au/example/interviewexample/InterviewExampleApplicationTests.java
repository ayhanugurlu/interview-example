package com.au.example.interviewexample;

import com.au.example.controller.mvc.PersonController;
import com.au.example.controller.rest.PersonRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewExampleApplicationTests {


	@Autowired
	PersonController personController;

	@Autowired
	PersonRestController personRestController;



	@Test
	public void contextLoads() {
		assertThat(personController).isNotNull();
		assertThat(personRestController).isNotNull();
	}

}
