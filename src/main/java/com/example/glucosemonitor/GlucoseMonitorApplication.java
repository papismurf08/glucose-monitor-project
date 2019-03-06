package com.example.glucosemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
		//(scanBasePackages = {"com.example.glucosemonitor.services"})
public class GlucoseMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlucoseMonitorApplication.class, args);
	}

}

