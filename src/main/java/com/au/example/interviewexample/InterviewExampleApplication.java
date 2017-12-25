package com.au.example.interviewexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.au.example.controller"})
public class InterviewExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewExampleApplication.class, args);
	}
}
