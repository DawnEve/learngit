package com.example1.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
	
    @GetMapping("/hello2")
    public String hello2(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello, from SpringBoot2.*: %s!", name);
    }

}
