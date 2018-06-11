package com.immigration.employee;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
//@ComponentScan("com.immigration.employee")
public class AlertMeApplication {

//	@Autowired
//	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(AlertMeApplication.class, args);
	}
}
