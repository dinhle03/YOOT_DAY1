package com.example.yootday1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ConfigurationPropertiesScan
public class YootDay1Application {

	public static void main(String[] args) {
		SpringApplication.run(YootDay1Application.class, args);
	}

}
