package com.example1.demo3.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemo1 {
	private final AtomicLong counter=new AtomicLong();
	private static final String template="Hello, %s!(json)";
	
	@GetMapping(value="greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name) {
		System.out.println("测试 json> greeting from: "+name);
//		return new Greeting(0, name);
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
