package com.cts.predictions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PredictionsAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredictionsAiApplication.class, args);
	}

}
