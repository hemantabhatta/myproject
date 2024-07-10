package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EnableScheduling
public class CustomiseSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomiseSchedulerApplication.class, args);
	}

}
