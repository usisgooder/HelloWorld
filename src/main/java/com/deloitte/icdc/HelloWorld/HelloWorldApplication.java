package com.deloitte.icdc.HelloWorld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@SpringBootApplication
@EnableScheduling
@RestController
@Component
@Slf4j
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello world from HelloWorldApplication";
	}

	@Scheduled(fixedRate = 10000) // Run every 10 seconds
	public void logRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000); // Generate a random number between 0 and 99
		log.info("Random number: {}", randomNumber);
	}

}
