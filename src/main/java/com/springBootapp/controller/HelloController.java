package com.springBootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootapp.pojo.Hello;
import com.springBootapp.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloService hs;

	@GetMapping
	public String hello() {

		return "hello tester";
	}

	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hello json() {

		return new Hello("welcome", "user pavan");
	}

	@PostMapping(value = "/jsonPost", consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hello postJson() {

		return hs.getHelloService();
	}

}
