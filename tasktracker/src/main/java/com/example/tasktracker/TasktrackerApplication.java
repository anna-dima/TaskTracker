package com.example.tasktracker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TasktrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasktrackerApplication.class, args);
	}

	 @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
