package com.meetapp.springboot.backend.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.meetapp.springboot.backend.apirest")
@SpringBootApplication
public class MeetappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetappBackendApplication.class, args);
	}

}
