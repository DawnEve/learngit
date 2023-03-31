package com.example1.demo3.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApp {
	private static final Logger log=LoggerFactory.getLogger(ConsumingRestApp.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApp.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		System.out.println("consuming rest...");
		return args -> {
			Quote quote = restTemplate.getForObject("http://localhost:8081/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}
