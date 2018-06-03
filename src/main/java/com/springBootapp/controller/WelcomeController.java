package com.springBootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springBootapp.constants.BootConstants;
import com.springBootapp.pojo.Customer;
import com.springBootapp.pojo.Greeting;
import com.springBootapp.service.WelcomeService;

@RestController
public class WelcomeController {

	public WelcomeController() {

	}

	
	
	@Autowired
	private WelcomeService ws;

	@RequestMapping(value = BootConstants.greet)
	public Greeting greeting() {

		return ws.getGreetMssg();
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public Customer getAddress() {
		System.out.println("getAddress");
		Customer customer = new Customer();
		customer.setName("Jack");
		customer.setLocation("US");

		return customer;
	}

}
