package com.example.stockProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestService restTemplate) throws Exception {
		return args -> {
			String jsonString = restTemplate.someRestCall("http://localhost:8080/api");
			log.info(jsonString.toString());
		};
	}
}
